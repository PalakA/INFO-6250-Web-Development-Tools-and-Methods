/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.pojo.Book;
import com.mvc.pojo.Computer;
import com.mvc.pojo.Music;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ProductController {

    @RequestMapping(value="/book.htm", method = RequestMethod.GET)
    public void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        if(param.equals("Book")) {
            Book obj = new Book();
            request.setAttribute("list", obj.getBook());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/book.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(param.equals("Computer")) {
            Computer obj = new Computer();
            request.setAttribute("list", obj.getComputer());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/computer.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(param.equals("Music")) {
            Music obj = new Music();
            request.setAttribute("list", obj.getMusic());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/music.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    
    @RequestMapping(value="/book.htm", method = RequestMethod.POST)
    public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        if(param.equals("Book")) {
            Book obj = new Book();
            request.setAttribute("list", obj.getBook());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/book.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(param.equals("Computer")) {
            Computer obj = new Computer();
            request.setAttribute("list", obj.getComputer());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/computer.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(param.equals("Music")) {
            Music obj = new Music();
            request.setAttribute("list", obj.getMusic());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/music.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
