package com.example.uapp.controller;

import com.example.uapp.model.Users;
import com.example.uapp.repository.UserRepo;
import com.example.uapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class MainController {

    private UserRepo userRepo;
    private UserService userService;

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable String userId) {
        return userService.findById(Integer.parseInt(userId));
    }

    @PostMapping
    public long addUser(@RequestBody Users user) {
        return userService.save(user);
    }

    @PutMapping("/{userId}")
    public Map<String, String> updateUserStatus(@PathVariable String userId) {
        return userService.updateUser(Integer.parseInt(userId));
    }
    }
