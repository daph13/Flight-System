package ie.lyit.testers;

import ie.lyit.flight.Menu;
import ie.lyit.serialize.EmployeeSerializer;

public class EmployeeSerializerTester {

	public static void main(String[] args) {
		 EmployeeSerializer emp = new EmployeeSerializer();
	 
		 //Call the BookSerializer deserializaEmployees() method
		 emp.deserializeEmployees();
		 //display the Employee array 
		 emp.list();
		 
		 Menu menu = new Menu();
			do {	menu.display();
					menu.readOption();
			
			switch(menu.getOption()) {
				case 1: emp.add();
						break;
				case 2: emp.list();
						break;
				case 3: emp.view();
						break;
				case 4: emp.edit();
						break;
				case 5: emp.delete();
						break;
				case 6: default:break;
				}
		}while(menu.getOption() != 6);
		//while option != 6
		
		//Call the BookSerializer serializaEmployees() method
		emp.serializeEmployees();
		 
	}

}
