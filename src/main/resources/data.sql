SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM deshidratador WHERE ID_deshidratador > 1;
DELETE FROM arduino WHERE ID_arduino > 1;
DELETE FROM tipo_sensor WHERE ID_tiposensor > 2;
DELETE FROM tipo_materia_prima WHERE ID_matep > 1;
DELETE FROM tipo_compostaje WHERE ID_compostaje > 1;
DELETE FROM perfil WHERE IDperfil > 2;
DELETE FROM resultado WHERE Cod_resultado > 2;
DELETE FROM sensores WHERE ID_sensor > 2;
SET FOREIGN_KEY_CHECKS = 1;

-- Insertar roles/perfiles iniciales
INSERT IGNORE INTO perfil (IDperfil, nombre) VALUES (1, 'ADMINISTRADOR');
INSERT IGNORE INTO perfil (IDperfil, nombre) VALUES (2, 'CLIENTE');

-- Insertar usuario administrador
INSERT IGNORE INTO usuario (nombre, apellido, usuario, contrasena, id_perfil)
SELECT 'Super', 'Administrador', 'admin', '$2a$10$E5Ss5pjArtiITqVDl9NAwOJqFvF4kSrMQSvyg8cBvDtcIb6ZUUqqq', IDperfil 
FROM perfil 
WHERE nombre = 'ADMINISTRADOR' 
LIMIT 1;

-- Insertar Arduino de prueba
INSERT IGNORE INTO arduino (ID_arduino, nombre, modelo) VALUES (1, 'Arduino UNO R3', 'Uno');

-- Insertar Tipos de Sensores
INSERT IGNORE INTO tipo_sensor (ID_tiposensor, nombre_sesor) VALUES (1, 'TEMPERATURA');
INSERT IGNORE INTO tipo_sensor (ID_tiposensor, nombre_sesor) VALUES (2, 'HUMEDAD');

-- Insertar Tipo Materia Prima
INSERT IGNORE INTO tipo_materia_prima (ID_matep, nombre, temperatura) VALUES (1, 'Orgánica General', 22.5);

-- Insertar Tipo Compostaje
INSERT IGNORE INTO tipo_compostaje (ID_compostaje, compuestos, temperatura_liminte, humedad_limite) VALUES (1, 'Residuos Orgánicos y Estiércol', 65.0, 70.0);

-- Insertar Deshidratador
INSERT IGNORE INTO deshidratador (ID_deshidratador, calentador, ID_arduino) VALUES (1, false, 1);

-- Insertar Cliente de prueba
INSERT IGNORE INTO cliente (cedula, nombre_1, apellido_1, correo) VALUES ('12345', 'Juan', 'Pérez', 'juan@example.com');

-- Insertar lecturas de sensores base
INSERT IGNORE INTO sensores (ID_sensor, Frcha_lectura, Valor_lectura, ID_arduino, ID_tiposensor)
VALUES (1, '2026-06-08 08:00:00', 65.8, 1, 1);
INSERT IGNORE INTO sensores (ID_sensor, Frcha_lectura, Valor_lectura, ID_arduino, ID_tiposensor)
VALUES (2, '2026-06-08 08:00:00', 34.0, 1, 2);

-- Insertar Resultados de prueba
INSERT IGNORE INTO resultado (Cod_resultado, Fecha_de_inicio, Fecha_de_fin, Valor, ID_sensor)
VALUES (1, '2026-06-08 08:00:00', '2026-06-09 12:00:00', 92.5, 1);
INSERT IGNORE INTO resultado (Cod_resultado, Fecha_de_inicio, Fecha_de_fin, Valor, ID_sensor)
VALUES (2, '2026-06-09 14:00:00', '2026-06-10 10:00:00', 88.0, 2);
