package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.User;
import dev.movie.Movieflix.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User newUser){
        return userRepository.save(newUser);
    }
}
