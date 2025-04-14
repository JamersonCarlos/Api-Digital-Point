package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SetorDepartamento;

@Repository
public interface SetorDepartamentoRepository extends JpaRepository<SetorDepartamento, Integer>{
        List<SetorDepartamento> findByDepartamentoId(Integer departamentoId);
}
