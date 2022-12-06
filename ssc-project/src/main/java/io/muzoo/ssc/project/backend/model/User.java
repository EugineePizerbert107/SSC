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
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String role = "Reader";

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Review> reviews;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "book_reader", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//    @JsonIgnore
//    private Set<Book> userbooks = new HashSet<>();

}
