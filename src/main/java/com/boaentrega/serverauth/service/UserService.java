package com.boaentrega.serverauth.service;

import com.boaentrega.serverauth.model.Role;
import com.boaentrega.serverauth.model.User;
import com.boaentrega.serverauth.model.UserPrincipal;
import com.boaentrega.serverauth.model.UserRole;
import com.boaentrega.serverauth.model.dto.UserDTO;
import com.boaentrega.serverauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null) {
             throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new UserPrincipal(user);
    }


    public UserDTO salvar(UserDTO usuarioDTO){
        User usuario = User.builder().nome(usuarioDTO.getNome())
                .password(encoder.encode(usuarioDTO.getPassword()))
                .email(usuarioDTO.getEmail())
                .roles(Arrays.asList(createRole(Role.ADMIN)))
                .sobrenome(usuarioDTO.getSobrenome()).build();
        usuario = repository.save(usuario);
                return UserDTO.builder().id(usuario.getId())
                        .email(usuario.getEmail())
                        .nome(usuario.getNome())
                        .sobrenome(usuario.getSobrenome()).build();
    }

    private UserRole createRole(Role role){
        return UserRole.builder().roleName(role).build();
    }
}
