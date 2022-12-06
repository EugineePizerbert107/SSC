package io.muzoo.ssc.project.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)

    private String name;

    private String email;

    private String biography;

    private int yearBorn;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;
}
