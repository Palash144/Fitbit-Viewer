package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DailyGoals {

    private int caloriesOut;
    private double distance;
    private int floors;
    private int steps;



    public DailyGoals(boolean canned) throws JSONException{
        if (canned){
            caloriesOut =123;
            distance = 321;
            floors = 111;
            steps = 222;
        }else {
            Request getData = new Request();
            final JSONObject obj = new JSONObject(getData.requestFor("activities/goals/daily.json"));
            final JSONObject fitData = obj.getJSONObject("goals");

            caloriesOut = fitData.getInt("caloriesOut");
            distance = fitData.getDouble("distance");
            floors = fitData.getInt("floors");
            steps = fitData.getInt("steps");
        }
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
