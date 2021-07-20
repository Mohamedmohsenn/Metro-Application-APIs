package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping("/Login")
    public String login(Model model, String email, String password)
    {
        try {
            String name = adminService.login(email, password);
            if(name != null)
            {
                model.addAttribute("name", "Welcome back "+ name);
                return "home";
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return "index";
    }


    @RequestMapping("/Home")
    public String goToHome()
    {
        return "home";
    }

}
