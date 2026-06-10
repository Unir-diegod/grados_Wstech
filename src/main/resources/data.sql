SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM deshidratador WHERE ID_deshidratador > 1;
DELETE FROM arduino WHERE ID_arduino > 1;
DELETE FROM tipo_sensor WHERE ID_tiposensor > 2;
DELETE FROM tipo_materia_prima WHERE ID_matep > 1;
DELETE FROM tipo_compostaje WHERE ID_compostaje > 1;
DELETE FROM perfil WHERE IDperfil > 2;
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
