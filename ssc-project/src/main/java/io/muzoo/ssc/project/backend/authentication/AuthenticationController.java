package io.muzoo.ssc.project.backend.authentication;

import io.muzoo.ssc.project.backend.SimpleResponseDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AuthenticationController {

    @GetMapping("/test")
    public String tesst(){
        return "Testing page";
    }

    @PostMapping("/api/login")
    public SimpleResponseDTO login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password =  request.getParameter("password");
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal!=null && principal instanceof User){
                request.logout();
            }
            request.login(username, password);
//            return "Login Success";
            return SimpleResponseDTO
                    .builder()
                    .success(true)
                    .message("You are login.")
                    .build();
        } catch (ServletException e) {
            return SimpleResponseDTO
                    .builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/api/logout")
    public SimpleResponseDTO logout(HttpServletRequest request){
        try {
            request.logout();
//            session.invalidate();
//            return "Logout";
            return SimpleResponseDTO
                    .builder()
                    .success(true)
                    .message("Successful Logout.")
                    .build();
        } catch (ServletException e) {
//            return "Failed to logout.";
            return SimpleResponseDTO
                    .builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }

    }
}
