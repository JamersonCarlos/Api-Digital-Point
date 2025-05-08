package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VOs.RoleVO;
import com.example.demo.config.security.TokenService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService; 

    @Autowired
    private TokenService tokenService; 


    @GetMapping("/{matricula}")
    public ResponseEntity<String> getNomeUser(@PathVariable String matricula) {
        return ResponseEntity.ok().body(userService.getNomeUser(matricula));
    }

    @GetMapping("/role")
    public ResponseEntity<RoleVO> getRoleUser(@RequestHeader ("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
                token = token.substring(7);
        }
        String matricula = tokenService.validateToken(token);        
        return ResponseEntity.ok().body(userService.getRoleUser(matricula));
    }

    
}
