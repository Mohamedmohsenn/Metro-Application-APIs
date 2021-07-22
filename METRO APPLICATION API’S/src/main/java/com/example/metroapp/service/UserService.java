package com.example.metroapp.service;

import com.example.metroapp.interfaces.IUserService;
import com.example.metroapp.model.User;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
@Autowired
    UserRepo userRepo;
    public Double getUserBalance(Integer userID){
        User user = userRepo.getById(userID);
        return user.getBalance();
    }
}
