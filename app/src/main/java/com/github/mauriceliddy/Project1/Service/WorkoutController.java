package com.github.mauriceliddy.Project1.Service;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.mauriceliddy.Project1.DataManagement.UserDatabaseAccess;
import com.github.mauriceliddy.Project1.Model.*;

@WebServlet("/workouts")
public class WorkoutController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ran doGet() in workouts");
        
        UserDatabaseAccess uAccess = new UserDatabaseAccess();
         List<Workout> workouts = new ArrayList<>();
         workouts = uAccess.retrieveAllFromDb();
        
         ObjectMapper mapper = new ObjectMapper();
         String jsonString = mapper.writeValueAsString(workouts);
        resp.setContentType("application/json");
        resp.getWriter().print(jsonString);
       // resp.getWriter().print(athleteListFromDB);
        //out.flush();
      

    }

}
