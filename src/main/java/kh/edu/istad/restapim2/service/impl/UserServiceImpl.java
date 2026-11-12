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

    private final UserRepository userRepository; // Fixed typo here

    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id).orElseThrow();
    }
    @Override
    public User create(CreateUserRequest request) {
        User user = new User(UUID.randomUUID(), request.name(), request.username(), request.password(), true);
        return userRepository.insert(user);

    }

    @Override
    public void delete(UUID id) {
        return userRepository.deleteById(id);
    }
        }
