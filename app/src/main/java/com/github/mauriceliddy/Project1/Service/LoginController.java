package com.github.mauriceliddy.Project1.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.mauriceliddy.Project1.DAO.AthleteDao;
import com.github.mauriceliddy.Project1.DataManagement.*;
import com.github.mauriceliddy.Project1.DataManagement.UserDatabaseAccess;
import com.github.mauriceliddy.Project1.Model.*;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserAccount> users = new ArrayList<>();
        System.out.println("Ran doGet() in login controller");
        UserDatabaseAccess uAccess = new UserDatabaseAccess();
        uAccess.accessDatabase();
        users = uAccess.getUsers();
        resp.getWriter().print(users);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println("Just got the following name in: "+ name);
        String password = req.getParameter("password");
        System.out.println("Just got the following password in: "+ password);
        
        if(name.equals("Maurice")&& password.equals("password")){
        resp.sendRedirect("dashboard.html");    
        }
        else{
            resp.sendRedirect("/app");    
        }
        //resp.sendRedirect("http://localhost:8080/app/");

        // if ((name = req.getParameter("name")) != null) {
        //     resp.getWriter().println("\n" + "(POST)Welcome: " + name + " you handsome devil, also a silly goose!");
        // } else {
        //     resp.getWriter().println("Post failed " + name);
        // }
    }
}
