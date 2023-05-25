package ru.YourName.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.YourName.dto.BookShort;
import ru.YourName.model.Book;
import ru.YourName.model.ReaderTicketUser;
import ru.YourName.repositories.BookRepository;
import ru.YourName.repositories.ReaderTicketUserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReaderTicketUserRepository readerTicketUserRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addNewBook(Book book)
    {
        Book newBook = bookRepository.save(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(newBook.getBookId()) ;
    }
    @Override
    public ResponseEntity<?> getBookShort(Integer bookId) {
        Book book = bookRepository.getReferenceById(bookId);
        if (!bookRepository.existsById(bookId))
        {
            return new ResponseEntity<>("Book with id " + bookId + " not found!", HttpStatus.BAD_REQUEST);
        }
        BookShort bookShort = new BookShort(book.getBookId(), book.getBookName(),book.isInStock(),
                book.getPublishingHouse(),book.getAuthors());

        return new ResponseEntity<>(bookShort,HttpStatus.OK);
    }

    @Override
    public List<BookShort> getAllBooksShort()
    {
        //add short info about all books
        List<BookShort> bookShorts = bookRepository.findAll().stream()
                .map(book -> new BookShort(book.getBookId(), book.getBookName(),book.isInStock(),
                        book.getAuthors(),book.getYearOfPublication())).
                collect(Collectors.toList());

        return bookShorts;
    }

    @Override
    public ResponseEntity<?> getBook(int bookId) {
        Map<String, Object> result = new HashMap<>();

        if (!bookRepository.existsById(bookId)) {
            return new ResponseEntity<>("Book with id " + bookId + " not found!",HttpStatus.BAD_REQUEST);
        }

        Book book = bookRepository.getReferenceById(bookId);
        result.put("book", book);

        List<ReaderTicketUser> readerTicketUsers = readerTicketUserRepository.findByBookBookId((Integer) bookId);
        result.put("readerTicketUsers", readerTicketUsers);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> deleteBook(int bookId) {
        if (!bookRepository.existsById(bookId)) {
            return new ResponseEntity<>("Book with id " + bookId + " not found!", HttpStatus.BAD_REQUEST);
        }
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>("Book " + bookId + " has been deleted!", HttpStatus.OK);
    }
}
