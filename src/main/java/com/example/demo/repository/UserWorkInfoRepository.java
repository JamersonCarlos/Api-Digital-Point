package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserWorkInfo;

@Repository
public interface UserWorkInfoRepository extends JpaRepository<UserWorkInfo, String> {

    // Verifica se a matrícula existe
    boolean existsByMatricula(String matricula);

    // Busca UserWorkInfo pela matrícula
    UserWorkInfo findByMatricula(String matricula);
}
