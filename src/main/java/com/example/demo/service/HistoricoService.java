package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.VOs.ResultBaterPontosVO;
import com.example.demo.dto.BaterPontoDTO;
import com.example.demo.dto.ResponseHistoricoAllUserDTO;
import com.example.demo.exception.NotExistRelationalAndUserException;
import com.example.demo.model.HistoricoPontos;
import com.example.demo.model.LocaisTrabalho;
import com.example.demo.model.User;
import com.example.demo.repository.HistoricoPontosRepository;
import com.example.demo.repository.LocaisTrabalhoRepository;
import com.example.demo.repository.UserRepository;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoPontosRepository historicoPontosRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private LocaisTrabalhoRepository locaisTrabalhoRepository; 

    @Autowired 
    private ModelMapper modelMapper = new ModelMapper(); 
    

    public List<HistoricoPontos> buscarUsandoLogin(String login){ 
        return historicoPontosRepository.findByUser_Login(login);
    }

    public ResultBaterPontosVO baterPonto(String subject, BaterPontoDTO data) { 
        Optional<User> userOpt = Optional.of(userRepository.findByLogin(subject));
        Optional<LocaisTrabalho> localOpt = locaisTrabalhoRepository.findById(data.localTrabalho());

        if(userOpt.isEmpty() || localOpt.isEmpty()) { 
            throw new NotExistRelationalAndUserException("Usuário ou Localização não encontrado");
        }
        

        HistoricoPontos historicoNovo = new HistoricoPontos(data.latitude(), data.longitude(), localOpt.get(), LocalDateTime.now(), data.justificativa(), userOpt.get(), null);

        HistoricoPontos result = historicoPontosRepository.save(historicoNovo);

        return new ResultBaterPontosVO(result.getCreatedAt(), result.getLatitude(), result.getLongitude(), result.getLocalizacao().getIdentificador());
    }

    public List<LocaisTrabalho> getAllLocais() { 
        return locaisTrabalhoRepository.findAll();
    }

    public List<HistoricoPontos> getHistoricoUser(String login) {
        return historicoPontosRepository.findByUser_Login(login).reversed();
    }

    public ResponseHistoricoAllUserDTO finalizarPonto(int id) { 
        return modelMapper.map(historicoPontosRepository.findById(id).map(t -> {
            t.setFinallyAt(LocalDateTime.now());
            return historicoPontosRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado!")), ResponseHistoricoAllUserDTO.class);
    }

}
