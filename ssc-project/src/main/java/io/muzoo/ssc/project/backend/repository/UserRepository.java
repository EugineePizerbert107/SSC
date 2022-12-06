package io.muzoo.ssc.project.backend.repository;

import io.muzoo.ssc.project.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByUsername(String username);

//    User findByUsername(String username);

}
