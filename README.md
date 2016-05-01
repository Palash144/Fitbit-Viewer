# Fitbit Viewer

Developed by Team 9 for CS2212 (Introduction to Software Engineering) at Western University

The Fitbit Viewer connects to the [Fitbit API](https://dev.fitbit.com) and displays data about the user's daily activities such as their distance travelled, floors climbed and calories burned that day. The user is also able to change the date to see their statistics on different dates. In addition, the user can view their best and lifetime total statistics, time series data, daily goals and can earn accolades. The GUI is built using Swing.

## Dependencies used in the Fitbit Viewer

* JCalendar
* JDatePicker
* JFreeChart
* ScribeJava
* JSON
* Log4J

## Screenshots

![picture](http://i.imgur.com/TFaoIgv.jpg)
![picture](http://i.imgur.com/awCxtQc.jpg)
![picture](http://i.imgur.com/AkyZLBa.jpg)
![picture](http://i.imgur.com/19bhqzx.jpg)
![picture](http://i.imgur.com/HhWJWD3.jpg)
![picture](http://i.imgur.com/pi074ks.jpg)

## Video Demonstration

https://youtu.be/EcMllHwSIOQ

## Modes of Operation
###### Test mode
Offline version of the application; no access to a user account.

###### Online mode 
Fully functional version of the application.  
__To connect to a user account, you will need to:__

1. Log into Fitbit website, and get a Request code from the Authorization server.
2. Trade the request for and Access/Refresh Token pair.
3. Get credentials for the Authorization server: This includes your App ID and a key/secret pair.
4. Place credentials in `/src/main/resources/Credentials.txt`, place refresh/access tokens in `/src/main/resources/Tokens.txt`.

*__Note:__ If everything goes as planned you will get an HTTP response with the code 200, its body will contain a JSON object describing the data you asked for. If it doesn't, and your access token has expired, you will need to ask for a new pair from the authorization server.*

## Prerequisites for building and running the project

You will need to have the following properly configured to build and run the project:
* Java
* Maven

## Getting a copy of the project

Clone the repository onto your local system:

```
git clone https://github.com/mikeshz/Fitbit-Viewer
```

## Running the project

Starting from the project root folder (after cloning/pulling), run:

```
mvn package
java -jar target/team09_FitBitProject-1.0-RELEASE-jar-with-dependencies.jar 
```

To run the program with canned data (test mode):

```
mvn package
java -jar target/team09_FitBitProject-1.0-RELEASE-jar-with-dependencies.jar test
```

## Javadoc

The javadoc is located in the ["doc" directory](https://github.com/mikeshz/Fitbit-Viewer/tree/master/doc)
