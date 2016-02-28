package ca.uwo.csd.cs2212.team09;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by taylor on 2016-02-28.
 */
public class HeartRateZones {

    private Double caloriesOut;
    private int minutes;
    private String name;

    public HeartRateZones(String theName, String date) throws JSONException {
        Request getData = new Request();
        final JSONObject obj = new JSONObject(getData.requestFor("activities/heart/date/" + date + "/1d.json"));
        final JSONArray fitData = obj.getJSONArray(("activities-heart"));

        final JSONObject fitAttribute = fitData.getJSONObject(0);
        final JSONObject values = fitAttribute.getJSONObject("value");
        final JSONArray zones = values.getJSONArray("heartRateZones");

        name = theName;

        int i = -1;

        if (name.equals("Out of Range"))
            i = 0;
        else if (name.equals("Fat Burn"))
            i = 1;
        else if (name.equals("Cardio"))
            i = 2;
        else if (name.equals("Peak"))
            i = 3;

        final JSONObject theZone = zones.getJSONObject(i);

        caloriesOut = theZone.getDouble("caloriesOut");
        minutes = theZone.getInt("minutes");
    }

    public String getName() {
        return name;
    }

    public Double getCaloriesOut() {
        return caloriesOut;
    }

    public int getMinutes() {
        return minutes;
    }


}
