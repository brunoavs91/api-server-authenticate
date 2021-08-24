package com.boaentrega.serverauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
@EnableDiscoveryClient
public class ServerAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerAuthApplication.class, args);
	}

	@GetMapping("/user")
	public Principal user(Principal user){
		return user;
	}
}
