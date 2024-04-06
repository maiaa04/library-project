package com.example.library.service;

import com.example.library.error.IsbnAlreadyExistsException;
import com.example.library.error.NoSuchBookException;
import com.example.library.error.UserAlreadyExistsException;
import com.example.library.infrastructure.entity.BookEntity;
import com.example.library.infrastructure.entity.UserEntity;
import com.example.library.infrastructure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAll(){
        return bookRepository.findAll();
    }
    public BookEntity getOne(long id){
        return bookRepository.findById(id).orElseThrow(NoSuchBookException::create);
    }
    public BookEntity create(BookEntity book){
        Optional<BookEntity> existingBook = bookRepository.findByIsbn(book.getIsbn());

        if (existingBook.isPresent()){
            throw IsbnAlreadyExistsException.create(book.getIsbn());
        }
        return bookRepository.save(book);
    }
    public void delete(long id){
        if(!bookRepository.existsById(id)){
            throw NoSuchBookException.create();
        }
        bookRepository.deleteById(id);
    }
}
