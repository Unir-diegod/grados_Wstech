-- Insertar roles/perfiles iniciales
INSERT IGNORE INTO perfil (nombre) VALUES ('ADMINISTRADOR');
INSERT IGNORE INTO perfil (nombre) VALUES ('CLIENTE');

-- Insertar usuario administrador
-- Obtener el ID del perfil ADMINISTRADOR recién insertado (asumiendo que es el ID 1, pero usamos un subquery para mayor seguridad)
INSERT IGNORE INTO usuario (nombre, apellido, usuario, contrasena, idperfil)
VALUES (
    'Super', 
    'Administrador', 
    'admin', 
    '$2a$10$E5Ss5pjArtiITqVDl9NAwOJqFvF4kSrMQSvyg8cBvDtcIb6ZUUqqq', -- admin123 hasheado en BCrypt
    (SELECT idperfil FROM perfil WHERE nombre = 'ADMINISTRADOR' LIMIT 1)
);
