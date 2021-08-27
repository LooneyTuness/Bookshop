package com.example.bookshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    private Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(
                    name = "bookId", referencedColumnName = "authorId"),
            inverseJoinColumns = @JoinColumn(
                    name = "authorId", referencedColumnName = "bookId"))
    private List<Book> books;

    public Author() { }

    public Author(Long authorId, String fname, String lname, Date dateOfBirth) {
        this.authorId = authorId;
        this.fname = fname;
        this.lname = lname;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAuthorId() { return authorId; }

    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + authorId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
