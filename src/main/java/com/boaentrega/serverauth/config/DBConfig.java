package com.boaentrega.serverauth.config;

import com.boaentrega.serverauth.model.Role;
import com.boaentrega.serverauth.model.User;
import com.boaentrega.serverauth.model.UserRole;
import com.boaentrega.serverauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@Profile("prod")
public class DBConfig {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    @Bean
    public void createUser(){
        UserRole role= UserRole.builder().roleName(Role.ADMIN).build();

        User user1 = User.builder().id(2L)
                .password(encoder.encode("123"))
                .roles(Arrays.asList(role))
                .nome("Lucas").email("lucas@email")
                .sobrenome("Assis").build();

        repository.save(user1);
    }



}
