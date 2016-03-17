package ca.uwo.csd.cs2212.team09;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.*;

public class Accolades implements Serializable {

    private AccAchievement DailyDistance;
    private AccAchievement DailyCalories;
    private AccAchievement DailyFloors;
    private AccAchievement DailySteps;
    private AccAchievement MotorVated;
    private AccAchievement DayOff;

    private AccAchievement LifeDistance;
    private AccAchievement LifeCalories;
    private AccAchievement LifeFloors;
    private AccAchievement LifeSteps;
    private AccAchievement MiddleMan;
    private AccAchievement ImmovableObject;

    private static final long serialVersionUID = 1L;

    public Accolades() {
        //TODO: this(); //Get all our shit from the main UI class here
        //Do our calculations on our shit here
        //Set relevant achievements
    }

    public AccAchievement getDailyDistance() {
        return DailyDistance;
    }

    public void setDailyDistance(AccAchievement dailyDistance) {
        DailyDistance = dailyDistance;
    }

    public AccAchievement getDailyCalories() {
        return DailyCalories;
    }

    public void setDailyCalories(AccAchievement dailyCalories) {
        DailyCalories = dailyCalories;
    }

    public AccAchievement getDailyFloors() {
        return DailyFloors;
    }

    public void setDailyFloors(AccAchievement dailyFloors) {
        DailyFloors = dailyFloors;
    }

    public AccAchievement getDailySteps() {
        return DailySteps;
    }

    public void setDailySteps(AccAchievement dailySteps) {
        DailySteps = dailySteps;
    }

    public AccAchievement getMotorVated() {
        return MotorVated;
    }

    public void setMotorVated(AccAchievement motorVated) {
        MotorVated = motorVated;
    }

    public AccAchievement getDayOff() {
        return DayOff;
    }

    public void setDayOff(AccAchievement dayOff) {
        DayOff = dayOff;
    }

    public AccAchievement getLifeDistance() {
        return LifeDistance;
    }

    public void setLifeDistance(AccAchievement lifeDistance) {
        LifeDistance = lifeDistance;
    }

    public AccAchievement getLifeCalories() {
        return LifeCalories;
    }

    public void setLifeCalories(AccAchievement lifeCalories) {
        LifeCalories = lifeCalories;
    }

    public AccAchievement getLifeFloors() {
        return LifeFloors;
    }

    public void setLifeFloors(AccAchievement lifeFloors) {
        LifeFloors = lifeFloors;
    }

    public AccAchievement getLifeSteps() {
        return LifeSteps;
    }

    public void setLifeSteps(AccAchievement lifeSteps) {
        LifeSteps = lifeSteps;
    }

    public AccAchievement getMiddleMan() {
        return MiddleMan;
    }

    public void setMiddleMan(AccAchievement middleMan) {
        MiddleMan = middleMan;
    }

    public AccAchievement getImmovableObject() {
        return ImmovableObject;
    }

    public void setImmovableObject(AccAchievement immovableObject) {
        ImmovableObject = immovableObject;
    }


    public static void main(String[] args){

     int D = 1500;
     Accolades kay = new Accolades();
     kay.loadDaily(D);
 }


    public void loadDaily(int D) {

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/Accolades.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/Accolades.txt"));

            StringBuilder StrLine = null;
            String Accolades = in.readLine();
            String Detail = in.readLine();
            String Names = in.readLine();
            // int Distance = ;
 /*----------------------------------------------------------------------------------------------*/

            //TODO: get object of distance. For now call it D.

            String DailyDistance = in.readLine();
            String tokens[] = DailyDistance.split(" ");
            if (D > 15) {
                tokens[2] = "1";
                tokens[3] = "1";
                tokens[4] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            } else if (D > 7) {
                tokens[2] = "1";
                tokens[3] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            } else if (D > 2) {
                tokens[2] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }

 /*----------------------------------------------------------------------------------------------*/
/*
            //TODO: get object of Calories. For now call it C

            DailyDistance = in.readLine();
            tokens = DailyDistance.split(" ");

            if( C >= 3000){
                tokens[2] = "1";tokens[3] = "1";tokens[4] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
            else if( C >= 2500){
                tokens[2] = "1";tokens[3] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
            else if( C >= 2000){
                tokens[2] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
 /*----------------------------------------------------------------------------------------------*/
/*
            //TODO: get objects of Floors. For now call it F.

            DailyDistance = in.readLine();
            tokens = DailyDistance.split(" ");

            if( F >= 25){
                tokens[2] = "1";tokens[3] = "1";tokens[4] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
            else if( F >= 15){
                tokens[2] = "1";tokens[3] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
            else if( F >= 5){
                tokens[2] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
 /*----------------------------------------------------------------------------------------------*/
/*
            //TODO: get objects of Steps. For now call it S.

            DailyDistance = in.readLine();
            tokens = DailyDistance.split(" ");

            if( S >= 1000){
                tokens[2] = "1";tokens[3] = "1";tokens[4] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
            else if( S >= 750){
                tokens[2] = "1";tokens[3] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
            else if( S >= 500){
                tokens[2] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " " + tokens[4];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
 /*----------------------------------------------------------------------------------------------*/
/*
            //TODO: get objects of Very-Active minutes and lightly active minutes. For now call them VA & LA

            DailyDistance = in.readLine();
            tokens = DailyDistance.split(" ");

            if (VA > LA){
                tokens[2] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
/*-----------------------------------------------------------------------------------------------*/
/*
            //TODO: get objects of Sedentary-Minutes. For now call it SM

            DailyDistance = in.readLine();
            tokens = DailyDistance.split(" ");

            if ( SM > 18 ){
                tokens[2] = "1";
                String newline = tokens[0] + " " + tokens[1] + " " + tokens[2];
                StrLine.append(newline);
                out.write(StrLine.toString());
            }
/*-----------------------------------------------------------------------------------------------*/


            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void loadLifetime(){


        try {
            BufferedReader in = new BufferedReader(new FileReader("Accolades.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("Accolades.txt"));

            StringBuilder StrLine = null;
            String Accolades = in.readLine();
            String Detail = in.readLine();
            String Names = in.readLine();
            String line;

            for (int i = 0; (line = in.readLine()) != null && i!=5 ; i++){
            }



        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void GetAchievements() {


    }

    public void dailyReset() {
/*
        try {
            BufferedReader in = new BufferedReader(new FileReader("Accolades.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("Accolades.txt"));

            StringBuilder StrLine = null;
            String Accolades = in.readLine();
            String Details = in.readLine();
            String Names = in.readLine();
            String[] tokens = Names.split(" ");
            String line;
            int i = 0;

            while((line = in.readLine()) != null && i != 6){

                if(i < 4){

                    line = tokens[i] + " 0 0 0 0";
                    StrLine.append(line);
                    out.write(StrLine.toString());
                }

                if( i >= 4){

                    line = tokens[i] + " 0 0";
                    StrLine.append(line);
                    out.write(StrLine.toString());
                }

                i++;
            }

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
*/    }


}
