package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService; 


    @GetMapping("/{matricula}")
    public ResponseEntity<String> getSetor(@PathVariable String matricula) {
        return ResponseEntity.ok().body(userService.getNomeUser(matricula));
    }


    
}
