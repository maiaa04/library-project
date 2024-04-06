package com.example.library.service;

import com.example.library.error.NoSuchLoanException;
import com.example.library.infrastructure.entity.LoanEntity;
import com.example.library.infrastructure.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository bookRepository) {
        this.loanRepository = bookRepository;
    }

    public List<LoanEntity> getAll(){
        return loanRepository.findAll();
    }
    public LoanEntity getOne(long id){
        return loanRepository.findById(id).orElseThrow(NoSuchLoanException::create);
    }
    public LoanEntity create(LoanEntity book){
        return loanRepository.save(book);
    }
    public void delete(long id){
        if(!loanRepository.existsById(id)){
            throw NoSuchLoanException.create();
        }
        loanRepository.deleteById(id);
    }
}
