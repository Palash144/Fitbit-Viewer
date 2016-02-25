package ca.uwo.csd.cs2212.team09;

public class UserInterface {
    UserData sessionData = new UserData();

    private int steps = -1;
    private int floors = -1;
    private int calories = -1;
    private int distance = -1;
    private int activeMinutes = -1;
    private int sedentaryMinutes = -1;


    //TODO: Test class to test UserData refreshAll(), remove after
    public static void main(String[] args) {
        UserData testSessionData = new UserData();
        String[] testreceive = testSessionData.refreshAll(false, "2016-01-08");

        System.out.println("testing return data:");
        for (int i = 0; i < testreceive.length; i++){
            System.out.println(testreceive[i]);
        }
        //System.out.println("the dudeman was active for " + testSessionData.getActiveMinutes(false, "2016-01-08"));
    }

    //return data from last session
    public void getCachedData() {

    }

    /**
     * @param canned true returns canned data
     */
    public void refreshData(boolean canned, String date) {

        //sessionData.refreshAll();

        try {
            System.out.println("Returning data for day: " + date);

            steps = sessionData.getSteps(canned, "");
            System.out.println("\n\n=====BEGIN OUTPUT=====");
            if (canned) {
                System.out.println("Returning canned data...");
            }
            System.out.println("\nBeth took " + steps + " steps.");

            floors = sessionData.getFloors(canned, date);
            System.out.println("Beth climbed " + floors + " floors");

            calories = sessionData.getCalories(canned, date);
            System.out.println("Beth burned " + calories + " calories");

            distance = sessionData.getDistance(canned, date);
            System.out.println("Beth travelled " + distance + "km");

            activeMinutes = sessionData.getActiveMinutes(canned, date);
            System.out.println("Beth was active for " + activeMinutes + " minutes");

            sedentaryMinutes = sessionData.getSedentaryMinutes(canned, date);
            System.out.println("Beth was inactive for " + sedentaryMinutes + " minutes");
        } catch (Exception e) {
            System.out.println("Something went horribly wrong, tell Michael about this: " + e);
        }
    }

    /**
     * @param canned true returns canned data
     */
    public int getSteps(boolean canned, String date) {
        //TODO: Add an additional or case for the data being out of date, or maybe another boolean parameter to force refresh
        if (steps == -1 || canned){
            //Refreshes steps, or gets canned steps if specified
            steps = sessionData.getSteps(canned, date);
        }
        return steps;
    }

    /**
     * @param canned true returns canned data
     */
    public int getFloors(boolean canned, String date) {
        if (floors == -1 || canned){
            floors = sessionData.getFloors(canned, date);
        }
        return floors;
    }

    /**
     * @param canned true returns canned data
     */
    public int getCalories(boolean canned, String date) {
        if (calories == -1 || canned){
            calories = sessionData.getCalories(canned, date);
        }
        return calories;
    }

    /**
     * @param canned true returns canned data
     */
    public int getDistance(boolean canned, String date) {
        if (distance == -1 || canned){
            distance = sessionData.getDistance(canned, date);
        }
        return distance;
    }

    /**
     * @param canned true returns canned data
     */
    public int getActiveMinutes(boolean canned, String date) {
        if (activeMinutes == -1 || canned){
            activeMinutes = sessionData.getActiveMinutes(canned, date);
        }
        return activeMinutes;
    }

    /**
     * @param canned true returns canned data
     */
    public int getSedentaryMinutes(boolean canned, String date) {
        if (sedentaryMinutes == -1 || canned){
            sedentaryMinutes = sessionData.getSedentaryMinutes(canned, date);
        }
        return sedentaryMinutes;
    }
}
