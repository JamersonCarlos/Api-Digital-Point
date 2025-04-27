package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Departamento;
import com.example.demo.model.Funcionario;
import com.example.demo.model.SetorDepartamento;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.SetorDepartamentoRepository;


@Service
public class SetoresService {

        @Autowired
        SetorDepartamentoRepository setorDepartamentoRepository; 

        @Autowired
        DepartamentoRepository departamentoRepository; 

        @Autowired 
        FuncionarioRepository funcionarioRepository; 

        @Autowired
        private ModelMapper modelMapper = new ModelMapper(); 

        public List<SetorDepartamento> getAllSetores(int idDepartamento) { 
                return setorDepartamentoRepository.findByDepartamentoId(idDepartamento);
        }

        public void novoSetor(int idDepartamento, String nomeSetor) { 
                Optional<Departamento> departamento = departamentoRepository.findById(idDepartamento); 
                SetorDepartamento newSetorDepartamento = new SetorDepartamento(nomeSetor, departamento.get()); 
                if(departamento.isPresent()) { 
                        setorDepartamentoRepository.save(newSetorDepartamento);
                }
        }

        public void deleteSetor(int idSetor) { 
                setorDepartamentoRepository.deleteById(idSetor);
        }

        public Optional<SetorDepartamento> getSetor(int idSetor) { 
                return setorDepartamentoRepository.findById(idSetor);
        }

        public Funcionario setChefeSetor(int idsetor, String matricula) { 
                Optional<SetorDepartamento> optional = setorDepartamentoRepository.findById(idsetor);
                if (optional.isPresent()) {
                        SetorDepartamento setorDepartamento = optional.get();
                        Funcionario chefeSet = funcionarioRepository.findByMatricula(matricula); 
                         if(chefeSet != null) {     
                                chefeSet.setSetorDepartamento(setorDepartamento);
                                setorDepartamento.setChefe(chefeSet);
                                setorDepartamentoRepository.save(setorDepartamento); 
                                return chefeSet; 
                        }
                        return null; 
                } else {
                        return null; 
                }
        }

}
