# Welcome to CS 2212 - Winter 2016

## Working with your repository

Clone your repository onto your local system:

```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team09.git
```

*Remember*: do *not* develop on the `master` or `dev` branches.  Instead, in
JIRA, create a feature branch off of `dev` to do your work.  Do your
development on your feature branch.  Then, when you are finished with your
feature, push your changes, and open a pull request to merge your changes back
into the `dev` branch.

## Running the current build

The current build of this project can only be run from the terminal as there is no GUI yet. Starting from the project root folder (after cloning/pulling), run:

```
mvn package
java -jar target/team09_FitBitProject-1.0-STAGE2-jar-with-dependencies.jar canned
```

Running the program with canned data should be sufficient for most testing purposes, however running it with real data is easily done by removing the "canned" argument:

```
mvn package
java -jar target/team09_FitBitProject-1.0-STAGE2-jar-with-dependencies.jar
```
