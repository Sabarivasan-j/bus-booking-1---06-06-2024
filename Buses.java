package practice;

public class Buses {
	private int busNumber = 1;
	private int capacity = 2;
	private String fromPlace;
	private String toPlace;
	private int bookedSeats = 0;
	
	Buses(int busNumber, int capacity, String fromPlace, String toPlace){
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
	}
	
	boolean bookSeat() {
		if(bookedSeats<capacity) {
			bookedSeats++;
			return true;
		}
		else return false;
	}
	
	int getBusNumber() {
		return busNumber;
	}
	int getCapacity() {
		return capacity;
	}
	String getFromPlace() {
		return fromPlace;
	}
	String getToPlace() {
		return toPlace;
	}
}
