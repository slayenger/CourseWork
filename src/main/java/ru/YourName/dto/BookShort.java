package ru.YourName.dto;

public class BookShort {

    private Integer bookId;
    private String bookName;
    private boolean inStock = true;
    private String yearOfPublishing;
    private String authors;

    public BookShort() {
    }

    public BookShort(Integer bookId, String bookName, boolean inStock,
                     String yearOfPublishing, String authors) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.inStock = inStock;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
