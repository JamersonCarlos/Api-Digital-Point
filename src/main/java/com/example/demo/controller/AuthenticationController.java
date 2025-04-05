package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.config.security.TokenService;
import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.dto.ErrorResponseDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.dto.ResponseSubject;
import com.example.demo.dto.ValidateTokenDTO;
import com.example.demo.exception.NotRegisterMatriculaUser;
import com.example.demo.exception.TokenInvalidException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserWorkInfoRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired 
    private AuthenticationManager authenticationManager;

    @Autowired 
    private UserWorkInfoRepository userWorkInfoRepository; 

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService; 

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data) { 
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponseDTO("Credenciais inválidas. Verifique seu login e senha."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {
        if(this.userRepository.findByLogin(data.login()) != null) throw new UserAlreadyExistsException("O usuário com login '" + data.login() + "' já existe."); 
        if(this.userWorkInfoRepository.findByMatricula(data.login()) == null) throw new NotRegisterMatriculaUser("A matricula " + data.login() + " não está cadastrada");

        //Criptografando a senha do usuário e salvando no banco de dados
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password()); 
        User newUser = new User(data.name(), data.login(), encryptedPassword, Role.USER);
        this.userRepository.save(newUser);
        
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-token")
    public ResponseEntity<?> verifyToken(@RequestBody ValidateTokenDTO token) {
        try {
            tokenService.validateToken(token.token());
            return ResponseEntity.ok().build();
        } catch (TokenInvalidException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponseDTO("Token inválido ou expirado. Faça login novamente."));
        }
    }

 }
