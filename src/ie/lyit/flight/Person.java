package ie.lyit.flight;

import java.io.Serializable;

public abstract class Person implements Serializable {

	protected Name name;		//COMPOSITION - Person HAS A Name
	protected Date dateOfBirth; //COMPOSITION - Person HAS A Date
	
	//Default Constructor
	//Called when object is created like this =>
	//	Person pObj = new Person();
	//Won't work cause Person is abstract
	public Person() {
		this.name = new Name();
		this.dateOfBirth = new Date();
	}
	
	//Initialisation Constructor
	//Called when object would have been created like this ==>
	//	 ==>Person pObj = new Person("Mr", "Joe", "Doe", 25, 12, 1985);
	//Won't work cause person is abstract
	public Person (String t, String fN, String sn, int d, int m, int y) {
		name = new Name(t, fN, sn);
		dateOfBirth = new Date(d, m, y) ;
	}
	
	//toString() method
	//==> Calls Name's toString() to display name, and 
	//		Date's toString() to display dateOfBirth
	public String toString() {
		return name + "," + dateOfBirth;
	}
	
	
	//set() and get() methods
	public void setName (Name nameIn) {
		name = nameIn;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setDateOfBirth (Date dateOfBirthIn) {
		dateOfBirth = dateOfBirthIn;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	@Override 
	public boolean equals (Object obj)
	{
		Person pObject;
		if (obj instanceof Person)
			pObject = (Person) obj;
		else
			return false;
		
		return (name.equals(pObject.name)
				&& dateOfBirth.equals(pObject.dateOfBirth));
				
	}
}
