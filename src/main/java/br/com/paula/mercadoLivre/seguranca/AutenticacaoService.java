package br.com.paula.mercadoLivre.seguranca;

import br.com.paula.mercadoLivre.usuario.Usuario;
import br.com.paula.mercadoLivre.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.
                findByLogin(login).orElseThrow(()-> new UsernameNotFoundException("Dados inválidos"));

        return usuario;
    }

}
