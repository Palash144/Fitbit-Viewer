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

    private boolean Canned;

    private AccAchievement[][] dailyDates;

    private static final long serialVersionUID = 1L;

    public Accolades(Boolean Canned, String date, double data[], String ltData[], MainView p) {
        //TODO: this(); //Get all our shit from the main UI class here
        //Do our calculations on our shit here
        //Set relevant achievements
        this.Canned = Canned;

        //AccAchievement[][] dailyDates = new AccAchievement[1000][7];

        double Ldistance = Double.parseDouble(ltData[6]);
        double Lcalories = Double.parseDouble(ltData[]);
        double Lfloors = Double.parseDouble(ltData[7]);
        double Lsteps = Double.parseDouble(ltData[8]);


        double Ddistance = data[1];
        double Dcalories = data[0];
        double Dfloors = data[2];
        double Dsteps = data[3];
        double SedentaryM = data[5];
        double Very_ActiveM = data[8];
        double Fairly_ActiveM = data[7];
        double Lightly_ActiveM = data[6];



        /*------------------------------------------------------------*/
        if(Canned == true){

            Ldistance = 550654;
            Lcalories = 1200739;
            Lfloors = 204582;
            Lsteps = 3202458;

                String[] tempSplit = date.split("-");
                int genVal = Integer.parseInt(tempSplit[0]) + Integer.parseInt(tempSplit[1]) + Integer.parseInt(tempSplit[2]);
                System.out.println("our hash is: " + genVal);

                genVal = genVal % 31;

                //Use mod 31 to create a database of 31 possible values
                returnData[0] = 1000.0 + (genVal * 50);
                returnData[1] = 12.0 + (genVal * 2);
                returnData[2] = 3.0 + (genVal);
                returnData[3] = 2378.0 + (480 * (genVal / 3)) + genVal;
                System.out.println("The number of steps should be: " + returnData[3]);
                returnData[4] = 54.0 + (genVal * 14);
                returnData[5] = 1440.0 - returnData[4];
                return returnData;
        }
        /*------------------------------------------------------------*/

         DailyDistance.setDaily(true);
         DailyCalories.setDaily(true);
         DailyFloors.setDaily(true);
         DailySteps.setDaily(true);
         MotorVated.setDaily(true);
         DayOff.setDaily(true);

         LifeDistance.setLifetime(true);
         LifeCalories.setLifetime(true);
         LifeFloors.setLifetime(true);
         LifeSteps.setLifetime(true);
         MiddleMan.setLifetime(true);
         ImmovableObject.setLifetime(true);

        //Daily Accolades are calculated here
        /*------------------------------------------------------------------------*/
        if (Ddistance >= 15) {
            if (!DailyDistance.isTier3()) {
                DailyDistance.setTier3(true);
            }
            if (!DailyDistance.isTier2()) {
                DailyDistance.setTier2(true);
            }
            if (!DailyDistance.isTier1()) {
                DailyDistance.setTier1(true);
            }
        } else if (Ddistance >= 7) {
            if (!DailyDistance.isTier2()) {
                DailyDistance.setTier2(true);
            }
            if (!DailyDistance.isTier1()) {
                DailyDistance.setTier1(true);
            }
        } else if (Ddistance >= 2) {
            if (!DailyDistance.isTier1()) {
                DailyDistance.setTier1(true);
            }
        }
        
        /*--------------------------------------------------------------*/
        if (Dcalories >= 3000) {
            if (!DailyCalories.isTier3() ) {
                DailyCalories.setTier3(true);
            }
            if (!DailyCalories.isTier2() ) {
                DailyCalories.setTier2(true);
            }
            if (!DailyCalories.isTier1() ) {
                DailyCalories.setTier1(true);
            }
        } else if (Dcalories >= 2500) {
            if (!DailyCalories.isTier2() ) {
                DailyCalories.setTier2(true);
            }
            if (!DailyCalories.isTier1() ) {
                DailyCalories.setTier1(true);
            }
        } else if (Dcalories >= 2000) {
            if (!DailyCalories.isTier1() ) {
                DailyCalories.setTier1(true);
            }
        }
        /*--------------------------------------------------------------*/
        if (Dfloors >= 25) {
            if (!DailyFloors.isTier3() ) {
                DailyFloors.setTier3(true);
            }
            if (!DailyFloors.isTier2() ) {
                DailyFloors.setTier2(true);
            }
            if (!DailyFloors.isTier1() ) {
                DailyFloors.setTier1(true);
            }
        } else if (Dfloors >= 15) {
            if (!DailyFloors.isTier2() ) {
                DailyFloors.setTier2(true);
            }
            if (!DailyFloors.isTier1() ) {
                DailyFloors.setTier1(true);
            }
        } else if (Dfloors >= 5) {
            if (!DailyFloors.isTier1() ) {
                DailyFloors.setTier1(true);
            }
        }
        
        /*--------------------------------------------------------------*/
        if (Dfloors >= 25) {
            if (!DailyFloors.isTier3() ) {
                DailyFloors.setTier3(true);
            }
            if (!DailyFloors.isTier2() ) {
                DailyFloors.setTier2(true);
            }
            if (!DailyFloors.isTier1() ) {
                DailyFloors.setTier1(true);
            }
        } else if (Dfloors >= 15) {
            if (!DailyFloors.isTier2() ) {
                DailyFloors.setTier2(true);
            }
            if (!DailyFloors.isTier1() ) {
                DailyFloors.setTier1(true);
            }
        } else if (Dfloors >= 5) {
            if (!DailyFloors.isTier1() ) {
                DailyFloors.setTier1(true);
            }
        }
        
        /*--------------------------------------------------------------*/
        if (Dsteps >= 3500) {
            if (!DailySteps.isTier3() ) {
                DailySteps.setTier3(true);
            }
            if (!DailySteps.isTier2() ) {
                DailySteps.setTier2(true);
            }
            if (!DailySteps.isTier1() ) {
                DailySteps.setTier1(true);
            }
        } else if (Dsteps >= 2500) {
            if (!DailySteps.isTier2() ) {
                DailySteps.setTier2(true);
            }
            if (!DailySteps.isTier1() ) {
                DailySteps.setTier1(true);
            }
        } else if (Dsteps >= 1000) {
            if (!DailySteps.isTier1() ) {
                DailySteps.setTier1(true);
            }
        }

        /*--------------------------------------------------------------*/
        if (Very_ActiveM > Lightly_ActiveM) {
            if (!MotorVated.isTier1() ) {
                MotorVated.setTier1(true);
            }
        }
        /*--------------------------------------------------------------*/
        if(SedentaryM >= 240) {
            if (!DayOff.isTier1() ) {
                DayOff.setTier1(true);
            }
        }
/*--------------------------------------------------------------------------------------------*/

        //Lifetime Accolades are calculated here

        if (Ldistance >= 1000000) {
            if (!LifeDistance.isTier3() ) {
                LifeDistance.setTier3(true);
            }
            if (!LifeDistance.isTier2() ) {
                LifeDistance.setTier2(true);
            }
            if (!LifeDistance.isTier1() ) {
                LifeDistance.setTier1(true);
            }
        } else if (Ldistance >= 750000) {
            if (!LifeDistance.isTier2() ) {
                LifeDistance.setTier2(true);
            }
            if (!LifeDistance.isTier1() ) {
                LifeDistance.setTier1(true);
            }
        } else if (Ldistance >= 500000) {
            if (!LifeDistance.isTier1() ) {
                LifeDistance.setTier1(true);
            }
        }
        
        /*--------------------------------------------------------------*/
        if (Lcalories >= 1500000) {
            if (!LifeCalories.isTier3() ) {
                LifeCalories.setTier3(true);
            }
            if (!LifeCalories.isTier2() ) {
                LifeCalories.setTier2(true);
            }
            if (!LifeCalories.isTier1() ) {
                LifeCalories.setTier1(true);
            }
        } else if (Lcalories >= 1000000) {
            if (!LifeCalories.isTier2() ) {
                LifeCalories.setTier2(true);
            }
            if (!LifeCalories.isTier1() ) {
                LifeCalories.setTier1(true);
            }
        } else if (Lcalories >= 750000) {
            if (!LifeCalories.isTier1() ) {
                LifeCalories.setTier1(true);
            }
        }
        /*--------------------------------------------------------------*/
       
        
        /*--------------------------------------------------------------*/
        if (Lfloors >= 600000) {
            if (!LifeFloors.isTier3() ) {
                LifeFloors.setTier3(true);
            }
            if (!LifeFloors.isTier2() ) {
                LifeFloors.setTier2(true);
            }
            if (!LifeFloors.isTier1() ) {
                LifeFloors.setTier1(true);
            }
        } else if (Lfloors >= 300000) {
            if (!LifeFloors.isTier2() ) {
                LifeFloors.setTier2(true);
            }
            if (!LifeFloors.isTier1() ) {
                LifeFloors.setTier1(true);
            }
        } else if (Lfloors >= 100000) {
            if (!LifeFloors.isTier1() ) {
                LifeFloors.setTier1(true);
            }
        }
        
        /*--------------------------------------------------------------*/
        if (Lsteps >= 10000000) {
            if (!LifeSteps.isTier3() ) {
                LifeSteps.setTier3(true);
            }
            if (!LifeSteps.isTier2() ) {
                LifeSteps.setTier2(true);
            }
            if (!LifeSteps.isTier1() ) {
                LifeSteps.setTier1(true);
            }
        } else if (Lsteps >= 7500000) {
            if (!LifeSteps.isTier2() ) {
                LifeSteps.setTier2(true);
            }
            if (!LifeSteps.isTier1() ) {
                LifeSteps.setTier1(true);
            }
        } else if (Lsteps >= 3000000) {
            if (!LifeSteps.isTier1() ) {
                LifeSteps.setTier1(true);
            }
        }
        /*--------------------------------------------------------------*/
        if(Fairly_ActiveM >= 1000000) {
            if (!MiddleMan.isTier1() ) {
                MiddleMan.setTier1(true);
            }
        }
        /*--------------------------------------------------------------*/
        if(SedentaryM >= 2500000) {
            if (!ImmovableObject.isTier1() ) {
                ImmovableObject.setTier1(true);
            }
        }
/*---------------------------------------------------------------------------------*/


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


    public void getAccAchievements(String date) {

    }

    public AccAchievement[] getAchievements(){

        AccAchievement[] Achievements = new AccAchievement[12];


    }

    public void getLifetime(){

    }

}
