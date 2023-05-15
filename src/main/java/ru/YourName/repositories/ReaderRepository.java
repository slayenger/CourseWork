package ru.YourName.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.YourName.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
