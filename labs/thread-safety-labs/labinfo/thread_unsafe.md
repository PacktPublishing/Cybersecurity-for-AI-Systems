## Procedures to run the Sample for Non-Synchronized Program :

1. Move to the Directory where the project is located.

2. Compile the program by the following command(This should be executed where the POM file is located)
	mvn clean compile

3. Create the JAR by the following command
	
	    mvn package
	
4. Execute the JAR file by(
	
	
	    sh run.sh security.lab.thread.NonSynchronized
	
5. Now You can find the results of the execution in the results/NonSynchronize.txt(Within the Project Folder itself)as 

    Alice: 2 Seats Booking Success
    
    John: 2 Seats Booking Success

### A Brief Explanation of the Program :
	
*Two people are trying to book two Train Tickets at the same time.
* Available Ticket Count is 2.
* In non-synchronization
 -  Both the people will have the successful Booking leading to the confusion at the time of journey. This is due to the thread-unsafe state of the Available Ticket Count  .
	
* Thread-Unsafe may or may not occur but Synchronization will never allow such confusions.
* And also the program explains way to handle the Checked Exceptions in File Handling procedures

