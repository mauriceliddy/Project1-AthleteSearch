package com.github.mauriceliddy.Project1.Service;

import java.io.IOException;
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        resp.setContentType("text/html");
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
         Logger logger = LogManager.getLogger(this.getClass());
            logger.error("An Admin User just logged in");
           resp.sendRedirect("adminDashboard.html");    
        }
        else if(userAccess){
            Logger logger = LogManager.getLogger(this.getClass());
            logger.info("An regular user just logged in, the name was: "+ name);
            System.out.println("USer access is true!!");
            HttpSession session  = req.getSession();
            session.setAttribute("name", name);
            
            RequestDispatcher rd = req.getRequestDispatcher("/userDashboard.html");
             rd.forward(req, resp);
             
            }
        else{
           
            resp.sendRedirect("/app");    
        }
}
}