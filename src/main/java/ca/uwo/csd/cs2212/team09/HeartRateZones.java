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

    private JSONObject getTheZone(int zoneNum, String date) throws JSONException {
        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/" + date + "/1d.json"));
        final JSONArray fitData = obj.getJSONArray(("activities-heart"));

        final JSONObject fitAttribute = fitData.getJSONObject(0);
        final JSONObject values = fitAttribute.getJSONObject("value");
        final JSONArray zones = values.getJSONArray("heartRateZones");
        final JSONObject theZone = zones.getJSONObject(zoneNum);
        return theZone;
    }

    /**
     * @param date Determines what date to get the data from
     * @throws JSONException
     */
    public HeartRateZones(int zoneNum, String date, boolean canned) throws JSONException {
        if(canned) {
            caloriesOut = 1.0;
            minutes = 2;
            name = "abc";

        }

        final JSONObject theZone = getTheZone(zoneNum, date);

        caloriesOut = theZone.getDouble("caloriesOut");
        minutes = theZone.getInt("minutes");
        name = theZone.getString("name");
    }

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
