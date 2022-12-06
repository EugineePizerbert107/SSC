package io.muzoo.ssc.project.backend.repository;

import io.muzoo.ssc.project.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAll();

    List<Review> findAllByUserUsername(String username);
}
