package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Team 9
 *         Used for getting the users heart rate zones
 */
public class HeartRateZones {

    private Double caloriesOut;
    private int minutes;
    private String name;

    /**
     * Constructor for each heart rate zone
     *
     * @param zoneNum The index at which the heart rate zone is in the JSON Array
     * @param date    Determines what date to get the data from
     * @param canned  true if using test data
     */
    public HeartRateZones(int zoneNum, String date, boolean canned) {
        if (canned) {
            caloriesOut = 1.0;
            minutes = 2;
            name = "abc";
            return;

        } else {
            try {
                Request getData = new Request();
                final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/" + date + "/1d.json"));
                final JSONArray fitData = obj.getJSONArray(("activities-heart"));

                final JSONObject fitAttribute = fitData.getJSONObject(0);
                final JSONObject values = fitAttribute.getJSONObject("value");
                final JSONArray zones = values.getJSONArray("heartRateZones");
                // gets the obj element from the array specified by the index number (zoneNum)
                final JSONObject theZone = zones.getJSONObject(zoneNum);
                // the attributes for the specific zone
                caloriesOut = theZone.getDouble("caloriesOut");
                minutes = theZone.getInt("minutes");
                name = theZone.getString("name");
            } catch (JSONException e) {
                //TODO: Handle this exception
            }
        }
    }

    /**
     * Gets calories burned in this zone
     * @return calories burnt in this zone
     */
    public Double getCaloriesOut() {
        return caloriesOut;
    }

    /**
     * Gets minutes spent in this zone
     * @return minutes spent in this zone
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Gets name of this zone
     * @return name of this zone
     */
    public String getName() {
        return name;
    }
}