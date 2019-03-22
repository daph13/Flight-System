package ie.lyit.serialize;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ie.lyit.flight.Employee;
public class EmployeeSerializer {
	
	private static final String FILENAME = "employees.ser";
	ArrayList<Employee> employees;
	
	//Default constructor 
	public EmployeeSerializer() {
		//Constructor employeeList ArrayList
		employees = new ArrayList<Employee>();
	}
	
	public void add() {
		//Create an Employee object
		Employee employee = new Employee();
		
		//if the Employee array is not empty
		if(!employees.isEmpty()) {
		//get the index of the last item in the array	
		int last = employees.size() - 1;
		//set the new Employee number to the next number  
		int next = employees.get(last).getNumber() + 1;
		employee.setNextNumber(next);
		//System.out.println("The next number is:" + employee.getNumber());
		employee.read();
		}
		else {
			//set the new Employee number to 1000 if it is the first item in the array
			employee.setNextNumber(1000);
			employee.read();
		}
		
		//if the Employee number is not set to 0, add the Employee to the array
		if(employee.getNumber() == 0) {
			JOptionPane.showMessageDialog(null, "Employee not added");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Employee added");
			employees.add(employee);
		}
		
	}
	
	public void serializeEmployees() {
		//Serialize the ArrayList
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(employees);
			os.close();
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}
	
	public void deserializeEmployees() {
		//Deserialize the ArrayList
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
			ObjectInputStream is = new ObjectInputStream(fileStream);
			employees = (ArrayList<Employee>)is.readObject();
			is.close();
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	public void list() {
		//loop through the employees array and...
		for(Employee tmpEmp:employees)
		//display the Employee objects from the array	
			System.out.println(tmpEmp);
	}
	
	public Employee view() {
		boolean exists = false;
		Scanner keyboard = new Scanner(System.in);
		
		//Read the number of the employee to be viewed from the user
		System.out.println("ENTER EMPLOYEE NUMBER: ");
		int empToView = keyboard.nextInt();
		
		//for every Employee object in employees
		for(Employee tmpEmp:employees) {
			//if it's number equals the number of the empToView
			if(tmpEmp.getNumber() == empToView)
			{
				exists = true;
				//display it and..
				System.out.println(tmpEmp);
				//return it
				return tmpEmp;
			}
		}
		if (exists == false) 
		{
			System.out.println("Employee does not exist");
		}
		return null;
	}
	
	public void delete() {
		Employee tempEmp = view();
		if(tempEmp != null) 
			employees.remove(tempEmp);
	}
	
	
	public void edit() {
		//Call view() to find, display, & return the employee to edit
		Employee tempEmp = view();
		
		//If the employee != null, i.e. it was found then
		if(tempEmp != null)
		{
			//get its index
			int index = employees.indexOf(tempEmp);
			//create a new variable to store the initial employee number
			int currentId = tempEmp.getNumber();
			//read in a new employee and 
			tempEmp.read();
			//if the employee number is not set to 0...
			if (tempEmp.getNumber() != 0) 
			{
				//reset the object in employees
				employees.set(index, tempEmp);
			}
			else 
			{
				//reset the employee number to it's initial number
				tempEmp.setNextNumber(currentId);
			}
				
			
				
		}
	}
	
}
