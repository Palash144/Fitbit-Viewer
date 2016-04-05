# Fitbit Viewer

Developed by Team 9 in CS2212 at Western University

The Fitbit Viewer connects to the [Fitbit API](https://dev.fitbit.com) and displays data about the user's daily activities such as their distance travelled, floors climbed and calories burned that day. The user is also able to change the date to see their statistics on different dates. In addition, the user can view their best and lifetime total statistics, time series data, daily goals and can earn accolades.

## Dependencies used in the Fitbit Viewer

* JCalendar
* JDatePicker
* JFreeChart
* ScribeJava
* JSON
* Log4J

## Video of the Fitbit Viewer in action

https://youtubevideourl

## Prerequisites for building and running the project

You will need to have the following properly configured to build and run the project:
* Java
* Maven

## Getting a copy of the project

Clone the repository onto your local system:

```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team09.git
```

## Running the project

Starting from the project root folder (after cloning/pulling), run:

```
mvn package
java -jar target/team09_FitBitProject-1.0-RELEASE-jar-with-dependencies.jar 
```

To run the program with canned data:

```
mvn package
java -jar target/team09_FitBitProject-1.0-RELEASE-jar-with-dependencies.jar test
```

## Javadoc

The javadoc is located in the "doc" directory
