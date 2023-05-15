package ru.YourName.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "readerticketuser")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ReaderTicketUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "readerid")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Reader reader;
    @ManyToOne()
    @JoinColumn(name = "bookid", nullable = true)
    @JsonIgnore
    private Book book;

    @Column(name = "receivingdate")
    private String receivingDate;

    @Column(name = "returndate")
    private String returnDate;

    @JsonProperty
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ReaderTicketUser() {}


    public ReaderTicketUser(int id, Reader readerId, Book book, List<Book> books, String receivingDate, String returnDate) {
        this.id = id;
        this.reader = readerId;
        this.book = book;
        this.receivingDate = receivingDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReaderId() {
        return reader;
    }

    public void setReaderId(Reader readerId) {
        this.reader = readerId;
    }



    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
