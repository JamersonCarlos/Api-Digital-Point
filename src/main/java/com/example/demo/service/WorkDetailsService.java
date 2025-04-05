package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserWorkInfo;
import com.example.demo.repository.UserWorkInfoRepository;

@Service
public class WorkDetailsService {

        @Autowired
        private UserWorkInfoRepository userWorkInfoRepository; 

        public UserWorkInfo getDetails(String matricula) { 
                return userWorkInfoRepository.findByMatricula(matricula);
        }

}
