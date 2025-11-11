package com.skillmatch.controller;

import com.skillmatch.dto.UsuarioDto;
import com.skillmatch.model.Usuario;
import com.skillmatch.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@Validated @RequestBody UsuarioDto dto) {
        try {
            Usuario criado = service.criar(dto);
            return ResponseEntity.ok(criado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscar(@RequestParam(value = "q", required = false) String q) {
        List<Usuario> lista = service.buscar(q);
        return ResponseEntity.ok(lista);
    }
}
