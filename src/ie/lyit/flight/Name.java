package ie.lyit.flight;

import java.io.Serializable;

public class Name implements Serializable {
	private String title;
	private String firstName;
	private String surname;
	
	// Default Constructor 
	// ==> Called when a Name object is created as follows
	//		Name n1 = new Name();
	
	public Name() {
		/*this.title = null;
		this.firstName = null;
		this.surname = null; */
		title=firstName=surname=null;
	}
	
	// Initialization Constructor
	// ==> Called when a Name object is created as follows
	//		Name n2 = new Name("Mr", "Joe", "Cole");
	public Name(String t, String fN, String sn) {
		this.title = t;
		this.firstName = fN;
		this.surname = sn;
	}
	
	public void setTitle(String setTitleTo) {
		title =  setTitleTo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setFirstName(String setFirstTo) {
		firstName = setFirstTo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setSurname(String setSurnameTo) {
		surname = setSurnameTo;
	}
	
	public String getSurname() {
		return surname;
	}
	
	
	
	@Override
	public String toString() {
		return title + " " + firstName + " " + surname;
	}
	
	// equals() method
	//==> Called when comparing an object with another object
	//	if(n1.equals(n2))
	@Override
	public boolean equals (Object obj) {
		Name nObject;
		if (obj instanceof Name)
			nObject = (Name) obj;
		else
			return false;
		
		return (this.title.equals(nObject.title)
				&& this.firstName.equals(nObject.firstName)
				&& this.surname.equals(nObject.surname));
			
	}
	
	public boolean isFemale() {
		
	/*	if (title == "Ms" || title == "Miss" || title == "Mrs")
			return true;
		else
			return false;
		*/
		
		if(title.equalsIgnoreCase("Miss") ||
			title.equalsIgnoreCase("Ms") ||
			title.equalsIgnoreCase("Mrs"))
			return true;
			else
			return false;
	}
}
