package com.skillmatch.repository;

import com.skillmatch.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    List<Usuario> findByNomeCompletoContainingIgnoreCaseOrProfissaoContainingIgnoreCase(String nome, String profissao);
}
