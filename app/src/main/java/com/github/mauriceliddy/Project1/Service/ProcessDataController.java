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

import com.github.mauriceliddy.Project1.DataManagement.DataInput;
import com.github.mauriceliddy.Project1.DataManagement.UserDatabaseAccess;
import com.github.mauriceliddy.Project1.Driver.ProcessData;
import com.github.mauriceliddy.Project1.Model.*;

@WebServlet("/findWorkout")

public class ProcessDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // List<UserAccount> users = new ArrayList<>();
        // System.out.println("Ran doGet() in login controller");
        // UserDatabaseAccess uAccess = new UserDatabaseAccess();
        // uAccess.accessDatabase();
        // users = uAccess.getUsers();
        // resp.getWriter().print(users);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        resp.setContentType("text/html");
        String day = req.getParameter("day");
        String type = req.getParameter("workoutType");
        int amount =  Integer.parseInt(req.getParameter("amount"));

        DataInput dataInput = new DataInput();
        UserDatabaseAccess uAccess = new UserDatabaseAccess();
        
        List<Workout> masterList = dataInput.readInData();
        ProcessData processData = new ProcessData();
        String response = processData.findWorkout(masterList, type, day, amount);
      
        resp.setContentType("text/pain");
        resp.getWriter().print(response);
           
          //  resp.sendRedirect("/app");    
        }
}
    

