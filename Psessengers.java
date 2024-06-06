package practice;

public class Passengers {
	private String name;
	private static int Id = 0;
	private int boardingBus;
	private String fromPlace;
	private String toPlace;
	
	Passengers(String name,int boardingBus, String fromPlace, String toPlace) {
		this.name = name;
		this.boardingBus = boardingBus;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
	}
	
	String getName() {
		return name;
	}
	int getId() {
		Id++;
		return Id;
	}
	int getBoardingBus() {
		return boardingBus;
	}
	String getFromPlace() {
		return fromPlace;
	}
	String getToPlace() {
		return toPlace;
	}
}
