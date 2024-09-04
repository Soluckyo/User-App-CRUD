package com.example.uapp.service;

import com.example.uapp.model.Users;
import java.util.Map;

public interface UserService {
    Long save(Users user);
    Users findById(long id);
    Map<String, String> updateUser(long id);
}
