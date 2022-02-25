/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment4_part9.controller;

import com.mycompany.assignment4_part9.pojo.User;
import com.mycompany.assignment4_part9.service.UserLookupService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    
    @GetMapping("/register.htm")
    public String handleGet() {
        
        return "registration-form";
    }

    @PostMapping("/register.htm")
    public String handlePost(HttpServletRequest request, UserLookupService userLookupService) {
        
        String email = request.getParameter("email");
        String pswd = request.getParameter("password");
        String startdate = request.getParameter("startdate");
        String aboutme = request.getParameter("aboutme");
        String gender = request.getParameter("gender");
        
        //create and populate User POJO
        User user = new User();
        user.setEmail(email);
        user.setPassword(pswd);
        user.setStartdate(startdate);
        user.setAboutme(aboutme);
        user.setGender(gender);
        
        //place the bean in the Scope
        request.setAttribute("userLookupService", userLookupService);
        request.setAttribute("info", userLookupService.getInfo());
        request.setAttribute("user", user);
        
        return "user-view";
    }
}
