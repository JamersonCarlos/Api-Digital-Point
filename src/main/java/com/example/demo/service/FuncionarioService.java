package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;


@Service
public class FuncionarioService {

        @Autowired
        private FuncionarioRepository funcionarioRepository; 

        public Funcionario getDetails(String matricula) { 
                return funcionarioRepository.findByMatricula(matricula);
        }

}
