package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VOs.SolicitacaoVO;
import com.example.demo.config.security.TokenService;
import com.example.demo.dto.SolicitacaoDTO;
import com.example.demo.model.SolicitacoesUser;
import com.example.demo.service.SolicitacoesService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

        @Autowired
        private TokenService tokenService; 

        @Autowired
        private SolicitacoesService solicitacoesService; 

        @PostMapping("/salvar")
        public ResponseEntity<SolicitacaoVO> salvarSolicitacao(@RequestHeader("Authorization") String token, @RequestBody SolicitacaoDTO solicitacao) { 
                if (token.startsWith("Bearer ")) {
                        token = token.substring(7);
                    }
                String subject = tokenService.validateToken(token);
                return ResponseEntity.ok().body(solicitacoesService.abrirSolicitacao(solicitacao, subject));
        }

        @GetMapping("/all")
        public ResponseEntity<List<SolicitacaoVO>> getAllSolicitacao(@RequestHeader("Authorization") String token) { 
                if (token.startsWith("Bearer ")) {
                        token = token.substring(7);
                    }
                String subject = tokenService.validateToken(token);
                return ResponseEntity.ok().body(solicitacoesService.getSolicitacoes(subject));
        }

        @GetMapping("/{id}")
        public ResponseEntity<SolicitacoesUser> getOneLicitacao(@PathVariable int id) { 
                
                Optional<SolicitacoesUser> response = solicitacoesService.getOneSolicitacao(id);
                if (response.isPresent()) {
                        return ResponseEntity.ok().body(response.get());
                } else {
                        return ResponseEntity.notFound().build();
                }
        }
        
}
