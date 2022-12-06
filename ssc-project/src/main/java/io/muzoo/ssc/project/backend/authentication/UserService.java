package io.muzoo.ssc.project.backend.authentication;

import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private PasswordEncoder passEncode = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        io.muzoo.ssc.project.backend.model.User user = userRepository.findFirstByUsername(username);
//        if ("admin".equals(username)){
//            return User.withUsername(username).password(passEncode.encode("123456")).roles("USER").build();
//        } else {
//            throw new UsernameNotFoundException("Invalid username or password");
//        }
        if(user!=null){
            return User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        }
        else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
