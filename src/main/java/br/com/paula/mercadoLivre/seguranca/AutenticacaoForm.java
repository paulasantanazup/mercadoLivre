package br.com.paula.mercadoLivre.seguranca;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AutenticacaoForm {

    private String email;

    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter(PasswordEncoder encoder) {
        return new UsernamePasswordAuthenticationToken(email, encoder.encode(senha));
    }
}
