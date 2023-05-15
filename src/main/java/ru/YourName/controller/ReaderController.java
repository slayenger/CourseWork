package ru.YourName.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.YourName.model.Book;
import ru.YourName.model.Reader;
import ru.YourName.model.ReaderTicketUser;
import ru.YourName.repositories.BookRepository;
import ru.YourName.repositories.ReaderRepository;
import ru.YourName.service.ReaderServiceImpl;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class ReaderController {

    @Autowired
    private ReaderServiceImpl readerService;


    @GetMapping("/readers")
    public List<Reader> getAllReaders()
    {
        return readerService.getAllReaders();
    }

    @PostMapping("/readers")
    public Reader addNewReader(@RequestBody Reader reader)
    {

        return readerService.addNewReader(reader);
    }

    @PutMapping("/readers/book")
    public ResponseEntity<?> giveBookToReader(@RequestParam("readerId") Integer readerId,
                                              @RequestParam("bookId") Integer bookId)
    {
        return readerService.giveBookToReader(readerId,bookId);
    }


    @DeleteMapping("/readers/book")
    public ResponseEntity<?> removeBookFromReader(@RequestParam("readerId") Integer readerId,
                                                  @RequestParam("bookId") Integer bookId)
    {
        return readerService.removeBookFromReader(readerId,bookId);
    }

    @GetMapping("/readers/{readerId}")
    public ResponseEntity<?> getReader(@PathVariable int readerId)
    {
        return readerService.getReader(readerId);
    }

    @DeleteMapping("/readers/{readerId}")
    public ResponseEntity<?> deleteReader(@PathVariable int readerId)
    {
        return readerService.deleteReader(readerId);
    }





}
