package com.example.metroapp.service;
import com.example.metroapp.interfaces.IAccountService;
import com.example.metroapp.repository.UserRepo;
import com.example.metroapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean SignUp(User user)
    {
        List<User> users = userRepo.findAll();
        boolean isExist = false;
        for(User u : users)
        {
            if(u.getEmail().equals(user.getEmail())) {
                isExist = true;
                break;
            }
        }
        if(!isExist)
        {
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String email,String password)
    {
        List<User> users = userRepo.findAll();
        for(User user : users)
        {
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
//    public void save(User user) {
//        userRepo.save(user);
//    }
//
//    public void delete(Integer id) {
//        userRepo.deleteById(id);
//    }
//
    @Override
    public User get(Integer id) {
        return userRepo.findById(id).get();
    }
//
//    public List<User> listAll(){
//        return userRepo.findAll();
//    }
}
