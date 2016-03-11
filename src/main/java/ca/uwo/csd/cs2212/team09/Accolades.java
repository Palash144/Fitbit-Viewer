package ca.uwo.csd.cs2212.team09;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.*;

/**
 * Created by michael on 12/02/16.
 */
public class Accolades {

    private String Achievement;
    private Boolean unlocked;
    private Boolean Daily;
    private Boolean Life;
    private int level;
    private int stars;
    private String[] details;

  /*  JSONObject achieve = new JSONObject();
    achieve.put("name",)
    achieve.put("type", )
    achieve.put("total",)
    achieve.put("Best", )

    */


    public Accolades(String achievement, Boolean unlocked) {
        Achievement = achievement;
        this.unlocked = false;

    }

    public void LoadAchievements(){

        //TODO: get objects from user data in terms of distance etc.
        try {
            BufferedReader in = new BufferedReader(new FileReader("Accolades.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("Accolades.txt"));

            String Accolades = in.readLine();
            String Detail = in.readLine();
            // int Distance = ;

            String DailyDistance = in.readLine();
            if()

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void GetAchievements(){

    }

    public void setUnlocked(){
        this.unlocked = true;
    }

    public Accolades LasttwoDaily(){

    }

    public Accolades LasttwoLife(){

    }

    public void DailyDistance(){
    }


}
