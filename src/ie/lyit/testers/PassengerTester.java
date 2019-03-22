package ie.lyit.testers;
import ie.lyit.flight.Date;
import ie.lyit.flight.Passenger;

public class PassengerTester {
	public static void main(String[] args) {

	Passenger p1 = new Passenger("Mr", "John", "Doe", 12, 12, 1997, 2, false);
	System.out.println("p1 = " + p1);
	Passenger p2 = new Passenger("Mrs", "Julia", "Fay", 12, 12, 1951, 3, true);
	System.out.println("p2 = " + p2);
	
	System.out.println("Changing p1 details");
	p1.setNoBags(1);
	Date d1 = new Date (13,5,1991);
	p1.setDateOfBirth(d1);
	System.out.println("New p1 details: " + p1);
	
	if(p1.equals(p2))
		System.out.println("Passengers are equal.");
	else
		System.out.println("Passengers are not equal.");

	
	}
}
