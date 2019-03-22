package ie.lyit.flight;

public class Passenger extends Person{ //INHERITENCE - Passenger
	private int noBags;
	private boolean priorityBoarding;
	
	//Default Constructor 
	//Called when object is created like this ==>
	// Passenger prObj = new Passenger();
	public Passenger() {
		super(); //The super() constructor will get called -- it's okay not to write this as it will already be called
		this.noBags = 0;
		this.priorityBoarding = false;
	}
	
	//Initialisation Constructor
	//Called when object is created like this ==>
	//	Passenger prObj = new Passenger("Mr", "Joe", "Doe", 24, 12, 1985, 2, false)
	public Passenger(String t, String fN, String sn, int d, int m, int y, int noB, boolean pB) {
		//Call super class constructor - Passing parameters from Person
		super(t,fN,sn,d,m,y);
		//And then initialise Passengers own instance variables
		noBags = noB;
		priorityBoarding = pB;
	}

	//OVERRIDING the Person toString() method
	//Calling Person's toString() method, and adding additional information from subclass 
	@Override
	public String toString() {
		return super.toString() + " ==> " + noBags + " bags, Priority Boarding: " + priorityBoarding;
	}
	
	@Override 
	public boolean equals (Object obj) {
		Passenger prObject;
		if (obj instanceof Passenger)
			prObject = (Passenger) obj;
		else
			return false;
		
		return (this.name.equals(prObject.name)
				&& this.dateOfBirth.equals(prObject.dateOfBirth)
				&& this.noBags== prObject.noBags
				&& this.priorityBoarding == prObject.priorityBoarding);
		
		/** OR MAKING IT SHORTER
		 * return (super.equals(prObject)
		 * 			&& this.noBags == prObject.noBags
		 * 			&& this.priorityBoarding == prObject.priorityBoarding);
		 */
		 
	}
	
	
	public void setNoBags (int setNoBagsTo) {
		noBags = setNoBagsTo;
	}
	
	public int getNoBags() {
		return noBags;
	}
	
	public void setPriorityBoarding (boolean setPBTo) {
		priorityBoarding = setPBTo;
	}
	
	public boolean getPriorityBoarding() {
		return priorityBoarding;
	}
	
}
