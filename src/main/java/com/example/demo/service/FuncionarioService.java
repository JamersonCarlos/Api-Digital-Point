package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.MatriculaJaExisteException;
import com.example.demo.model.Funcionario;
import com.example.demo.model.SetorDepartamento;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.SetorDepartamentoRepository;


@Service
public class FuncionarioService {

        @Autowired
        private FuncionarioRepository funcionarioRepository; 
        
        @Autowired
        private SetorDepartamentoRepository setorDepartamentoRepository; 

        public Funcionario getDetails(String matricula) { 
                return funcionarioRepository.findByMatricula(matricula);
        }
        
        public void salvarFuncionario(int idSetor, Funcionario funcionario) { 
                Optional<SetorDepartamento> setorFuncionario = setorDepartamentoRepository.findById(idSetor);

                if (funcionarioRepository.existsById(funcionario.getMatricula())) {
                        throw new MatriculaJaExisteException("Funcionário com matrícula " + funcionario.getMatricula() + " já existe.");
                }

                funcionario.setSetorDepartamento(setorFuncionario.get());
                funcionarioRepository.save(funcionario);
        }

}
