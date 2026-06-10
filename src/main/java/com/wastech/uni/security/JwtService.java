package com.wastech.uni.security;

import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class JwtService {
    private static final String SECRET_KEY = "WastechSuperSecretPrivateKeyForHMACSHA256SignatureVerificationWastechSuperSecretPrivateKeyForHMACSHA256SignatureVerification";

    public String generateToken(String username, String role) {
        try {
            String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
            long now = System.currentTimeMillis();
            long exp = now + 1000 * 60 * 60 * 24; // 24 horas de expiración
            String payload = String.format("{\"sub\":\"%s\",\"role\":\"%s\",\"iat\":%d,\"exp\":%d}", username, role, now / 1000, exp / 1000);

            String encodedHeader = base64UrlEncode(header);
            String encodedPayload = base64UrlEncode(payload);
            String signature = hmacSha256(encodedHeader + "." + encodedPayload, SECRET_KEY);

            return encodedHeader + "." + encodedPayload + "." + signature;
        } catch (Exception e) {
            throw new RuntimeException("Error al generar token JWT", e);
        }
    }

    public boolean validateToken(String token) {
        if (token == null || token.isBlank()) return false;
        String[] parts = token.split("\\.");
        if (parts.length != 3) return false;

        try {
            String encodedHeader = parts[0];
            String encodedPayload = parts[1];
            String signature = parts[2];

            String expectedSignature = hmacSha256(encodedHeader + "." + encodedPayload, SECRET_KEY);
            if (!expectedSignature.equals(signature)) {
                return false;
            }

            // Validar expiración
            String payload = base64UrlDecode(encodedPayload);
            if (!payload.contains("\"exp\":")) return false;
            
            int expIndex = payload.indexOf("\"exp\":");
            int commaIndex = payload.indexOf(",", expIndex);
            if (commaIndex == -1) {
                commaIndex = payload.indexOf("}", expIndex);
            }
            String expStr = payload.substring(expIndex + 6, commaIndex).trim();
            long expTime = Long.parseLong(expStr);
            long currentTime = System.currentTimeMillis() / 1000;

            return currentTime < expTime;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            String[] parts = token.split("\\.");
            String payload = base64UrlDecode(parts[1]);
            int subIndex = payload.indexOf("\"sub\":\"");
            int endQuote = payload.indexOf("\"", subIndex + 7);
            return payload.substring(subIndex + 7, endQuote);
        } catch (Exception e) {
            return null;
        }
    }

    public String getRoleFromToken(String token) {
        try {
            String[] parts = token.split("\\.");
            String payload = base64UrlDecode(parts[1]);
            int roleIndex = payload.indexOf("\"role\":\"");
            int endQuote = payload.indexOf("\"", roleIndex + 8);
            return payload.substring(roleIndex + 8, endQuote);
        } catch (Exception e) {
            return null;
        }
    }

    private String base64UrlEncode(String input) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    private String base64UrlDecode(String input) {
        return new String(Base64.getUrlDecoder().decode(input), StandardCharsets.UTF_8);
    }

    private String hmacSha256(String data, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] rawHmac = sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getUrlEncoder().withoutPadding().encodeToString(rawHmac);
    }
}
