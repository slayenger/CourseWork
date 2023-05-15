package ru.YourName.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "bookid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column (name = "typeid")
    private String  typeId;

    @Column(name = "bookname")
    private String bookName;

    @Column(name = "instock")
    private boolean inStock = true;
    @Column(name = "authors")
    private String authors;

    @Column(name = "numberofpages")
    private Integer numberOfPages;

    @Column(name = "publishingHouse")
    private String publishingHouse;

    @Column(name = "yearofpublication")
    private String yearOfPublication;


    public Book() {}

    public Book(String typeId, String bookName, String authors,
                Integer numberOfPages,String publishingHouse,
                String yearOfPublication, boolean inStock) {
        this.inStock=inStock;
        this.typeId = typeId;
        this.bookName = bookName;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
        this.yearOfPublication = yearOfPublication;

    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getBookId() {
        return bookId;
    }


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Integer getNumberOfPage() {
        return numberOfPages;
    }

    public void setNumberOfPage(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
