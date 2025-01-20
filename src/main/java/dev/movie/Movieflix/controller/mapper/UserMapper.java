package dev.movie.Movieflix.controller.mapper;

import dev.movie.Movieflix.controller.request.UserRequest;
import dev.movie.Movieflix.controller.response.UserResponse;
import dev.movie.Movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
