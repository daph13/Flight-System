package ie.lyit.flight;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
	private int option;
	
	public Menu() {
		option = 0;
	}
	
	public void display() {
		System.out.println("\t1.Add");
		System.out.println("\t2.List");
		System.out.println("\t3.View");
		System.out.println("\t4.Edit");
		System.out.println("\t5.Delete");
		System.out.println("\t6.Quit");
	}
	
	public void readOption() {
		Scanner kbdInt = new Scanner(System.in);
		System.out.println("\nEnter Option [1|2|3|4|5|6]");
		
		
		try {
		option = kbdInt.nextInt();
		}
		catch(InputMismatchException iME)
		{
			System.out.println(iME.getMessage());
			return;
		}
		
		//show an error message to prompt the user to enter a valid option
		if (option > 6 || option <1) {
			System.out.println("Invalid Number \nPlease enter an option between 1 - 6");
			//JOptionPane.showMessageDialog(null, "Invalid Number \nPlease enter an option between 1 - 6", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int getOption() {
		return option;
	}
}
