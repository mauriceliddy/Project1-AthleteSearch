package com.github.mauriceliddy.Project1.Driver;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.github.mauriceliddy.Project1.Model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessData {
    private final Logger logger = LogManager.getLogger(this.getClass());

    int distance = 0;
    int gain = 0;
    double time = 0;
    String workoutType = "";
    Scanner scan = new Scanner(System.in);
   // List<Workout> masterList;

    // public ProcessData(List<Workout> masterList) {
    //     this.masterList = masterList;
    // }

   
    /**
     *
     * @param workoutType
     * @param day
     */
    public String findWorkout(List<Workout> masterList,String workoutType, String day, int amount) {
        String response="";
        boolean workoutFound = false;
        for (Workout workout : masterList) {
            switch (workoutType) {
            case "distance":
                if (workout.getDistance() == amount && workout.getDay().equals(day)) {
                    response += "We found a workout, you should run with: " + workout.getUserAccount().getName()
                            + " on " + workout.getDay() + "\n";
                    workoutFound = true;
                }
                break;
            case "gain":
                if (workout.getGain() == amount && workout.getDay().equals(day)) {
                    response += "We found a workout, you should run with: " + workout.getUserAccount().getName()
                            + " on " + workout.getDay()+ "\n";;
                    workoutFound = true;
                }
                break;
            case "time":
                if (workout.getTime() == amount && workout.getDay().equals(day)) {
                    response += "We found a workout, you should run with: " + workout.getUserAccount().getName()
                            + " on " + workout.getDay()+ "\n";;
                    workoutFound = true;
                }
                break;
            }
        }

        if (!workoutFound) {
            response = "Sorry, no one to run with this week..";
            logger.info("No workout found for the user during this session");
        }
        if (workoutFound) {
            logger.info("User found a desired workout for this week");

        }
        return response;

    }

     // /**
    //  * 
    //  * @param day
    //  * @param choice
    //  * @throws Exception
    //  */
    // public void processChoice(String day, int choice) throws Exception {
    //     List<String> strDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thusday", "Friday");
    //     List<Integer> strChoices = Arrays.asList(1, 2, 3);

    //     if (strDays.contains(day) && strChoices.contains(choice)) {
    //         switch (choice) {
    //         case 1:
    //             System.out.println("How far do you want to run?");
    //             distance = scan.nextInt();
    //             workoutType = "distance";
    //             break;
    //         case 2:
    //             System.out.println("How much vertical gain do you want?");
    //             gain = scan.nextInt();
    //             workoutType = "gain";
    //             break;
    //         case 3:
    //             System.out.println("How much time do you want to run for in hours?");
    //             time = scan.nextDouble();
    //             workoutType = "time";
    //             break;
    //         }
    //         findWorkout(workoutType, day, distance, gain, time);
    //     } else {
    //         System.out.println("Invalid choice(s). Ending program...");
    //         logger.error("User entered wrong/invalid choices, application crashed");
    //         throw new Exception();
    //         }        

    // }

}
