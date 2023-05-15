package ru.YourName.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.YourName.model.ReaderTicketUser;

import java.util.List;

public interface ReaderTicketUserRepository extends JpaRepository<ReaderTicketUser, Integer> {
    List<ReaderTicketUser> findByBookBookId(Integer bookId);
}
