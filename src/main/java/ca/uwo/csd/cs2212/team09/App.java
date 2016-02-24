package ca.uwo.csd.cs2212.team09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Main class
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("Attempting to log in");

        //To run this: (uncanned data)
        //java -jar target/team09_FitBitProject-1.0-SNAPSHOT-jar-with-dependencies.jar
        if (args.length == 0){
            UserInterface user = new UserInterface();
            user.getData(false);
        }
        //To run this: (canned data)
        //java -jar target/team09_FitBitProject-1.0-SNAPSHOT-jar-with-dependencies.jar canned
        else if (args[0].equals("canned")) {
            UserInterface user = new UserInterface();
            user.getData(true);
        }

        logger.trace("Exiting main");
    }
}
