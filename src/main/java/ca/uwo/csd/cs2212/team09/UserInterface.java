package ca.uwo.csd.cs2212.team09;

public class UserInterface {
    UserData sessionData = new UserData();

    private int steps = -1;
    private int floors = -1;
    private int calories = -1;
    private int distance = -1;
    private int activeMinutes = -1;
    private int sedentaryMinutes = -1;


    public static void main(String[] args) {
        UserData testSessionData = new UserData();
        testSessionData.refreshAll(false);

        //testSessionData.getSteps(false);
    }

    /**
     * @param canned true returns canned data
     */
    public void refreshData(boolean canned) {

        //sessionData.refreshAll();

        try {
            steps = sessionData.getSteps(canned);
            System.out.println("\n\n=====BEGIN OUTPUT=====");
            if (canned) {
                System.out.println("Returning canned data...");
            }
            System.out.println("\nOn 2016-01-08, Beth took " + steps + " steps.");

            floors = sessionData.getFloors(canned);
            System.out.println("Beth climbed " + floors + " floors");

            calories = sessionData.getCalories(canned);
            System.out.println("Beth burned " + calories + " calories");

            distance = sessionData.getDistance(canned);
            System.out.println("Beth travelled " + distance + "km");

            activeMinutes = sessionData.getActiveMinutes(canned);
            System.out.println("Beth was active for " + activeMinutes + " minutes");

            sedentaryMinutes = sessionData.getSedentaryMinutes(canned);
            System.out.println("Beth was inactive for " + sedentaryMinutes + " minutes");
        } catch (Exception e) {
            System.out.println("Something went horribly wrong, tell Michael about this: " + e);
        }
    }

    /**
     * @param canned true returns canned data
     */
    public int getSteps(boolean canned) {
        //TODO: Add an additional or case for the data being out of date, or maybe another boolean parameter to force refresh
        if (steps == -1 || canned){
            //Refreshes steps, or gets canned steps if specified
            steps = sessionData.getSteps(canned);
        }
        return steps;
    }

    /**
     * @param canned true returns canned data
     */
    public int getFloors(boolean canned) {
        if (floors == -1 || canned){
            floors = sessionData.getFloors(canned);
        }
        return floors;
    }

    /**
     * @param canned true returns canned data
     */
    public int getCalories(boolean canned) {
        if (calories == -1 || canned){
            calories = sessionData.getCalories(canned);
        }
        return calories;
    }

    /**
     * @param canned true returns canned data
     */
    public int getDistance(boolean canned) {
        if (distance == -1 || canned){
            distance = sessionData.getDistance(canned);
        }
        return distance;
    }

    /**
     * @param canned true returns canned data
     */
    public int getActiveMinutes(boolean canned) {
        if (activeMinutes == -1 || canned){
            activeMinutes = sessionData.getActiveMinutes(canned);
        }
        return activeMinutes;
    }

    /**
     * @param canned true returns canned data
     */
    public int getSedentaryMinutes(boolean canned) {
        if (sedentaryMinutes == -1 || canned){
            sedentaryMinutes = sessionData.getSedentaryMinutes(canned);
        }
        return sedentaryMinutes;
    }
}
