package kh.edu.istad.restapim2.service;

import kh.edu.istad.restapim2.model.CreateUserRequest;
import kh.edu.istad.restapim2.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User getById(UUID id);
    User create(CreateUserRequest request);
    void delete(UUID id);
}