package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserData {
    private int Total;
    private int Best;

    /**
     * @param canned true returns canned data
     * @return the number of steps taken
     */
    public static int getSteps(boolean canned) throws JSONException {
        //TODO: This method is not quite complete, but it seems to work and you can expect the final one to look like this
        if (canned == true) {
            return 1337;
        }
        Request getData = new Request();

        //Substitute the string in getData.requestFor("STRINGHERE") for what you need
        final JSONObject obj = new JSONObject(getData.requestFor("activities/steps/date/2016-01-08/1d.json"));
        final JSONArray fitData = obj.getJSONArray("activities-steps");
        final int n = fitData.length();
        for (int i = 0; i < n; ++i) {
            final JSONObject fitAttribute = fitData.getJSONObject(i);
            //System.out.println(fitAttribute.getString("dateTime"));
            String dateTime = fitAttribute.getString("dateTime");

            //System.out.println(fitAttribute.getInt("value"));
            return fitAttribute.getInt("value");

            //System.out.println(fitAttribute.getString("time"));
        }

        //Something has gone horribly wrong if we reach this point, throw an exception here and let someone else deal with it
        return -1;
    }

    public static int getFloors(boolean canned) {
        //TODO: Complete this method
        if (canned == true) {
            return 137;
        }
        return 0;
    }

    public static int getCalories(boolean canned) {
        //TODO: Complete this method
        if (canned == true) {
            return 1500;
        }
        return 0;
    }

    public static int getDistance(boolean canned) {
        //TODO: Complete this method
        if (canned == true) {
            return 50;
        }
        return 0;
    }

    public static int getActiveMinutes(boolean canned) {
        //TODO: Complete this method
        if (canned == true) {
            return 69;
        }
        return 0;
    }

    public static int getSedentaryMinutes(boolean canned) {
        //TODO: Complete this method
        if (canned == true) {
            return 1222;
        }
        return 0;
    }

/*    public static Achievements getAchievements(boolean canned){
        //TODO: Complete this method
        return new Achievements();
    }*/

    /**
     *
     * creates the Daily Goals from the DailyGoals class constructor
     * @throws JSONException
     */
    public DailyGoals getDailyGoals( String date, boolean canned) throws JSONException{
        DailyGoals goals = new DailyGoals(date, canned);
        return goals;
    }

    /** TODO: Complete
     * Checks if user is at daily goal
     * @param canned Whether canned data is used or not
     * @return an array of strings detailing progress on daily goals. 
     * [0] = Calories 
     * [1] = Distance
     * [2] = Floors
     * [3] = Steps
     * @throws JSONException
     */
    public String[] isAtGoal(String date, boolean canned) throws JSONException{
        DailyGoals goals = new DailyGoals(date, canned);

        String[] s = new String [4];

        //Calories
        if (getCalories(canned) < goals.getCaloriesOutGoal())
        	s[0] = "Calories Burned Goal: Below goal";
        else if (getCalories(canned) == goals.getCaloriesOutGoal())
        	s[0] = "Calories Burned Goal: Reached goal";
        else
        	s[0] = "Calories Burned Goal: Surpassed goal";

        //Distance
        if (getDistance(canned) < goals.getDistanceGoal())
        	s[1] = "Distance Traveled Goal: Below goal";
        else if (getDistance(canned) == goals.getDistanceGoal())
        	s[1] = "Distance Traveled Goal: Reached goal";
        else
        	s[1] = "Distance Traveled Goal: Surpassed goal";

        //Floors
        if (getFloors(canned) < goals.getFloorsGoal())
        	s[2] = "Floors Climbed Goal: Below goal";
        else if (getFloors(canned) == goals.getFloorsGoal())
        	s[2] = "Floors Climbed Goal: Reached goal";
        else
        	s[2] = "Floors Climbed Goal: Surpassed goal";

        //Steps
        if (getSteps(canned) < goals.getStepsGoal())
        	s[3] = "Steps Taken Goal: Below goal";
        else if (getSteps(canned) == goals.getStepsGoal())
        	s[3] = "Steps Taken Goal: Reached goal";
        else
        	s[4] = "Steps Taken Goal: Surpassed goal";

        //Return statement
        return s;
    }
 }


