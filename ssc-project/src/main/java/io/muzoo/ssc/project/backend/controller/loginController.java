package io.muzoo.ssc.project.backend.controller;

import io.muzoo.ssc.project.backend.model.User;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/checkUser")
    public loginDTO checking(){
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal!=null && principal instanceof org.springframework.security.core.userdetails.User){
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
                User u = userRepository.findFirstByUsername(user.getUsername());
                return loginDTO.builder()
                        .loggedIn(true)
                        .name(u.getUsername())
                        .role(u.getRole())
                        .username(u.getUsername())
                        .build();
            }
        } catch (Exception e) {

        }
        return loginDTO.builder()
                .loggedIn(false)
                .build();
    }
}
