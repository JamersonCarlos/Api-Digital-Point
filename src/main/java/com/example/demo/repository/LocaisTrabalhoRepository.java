package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LocaisTrabalho;

public interface LocaisTrabalhoRepository extends JpaRepository<LocaisTrabalho, Integer> {
    
}
