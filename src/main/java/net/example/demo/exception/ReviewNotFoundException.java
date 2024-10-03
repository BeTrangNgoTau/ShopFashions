package net.example.demo.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
            super("Review not found with ID: " + id);
        }
}
