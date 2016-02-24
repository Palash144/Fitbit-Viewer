package ca.uwo.csd.cs2212.team09;

public class UserInterface {
    //TODO: Currently set to true for debugging purposes, the user should NOT be logged in by default
    private static boolean loggedIn = true;

    private static int calories;

    /**
     * @param canned true returns canned data
     */
    public void getData(boolean canned) {
        if (loggedIn || canned) {
            try {
                int steps = UserData.getSteps(canned);
                System.out.println("\n\n=====BEGIN OUTPUT=====");
                if (canned){
                    System.out.println("Returning canned data...");
                }
                System.out.println("\nOn 2016-01-08, Beth took " + steps + " steps.");

                int floors = UserData.getFloors(canned);
                System.out.println("Beth climbed " + floors + " floors");

                calories = UserData.getCalories(canned);
                System.out.println("Beth burned " + calories + " calories");

                int distance = UserData.getDistance(canned);
                System.out.println("Beth travelled " + distance + "km");

                int activeMinutes = UserData.getActiveMinutes(canned);
                System.out.println("Beth was active for " + activeMinutes + " minutes");

                int sedentaryMinutes = UserData.getSedentaryMinutes(canned);
                System.out.println("Beth was inactive for " + sedentaryMinutes + " minutes");
            } catch (Exception e) {
                System.out.println("Something went horribly wrong, tell Michael about this: " + e);
            }

        } else {
            System.out.println("You are not logged in!");
            //Ask the user to log in
        }
    }

    public int getCalories(){
        return calories;
    }
}
