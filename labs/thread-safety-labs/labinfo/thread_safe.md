### Procedures to run the Sample for Synchronized Program:

1. Move to the Directory where the project is located.

2. Compile the program by the following command(This should be executed where the POM file is located)
	mvn clean compile

3. Create the JAR by the following command
	mvn package
	
4. Execute the JAR file by
	
    	   sh run.sh security.lab.thread.Synchronized
	
5. Now You can find the results of the execution in the results/Synchronize.txt(Within the Project Folder itself) as

        Alice: 2 Seats Booking Success
        
        John: Seats Not Available

### A Brief Explanation of the Program :
	
	
* Two people are trying to book two Train Tickets at the same time.
* Available Ticket Count is 2.
* In synchronization , One of them will have the Successful Booking.
* Hence confusion at the time of journey can be avoided. 
* Synchronization is concept of maintaining the state of the variable at the time multiple access to it.
* And also the program explains way to handle the Checked Exceptions in File Handling procedures
