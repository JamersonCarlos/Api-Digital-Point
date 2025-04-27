package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.VOs.DepartamentoVO;
import com.example.demo.VOs.SetorDepartamentoVO;
import com.example.demo.model.Departamento;
import com.example.demo.model.SetorDepartamento;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.SetorDepartamentoRepository;

@Service
public class DepartamentoService {

        @Autowired
        DepartamentoRepository departamentoRepository; 


        @Autowired
        SetorDepartamentoRepository setorDepartamentoRepository; 

        @Autowired
        private ModelMapper modelMapper = new ModelMapper(); 

        public DepartamentoVO getOneDepartamento(String matriculaUser) { 
                
                Departamento departamento = departamentoRepository.findByChefe_Matricula(matriculaUser);
                List<SetorDepartamento> setores = setorDepartamentoRepository.findByDepartamentoId(departamento.getId());
                DepartamentoVO departamentoVO =  modelMapper.map(departamento, DepartamentoVO.class);
                departamentoVO.setQtdSetores(setores.size());
                departamentoVO.setSetores(setores.stream().map(t -> modelMapper.map(t, SetorDepartamentoVO.class)).toList());
                return departamentoVO;
        }
}
