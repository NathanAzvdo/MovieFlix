package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.User;
import dev.movie.Movieflix.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User save(User newUser){
        String pass = newUser.getPassword();
        newUser.setPassword(passwordEncoder.encode(pass));
        return userRepository.save(newUser);
    }
}
