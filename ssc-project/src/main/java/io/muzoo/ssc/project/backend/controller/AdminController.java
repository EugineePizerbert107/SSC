package io.muzoo.ssc.project.backend.controller;
import io.muzoo.ssc.project.backend.model.Author;
import io.muzoo.ssc.project.backend.model.Book;
import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.repository.AuthorRepository;
import io.muzoo.ssc.project.backend.repository.BookRepository;
import io.muzoo.ssc.project.backend.repository.ReviewRepository;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/api/addAuthor")
    public Author addAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    @PostMapping("/api/addBook")
    public Book addBook(@RequestBody Book book){
//        Author author = authorRepository.findFirstById(1);
//        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @GetMapping("/api/authorList")
    public List<Author> findAll(){
        return authorRepository.findAll();
    }

}
