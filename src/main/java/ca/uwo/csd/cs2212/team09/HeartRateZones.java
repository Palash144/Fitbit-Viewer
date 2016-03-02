package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by taylor on 2016-02-28.
 * <p>
 * Used for getting the users heart rate zones
 */
public class HeartRateZones {

    private Double caloriesOut;
    private int minutes;
    private String name;

    /**
     *
     * @param zoneNum index number for the zones
     * @param date determines what day to use
     * @throws JSONException
     */
    public HeartRateZones(int zoneNum, String date, boolean canned) throws JSONException {
        if (canned) {
            caloriesOut = -1.0;
            minutes = -1;
            name = "canned";

        } else {
            //gets the data from the server
            // activities/heart... obj -> activities-heart array -> value obj -> heartratezones array
            Request getData = new Request();
            final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/" + date + "/1d.json"));
            final JSONArray fitData = obj.getJSONArray(("activities-heart"));

            final JSONObject fitAttribute = fitData.getJSONObject(0);
            final JSONObject values = fitAttribute.getJSONObject("value");
            final JSONArray zones = values.getJSONArray("heartRateZones");
            // gets the obj element from the array specified by the index number (zoneNum)
            final JSONObject theZone = zones.getJSONObject(zoneNum);

    /**
     * @param date Determines what date to get the data from
     *
     */
    public HeartRateZones(int zoneNum, String date, boolean canned) {
        if (canned) {
            caloriesOut = 1.0;
            minutes = 2;
            name = "abc";
            return;

        } else {
        	fillData(zoneNum, date);
        }
    }

    private void fillData(int zoneNum, String date) {
    	try {
    		final JSONObject theZone = getTheZone(zoneNum, date);
            // the attributes for the specific zone
            caloriesOut = theZone.getDouble("caloriesOut");
            minutes = theZone.getInt("minutes");
            name = theZone.getString("name");
    	}
    	catch(JSONException e) {

    	}
    	finally {

    	}
    }

    //getters for the zones elements

    public Double getCaloriesOut() {
        return caloriesOut;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getName() {
        return name;
    }
}
