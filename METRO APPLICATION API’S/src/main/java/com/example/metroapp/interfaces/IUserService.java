package com.example.metroapp.interfaces;

import java.util.Date;

public interface IUserService {
    public Double getUserBalance(Integer userID);
    public Boolean changeUserPassword(String username,String oldPassword,String newPassword);
    public Boolean changeUserEmail(String username,String password,String newEmail);
    public Boolean changeUserPhoneNum(String username,String password,String newEmail);
    public Boolean changeUserFullName(String username,String newName);
    public Boolean changeUserDate(String username, Date newDate);
}
