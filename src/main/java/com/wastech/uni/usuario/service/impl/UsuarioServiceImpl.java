package com.wastech.uni.usuario.service.impl;

import com.wastech.uni.cliente.repository.ClienteRepository;
import com.wastech.uni.exception.BusinessException;
import com.wastech.uni.exception.ResourceNotFoundException;
import com.wastech.uni.perfil.repository.PerfilRepository;
import com.wastech.uni.usuario.dto.UsuarioDTO;
import com.wastech.uni.usuario.entity.Usuario;
import com.wastech.uni.usuario.repository.UsuarioRepository;
import com.wastech.uni.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findByNombreOrUsuario(String search) {
        if (search == null || search.trim().isEmpty()) return findAll();
        return usuarioRepository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCaseOrUsuarioContainingIgnoreCase(search, search, search);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findByUsuario(String username) {
        return usuarioRepository.findByUsuario(username);
    }

    @Override
    public Usuario save(UsuarioDTO dto) {
        if (usuarioRepository.existsByUsuario(dto.getUsuario())) {
            throw new BusinessException("El nombre de usuario ya está en uso");
        }
        Usuario usuario = new Usuario();
        mapDtoToEntity(dto, usuario);
        // Validar contraseña obligatoria en creación
        if (dto.getContrasena() == null || dto.getContrasena().trim().isEmpty()) {
            throw new BusinessException("La contraseña es obligatoria para nuevos usuarios");
        }
        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        
        if (usuarioRepository.existsByUsuarioAndIdusuarioNot(dto.getUsuario(), id)) {
            throw new BusinessException("El nombre de usuario ya está en uso por otra persona");
        }

        mapDtoToEntity(dto, usuario);

        // Si se envió una nueva contraseña, actualizarla
        if (dto.getContrasena() != null && !dto.getContrasena().trim().isEmpty()) {
            usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        }
        
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario", "id", id);
        }
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException("No se puede eliminar el usuario porque tiene registros asociados.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUsuario(String username) {
        return usuarioRepository.existsByUsuario(username);
    }

    private void mapDtoToEntity(UsuarioDTO dto, Usuario entity) {
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setUsuario(dto.getUsuario());
        
        entity.setPerfil(perfilRepository.findById(dto.getIdperfil())
                .orElseThrow(() -> new BusinessException("Perfil seleccionado no válido")));
                
        if (dto.getCedulaCliente() != null && !dto.getCedulaCliente().trim().isEmpty()) {
            entity.setCliente(clienteRepository.findById(dto.getCedulaCliente())
                    .orElseThrow(() -> new BusinessException("Cliente seleccionado no válido")));
        } else {
            entity.setCliente(null);
        }
    }
}
