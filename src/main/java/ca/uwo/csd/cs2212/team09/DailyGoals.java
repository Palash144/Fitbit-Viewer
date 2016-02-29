package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by taylor on 2016-02-27.
 * Fetches the Daily Goals using the constructor
 *
 */
public class DailyGoals {

    private int caloriesOut;
    private double distance;
    private int floors;
    private int steps;


    /**
     * Constructor assigning the 4 goal attributes to their respective variables
     * @throws JSONException
     */
    public DailyGoals() throws JSONException{

        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/goals/daily.json"));
        final JSONObject fitData = obj.getJSONObject("goals");

        caloriesOut = fitData.getInt("caloriesOut");
        distance = fitData.getDouble("distance");
        floors = fitData.getInt("floors");
        steps = fitData.getInt("steps");
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
