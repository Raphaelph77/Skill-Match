package com.skillmatch.service;

import com.skillmatch.dto.UsuarioDto;
import com.skillmatch.model.Usuario;
import com.skillmatch.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repo;

    @Transactional
    public Usuario criar(UsuarioDto dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        Usuario u = Usuario.builder()
                .nomeCompleto(dto.getNomeCompleto())
                .email(dto.getEmail())
                .profissao(dto.getProfissao())
                .senha(dto.getSenha())
                .build();
        return repo.save(u);
    }

    public List<Usuario> buscar(String q) {
        if (q == null || q.isBlank()) {
            return repo.findAll();
        }
        return repo.findByNomeCompletoContainingIgnoreCaseOrProfissaoContainingIgnoreCase(q, q);
    }
}
