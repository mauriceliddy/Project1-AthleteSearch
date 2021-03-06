package com.github.mauriceliddy.Project1.DataManagement;
import com.github.mauriceliddy.Project1.Model.*;
import com.github.mauriceliddy.Project1.DAO.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class UserDatabaseAccess {
    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties = new Properties();
    Connection connection;
    String url;
    String password;
    String username;
    WorkoutDao wDao;
    AthleteDao aDao;
    UserAccountDao uDao;

    public UserDatabaseAccess(){

    }

    public void accessDatabase() {
        System.out.println("calling accessdatabase..");
        try {
            FileInputStream fileStream = new FileInputStream("C:/VSCode Programs/Week4/Project-1/app/database.properties");
            properties.load(fileStream);
            System.out.println("found a filestream");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        url = properties.getProperty("URL");
        password = properties.getProperty("CONNECTION_PASSWORD");
        username = properties.getProperty("CONNECTION_USERNAME");

        try {
            logger.error("Opening connection to the database...****");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("made it past driver manager");
            aDao= new AthleteDao(connection);
            wDao = new WorkoutDao(connection);
            uDao = new UserAccountDao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sendCSVDataToDatabase(List<Workout> masterList) {
        accessDatabase();

        // Erase data from database first
        clearAllTables();

        // Extract Athletes from masterlist and send to database to populate athlete
        // table first
        // Use set because I want to ignore any repeats
        Set<UserAccount> masterAthleteSet = new HashSet<>();
        for (Workout wout : masterList) {
            masterAthleteSet.add(wout.getUserAccount());
            //System.out.println(wout);
        }
System.out.println("masterAthlete set:" + masterAthleteSet);
System.out.println("end");
        // Insert each Athlete into the database
        // insertAth() method returns the athlete so we can update the Athlete ID in the
        // model based on value assigned by database
        Set<UserAccount> newSet = new HashSet<>();
        for (UserAccount ath : masterAthleteSet) {
            ath= uDao.insertUser(ath); // insert into DB
            newSet.add(ath); // add that Athlete with updated ID to Set for use later
        }


        // For each workout, set the athlete ID in the masterLst to match the athlete id
        // from the database
        for (Workout wout : masterList) {
            for (UserAccount ath : newSet) {
                if (ath.getName().equals(wout.getUserAccount().getName())) {
                    wout.getUserAccount().setId(ath.getId());
                }
            }
        }
        // Finally, since the Athlete Ids are all fixed we can insert each workout into
        // the database accurately with no existing value errors
        for (Workout wout : masterList) {
            wDao.insert(wout);
        }
    }

    public List<Workout> retrieveAllFromDb() {
        List<Workout> workoutsFromDB = new ArrayList<>();
        accessDatabase();
        workoutsFromDB = wDao.getAll();
        return workoutsFromDB;
    }

    public List<Athlete> retrieveAthletesFromDb(){
        List<Athlete> athletesFromDB = new ArrayList<>();
        accessDatabase();
        athletesFromDB =  aDao.getAll();
        return athletesFromDB;
    }

    public void clearAllTables(){
        accessDatabase();
        wDao.clearTable();
        aDao.clearTable();
        uDao.clearTable();
    }

    public void addAthlete(Athlete ath){
        accessDatabase();
        aDao.insertAth(ath);
    }

    List<UserAccount> users = new ArrayList<>();
    public List<UserAccount> getUsers(){
        accessDatabase();
        users = uDao.getAll();
        return users;
    }

    public void addUser(UserAccount user){
        accessDatabase();
        uDao.insertUser(user);
    }
    public void deleteUser(UserAccount user){
        accessDatabase();
        wDao.deleteUserWorkouts(user.getId());
        uDao.delete(user);
    }

    public UserAccount getSingleUser(String uName){
        accessDatabase();
        UserAccount user = uDao.getUser(uName);
        return user;
    }

    public List<Workout> getWorkouts(int id){
        accessDatabase();
        List<Workout> workouts = new ArrayList<>();

        workouts = wDao.getWorkouts(id);
        return workouts;
    }

    public void deleteWorkout(int wid){
        accessDatabase();
        wDao.deleteWorkout(wid);
    
    }
    public void addWorkout(Workout wout){
        accessDatabase();
        wDao.insert(wout);
    }
}
