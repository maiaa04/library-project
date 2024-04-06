package com.example.library.controller;

import com.example.library.infrastructure.entity.LoanEntity;
import com.example.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@PreAuthorize("hasRole('ADMIN')")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService bookService) {
        this.loanService = bookService;
    }

    @GetMapping
    public List<LoanEntity> getAllLoans(){
        return loanService.getAll();
    }

    @GetMapping("/{loan_id}")
    public LoanEntity getLoan(@PathVariable long loan_id){
        return loanService.getOne(loan_id);
    }

    @PostMapping
    public ResponseEntity<LoanEntity> createLoan(@RequestBody LoanEntity loan){
        var newLoan = loanService.create(loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
    }

    @DeleteMapping("/{loan_id}")
    public ResponseEntity<Void> delete(@PathVariable long loan_id){
        loanService.delete(loan_id);
        return ResponseEntity.noContent().build();
    }
}
