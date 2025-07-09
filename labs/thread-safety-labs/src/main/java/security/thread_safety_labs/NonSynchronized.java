package security.thread_safety_labs;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class NonSynchronizedTicketCounter{
	/*
	 * This Class performs the non-synchronized Block and writes 
	 * the final status to the File specified
	*/
	int availableSeats = 2;
	void bookTicket(String pname,int numberOfSeats)
	{
		String bookingData;
		Path path = Paths.get("results/NonSynchronize.txt");
		if((availableSeats>=numberOfSeats)&&(numberOfSeats>0))
		{
			bookingData = System.lineSeparator()+pname+" : "+numberOfSeats+" "
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

class NonSynchronizedTicketBookingThread extends Thread{
	/*
	 * Class where the variables are initialized and
	 * passed to the non-synchronized Block*/
	NonSynchronizedTicketCounter ticketCounter;
	String name;
	int seats;
	NonSynchronizedTicketBookingThread(NonSynchronizedTicketCounter ticketCounterObject,String passengerName,int passengerSeatsCount)
	{
		ticketCounter = ticketCounterObject;
		name = passengerName;
		seats = passengerSeatsCount;
		start();
	}
	public void run()
	{
		//Call to the Non-Synchronized Block
		ticketCounter.bookTicket(name, seats);
	}
}
public class NonSynchronized {
	/*
	 * Class Creates 2 Threads With the passenger data
	 * and Sends call for for the Non-Synchronized Block
	 */
	public static void main(String[] args) {
		/*
		 * Empties the File to store the Final Status and
		 * if File is not present create it
		 * */
		try {
			PrintWriter writer = new PrintWriter("results/NonSynchronize.txt");
			writer.write("");
			writer.close();
		} catch (FileNotFoundException e) {
			File file = new File("results/NonSynchronize.txt");
			e.printStackTrace();
		}
		NonSynchronizedTicketCounter ticketCounter = new NonSynchronizedTicketCounter();
		//Objects to the  synchronized Block
		NonSynchronizedTicketBookingThread thread1 = new NonSynchronizedTicketBookingThread(ticketCounter,"Alice",2);
		NonSynchronizedTicketBookingThread thread2 = new NonSynchronizedTicketBookingThread(ticketCounter,"John",2);
		
	}
}