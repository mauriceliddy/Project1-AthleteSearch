// package com.github.mauriceliddy.Project1.Service;

// import java.io.IOException;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.github.mauriceliddy.Project1.DataManagement.UserDatabaseAccess;
// import com.github.mauriceliddy.Project1.Model.*;

// import java.util.ArrayList;
// import java.util.List;

// @WebServlet("/userLogin")
// public class userController2 extends HttpServlet {
    
//       HttpSession session;
//       String userName="";
//       UserAccount user;
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         System.out.println("IN doget() for adminController");
//         // String word = null;
//         // System.out.println("Attribute id: "+ req.getAttribute(word));
//          session= req.getSession();
//         System.out.println("Session ID: "+ session.getAttribute("name"));
//          userName = (String)session.getAttribute("name");

//         UserDatabaseAccess uAccess = new UserDatabaseAccess();
//          user =  uAccess.getSingleUser(userName);
//         // System.out.println("Got in the servet: "+ user);
//         List<Workout> workouts = new ArrayList<>();

//          workouts = uAccess.getWorkouts(user.getId());
//         // System.out.println("Workout from db: "+ workouts);
        
//          ObjectMapper mapper = new ObjectMapper();
//          String jsonString = mapper.writeValueAsString(workouts);
//         resp.setContentType("application/json");
//         resp.getWriter().print(jsonString);
//     }

//     @Override
//     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         System.out.println("Ran doGet() in workouts");
        
//         UserDatabaseAccess uAccess = new UserDatabaseAccess();
        
//         String day = req.getParameter("day");
//         int distance = Integer.parseInt((req.getParameter("distance")));
//         int time = Integer.parseInt((req.getParameter("time")));
//         int gain = Integer.parseInt((req.getParameter("gain")));

//         System.out.println("i have the correct name!: "+userName);
//         System.out.println("Just got the following name in: "+ day);
//         Workout wout = new Workout(0,day,distance,gain,time,user);
//         uAccess.addWorkout(wout);
//         resp.sendRedirect("userDashboard.html");
//     }
// }
