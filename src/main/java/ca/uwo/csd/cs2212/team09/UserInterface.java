package ca.uwo.csd.cs2212.team09;

public class UserInterface {
    //TODO: Currently set to true for debugging purposes, the user should NOT be logged in by default
    private static boolean loggedIn = true;
    UserData newSessionData = new UserData();

    /**
     * @param canned true returns canned data
     */
    public void getData(boolean canned) {
        if (loggedIn || canned) {
            try {

                int steps = newSessionData.getSteps(canned);
                System.out.println("\n\n=====BEGIN OUTPUT=====");
                if (canned){
                    System.out.println("Returning canned data...");
                }
                System.out.println("\nOn 2016-01-08, Beth took " + steps + " steps.");

                int floors = newSessionData.getFloors(canned);
                System.out.println("Beth climbed " + floors + " floors");

                int calories = newSessionData.getCalories(canned);
                System.out.println("Beth burned " + calories + " calories");

                int distance = newSessionData.getDistance(canned);
                System.out.println("Beth travelled " + distance + "km");

                int activeMinutes = newSessionData.getActiveMinutes(canned);
                System.out.println("Beth was active for " + activeMinutes + " minutes");

                int sedentaryMinutes = newSessionData.getSedentaryMinutes(canned);
                System.out.println("Beth was inactive for " + sedentaryMinutes + " minutes");
            } catch (Exception e) {
                System.out.println("Something went horribly wrong, tell Michael about this: " + e);
            }

        } else {
            System.out.println("You are not logged in!");
            //Ask the user to log in
        }
    }
}
