package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SolicitacoesUser;

public interface SolicitacoesUserRepository extends JpaRepository<SolicitacoesUser, Integer>{
        List<SolicitacoesUser> findByUser_Login(String matricula);
        List<SolicitacoesUser> findAllByHistoricoPontos_Id(Integer idPonto);
}
