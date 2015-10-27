# nearbyplaces
A Java Swing application which calls Google Places API using REST/GET client to show interesting places near a given location, within a given distance. 


STEPS TO RUN 

1. Download the source code and extract it to a package named say, nearbyplace.
2. On the command prompt, run the two commands below 
   cd nearbyplaces/target 
   java -jar nearbyplaces-0.0.1-SNAPSHOT-jar-with-dependencies.jar 
3. This opens up a Swing UI having some default values for Latitude/Longitude/Radius. 
(The values may be edited as needed) 
4. Click on the button "Search" to search for interesting places near this default 
location. This displays Name, Vicinity and Types of several places in the proximity. 
5. Edit the values for Latitude/Longitude and Radius as needed to query for new values, 
as many times as needed 

SOME FACTS ON DESIGN AND DEVELOPMENT 

1. The application is a Swing based runnable jar file. 
2. Has been built using maven. pom.xml is included.
3. Uses Jackson libraries for REST/JSON 
4. The Google Places API requires an API usage key and I am using my personal key
generated using my google account. It is currently hardcoded in one of the files
in the source code. Extensive usage of this application may exceed the free quota
provided by Google to use the places API!
