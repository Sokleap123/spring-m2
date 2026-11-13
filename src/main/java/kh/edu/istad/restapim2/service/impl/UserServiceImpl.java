package kh.edu.istad.restapim2.service.impl;

import kh.edu.istad.restapim2.model.CreateUserRequest;
import kh.edu.istad.restapim2.model.User;
import kh.edu.istad.restapim2.repository.UserRepository;
import kh.edu.istad.restapim2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User create(CreateUserRequest request) {
        User newUser = new User(
                UUID.randomUUID(),
                request.name(),
                request.username(),
                request.password(),
                true
        );
        userRepository.insert(newUser);
        return newUser;
    }
    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}