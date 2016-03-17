package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


public class DailyGoals implements Serializable {

    private int caloriesOutGoal;
    private double distanceGoal;
    private int floorsGoal;
    private int stepsGoal;


    public DailyGoals(int theCalories, int theDistance, int theFloors, int theSteps) throws JSONException {
        caloriesOutGoal = theCalories;
        distanceGoal = theDistance;
        floorsGoal = theFloors;
        stepsGoal = theSteps;
    }

    public DailyGoals() {
        caloriesOutGoal = 750;
        distanceGoal = 100;
        floorsGoal = 200;
        stepsGoal = 2500;
    }

    public int getCaloriesOutGoal() {
        return caloriesOutGoal;
    }

    public void setCaloriesOutGoal(int caloriesOutGoal) {
        this.caloriesOutGoal = caloriesOutGoal;
    }

    public double getDistanceGoal() {
        return distanceGoal;
    }

    public void setDistanceGoal(double distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    public int getFloorsGoal() {
        return floorsGoal;
    }

    public void setFloorsGoal(int floorsGoal) {
        this.floorsGoal = floorsGoal;
    }

    public int getStepsGoal() {
        return stepsGoal;
    }

    public void setStepsGoal(int stepsGoal) {
        this.stepsGoal = stepsGoal;
    }
}