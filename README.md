# nearbyplaces
A Java Swing application which calls Google Places API using REST/GET client to show interesting places near a given location, within a given distance. 


STEPS TO RUN 

1. Download the source code and extract it to a folder named nearbyplaces.
2. Install Java(Version 8 or 7 or 6)
3. On the command prompt, run the two commands below

   cd nearbyplaces/target 
   
   java -jar nearbyplaces-0.0.1-SNAPSHOT-jar-with-dependencies.jar 

4. This opens up a Swing UI having some default values for Latitude/Longitude/Radius. 
(The values may be edited as needed)
5. Click on the button "Search" to search for interesting places near this default 
location. This displays Name, Vicinity and Types of several places in the proximity. 
6. Edit the values for Latitude/Longitude and Radius as needed to query for new values, 
as many times as needed

BUILDING THE APP LOCALLY

1) The system should be connected to Internet.

2) Install Maven Version 3 or later.

3) Open a command prompt, and change to the directory nearbyplaces

4) Run the command below

nearbyplaces > mvn install

5) Step 4 will download maven dependencies and produce the executable package
nearbyplace/target/nearbyplaces-0.0.1-SNAPSHOT-jar-with-dependencies.jar

SOME FACTS ON DESIGN AND DEVELOPMENT 

1. The application is a Swing based runnable jar file. 
2. Has been built using maven. pom.xml is included.
3. Uses Jackson libraries for REST/JSON 
4. The Google Places API requires an API usage key and I am using my personal key
generated using my google account. It is currently hardcoded in one of the files
in the source code. Extensive usage of this application may exceed the free quota
provided by Google to use the places API!
