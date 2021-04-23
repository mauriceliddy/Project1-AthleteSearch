package com.github.mauriceliddy.Project1.DataManagement;
import com.github.mauriceliddy.Project1.Model.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataInput {
    List<Workout> masterList = new ArrayList<>();
    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<Workout> readInData() {

        try {
            logger.info("************************Reading in data from csv*****************");
            Scanner sc = new Scanner(new File("C:/VSCode Programs/Week4/Project-1/data.csv"));
            sc.useDelimiter(","); // sets the delimiter pattern
            while (sc.hasNext()) // returns a boolean value
            {
                UserAccount athlete = new UserAccount();
                athlete.setName(sc.next().replaceAll("\\P{Print}", ""));
                athlete.setId(Integer.parseInt(sc.next()));
                athlete.setPassword(sc.next().replaceAll("\\P{Print}", ""));
             
                Workout workout = new Workout();
                workout.setDay(sc.next());
                workout.setDistance(Integer.parseInt(sc.next()));
                workout.setGain(Integer.parseInt(sc.next()));
                workout.setTime(Double.parseDouble(sc.next()));
                workout.setUserAccount(athlete);
                masterList.add(workout);
            }
            sc.close(); // closes the scanner

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return masterList;
    }

}
