package ru.YourName.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.YourName.model.Book;
import ru.YourName.model.Reader;
import ru.YourName.model.ReaderTicketUser;
import ru.YourName.repositories.BookRepository;
import ru.YourName.repositories.ReaderRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public Reader addNewReader(Reader reader) {
        ReaderTicketUser readerTicketUser = new ReaderTicketUser();
        readerTicketUser.setReader(reader);
        reader.setReaderTicketUser(readerTicketUser);
        return readerRepository.save(reader);
    }

    @Override
    public ResponseEntity<?> giveBookToReader(Integer readerId, Integer bookId) {
        Optional<Reader> readerOptional = readerRepository.findById(readerId);
        if (!readerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Reader reader = readerOptional.get();

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Book book = bookOptional.get();
        book.setInStock(false);

        ReaderTicketUser readerTicketUser = reader.getReaderTicketUser();
        readerTicketUser.setBook(book);
        //setting receiving date
        Date receivingDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        readerTicketUser.setReceivingDate(dateFormat.format(receivingDate));
        //setting return date (?)
        Calendar returnDate = Calendar.getInstance();
        returnDate.add(Calendar.DATE,3);
        readerTicketUser.setReturnDate(dateFormat.format(returnDate.getTime()));

        readerRepository.save(reader);

        return ResponseEntity.ok().build();
    }

    //maybe need to fix
    @Override
    public ResponseEntity<?> removeBookFromReader(Integer readerId, Integer bookId) {
        Optional<Reader> readerOptional = readerRepository.findById(readerId);
        if (!readerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Reader reader = readerOptional.get();

        ReaderTicketUser readerTicketUser = reader.getReaderTicketUser();
        if (readerTicketUser.getBook() == null || readerTicketUser.getBook().getBookId() != bookId) {
            return ResponseEntity.notFound().build();
        }
        //update book info
        bookRepository.getReferenceById(bookId).setInStock(true);
        //deleting info about reader's book
        readerTicketUser.setReceivingDate(null);
        readerTicketUser.setReturnDate(null);
        readerTicketUser.setBook(null);
        readerRepository.save(reader);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getReader(int readerId) {
        if (!readerRepository.existsById(readerId))
        {
            return new ResponseEntity<>("Reader with " + readerId + " not found!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(readerRepository.getReferenceById(readerId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteReader(int readerId) {
        if (!readerRepository.existsById(readerId))
        {
            return new ResponseEntity<>("Reader with " + readerId + " not found!", HttpStatus.BAD_REQUEST);
        }
        readerRepository.deleteById(readerId);

        return new ResponseEntity<>("Reader with id " + readerId + " has been deleted!", HttpStatus.OK);
    }


}
