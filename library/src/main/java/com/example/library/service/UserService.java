package com.example.library.service;

import com.example.library.controller.dto.LoginDTO;
import com.example.library.controller.dto.LoginResponceDTO;
import com.example.library.error.NoSuchUserException;
import com.example.library.error.UserAlreadyExistsException;
import com.example.library.error.WrongPasswordException;
import com.example.library.infrastructure.entity.UserEntity;
import com.example.library.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }
    public UserEntity getOne(long user_id){
        return userRepository.findById(user_id).orElseThrow(NoSuchUserException::create);
    }
    public UserEntity create(UserEntity user){
        Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()){
            throw UserAlreadyExistsException.create(user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void delete(long user_id){
        if(!userRepository.existsById(user_id)){
            throw NoSuchUserException.create();
        }
        userRepository.deleteById(user_id);
    }

    public LoginResponceDTO login(LoginDTO dto){
        UserEntity userEntity = userRepository.findByUsername(dto.getUsername()).orElseThrow(RuntimeException::new);

        if(!passwordEncoder.matches(dto.getPassword(), userEntity.getPassword())){
            throw WrongPasswordException.create();
        }

        String token = jwtService.generateToken(userEntity);
        return new LoginResponceDTO(token);
    }
}
