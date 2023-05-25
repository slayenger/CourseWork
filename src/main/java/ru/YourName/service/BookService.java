package ru.YourName.service;

import org.springframework.http.ResponseEntity;
import ru.YourName.dto.BookShort;
import ru.YourName.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    public List<Book> getAllBooks();

    public ResponseEntity<?> addNewBook(Book book);

    public ResponseEntity<?> getBookShort(Integer bookId);

    public ResponseEntity<?> getBook(int bookId);

    public ResponseEntity<?> deleteBook(int bookId);

    public List<BookShort> getAllBooksShort();

}
