package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DailyGoals {

    private int caloriesOut;
    private double distance;
    private int floors;
    private int steps;


    public DailyGoals(int theCalories, int theDistance, int theFloors, int theSteps) throws JSONException {
        caloriesOut = theCalories;
        distance = theDistance;
        floors = theFloors;
        steps = theSteps;
    }

    public DailyGoals() {
        caloriesOut = 750;
        distance = 100;
        floors = 200;
        steps = 2500;
    }

    public int getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(int caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
