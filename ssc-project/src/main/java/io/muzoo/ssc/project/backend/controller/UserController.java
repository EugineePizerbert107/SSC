package io.muzoo.ssc.project.backend.controller;
import io.muzoo.ssc.project.backend.model.User;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    //nav
    //make controller for create user and update user
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/currUser")
    public Integer findUser(){
//        User user = userRepository.findFirstByUsername()
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        User user = userRepository.findFirstByUsername(currentUser);
        return user.getId();
    }
}
