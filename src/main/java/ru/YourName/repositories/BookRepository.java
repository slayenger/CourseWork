package ru.YourName.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.YourName.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
