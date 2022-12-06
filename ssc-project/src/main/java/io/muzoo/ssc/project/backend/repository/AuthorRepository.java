package io.muzoo.ssc.project.backend.repository;

import io.muzoo.ssc.project.backend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findFirstById(Integer author_id);
}
