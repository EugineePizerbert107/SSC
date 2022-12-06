package io.muzoo.ssc.project.backend.repository;

import io.muzoo.ssc.project.backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();

    Book findFirstById(Integer book_id);

}
