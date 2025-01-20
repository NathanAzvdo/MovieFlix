package dev.movie.Movieflix.controller;

import dev.movie.Movieflix.controller.mapper.UserMapper;
import dev.movie.Movieflix.controller.request.UserRequest;
import dev.movie.Movieflix.controller.response.UserResponse;
import dev.movie.Movieflix.entity.User;
import dev.movie.Movieflix.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        User savedUser = userService.save(UserMapper.toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }


}
