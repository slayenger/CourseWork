package ru.YourName.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.YourName.model.ReaderTicketUser;
import ru.YourName.repositories.ReaderTicketUserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReaderTicketUserController {

    private final ReaderTicketUserRepository readerTicketUserRepository;

    @Autowired
    public ReaderTicketUserController(ReaderTicketUserRepository readerTicketUserRepository) {
        this.readerTicketUserRepository = readerTicketUserRepository;
    }

    @GetMapping("/tickets")
    public List<ReaderTicketUser> getAllTickets()
    {
        List<ReaderTicketUser> tickets = readerTicketUserRepository.findAll();

        /*for (ReaderTicketUser ticket: tickets)
        {
            ticket.getReader().getReaderId();
            ticket.getBook().getBookId();
        }*/

        return tickets;
    }

    @PostMapping("/tickets")
    public ReaderTicketUser addNewReader(@RequestBody ReaderTicketUser readerTicketUser)
    {
        readerTicketUserRepository.save(readerTicketUser);
        return readerTicketUser;
    }


    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<?> getReader(@PathVariable int ticketId)
    {
        if (!readerTicketUserRepository.existsById(ticketId))
        {
            return new ResponseEntity<>("Ticket with id " + ticketId + " not found!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(readerTicketUserRepository.getReferenceById(ticketId), HttpStatus.OK);
    }

    @DeleteMapping("/tickets/{ticketId}")
    public ResponseEntity<?> deleteReader(@PathVariable int ticketId)
    {
        if (!readerTicketUserRepository.existsById(ticketId))
        {
            return new ResponseEntity<>("Ticket with id " + ticketId + " not found!", HttpStatus.BAD_REQUEST);
        }

        readerTicketUserRepository.deleteById(ticketId);

        return new ResponseEntity<>("Ticket with id " + ticketId + " has been deleted!", HttpStatus.OK);
    }

    @PutMapping("/tickets")
    public ReaderTicketUser saveReaderTicketUser(@RequestBody ReaderTicketUser readerTicketUser)
    {
        readerTicketUserRepository.save(readerTicketUser);
        return readerTicketUser;
    }

}
