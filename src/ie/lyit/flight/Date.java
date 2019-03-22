package ie.lyit.flight;

import java.io.Serializable;

public class Date implements Serializable {

	private int day;
	private int month;
	private int year;

	private final int MAX_DAY = 31;
	private final int MIN_DAY = 1;
	private final int MAX_MONTH = 12;
	private final int MIN_MONTH = 1;
	private final int MIN_YEAR = 1900;
	
	// Default Constructor 
	//	==> Called when a Date object is created as follows - Date d1 = new Date();
	public Date(){
	   day=month=year=0;
	}

	// Initialization Constructor
	// ==> Called when a Date object is created as follows - Date d2 = new Date(14,9,2010);
	// Initialisation Constructor
  	public Date(int day, int month, int year) throws IllegalArgumentException{
  		if(day < MIN_DAY || day > MAX_DAY || month < MIN_MONTH || month > MAX_MONTH || year < MIN_YEAR) {
  			throw new IllegalArgumentException ("Invalid Date"); 
  			
  		}
       this.day = day;
       this.month = month;
	    this.year = year;
  	}
  	
 // toString() method
 	// ==> Called when a String of the class is used, e.g. - System.out.print(d1);
 	//																  or System.out.print(d1.toString());
 	@Override
    public String toString(){
 		return (day + "/" + month + "/" + year);
 	}
 	
 // equals() method
 	// ==> Called when comparing an object with another object, e.g. - if(d1.equals(d2))
 	@Override
    public boolean equals(Object o){
 		// First check if o is a null reference to prevent run-time exceptions
 		if(o == null) 
          return false;
 	
 		// Next check if o references the current object, if it does it must be equal
 		if (this == o)
 			return true;
          
 		// Next check if o is in fact a Date object
 		if(!(o instanceof Date))
 			return false;
 		else
 		{
 			// If none of the above are true, cast o to a Date object so that
             // we can compare the object's instance variables and methods
 			Date other = (Date)o;
 			
 			return (this.day == other.day) &&
 				   (this.month == other.month) &&
 				   (this.year == other.year);
 		}
 	}
 	
 	// get methods
 	// ==> Called when retrieving part of an object, e.g. - if (d1.getYear() == d2.getYear())
 	public int getDay(){
 		return day;
 	}
 	public int getMonth(){
 		return month;
 	}
 	public int getYear(){
 		return year;
 	}

 	// set methods
 	// ==> Called when setting part of an object, e.g. - d1.setDay(14);
 	//													 d1.setMonth(9);
 	//								    				 d1.setYear(2010);
 	
 	public void setDay(int setDayTo) throws IllegalArgumentException {
 		if (setDayTo < MIN_DAY || setDayTo > MAX_DAY)
 			//ERROR will occur --> throw exception
 			// Method will stop at this point if exception thrown
 			throw new IllegalArgumentException ("Day must be between 1 - 31");
 
        day=setDayTo;
 	}
  	public void setMonth(int setMonthTo) throws IllegalArgumentException{
  		if (setMonthTo < MIN_MONTH || setMonthTo > MAX_MONTH)
 		
 			throw new IllegalArgumentException ("Month must be between 1 - 12");
 		
  		month = setMonthTo;
  	}
  	
  	public void setYear(int setYearTo) throws IllegalArgumentException{
  		if (setYearTo < MIN_YEAR)
  		
  			throw new IllegalArgumentException ("Were you really born that year?");
  		
  		year = setYearTo;
  	}
}
