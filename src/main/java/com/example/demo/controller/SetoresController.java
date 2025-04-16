package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SetorDTO;
import com.example.demo.service.SetoresService;

@RestController
@RequestMapping("setores")
public class SetoresController {

        @Autowired 
        private SetoresService setoresService; 


        @PostMapping("/add")
        public ResponseEntity<?> saveSetor(@RequestBody SetorDTO setor ) { 
                setoresService.novoSetor(setor.id_departamento(), setor.nome());
                return ResponseEntity.ok().build();
        }

        @DeleteMapping("/{idSetor}")
        public ResponseEntity<?> saveSetor(@PathVariable int idSetor) { 
                setoresService.deleteSetor(idSetor);
                return ResponseEntity.ok().build();
        }



}
