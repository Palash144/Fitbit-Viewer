package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/** Class used to store and manipulate the data of the user
 * @author Team 9
 *
 */
public class UserData {

    private int bestSteps = -1;
    private int bestFloors = -1;
    private int bestCalories = -1;
    private int bestDistance = -1;

    private int totalSteps = -1;
    private int totalFloors = -1;
    private int totalCalories = -1;
    private int totalDistance = -1;

    /** Refreshes the user's data
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return An array of strings storing the user's data
     */
    public double[] refreshAll(boolean canned, String date) {
        double[] returnData = new double[9];
        if (canned == true) {
            String[] tempSplit = date.split("-");
            int genVal = Integer.parseInt(tempSplit[0]) + Integer.parseInt(tempSplit[1]) + Integer.parseInt(tempSplit[2]);
            System.out.println("our hash is: " + genVal);

            genVal = genVal % 31;

            //Use mod 31 to generate different values
            returnData[0] = 1000.0 + (genVal * 50);
            returnData[1] = 12.0 + (genVal * 2);
            returnData[2] = 3.0 + (genVal);
            returnData[3] = 2378.0 + (480 * (genVal / 3)) + genVal;
            returnData[4] = 54.0 + (genVal * 14);
            returnData[5] = 1440.0 - returnData[4];
            return returnData;
        }
        Request getData = new Request();
        try {
            //final JSONObject obj = new JSONObject(getData.requestFor("activities/date/2016-01-08.json"));
            final JSONObject obj = new JSONObject(getData.requestFor("activities/date/" + date + ".json"));

            final JSONObject fitData = obj.getJSONObject("summary");
            System.out.println("steps: " + fitData.getString("steps"));
            returnData[3] = (fitData.getDouble("steps"));

            final JSONArray distanceArray = fitData.getJSONArray("distances");
            final JSONObject totalDistance = distanceArray.getJSONObject(0);
            System.out.println("distance: " + totalDistance.getString("distance"));
            returnData[1] = (totalDistance.getDouble("distance"));

            System.out.println("floors: " + fitData.getDouble("floors"));
            returnData[2] = (fitData.getDouble("floors"));

            System.out.println("calories: " + fitData.getDouble("caloriesOut"));
            returnData[0] = (fitData.getDouble("caloriesOut"));

            double activeMinutes = 0;
            activeMinutes += Integer.parseInt(fitData.getString("fairlyActiveMinutes"));
            activeMinutes += Integer.parseInt(fitData.getString("lightlyActiveMinutes"));
            activeMinutes += Integer.parseInt(fitData.getString("veryActiveMinutes"));
            System.out.println("active minutes: " + activeMinutes);
            returnData[4] = activeMinutes;

            System.out.println("sedentary minutes: " + fitData.getString("sedentaryMinutes"));
            returnData[5] = (fitData.getDouble("sedentaryMinutes"));

            returnData[6] = Integer.parseInt(fitData.getString("lightlyActiveMinutes"));
            returnData[7] = Integer.parseInt(fitData.getString("fairlyActiveMinutes"));
            returnData[8] = Integer.parseInt(fitData.getString("veryActiveMinutes"));

        } catch (Exception e) {
            //TODO: Throw an exception
            System.out.println("Failed to refresh all data: " + e.getMessage());
        }
        return returnData;
    }

    /**
     * Refreshes userdata for the mysummary panel
     * @param canned true if using test data
     * @return the userdata
     */
    public String[] refreshMySummary(boolean canned) {
        String[] returnData = new String[10];
        if (canned == true) {
            returnData[0] = "02-25-2016"; //best distance (date)
            returnData[1] = "4";          //best distance
            returnData[2] = "03-01-2016"; //best floors (date)
            returnData[3] = "6";          //best floors
            returnData[4] = "03-01-2016"; //best steps (date)
            returnData[5] = "8";          //best steps
            returnData[6] = "9";          //lifetime distance
            returnData[7] = "10";         //lifetime floors
            returnData[8] = "11";         //lifetime steps
            returnData[9] = "11";         //lifetime calories
            return returnData;
        }
        Request getData = new Request();
        try {
            //final JSONObject obj = new JSONObject(getData.requestFor("activities/date/2016-01-08.json"));
            final JSONObject obj = new JSONObject(getData.requestFor("activities.json"));

            final JSONObject fitData = obj.getJSONObject("best");

            final JSONObject trackerData = fitData.getJSONObject("tracker");

            JSONObject bestValue = trackerData.getJSONObject("distance");
            System.out.println("best distance date: " + bestValue.getString("date"));
            System.out.println("best distance: " + bestValue.getString("value"));
            returnData[0] = bestValue.getString("date");
            returnData[1] = bestValue.getString("value");

            bestValue = trackerData.getJSONObject("floors"); //TODO: This returns an unrounded double; Fix it by casting to int
            System.out.println("best floors date: " + bestValue.getString("date"));
            System.out.println("best floors: " + bestValue.getString("value"));
            returnData[2] = bestValue.getString("date");
            returnData[3] = bestValue.getString("value");

            bestValue = trackerData.getJSONObject("steps");
            System.out.println("best steps date: " + bestValue.getString("date"));
            System.out.println("best steps: " + bestValue.getString("value"));
            returnData[4] = bestValue.getString("date");
            returnData[5] = bestValue.getString("value");

            final JSONObject lifeTime = obj.getJSONObject("lifetime");
            bestValue = lifeTime.getJSONObject("total");

            String totalValue = bestValue.getString("distance");
            System.out.println("total Distance travelled: " + totalValue);
            returnData[6] = (totalValue);

            totalValue = bestValue.getString("floors");
            System.out.println("total Floors climbed: " + totalValue);
            returnData[7] = (totalValue);

            totalValue = bestValue.getString("steps");
            System.out.println("total Steps taken: " + totalValue);
            returnData[8] = (totalValue);

            totalValue = bestValue.getString("caloriesOut");
            System.out.println("total calories: " + totalValue);
            returnData[9] = (totalValue);

        } catch (Exception e) {
            //TODO: Throw an exception
            System.out.println("Failed to refresh all data: " + e.getMessage());
        }
        return returnData;
    }

    /**
     * Retrieves the steps taken for the User
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
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

    /** Retrieves the number of floors climbed by the user
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of floors climbed by the user
     */
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

/*    public static Achievements getAchievements(boolean canned){
        //TODO: Complete this method
        return new Achievements();
    }*/

    /**
     * gets the user's resting heartrate
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the user's resting heart rate
     * @throws JSONException
     */
    public int getRestingHeartRate(boolean canned, String date) throws JSONException {

        if(canned) return -1;

        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/"+ date +"/1d.json"));
        final JSONArray fitData = obj.getJSONArray(("activities-heart"));

        final JSONObject fitAttribute = fitData.getJSONObject(0);
        final JSONObject values = fitAttribute.getJSONObject("value");
        System.out.println(values.toString());
        return values.getInt("restingHeartRate");

    }

    /**
     *
     * creates an array of heart rate zones storing each zone
     * because only the default ones are used 0 will store Out of Range, 1 will store Fat Burn, 2 Cardio, 3 Peak
     *
     * @param date determines what day to use
     * @param canned true if using canned/test data
     * @return heart rate zones
     * @throws JSONException
     */
    public  HeartRateZones[] getHeartRateZones (String date, boolean canned) throws JSONException{
        //creates 4 heartrate zones for canned data
        if(canned){
            HeartRateZones[] foo = new HeartRateZones[4];
            for(int i = 0;i<4;i++ )
                foo[i] = new HeartRateZones(0,"1",true);
            return foo;
        }
        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/" + date + "/1d.json"));
        final JSONArray fitData = obj.getJSONArray(("activities-heart"));

        final JSONObject fitAttribute = fitData.getJSONObject(0);
        final JSONObject values = fitAttribute.getJSONObject("value");
        final JSONArray zones = values.getJSONArray("heartRateZones");

        HeartRateZones[] heartZones = new HeartRateZones[zones.length()];
        // stores all zones in the heartzones array
        for (int i = 0; i < zones.length(); i++){
            heartZones[i] = new HeartRateZones (i,date,canned);
        }
        return heartZones;
    }
}
