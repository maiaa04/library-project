package com.example.library.infrastructure.entity;

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

    @OneToMany
    @Column(name = "book_ids")
    private List<BookEntity> book_ids;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id; //?????

    @Basic
    @Column(name = "loan_date")
    private Date loan_date;

    @Basic
    @Column(name = "due_date")
    private Date due_date;

    @Basic
    @Column(name = "return_date")
    private Date return_date;

    public long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(long loan_id) {
        this.loan_id = loan_id;
    }

    public List<BookEntity> getBook_ids() {
        return book_ids;
    }

    public void setBook_ids(List<BookEntity> book_ids) {
        this.book_ids = book_ids;
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
