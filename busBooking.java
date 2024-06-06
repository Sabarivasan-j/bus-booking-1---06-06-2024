package practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class busBooking {
	
	ArrayList<Buses> busList = new ArrayList<Buses>();
	ArrayList<Passengers> passengerList = new ArrayList<Passengers>();
	
	//DISPLAY PASSENGERS LIST METHOD
	void displayPassengers() {
		for(Passengers ele : passengerList) {
			System.out.println(ele);
		}
	}
	
	Buses findBusNumber(int number) {
		for(Buses bus : busList) {
			if(bus.getBusNumber() == number) return bus;
		}
		return null;
	}
	
	//ADD BUS METHOD
	void addBus(Buses bus) {
		busList.add(bus);
	}
	
	//ADD PASSENGER 
	void addPassenger(Passengers passenger) {
		passengerList.add(passenger);
	}
	
	//BOOK TICKET METHOD
	Passengers bookTicket(String name, int busNumber, String fromPlace, String toPlace) {
		Buses bus = findBusNumber(busNumber);
		if( bus != null && bus.bookSeat()) {
			Passengers passenger = new Passengers(name,busNumber,fromPlace,toPlace);
			return passenger;
		}
		else return null;
	}
	//MAIN METHOD
	public static void main(String[] args) {
		
		busBooking system = new busBooking();
		
		Scanner scanner = new Scanner(System.in);
		
		system.addBus(new Buses(10,2,"A","B"));
		system.addBus(new Buses(20,2,"B","C"));
		
		while(true) {
			System.out.println("Press 1 to Book tickets");
			System.out.println("Press 2 to View bookings");
			System.out.println("Press 3 to Exit");
			System.out.println("Enter your choice here : ");
			int choice = 0;
			try {
			choice = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input");
				scanner.nextLine();
				continue;
			}
			scanner.nextLine();
			
			switch(choice) {
			
			case 1 :	
						try {
						System.out.println("Enter the passenger's name : ");
						String name = scanner.nextLine();
						
						System.out.println("Enter the Bus Number : ");
						int busNum = scanner.nextInt();
						
						//consume the leftover newline
						scanner.nextLine();
						
						System.out.println("Enter the OnBoarding stop : ");
						String OnBoardingStop = scanner.nextLine();
						
						System.out.println("Enter the OffBoarding stop : ");
						String OffBoardingStop = scanner.nextLine();
						
						Passengers passenger = system.bookTicket(name,busNum,OnBoardingStop,OffBoardingStop);
						if(passenger != null) {
							system.addPassenger(passenger);
							System.out.println("Ticket Booked Successfully!!!");
							System.out.println("Your Passenger Id is : "+passenger.getId());
							System.out.println("--------------------Thank you----------------------");
						}
						else {
							System.out.println("Failed to Book Ticket");
						}
						break;
						}
						catch(InputMismatchException e) {
							System.out.println("Invalid Input");
							scanner.nextLine();
							continue;
						}
			case 2 : 	system.displayPassengers();
						break;
			case 3 :	System.out.println("Exiting...");
						scanner.close();
						System.exit(0);
						break;
			}
		}
  }
}
