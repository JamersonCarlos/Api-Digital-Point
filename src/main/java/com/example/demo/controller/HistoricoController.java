package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VOs.ResultBaterPontosVO;
import com.example.demo.config.security.TokenService;
import com.example.demo.dto.BaterPontoDTO;
import com.example.demo.dto.ResponseHistoricoAllUserDTO;
import com.example.demo.model.HistoricoPontos;
import com.example.demo.model.LocaisTrabalho;
import com.example.demo.service.HistoricoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService; 

    @Autowired 
    private TokenService tokenService; 

    @Autowired 
    private ModelMapper modelMapper = new ModelMapper(); 

    @PostMapping("/add")
    public ResponseEntity<ResultBaterPontosVO> salvarLocal(@RequestHeader("Authorization") String token, @RequestBody BaterPontoDTO data) { 
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String subject = tokenService.validateToken(token);
        return ResponseEntity.ok().body(historicoService.baterPonto(subject, data));
    }

    @GetMapping("/locais")
    public ResponseEntity<List<LocaisTrabalho>> locaisTrabalho() { 
        return ResponseEntity.ok().body(historicoService.getAllLocais());
    }

    @GetMapping("/all") 
    public ResponseEntity<List<ResponseHistoricoAllUserDTO>> historicoPontos(@RequestHeader ("Authorization") String token) { 
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String subject = tokenService.validateToken(token);
        return ResponseEntity.ok().body(historicoService.getHistoricoUser(subject).stream().map(this::toHistoricoSummaryModel).collect(Collectors.toList()));
    }
    
    private ResponseHistoricoAllUserDTO toHistoricoSummaryModel(HistoricoPontos historicoPontos) { 
        return modelMapper.map(historicoPontos, ResponseHistoricoAllUserDTO.class);
    }

    @PutMapping("/fechar-ponto/{id}") 
    public ResponseEntity<ResponseHistoricoAllUserDTO> updateHistoryPoints(@PathVariable int id) { 
        return ResponseEntity.ok().body(historicoService.finalizarPonto(id));
    }
    


    
}
