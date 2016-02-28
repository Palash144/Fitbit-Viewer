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


    public int getRestingHeartRate(boolean canned, String date) throws JSONException {

        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/"+ date +"/1d.json"));
        final JSONArray fitData = obj.getJSONArray(("activities-heart"));

        final JSONObject fitAttribute = fitData.getJSONObject(0);
        final JSONObject values = fitAttribute.getJSONObject("value");
        System.out.println(values.toString());
        return values.getInt("restingHeartRate");

    }

}
