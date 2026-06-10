package com.wastech.uni;

import com.wastech.uni.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArduinoPerformanceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private JwtService jwtService;

    @Test
    void test50ConcurrentSensorReadings() throws InterruptedException {
        String url = "http://localhost:" + port + "/api/sensores/lectura";

        // Generar un token JWT para la autenticación
        String jwtToken = jwtService.generateToken("admin", "ADMINISTRADOR");

        int numberOfRequests = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(25); // Aumentar pool a 25 hilos
        CountDownLatch latch = new CountDownLatch(numberOfRequests);
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failureCount = new AtomicInteger(0);

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofSeconds(3))
                .build();

        // Petición de calentamiento (Warm-up) para evitar latencia de carga inicial (cold-start)
        try {
            String jsonWarm = "{\"idArduino\":1,\"temperatura\":22.0,\"humedad\":60.0}";
            HttpRequest httpRequestWarm = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + jwtToken)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonWarm))
                    .build();
            httpClient.send(httpRequestWarm, HttpResponse.BodyHandlers.discarding());
        } catch (Exception e) {
            // Ignorar errores de warm-up
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfRequests; i++) {
            final double temp = 20.0 + (i % 10);
            final double hum = 50.0 + (i % 20);
            executorService.submit(() -> {
                try {
                    String json = String.format(java.util.Locale.US, "{\"idArduino\":1,\"temperatura\":%.1f,\"humedad\":%.1f}", temp, hum);

                    HttpRequest httpRequest = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .header("Content-Type", "application/json")
                            .header("Authorization", "Bearer " + jwtToken)
                            .POST(HttpRequest.BodyPublishers.ofString(json))
                            .build();

                    HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                    if (response.statusCode() == 200) {
                        successCount.incrementAndGet();
                    } else {
                        failureCount.incrementAndGet();
                        System.err.println("Request failed with status: " + response.statusCode() + " body: " + response.body());
                    }
                } catch (Exception e) {
                    failureCount.incrementAndGet();
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(10, TimeUnit.SECONDS);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        executorService.shutdown();

        System.out.println("========== PERFORMANCE TEST SUMMARY ==========");
        System.out.println("Solicitudes exitosas: " + successCount.get());
        System.out.println("Solicitudes fallidas: " + failureCount.get());
        System.out.println("Duración total: " + duration + " ms");
        System.out.println("==============================================");

        assertEquals(numberOfRequests, successCount.get(), "No todas las peticiones fueron procesadas exitosamente");
        assertEquals(0, failureCount.get(), "Hubo fallas en el procesamiento de lecturas");
        assertTrue(duration < 5000, "El tiempo de procesamiento excedió los 5 segundos (duración: " + duration + "ms)");
    }
}
