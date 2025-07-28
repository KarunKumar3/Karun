package airReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {

	static ArrayList<Flight> list = new ArrayList<>();
	static ArrayList<Reservation> reserv = new ArrayList<>();
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		list.add(new Flight(123, "London", 5));
		list.add(new Flight(456, "India", 15));
		list.add(new Flight(789, "USA", 4));
		while(true) {
			System.out.println("\n------AirLine Reservation Systems--------");
			System.out.println("1.Display Available Seats");
			System.out.println("2.Book a Flight");
			System.out.println("3.View Reservation");
			System.out.println("4.Cancel Booking");
			System.out.println("5.exit");
			System.out.println("Choose an Option");
			
			int Choice=getValidIntegerInput();
			switch(Choice) {
			case 1 : {
				displayAvailableFlights();
				break;
			}
			case 2 : {
				bookFlight();
				break;
			}
			case 3 : {
				viewReservation();
				break;
			}
			case 4 : {
				cancelBooking();
				break;
			}
			case 5 : {
				System.out.println("Existing the system");
				scan.close();
				return;
			}
			default : {
				System.out.println("Invalid option, please try again");
			}
			}
		}
	}

	private static void cancelBooking() {
		System.out.println("Enter the name of the passenger to cancel the flight");
		String PassengerName=scan.next();
		Reservation reservationToCancel=null;
		for(Reservation r:reserv) {
			if(r.getName().equalsIgnoreCase(PassengerName)) {
				reservationToCancel=r;
				break;
			}
		}
		if(reservationToCancel !=null) {
			Flight flight=reservationToCancel.getFlight();
			flight.setAvailableSeats(flight.getAvailableSeats()+1);
			reserv.remove(reservationToCancel);
			System.out.println("Reservation is Cancel for the Passenger");
		}else {
			System.out.println("No Resrvation are made yet with the name "+PassengerName);
		}
		
	}

	private static void viewReservation() {
		if(reserv.isEmpty()) {
			System.out.println("No reservation done yet!!!!!");
		}else {
			System.out.println("Reservations------");
			for(Reservation r:reserv) {
				System.out.println("Passenger Name "+r.getName());
				System.out.println("Flight Name "+r.getFlight().getFlightNumber());
				System.out.println("Designation Name "+r.getFlight().getDesignation());
				System.out.println("=========================");
			}
		}
		
	}

	private static void bookFlight() {
		displayAvailableFlights();
		System.out.println("Enter the Flight number you want to book");
		int flightNumber=getValidIntegerInput();
		Flight selectFlight=null;
		for(Flight flight:list) {
			if(flight.getFlightNumber()==flightNumber) {
				selectFlight=flight;
				break;
			}
		}
		if(selectFlight==null) {
			System.out.println("Invalid Flight number try again");
			return;
		}
		if(selectFlight.getAvailableSeats()>0) {
			System.out.println("Enter your name");
			String passengerName=scan.next();
			Reservation reservation=new Reservation(passengerName,selectFlight);
			reserv.add(reservation);
			selectFlight.decreaseAvailableSeats();
			System.out.println("Booking Successfully!!!");
		}else {
			System.out.println("Sorry Seats are not available");
		}
		
	}
 
	private static void displayAvailableFlights() {
		System.out.println("\n------Available flights------------");
		for(Flight f:list) {
			System.out.println("FlightNumber: "+f.getFlightNumber()+",Designation "+f.getDesignation()+", AvaiableSeats "+f.getAvailableSeats());
		}
		
	}

	private static int getValidIntegerInput() {
		while(!scan.hasNextInt()) {
			System.out.println("Enter the proper number");
			scan.next();
		}
		return scan.nextInt();
	}

}
