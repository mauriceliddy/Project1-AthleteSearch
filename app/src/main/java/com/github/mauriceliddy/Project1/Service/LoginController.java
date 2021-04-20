package com.github.mauriceliddy.Project1.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.github.mauriceliddy.Project1.DataManagement.UserDatabaseAccess;
import com.github.mauriceliddy.Project1.Model.*;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session!=null){
            String user = (String)session.getAttribute("user");
            // do stuff here
        }

        List<UserAccount> users = new ArrayList<>();
        System.out.println("Ran doGet() in login controller");
        UserDatabaseAccess uAccess = new UserDatabaseAccess();
        uAccess.accessDatabase();
        users = uAccess.getUsers();
        resp.getWriter().print(users);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        System.out.println("Just got the following name in: "+ name);
        String password = req.getParameter("password");
        System.out.println("Just got the following password in: "+ password);
        UserDatabaseAccess uAccess = new UserDatabaseAccess();
        
        boolean userAccess = false;
         List<UserAccount> accountListFromDB = new ArrayList<>();
         accountListFromDB = uAccess.getUsers();
         for (UserAccount userAccount : accountListFromDB) {
             if(userAccount.getName().equals(name)&& userAccount.getPassword().equals(password)){
                 userAccess = true;
             }
         }

        if(name.equals("admin")&& password.equals("admin")){
           resp.sendRedirect("adminDashboard.html");    
        }
        else if(userAccess){
            System.out.println("USer access is true!!");
            HttpSession session  = req.getSession();
            session.setAttribute("name", name);
            //RequestDispatcher rd = req.getRequestDispatcher("/userLogin");
            RequestDispatcher rd = req.getRequestDispatcher("/userDashboard.html");
             rd.forward(req, resp);
            //resp.sendRedirect("userDashboard.html");    
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
