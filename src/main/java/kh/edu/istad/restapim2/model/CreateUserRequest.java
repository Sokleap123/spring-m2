package kh.edu.istad.restapim2.model;

public record CreateUserRequest(
        String name,
        String username,
        String password
) {
}