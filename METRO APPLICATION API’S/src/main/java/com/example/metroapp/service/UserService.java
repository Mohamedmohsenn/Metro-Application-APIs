package com.example.metroapp.service;

import com.example.metroapp.interfaces.IUserService;
import com.example.metroapp.model.User;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public Double getUserBalance(Integer userID){
        User user = userRepo.getById(userID);
        return user.getBalance();
    }
    @Override
    public Boolean changeUserPassword(String username,String oldPassword,String newPassword){

        User user=userRepo.findByUsername(username)
                .orElse(null);
        if (user == null)
        {
            return false;
        }
        String userPassword = user.getPassword();
        String encryptedNewPassword = encoder.encode(newPassword);
        if(encoder.matches(oldPassword,userPassword)){
            try {
                user.setPassword(encryptedNewPassword);
                userRepo.save(user);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
        return false;
    }
    @Override
    public Boolean changeUserEmail(String username,String password,String newEmail){

        User user= userRepo.findByUsername(username)
                .orElse(null);
        if (user == null)
        {
            return false;
        }
        String userPassword = user.getPassword();
        if(encoder.matches(password,userPassword)){
            try {
                user.setEmail(newEmail);
                userRepo.save(user);
                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }
        return false;
    }
    @Override
    public Boolean changeUserPhoneNum(String username,String password,String newPhoneNum){
        User user= userRepo.findByUsername(username)
                .orElse(null);
        if (user == null)
        {
            return false;
        }
        String userPassword = user.getPassword();
        if(encoder.matches(password,userPassword)){
            try {
                user.setPhone_number(newPhoneNum);
                userRepo.save(user);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
        return false;
    }
    @Override
    public Boolean changeUserFullName(String username,String newName){
        User user= userRepo.findByUsername(username)
                .orElse(null);
        if (user == null)
        {
            return false;
        }
        try {
            user.setFullname(newName);
            userRepo.save(user);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    @Override
    public Boolean changeUserDate(String username, Date newDate){
        User user= userRepo.findByUsername(username)
                .orElse(null);
        if (user == null)
        {
            return false;
        }
        try {
            user.setDate_of_birth(newDate);
            userRepo.save(user);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
