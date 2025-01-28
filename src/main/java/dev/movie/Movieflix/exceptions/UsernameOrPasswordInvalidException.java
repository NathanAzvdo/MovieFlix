package dev.movie.Movieflix.exceptions;

public class UsernameOrPasswordInvalidException extends RuntimeException {

    public UsernameOrPasswordInvalidException(String message) {
        super(message);
    }

}
