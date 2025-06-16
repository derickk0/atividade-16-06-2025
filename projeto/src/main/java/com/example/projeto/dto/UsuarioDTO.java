package com.example.projeto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "O email deve ser válido")
    private String email;
    @NotBlank(message = "A senha não pode estar vazia")
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O email não pode estar vazio") @Email(message = "O email deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email não pode estar vazio") @Email(message = "O email deve ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha não pode estar vazia") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha não pode estar vazia") String senha) {
        this.senha = senha;
    }
}
