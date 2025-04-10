package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
                SolicitacaoVO novaSolicitacao = solicitacoesService.abrirSolicitacao(solicitacao, subject);
                if(novaSolicitacao != null) { 
                        return ResponseEntity.ok().body(novaSolicitacao);
                } else { 
                        return ResponseEntity.notFound().build(); 
                }
        }

        @GetMapping("/ponto/{id}")
        public ResponseEntity<List<SolicitacaoVO>> getAllSolicitacoesReferencePonto(@RequestHeader("Authorization") String token, @PathVariable int id) { 
                return ResponseEntity.ok().body(solicitacoesService.getSolicitacoes(id));
        }

        @DeleteMapping("/ponto/{id}")
        public ResponseEntity<?>  deleteOneSolicitacao(@PathVariable int id) { 
                solicitacoesService.deleteOneSolicitacao(id);
                return ResponseEntity.ok().build();
        }

     
        
}
