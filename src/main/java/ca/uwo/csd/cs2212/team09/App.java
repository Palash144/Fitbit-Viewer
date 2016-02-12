package ca.uwo.csd.cs2212.team09; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//This is currently defined as our main class in pom.xml, we can create
// a different main class or just change the code in this
public class App {
    static Logger logger = LogManager.getLogger (App.class.getName());
    public static void main ( String[] args ) {
        logger.trace("Entering main");
        logger.warn("Hello Maven/log4j World"); 
        logger.info("This is team 09"); 
        logger.trace("Exiting main");  
    } 
}
