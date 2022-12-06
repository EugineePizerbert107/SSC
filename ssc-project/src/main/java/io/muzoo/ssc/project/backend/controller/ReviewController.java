package io.muzoo.ssc.project.backend.controller;

import io.muzoo.ssc.project.backend.model.Book;
import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.model.User;
import io.muzoo.ssc.project.backend.repository.BookRepository;
import io.muzoo.ssc.project.backend.repository.ReviewRepository;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    //all review methods list at here
    //get all reviews that user made
    @GetMapping("/api/user/{username}/reviews")
    public List<Review> findAll(@PathVariable String username){
        return reviewRepository.findAllByUserUsername(username);
    }

    @PostMapping("/api/createReview/{book_id}/{username}")
    public Review createReview(@PathVariable String username, @PathVariable Integer book_id, @RequestBody Review review){
        User user = userRepository.findFirstByUsername(username);
        review.setUser(user);
        Book book = bookRepository.findFirstById(book_id);
        review.setBook(book);
        return reviewRepository.save(review);
    }

    @Transactional
    @DeleteMapping("/api/deleteReview/{review_id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer review_id) {
        reviewRepository.deleteById(review_id);
        return ResponseEntity.noContent().build();
    }
}
