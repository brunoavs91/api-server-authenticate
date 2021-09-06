package com.boaentrega.serverauth.controller;

import com.boaentrega.serverauth.model.dto.UserDTO;
import com.boaentrega.serverauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO usuarioDTO) {

        usuarioDTO = service.salvar(usuarioDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }

}
