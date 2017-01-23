# PizzaApplication
Program which reads pizza type and time it was ordered, sorts it lexicographically and converts the Epoch time to human readable date/time and writes to another file

##Completed Tasks:
- Mavenized the project
- Source code is included
- Few test cases were included due to shortage of time
- Ability to run test cases from command line with maven
- Ability to pass the input and output file paths as input arguments to the jar executable


##How to Run?
1. Clone or download the file to your local machine, which has maven path set up already
2. Go to the Folder PizzaApp. (CD PizzaApp)
3. run the $`mvn compile` command, one the build success message is seen
4. run the $`mvn package` command, you can see the all the test cases being run and jar file being created in target folder
5. run the $`java` `/path/../target/PizzaApp=1.2.jar` `com.venkat.java.App` `/path/../sample_data.txt` `/path/../output_data.txt`
6. the human readable date-time with the pizza type will be written to the output file.

##Assumptions Made
1.Input file exists
2.Input file contains records with columns `Order` and `Time`
3.Time obtained from the input file is Unix Epoch Time.
4.User is supposed to pass the arguments for the input and output file.

##Design
1. The application fetches the data from the sample text file.
2. Reads and stores the records to a Model Object `OrderData`.
3. Since it's easy to compare the epoch time stamps, they were sorted by comparing and later written to output file.


###Captured Results produced
Venkats-iMac:PizzaApp venkat$ mvn compile
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building PizzaApp 1.2
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ PizzaApp ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/venkat/Documents/workspace/assignmentApp/PizzaApp/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ PizzaApp ---
[INFO] Nothing to compile - all classes are up to date
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.415 s
[INFO] Finished at: 2017-01-23T03:25:11-05:00
[INFO] Final Memory: 8M/491M
[INFO] ------------------------------------------------------------------------
Venkats-iMac:PizzaApp venkat$ mvn package
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building PizzaApp 1.2
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ PizzaApp ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/venkat/Documents/workspace/assignmentApp/PizzaApp/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ PizzaApp ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ PizzaApp ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/venkat/Documents/workspace/assignmentApp/PizzaApp/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ PizzaApp ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ PizzaApp ---
[INFO] Surefire report directory: /Users/venkat/Documents/workspace/assignmentApp/PizzaApp/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.venkat.java.AppTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.179 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ PizzaApp ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.782 s
[INFO] Finished at: 2017-01-23T03:27:45-05:00
[INFO] Final Memory: 12M/491M
[INFO] ------------------------------------------------------------------------
Venkats-iMac:PizzaApp venkat$ java -cp /Users/venkat/Documents/workspace/assignmentApp/PizzaApp/target/PizzaApp-1.2.jar com.venkat.java.App /Users/venkat/Desktop/sample_data_ordered.txt /Users/venkat/Desktop/output_data.txt 
meatMeaT	Mon, Sep 19, '16 2:24 PM
VegVeg	Mon, Sep 19, '16 2:24 PM
bread	Fri, Sep 23, '16 2:24 PM
bread	Sun, Oct 23, '16 2:24 PM
Pizza	Mon, Oct 24, '16 2:24 PM
Bread	Tue, Oct 25, '16 2:24 PM
p1zza	Wed, Oct 26, '16 2:24 PM
pizza	Thu, Oct 27, '16 2:24 PM
Meat	Sat, Sep 23, '17 2:24 PM


