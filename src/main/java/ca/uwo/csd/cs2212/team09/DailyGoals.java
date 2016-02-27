package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by taylor on 2016-02-27.
 */
public class DailyGoals {

    int caloriesOut;
    double distance;
    int floors;
    int steps;


    DailyGoals() throws JSONException{

        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/goals/daily.json"));
        caloriesOut = obj.getInt("caloriesOut");
        distance = obj.getDouble("distance");
        floors = obj.getInt("floors");
        steps = obj.getInt("steps");
    }

    public int getCaloriesOutGoal() {
        return caloriesOut;
    }

    public double getDistanceGoal() {
        return distance;
    }

    public int getFloorsGoal() {
        return floors;
    }

    public int getStepsGoal() {
        return steps;
    }


}
