package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserData {

    private int bestSteps = -1;
    private int bestFloors = -1;
    private int bestCalories = -1;
    private int bestDistance = -1;

    private int totalSteps = -1;
    private int totalFloors = -1;
    private int totalCalories = -1;
    private int totalDistance = -1;
    
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

    //TODO: write method to return cached data for my summary

    //return new data from fitbit
    public String[] refreshMySummary(boolean canned) {
        String[] returnData = new String[8];
        if (canned == true) {
            returnData[0] = "3";
            returnData[1] = "4";
            returnData[2] = "5";
            returnData[3] = "6";
            returnData[4] = "7";
            returnData[5] = "8";
            returnData[6] = "9";
            returnData[7] = "10";
            return returnData;
        }
        Request getData = new Request();
        try {
            //final JSONObject obj = new JSONObject(getData.requestFor("activities/date/2016-01-08.json"));
            final JSONObject obj = new JSONObject(getData.requestFor("activities.json"));

            final JSONObject fitData = obj.getJSONObject("best");

            final JSONObject trackerData = fitData.getJSONObject("tracker");

/*            JSONObject bestValue = trackerData.getJSONObject("caloriesOut");
            System.out.println("best calories date: " + bestValue.getString("date"));
            System.out.println("best calories: " + bestValue.getString("value"));
            returnData[0] = (bestValue.getString("value"));*/
            
            JSONObject bestValue = trackerData.getJSONObject("distance");
            System.out.println("best distance date: " + bestValue.getString("date"));
            System.out.println("best distance: " + bestValue.getString("value"));
            returnData[1] = (bestValue.getString("date") + "/"  + bestValue.getString("value"));

            bestValue = trackerData.getJSONObject("floors"); //TODO: This returns an unrounded double; Fix it by casting to int
            System.out.println("best floors date: " + bestValue.getString("date"));
            System.out.println("best floors: " + bestValue.getString("value"));
            returnData[2] = (bestValue.getString("date") + "/"  + bestValue.getString("value"));

            bestValue = trackerData.getJSONObject("steps");
            System.out.println("best steps date: " + bestValue.getString("date"));
            System.out.println("best steps: " + bestValue.getString("value"));
            returnData[3] = (bestValue.getString("date") + "/"  + bestValue.getString("value"));

            final JSONObject lifeTime = obj.getJSONObject("lifetime");
            bestValue = lifeTime.getJSONObject("total");

            String totalValue = bestValue.getString("caloriesOut");   //Calories are -1, to be discussed
            System.out.println("total Calories burned: " + totalValue);
            returnData[4] = (totalValue);

            totalValue = bestValue.getString("distance");
            System.out.println("total Distance travelled: " + totalValue);
            returnData[5] = (totalValue);

            totalValue = bestValue.getString("floors");
            System.out.println("total Floors climbed: " + totalValue);
            returnData[6] = (totalValue);

            totalValue = bestValue.getString("steps");
            System.out.println("total Steps taken: " + totalValue);
            returnData[7] = (totalValue);


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
        if (canned == true) {
            return 69;
        }
        return -1;
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
}
