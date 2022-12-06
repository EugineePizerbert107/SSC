package io.muzoo.ssc.project.backend.initiation;

import io.muzoo.ssc.project.backend.model.Author;
import io.muzoo.ssc.project.backend.model.Book;
import io.muzoo.ssc.project.backend.model.Review;
import io.muzoo.ssc.project.backend.model.User;
import io.muzoo.ssc.project.backend.repository.AuthorRepository;
import io.muzoo.ssc.project.backend.repository.BookRepository;
import io.muzoo.ssc.project.backend.repository.ReviewRepository;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InitAppRunner implements ApplicationRunner {

    private PasswordEncoder passEncode = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AuthorRepository authorRepository;


    //building the new user, also new books will be list at here, build the publisher, and author
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = userRepository.findFirstByUsername("reader");
        if(user == null){
//            Author author = new Author();
//            author.setName("Jk. Rowling");
//            author.setYearBorn(1985);
//            author.setEmail("JkRowling@gmail.com");
//            author.setBiography("She is a great author!");
//            author.setBooks(books);


            Author author = Author.builder().name("Jk. Rowling").yearBorn(1985).
                    email("JkRowling@gmail.com").biography("She is a great author!").build();

            authorRepository.save(author);

            Author author1 = Author.builder().name("Gavin Sukhwir").yearBorn(2001).
                    email("gavinsukhwir@gmail.com").biography("I am born in Jakarta").build();

            authorRepository.save(author1);

//            Book book = new Book();
//            book.setYear(2015);
//            book.setTitle("Dusk until Dawn");
//            book.setDescription("Reader should read this book");
//            book.setPrice(200);
//            book.setAuthor(author);
//            bookRepository.save(book);
//
//            Book book1 = new Book();
//            book1.setYear(2010);
//            book1.setTitle("Lockwood & Co");
//            book1.setDescription("Detective of ghost");
//            book1.setPrice(1000);
//            book1.setAuthor(author);
//            bookRepository.save(book1);

            Book book = Book.builder().year(2015).title("Dusk Until Dawn").
                    description("Reader should read this book").price(200).author(author).build();

            bookRepository.save(book);

            Book book1 = Book.builder().year(2010).title("Lockwood & Co").
                    description("Detective of ghost").price(1000).author(author1).build();

            bookRepository.save(book1);


//            Set<Book> books = new HashSet<>();
//            books.add(book);
//            books.add(book1);

//            admin = new User();
//            admin.setUsername("reader");
//            admin.setPassword(passEncode.encode("123456"));
//            admin.setEmail("reader@gmail.com");
//            userRepository.save(admin);

            User admin = User.builder().username("admin").password(passEncode.encode("123456"))
                    .email("admin@gmail.com").role("admin").build();

            userRepository.save(admin);

            User reader = User.builder().username("reader").password(passEncode.encode("123456"))
                    .email("reader@gmail.com").role("reader").build();

            userRepository.save(reader);

            Review review = Review.builder().description("This book is good").rating(5)
                    .user(admin).book(book).build();

            reviewRepository.save(review);

            Review review1 = Review.builder().description("This book is so fun to read").rating(5)
                    .user(reader).book(book1).build();

            reviewRepository.save(review1);
        }
    }
}
