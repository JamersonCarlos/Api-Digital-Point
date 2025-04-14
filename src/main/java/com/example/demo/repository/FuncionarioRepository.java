package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

    // Verifica se a matrícula existe
    boolean existsByMatricula(String matricula);

    // Busca UserWorkInfo pela matrícula
    Funcionario findByMatricula(String matricula);

    Funcionario findByTelefone(String telefone);

    List<Funcionario> findAllBySetorDepartamento_Id(int setorId);
   
}
