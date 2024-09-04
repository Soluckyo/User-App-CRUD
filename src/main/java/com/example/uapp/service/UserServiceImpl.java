package com.example.uapp.service;

import com.example.uapp.exception.UserNotFoundException;
import com.example.uapp.model.Users;
import com.example.uapp.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    @Override
    public Long save(Users user) {
        return userRepo.save(user).getId();
    }

   @Override
   public Users findById(long id) {
       if(userRepo.findById(id).isEmpty())
           throw new UserNotFoundException("User does not exist");

        return userRepo.findById(id).get();
   }

    @Override
    public Map<String, String> updateUser(long id) {
        if(userRepo.findById(id).isEmpty())
            throw new UserNotFoundException("User does not exist");

        Users user = userRepo.findById(id).get();
        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", "" + user.getId());
        updateResponse.put("previous status", user.getStatus());
        if(user.getStatus().equalsIgnoreCase("offline")) {
            user.setStatus("online");
            updateResponse.put("current status", user.getStatus());
        }else {
            user.setStatus("offline");
            updateResponse.put("current status", user.getStatus());
        }
        userRepo.save(user);
        return updateResponse;
    }
}
