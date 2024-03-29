package com.example.library.controller;

import com.example.library.infrastructure.entity.BookEntity;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookEntity> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{book_id}")
    public BookEntity getBook(@PathVariable long book_id){
        return bookService.getOne(book_id);
    }

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book){
        var newBook = bookService.create(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<Void> delete(@PathVariable long book_id){
        bookService.delete(book_id);
        return ResponseEntity.noContent().build();
    }
}
