package com.example.library.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loans", schema = "library")
public class LoanEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "loan_id")
    private long loan_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id; //?????

    @Basic
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "loan_date")
    private Date loan_date;

    @Basic
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "due_date")
    private Date due_date;

    @Basic
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "return_date")
    private Date return_date;

    public long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(long loan_id) {
        this.loan_id = loan_id;
    }

    public BookEntity getBook_id() {
        return book_id;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
