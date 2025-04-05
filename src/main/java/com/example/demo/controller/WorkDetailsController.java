package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.security.TokenService;
import com.example.demo.service.WorkDetailsService;

@RestController
@RequestMapping("/trabalho")
public class WorkDetailsController {    
        
        @Autowired
        private WorkDetailsService workDetailsService; 

        @Autowired 
        private TokenService tokenService; 

        @GetMapping("detalhes")
        public ResponseEntity<?> getDetailsUserWork(@RequestHeader("Authorization") String token) { 
                if (token.startsWith("Bearer ")) {
                        token = token.substring(7);
                    }
                    String subject = tokenService.validateToken(token);
                return ResponseEntity.ok().body(workDetailsService.getDetails(subject));
        }

}
