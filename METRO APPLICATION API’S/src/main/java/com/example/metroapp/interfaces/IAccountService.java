package com.example.metroapp.interfaces;

import com.example.metroapp.model.User;


public interface IAccountService {
    public boolean login(String email,String password);
    public boolean SignUp(User user);
    public User get(Integer id);
}
