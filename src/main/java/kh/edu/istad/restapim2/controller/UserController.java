package kh.edu.istad.restapim2.controller;

import kh.edu.istad.restapim2.model.User; // Fixed package path and imported the User model
import kh.edu.istad.restapim2.model.CreateUserRequest; // Fixed package path
import kh.edu.istad.restapim2.service.UserService; // Fixed package path
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController { // Removed the generic <User> parameter

    private final UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id){
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}