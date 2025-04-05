package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HistoricoPontos;

@Repository
public interface HistoricoPontosRepository extends JpaRepository<HistoricoPontos, Integer> {
    List<HistoricoPontos> findByUser_Login(String login);
}
