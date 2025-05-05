package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.LocaisTrabalho;

public interface LocaisTrabalhoRepository extends JpaRepository<LocaisTrabalho, Integer> {
    @Query("SELECT l FROM LocaisTrabalho l WHERE l.setorDepartamento IS EMPTY")
    List<LocaisTrabalho> findLocaisSemSetores();
}
