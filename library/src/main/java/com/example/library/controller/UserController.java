package com.example.library.controller;

import com.example.library.controller.dto.LoginDTO;
import com.example.library.controller.dto.LoginResponceDTO;
import com.example.library.infrastructure.entity.UserEntity;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{user_id}")
    public UserEntity getUser(@PathVariable long user_id){
        return userService.getOne(user_id);
    }

    @PostMapping("/create")
    @PreAuthorize("permitAll()")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        var newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginResponceDTO> login(@RequestBody LoginDTO body){
        LoginResponceDTO dto = userService.login(body);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable long user_id){
        userService.delete(user_id);
        return ResponseEntity.noContent().build();
    }
}
