package com.github.mauriceliddy.Project1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.github.mauriceliddy.Project1.DataManagement.*;
import com.github.mauriceliddy.Project1.Driver.ProcessData;
import com.github.mauriceliddy.Project1.Model.*;

import org.junit.jupiter.api.Test;

public class ProcessDataTest {

    // Set up Class with a Dummy Athlete and workout data
    UserAccount athlete = new UserAccount(1,"Maurice", "password1");
    Workout workout = new Workout(1,"Monday", 10, 4000, 5,athlete);
    List<Workout> masterList = new ArrayList<>();

    // Test findWorkout() to see if it will return a true when a workout is found
    @Test
    void testCorrectRunFound() {
        String str="";
        masterList.add(workout);
        ProcessData processData = new ProcessData();
        String result = processData.findWorkout(masterList,"distance", "Monday", 10);
        str = result.replaceAll("\\P{Print}", "");
        String tmp = "We found a workout, you should run with: Maurice on Monday";
        String clean = tmp.replaceAll("\\P{Print}", "");

        assertEquals(str, clean);
    }

    // Test findWorkout() to see if it will return a false when a workout is not
    // found
    @Test
    void testNoRunFound() {
        masterList.add(workout);
        ProcessData processData = new ProcessData();
        String result = processData.findWorkout(masterList,"distance", "Monday", 100);
        assertEquals(result, "Sorry, no one to run with this week..");
    }

}
