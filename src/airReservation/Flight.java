package airReservation;

public class Flight {

	private int flightNumber;
	private String designation;
	private int availableSeats;
	public Flight(int flightNumber, String designation, int availableSeats) {
		super();
		this.flightNumber = flightNumber;
		this.designation = designation;
		this.availableSeats = availableSeats;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", designation=" + designation + "]";
	}
	
	public void decreaseAvailableSeats() {
		if(availableSeats>0) {
			availableSeats--;
		}
	}
}
