package ru.YourName.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.YourName.model.Reader;

import java.util.List;

public interface ReaderService {

    public List<Reader> getAllReaders();

    public Reader addNewReader(Reader reader);

    public ResponseEntity<?> giveBookToReader( Integer readerId, Integer bookId);

    public ResponseEntity<?> removeBookFromReader( Integer readerId,  Integer bookId);

    public ResponseEntity<?> getReader(int id);

    public ResponseEntity<?> deleteReader(int bookId);

}
