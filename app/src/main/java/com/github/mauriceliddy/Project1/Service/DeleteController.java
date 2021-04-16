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

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("Deleting user in doDelete..");
        UserDatabaseAccess uAccess = new UserDatabaseAccess();
       
        String stringID = req.getParameter("id");
        int intID = Integer.parseInt(stringID);
        UserAccount uAccount = new UserAccount(intID);
        uAccess.deleteUser(uAccount);
        resp.sendRedirect("dashboard.html");

        // if ((name = req.getParameter("name")) != null) {
        //     resp.getWriter().println("\n" + "(POST)Welcome: " + name + " you handsome devil, also a silly goose!");
        // } else {
        //     resp.getWriter().println("Post failed " + name);
        // }
    }
}
