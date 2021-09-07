# Toyrobot


# How to run
   To run the application please follow the below steps

## Pre requisites
    Java 1.8
    Maven3
    Eclipse/Intellij (Optional)

# Steps

1. clone the repository
2. navigate to toyrobot folder. This folder should have pom.xml available
3. Open the command prompt from that directory
4. Perform the following commands

 

        mvn clean install
        mvn exec:java or mvn exec:java -D"exec.mainClass"="toyrobot.App"  (if you are in windows)

Application will start running the commands from the following file: **toyrobot\testdata.txt**

If you want to use your own test data file you can give the command as below. This will override **default testdata.txt file.** .Feel free to edit here to test with different data

    mvn exec:java -D"exec.mainClass"="toyrobot.App" -D"exec.args"="C:\deepthi\test.txt"

# Another Option to run the application

After  `mvn clean install`  command run the below commands

java -cp target/toyrobot-0.0.1-SNAPSHOT.jar toyrobot.App   -> default testdata
java -cp target/toyrobot-0.0.1-SNAPSHOT.jar toyrobot.App C:\deepthi\test.txt   ->override testdata

 # Option3

In addition to the above, you can import the project into eclipse or anyother ide and run the application.

Main class can be found under
	- toyrobot.App

Test class can be found under
	- toyrobot.app.RobortsimulatorTest
	
Test data used for running the test cases can be found under	
	- src/test/resources/