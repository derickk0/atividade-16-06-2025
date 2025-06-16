package com.example.projeto.controller;

import com.example.projeto.dto.UsuarioDTO;
import com.example.projeto.dto.UsuarioResponseDTO;
import com.example.projeto.model.Usuario;
import com.example.projeto.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin
@EnableWebSecurity
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }

    @PostMapping
    public ResponseEntity<Map<Object, String>> salvar(@Valid @RequestBody UsuarioDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("menssagem", "Usuário cadastrado com sucesso!"));
    }

    @PutMapping("/{email}")
    public ResponseEntity<Map<Object, String>> atualizar(@PathVariable String email, @Valid @RequestBody UsuarioDTO dto) {
        usuarioService.atualizar(email, dto);
        return ResponseEntity
                .ok(Map.of("menssagem", "Usuário atualizado com sucesso!"));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Map<Object, String>> deletar(@PathVariable String email) {
        usuarioService.deletar(email);
        return ResponseEntity
                .ok(Map.of("menssagem", "Usuário deletado com sucesso!"));
    }
}
