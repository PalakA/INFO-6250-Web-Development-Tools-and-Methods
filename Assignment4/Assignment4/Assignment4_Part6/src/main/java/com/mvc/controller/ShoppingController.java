/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ajayp
 */

@Controller
public class ShoppingController {
    
    @RequestMapping(value="/book.htm", method = RequestMethod.GET)
    public void getProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<String> list;
        if (action.equals("add")) {
            String[] items = request.getParameterValues("chkItem");
            if (session.getAttribute("list") != null)
                list = (List<String>) session.getAttribute("list");
            else
                list = new ArrayList<>();
            for (String s : items) {
                list.add(s);
            }
            request.setAttribute("item", items);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirmAdd.jsp");
            rd.forward(request, response);
        } else {
            String element = request.getParameter("element");
            list = (List<String>) session.getAttribute("list");
            list.remove(element);
            request.setAttribute("item", element);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirmDelete.jsp");
            rd.forward(request, response);
        }
        session.setAttribute("list", list);
    }
    
    @RequestMapping(value="/book.htm", method = RequestMethod.POST)
    public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<String> list;
        if (action.equals("add")) {
            String[] items = request.getParameterValues("chkItem");
            if (session.getAttribute("list") != null)
                list = (List<String>) session.getAttribute("list");
            else
                list = new ArrayList<>();
            for (String s : items) {
                list.add(s);
            }
            request.setAttribute("item", items);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirmAdd.jsp");
            rd.forward(request, response);
        } else {
            String element = request.getParameter("element");
            list = (List<String>) session.getAttribute("list");
            list.remove(element);
            request.setAttribute("item", element);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirmDelete.jsp");
            rd.forward(request, response);
        }
        session.setAttribute("list", list);
    }
}
