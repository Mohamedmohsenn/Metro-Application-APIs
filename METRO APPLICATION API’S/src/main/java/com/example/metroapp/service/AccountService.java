package com.example.metroapp.service;
import com.example.metroapp.interfaces.IAccountService;
import com.example.metroapp.repository.UserRepo;
import com.example.metroapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService implements IAccountService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public User get(Integer id) {
        return userRepo.findById(id).get();
    }

}
