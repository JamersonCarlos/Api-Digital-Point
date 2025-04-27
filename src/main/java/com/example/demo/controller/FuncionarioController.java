package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.security.TokenService;
import com.example.demo.exception.MatriculaJaExisteException;
import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("detalhes")
    public ResponseEntity<?> getDetailsUserWork(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String subject = tokenService.validateToken(token);
        return ResponseEntity.ok().body(funcionarioService.getDetails(subject));
    }

    @PostMapping("salvar/{idSetor}")
    public ResponseEntity<?> salvarFuncionario(@PathVariable int idSetor, @RequestBody Funcionario funcionario) { 
        try {  
            funcionarioService.salvarFuncionario(idSetor, funcionario);
            return ResponseEntity.ok().build();
        } catch (MatriculaJaExisteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
