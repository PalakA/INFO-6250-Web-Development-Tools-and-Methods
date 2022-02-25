/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment4_part7.controller;

import com.mycompany.assignment4_part7.pojo.User;
import com.mycompany.assignment4_part7.service.UserLookupService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author palak
 */

public class RegistrationController extends AbstractController{
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        UserLookupService utility = (UserLookupService) this.getApplicationContext().getBean("userLookupService");
        request.setAttribute("info", utility.getInfo());
        request.setAttribute("userLookupService", utility);
        
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
        request.setAttribute("user", user);
        
        return new ModelAndView("user-view");
    }
}
