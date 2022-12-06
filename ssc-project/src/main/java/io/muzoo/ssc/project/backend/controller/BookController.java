package io.muzoo.ssc.project.backend.controller;

import io.muzoo.ssc.project.backend.model.Book;
import io.muzoo.ssc.project.backend.repository.BookRepository;
import io.muzoo.ssc.project.backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/api/bookList")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }


}
