package io.muzoo.ssc.project.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int year;

    private String description;

    private int price;

    private int ratings;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    //reader
//    @ManyToMany(mappedBy = "userbooks", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();
}
