package ru.YourName.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.YourName.dto.BookShort;
import ru.YourName.model.Book;
import ru.YourName.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService=bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<?> addNewBook(@RequestBody Book book)
    {
        return bookService.addNewBook(book);
    }

    @GetMapping("/books/short/{bookId}")
    public ResponseEntity<?> getBookShort(@PathVariable Integer bookId)
    {
        return bookService.getBookShort(bookId);
    }

    @GetMapping("/books/short")
    public List<BookShort> getAllBooksShort()
    {
       return bookService.getAllBooksShort();
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable int bookId)
    {
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/books/{bookId}")
    @Transactional
    public ResponseEntity<?> deleteBook(@PathVariable int bookId)
    {
        return bookService.deleteBook(bookId);
    }

}
