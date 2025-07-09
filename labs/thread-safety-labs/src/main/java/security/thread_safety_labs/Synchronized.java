package security.thread_safety_labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
/*
 * 
 * A Simple Java Application to Book Railway Tickets 
 * This explains the synchronization and Exception Handling Procedures
 * 
 */

class SynchonizedTicketCounter{
	/*
	 * This Class performs the synchronized Block and writes 
	 * the final status to the File specified
	*/
	int availableSeats = 2;
	String bookingdata ;
	synchronized void bookTicket(String pname,int numberOfSeats)
	{
		/*A synchronized Block which maintains the State of Thread
		 *and stores the final status to the file
		 */
		String bookingData;
		Path path = Paths.get("results/Synchronize.txt");
		if((availableSeats>=numberOfSeats)&&(numberOfSeats>0))
		{
			bookingData =  System.lineSeparator()+pname+" : "+numberOfSeats+" "
					+ "Seats Booking Success"+ System.lineSeparator();
			availableSeats-=numberOfSeats;
		}else
			bookingData = System.lineSeparator()+pname+" :"
					+ " Seats Not Available"+ System.lineSeparator();
		try {
			Files.write(path, bookingData.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class SynchronizeTicketBooking extends Thread{
	/*
	 * Class where the variables are initialized with the data and
	 * passed to the synchronized Block*/
	SynchonizedTicketCounter ticketCounter;
	String name;
	int seats;
	SynchronizeTicketBooking(SynchonizedTicketCounter ticketCounterObject,String passengerName,int passengerSeatsCount)
	{
		ticketCounter = ticketCounterObject;
		name = passengerName;
		seats = passengerSeatsCount;
		start();
	}
	public void run()
	{
		//Call to the Synchronized Block
		ticketCounter.bookTicket(name, seats);
	}
}

public class Synchronized{
	/*
	 * Class Creates 2 Threads With the passenger data
	 * and Sends call for for the Synchronized Block
	 */
	public static void main(String[] args) {
		/*
		 * Empties the File to store the Final Status and
		 * if File is not present create it
		 * */
		try {
			PrintWriter writer = new PrintWriter("results/Synchronize.txt");
			writer.write("");
			writer.close();
		} catch (FileNotFoundException e) {
			File file = new File("results/Synchronize.txt");
			e.printStackTrace();
		}
		SynchonizedTicketCounter ticketCounter = new SynchonizedTicketCounter();
		//Objects to the  synchronized Block
		SynchronizeTicketBooking thread1 = new SynchronizeTicketBooking(ticketCounter,"Alice",2);
		SynchronizeTicketBooking threa2 = new SynchronizeTicketBooking(ticketCounter,"John",2);    
	}
}
