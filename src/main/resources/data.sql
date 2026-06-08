-- Insertar roles/perfiles iniciales
INSERT IGNORE INTO perfil (nombre) VALUES ('ADMINISTRADOR');
INSERT IGNORE INTO perfil (nombre) VALUES ('CLIENTE');

-- Insertar usuario administrador
INSERT IGNORE INTO usuario (nombre, apellido, usuario, contrasena, id_perfil)
SELECT 'Super', 'Administrador', 'admin', '$2a$10$E5Ss5pjArtiITqVDl9NAwOJqFvF4kSrMQSvyg8cBvDtcIb6ZUUqqq', idperfil 
FROM perfil 
WHERE nombre = 'ADMINISTRADOR' 
LIMIT 1;
