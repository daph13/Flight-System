package ie.lyit.testers;
import java.util.ArrayList;

import ie.lyit.flight.Name;

public class NameTester {

	public static void main(String[] args) {
		//Create a Name object called personA
		Name personA = new Name();
		Name personB = new Name("Mrs", "Marge", "Simpson");
		
		//display personA's details on screen
		System.out.println(personA);
		
		//set personA's name
		personA.setTitle("Mr");
		personA.setFirstName("Homer");
		personA.setSurname("Simpson");
		
		//display personA's details on screen
		System.out.println(personA);

		//display personB's details on screen
		System.out.println(personB);
		
		if(personA.equals(personB))
			System.out.println(personA + " is the same as " + personB);
		else
			System.out.println(personA + " is not the same as " + personB);
		
		if(personA.isFemale())	// or if(personA.isFemale()==true)
			System.out.println(personA + " is female.");			
		else
			System.out.println(personA + " is not female.");					

		if(personB.isFemale())
			System.out.println(personB + " is female.");			
		else
			System.out.println(personB + " is not female.");
		
		
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(new Name("Mr", "Bart", "Simpson"));
		names.add(personA);
		names.add(personB);
		names.trimToSize();
		
		for(Name tempName:names )
		       System.out.println(tempName);
		    
		   if(nameSearch(personA, names))
		       System.out.println("FOUND!");
		   else
			   System.out.println("NOT FOUND!");	    
		}
		
		public static boolean nameSearch(Name nameSearch, ArrayList<Name> listOfNames){
		    return listOfNames.contains(nameSearch);
		}
		

	}
	
	
	


