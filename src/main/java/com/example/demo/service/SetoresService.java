package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Departamento;
import com.example.demo.model.SetorDepartamento;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.repository.SetorDepartamentoRepository;

@Service
public class SetoresService {

        @Autowired
        SetorDepartamentoRepository setorDepartamentoRepository; 

        @Autowired
        DepartamentoRepository departamentoRepository; 

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

}
