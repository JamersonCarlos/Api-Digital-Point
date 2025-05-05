package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.VOs.FuncionarioVO;
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
        private final ModelMapper modelMapper = new ModelMapper(); 
        
        @Autowired
        private SetorDepartamentoRepository setorDepartamentoRepository; 

        public FuncionarioVO getDetails(String matricula) { 
                Funcionario funcionario = funcionarioRepository.findByMatricula(matricula);
                return modelMapper.map(funcionario, FuncionarioVO.class);
        }
        
        public void salvarFuncionario(int idSetor, Funcionario funcionario) { 
                Optional<SetorDepartamento> setorFuncionario = setorDepartamentoRepository.findById(idSetor);

                if (funcionarioRepository.existsById(funcionario.getMatricula())) {
                        throw new MatriculaJaExisteException("Funcionário com matrícula " + funcionario.getMatricula() + " já existe.");
                }

                funcionario.setSetorDepartamento(setorFuncionario.get());
                funcionarioRepository.save(funcionario);
        }

        public void deleteFuncionario(String matricula) { 
                Funcionario funcionario = funcionarioRepository.findByMatricula(matricula); 
                if(funcionario != null) { 
                        funcionarioRepository.delete(funcionario);
                }
        }

}
