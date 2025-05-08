package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.VOs.RoleVO;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository; 

    public String getNomeUser(String matricula) { 
        return userRepository.findByLogin(matricula).get().getName();
    }

    public RoleVO getRoleUser(String matricula) { 
        return new RoleVO(userRepository.findByLogin(matricula).get().getRole().getRole());  
    }

}
