# Welcome to CS 2212 - Winter 2016

## Working with your repository

Clone your repository onto your local system:

```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team09.git
```

## Running the current build
Starting from the project root folder (after cloning/pulling), run:

```
mvn package
java -jar target/team09_FitBitProject-1.0-STAGE2-jar-with-dependencies.jar
```

To run the program with canned data:

```
mvn package
java -jar target/team09_FitBitProject-1.0-STAGE2-jar-with-dependencies.jar test
```
