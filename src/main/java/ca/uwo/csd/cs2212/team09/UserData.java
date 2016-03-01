package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserData {

    public String[] refreshAll(boolean canned, String date) {
        String[] returnData = new String[6];
        if (canned == true) {
            returnData[0] = "123";
            returnData[1] = "1234";
            returnData[2] = "12";
            returnData[3] = "13";
            returnData[4] = "23";
            returnData[5] = "1223";
            return returnData;
        }
        Request getData = new Request();
        try {
            //final JSONObject obj = new JSONObject(getData.requestFor("activities/date/2016-01-08.json"));
            final JSONObject obj = new JSONObject(getData.requestFor("activities/date/" + date + ".json"));

            final JSONObject fitData = obj.getJSONObject("summary");
            System.out.println("steps: " + fitData.getString("steps"));
            returnData[3] = (fitData.getString("steps"));

            final JSONArray distanceArray = fitData.getJSONArray("distances");
            final JSONObject totalDistance = distanceArray.getJSONObject(0);
            System.out.println("distance: " + totalDistance.getString("distance"));
            returnData[1] = (totalDistance.getString("distance"));

            System.out.println("floors: " + fitData.getString("floors"));
            returnData[2] = (fitData.getString("floors"));

            System.out.println("calories: " + fitData.getString("caloriesOut"));
            returnData[0] = (fitData.getString("caloriesOut"));

            int activeMinutes = 0;
            activeMinutes += Integer.parseInt(fitData.getString("fairlyActiveMinutes"));
            activeMinutes += Integer.parseInt(fitData.getString("lightlyActiveMinutes"));
            activeMinutes += Integer.parseInt(fitData.getString("veryActiveMinutes"));
            System.out.println("active minutes: " + activeMinutes);
            returnData[4] = activeMinutes + "";

            System.out.println("sedentary minutes: " + fitData.getString("sedentaryMinutes"));
            returnData[5] = (fitData.getString("sedentaryMinutes"));

        } catch (Exception e) {
            //TODO: Throw an exception
            System.out.println("Failed to refresh all data: " + e.getMessage());
        }
        return returnData;
    }

    /**
     * @param canned true returns canned data
     * @return the number of steps taken
     */

    public int getSteps(boolean canned, String date) {
        if (canned == true) {
            return 1337;
        }

        Request getData = new Request();
        try {
            //Substitute the string in getData.requestFor("STRINGHERE") for what you need
            final JSONObject obj = new JSONObject(getData.requestFor("activities/steps/date/" + date + "/1d.json"));
            final JSONArray fitData = obj.getJSONArray("activities-steps");
            final JSONObject fitAttribute = fitData.getJSONObject(0);
            return fitAttribute.getInt("value");
        } catch (Exception e) {
            System.out.println("Failed to get steps: " + e.getMessage());
        }

        //Something has gone horribly wrong if we reach this point, throw an exception here and let someone else deal with it
        //TODO: Throw an exception
        return -1;
    }

    public int getFloors(boolean canned, String date) {
        if (canned == true) {
            return 137;
        }

        Request getData = new Request();
        try {
            final JSONObject obj = new JSONObject(getData.requestFor("activities/floors/date/" + date + "/1d.json"));
            final JSONArray fitData = obj.getJSONArray("activities-floors");
            final JSONObject fitAttribute = fitData.getJSONObject(0);
            return fitAttribute.getInt("value");
            //Something has gone horribly wrong if we reach this point, throw an exception here and let someone else deal with it
        } catch (Exception e) {
            System.out.println("Failed to get floors: " + e.getMessage());
        }
        return -1;
    }


    public int getCalories(boolean canned, String date) {
        //TODO: Complete this method
        if (canned == true) {
            return 1500;
        }

        Request getData = new Request();
        try {
            final JSONObject obj = new JSONObject(getData.requestFor("activities/calories/date/" + date + "/1d.json"));
            final JSONArray fitData = obj.getJSONArray("activities-calories");
            final JSONObject fitAttribute = fitData.getJSONObject(0);
            return fitAttribute.getInt("value");
        } catch (Exception e) {
            System.out.println("Failed to get calories: " + e.getMessage());
        }
        //Something has gone horribly wrong if we reach this point, throw an exception here and let someone else deal with it
        return -1;
    }

    public int getDistance(boolean canned, String date) {
        //TODO: Complete this method
        if (canned == true) {
            return 50;
        }

        Request getData = new Request();
        try {
            final JSONObject obj = new JSONObject(getData.requestFor("activities/distance/date/" + date + "/1d.json"));
            final JSONArray fitData = obj.getJSONArray("activities-distance");
            final JSONObject fitAttribute = fitData.getJSONObject(0);
            return fitAttribute.getInt("value");
        } catch (Exception e) {
            System.out.println("Failed to get distance: " + e.getMessage());
        }
        //Something has gone horribly wrong if we reach this point, throw an exception here and let someone else deal with it
        return -1;
    }

    public int getActiveMinutes(boolean canned, String date) {
        //TODO: Complete this method; We will add together lightly active, fairly active and very active
        int activeMinutes = 0;
        if (canned == true) {
            return 69;
        }

        Request getData = new Request();
        try {
            final JSONObject obj = new JSONObject(getData.requestFor("activities/date/" + date + ".json"));
            final JSONObject fitData = obj.getJSONObject("summary");

            activeMinutes += Integer.parseInt(fitData.getString("fairlyActiveMinutes"));
            activeMinutes += Integer.parseInt(fitData.getString("lightlyActiveMinutes"));
            activeMinutes += Integer.parseInt(fitData.getString("veryActiveMinutes"));
        } catch (Exception e) {
            System.out.println("Failed to get get active minutes: " + e.getMessage());
        }

        return activeMinutes;
    }

    public int getSedentaryMinutes(boolean canned, String date) {
        //TODO: Complete this method
        if (canned == true) {
            return 1222;
        }

        Request getData = new Request();
        try {
            final JSONObject obj = new JSONObject(getData.requestFor("activities/minutesSedentary/date/" + date + "/1d.json"));
            final JSONArray fitData = obj.getJSONArray("activities-minutesSedentary");
            final JSONObject fitAttribute = fitData.getJSONObject(0);
            return fitAttribute.getInt("value");
        } catch (Exception e) {
            System.out.println("Failed to get sedentary minutes: " + e.getMessage());
        }
        //Something has gone horribly wrong if we reach this point, throw an exception here and let someone else deal with it
        return -1;
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

    public HeartRateZones getOutOfRangeZone( boolean canned, String date) throws JSONException{
        HeartRateZones zone = new HeartRateZones("Out of Range", date);
        return zone;
    }

    public HeartRateZones getFatBurnZone( boolean canned, String date) throws JSONException{
        HeartRateZones zone = new HeartRateZones("Fat Burn", date);
        return zone;
    }
    public HeartRateZones getCardioZone( boolean canned, String date) throws JSONException{
        HeartRateZones zone = new HeartRateZones("Cardio", date);
        return zone;
    }
    public HeartRateZones getPeakZone( boolean canned, String date) throws JSONException{
        HeartRateZones zone = new HeartRateZones("Peak", date);
        return zone;
    }

}
