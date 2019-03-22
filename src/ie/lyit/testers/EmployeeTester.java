package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.flight.Employee;
import ie.lyit.flight.Name;

public class EmployeeTester {

	public static void main(String[] args) {
	
		Employee e1 = new Employee ("Mr", "Jake", "Ellen", 12, 10, 1988, 5100.00, 15, 05, 2009);
		Employee e2 = new Employee ("Ms", "Hailey", "Pickles", 13, 01, 1989, 5200.00, 15, 02, 2009);
		Employee e3 = new Employee ();
		Employee e4 = new Employee();
		Employee e5 = new Employee();

		Name n1 = new Name("Mr", "Bart", "Gray");
		e3.setName(n1);
		
		
		System.out.println("Employee 1: " + e1);
		System.out.println("Employee 2: " + e2);
		
		if(e1.equals(e2))
			System.out.println("Employees are equal.");
		else
			System.out.println("Employees are not equal.");
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println(employees);
		System.out.println(employees.get(0).employeeSearch(e4, employees));
		//System.out.println(employeeSearch(e4, employees));
		
	}
	
//	public static boolean  employeeSearch(Employee e, ArrayList<Employee> list) {
//		boolean isPresent = false;
//		
//		for(int i = 0; i < list.size(); i++) {
//			if(e.getNumber() == list.get(i).getNumber()) {
//				isPresent = true;
//			}
//		}
//		return isPresent;
//			
//	}
}
