package ca.uwo.csd.cs2212.team09;

/**
 * Class that implements the UI of the dashboard and user data
 * @author Team 9
 *
 */
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
        Double[] testreceive = testSessionData.refreshAll(false, "2016-01-08");

        System.out.println("testing return data:");
        for (int i = 0; i < testreceive.length; i++){
            System.out.println(testreceive[i]);
        }
        //System.out.println("the dudeman walked " + testSessionData.getSteps(false, "2016-01-08"));
    }

    /**
     * Returns data from last session
     */
    public void getCachedData() {

    }

    /** Refreshes the data of the user
     * @param canned true returns canned data
     * @param date date of the data to be returned in the format "yyyy-mm-dd"
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

    /** Retrieves the steps taken for the User
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of steps taken
     */
    public int getSteps(boolean canned, String date) {
        //TODO: Add an additional or case for the data being out of date, or maybe another boolean parameter to force refresh
        if (steps == -1 || canned){
            //Refreshes steps, or gets canned steps if specified
            steps = sessionData.getSteps(canned, date);
        }
        return steps;
    }

    /** Retrieves the number of floors climbed by the user
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of floors climbed by the user
     */
    public int getFloors(boolean canned, String date) {
        if (floors == -1 || canned){
            floors = sessionData.getFloors(canned, date);
        }
        return floors;
    }

    /** Retrieves the number of calories burned by the user
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of calories burned by the user
     */
    public int getCalories(boolean canned, String date) {
        if (calories == -1 || canned){
            calories = sessionData.getCalories(canned, date);
        }
        return calories;
    }

    /** Retrieves the distance travelled by the user
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of floors climbed by the user
     */
    public int getDistance(boolean canned, String date) {
        if (distance == -1 || canned){
            distance = sessionData.getDistance(canned, date);
        }
        return distance;
    }

    /** Retrieves the number of active minutes by the user
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of active minutes by the user
     */
    public int getActiveMinutes(boolean canned, String date) {
        if (activeMinutes == -1 || canned){
            activeMinutes = sessionData.getActiveMinutes(canned, date);
        }
        return activeMinutes;
    }

    /** Retrieves the number of sedentary minutes by the user
     * @param canned true if using canned/test data
     * @param date date of the data retrieved in the format "yyyy-mm-dd"
     * @return the number of sedentary minutes by the user
     */
    public int getSedentaryMinutes(boolean canned, String date) {
        if (sedentaryMinutes == -1 || canned){
            sedentaryMinutes = sessionData.getSedentaryMinutes(canned, date);
        }
        return sedentaryMinutes;
    }
}
