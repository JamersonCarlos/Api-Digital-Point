package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.VOs.SolicitacaoVO;
import com.example.demo.dto.SolicitacaoDTO;
import com.example.demo.model.SolicitacoesUser;
import com.example.demo.model.User;
import com.example.demo.repository.SolicitacoesUserRepository;
import com.example.demo.repository.UserRepository;

@Service
public class SolicitacoesService {
        
        @Autowired
        private SolicitacoesUserRepository solicitacoesUserRepository; 

        @Autowired
        private UserRepository userRepository; 

        @Autowired 
        private ModelMapper modelMapper = new ModelMapper(); 
    
        public SolicitacaoVO abrirSolicitacao(SolicitacaoDTO solicitacao, String matricula) { 
                final User user = userRepository.findByLogin(matricula);
                final SolicitacoesUser solicitacoesUser = new SolicitacoesUser(solicitacao.anulacao_ponto(), solicitacao.alterar_horario_entrada(), solicitacao.alterar_horario_saida(), solicitacao.novo_horario_entrada(), solicitacao.novo_horario_saida(), user, LocalDateTime.now());
                return modelMapper.map(solicitacoesUserRepository.save(solicitacoesUser), SolicitacaoVO.class);
        }

        public List<SolicitacaoVO> getSolicitacoes(String matricula) { 
                return solicitacoesUserRepository.findByUser_Login(matricula).stream().map(t -> modelMapper.map(t, SolicitacaoVO.class)).collect(Collectors.toList());
        }

        public Optional<SolicitacoesUser> getOneSolicitacao(int idSolicitacao) { 
                return solicitacoesUserRepository.findById(idSolicitacao);
        }
}
