package com.boaentrega.serverauth.service;

import com.boaentrega.serverauth.model.User;
import com.boaentrega.serverauth.model.UserPrincipal;
import com.boaentrega.serverauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null) {
             throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new UserPrincipal(user);
    }

}
