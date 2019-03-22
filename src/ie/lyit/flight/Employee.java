package ie.lyit.flight;


import java.awt.Dimension;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;




public class Employee extends Person implements Payable, Serializable {
	private double salary;
	private Date startDate;
	private int number;
	
	private static int nextNumber = 1000;
	
	private final double MAX_SALARY = 150000.00;
	
	
	public Employee() {
		super();
		salary = 0.0;
		startDate = new Date();
		number = nextNumber++;
	}
	
	public Employee(String t, String fN, String sn, int d, int m, int y, double sal, int sd, int sm, int sy) {
		super(t,fN,sn,d,m,y);
		salary = sal;
		startDate = new Date(sd, sm, sy);
		number = nextNumber++;
	}
	
	@Override 
	public String toString() {
		return super.toString() + " ==> Date Started: " + startDate + ", Salary: " + salary + ", Employee ID: " + number ;
	}

	@Override 
	public boolean equals (Object obj) {
		Employee emObject;
		if (obj instanceof Employee)
			emObject = (Employee) obj;
		else
			return false;
		
		return (this.name.equals(emObject.name)
				&& this.dateOfBirth.equals(emObject.dateOfBirth)
				&& this.salary == emObject.salary
				&& this.startDate.equals(emObject.startDate)
				&& this.number == emObject.number);
		//return(this.number == emObject.number);
	}
	
	public void setSalary (double setSalaryTo) {
		salary = setSalaryTo;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setStartDate(Date setSDateTo) {
		startDate = setSDateTo;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNextNumber(int next) {
		number = next;
	}
		
	
	@Override
	public double calculateWage(double taxPercentage) {
		// TODO Auto-generated method stub
		double wage;
		wage = salary/12  - (salary/12 * (taxPercentage/100));
		return wage;
		
		// double wage = salary/12
		// wage -= (wage * (taxPercentage/100));
		//return wage
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		// TODO Auto-generated method stub
		double newAmount = 0.0;
		newAmount = salary + incrementAmount;
		
		if(newAmount > MAX_SALARY) {
			System.out.println("Salary cannot be more than €150000.00");
			newAmount = MAX_SALARY;
		}
		
		return newAmount;
	}

	public boolean  employeeSearch(Employee e, ArrayList<Employee> list) {
		boolean isPresent = false;
		
		for(int i = 0; i < list.size(); i++) {
			if(e.getNumber() == list.get(i).getNumber()) {
				isPresent = true;
			}
		}
		return isPresent;
			
	}
	
	public void read() {
		JPanel panel = new JPanel();
		
		JTextField txtNumber = new JTextField();
		//set Employee number 
		txtNumber.setText("" + this.getNumber());
		txtNumber.setEditable(false);
		
		JLabel title = new JLabel("Title: ");
		JTextField txtTitle = new JTextField();
		txtTitle.setPreferredSize(new Dimension(50,20));

		//if Employee's title is not null, set the JTextField to it's value 
		if(txtTitle != null)
		{
			txtTitle.setText(this.getName().getTitle());
		}
		
		JLabel fName = new JLabel("First Name: ");
		JTextField txtFirstName = new JTextField();
		txtFirstName.setPreferredSize(new Dimension(100,20));
		
		//if Employee's firstName is not null, set the JTextField to it's value 
		if(txtFirstName != null)
		{
			txtFirstName.setText(this.getName().getFirstName());
		}
		
		JLabel sName = new JLabel("Surname: ");
		JTextField txtSurname = new JTextField();
		txtSurname.setPreferredSize(new Dimension(100,20));
		
		//if Employee's surname is not null, set the JTextField to it's value 
		if(txtSurname != null)
		{
			txtSurname.setText(this.getName().getSurname());
		}
		
		//items added in the panel will be arranged horizontally
		panel.add(title);
		panel.add(txtTitle);
		panel.add(fName);
		panel.add(txtFirstName);
		panel.add(sName);
		panel.add(txtSurname);
		
		JDateChooser txtBirthDate = new JDateChooser();		
		
		txtBirthDate.setDateFormatString("dd/MM/yyyy");
		java.util.Date cDate = new java.util.Date();
	
			//if Employee's day of birth is 0 
			if (this.dateOfBirth.getDay() == 0) {
				//set the JDateChooser to the current date
				txtBirthDate.setDate(cDate);
			}
			else
			{
				//else if Employee's day of birth is NOT 0, set the JDateChooser to the Employee's dateOfBirth
				//Create a string of the employee's date of birth
				String bDate = this.dateOfBirth.getDay() + "/" + this.dateOfBirth.getMonth() + "/" + this.dateOfBirth.getYear();			
				//create a new Date object from java.util package
				java.util.Date date = new java.util.Date();

				try {
					//format the date and parse the employee's date of birth which is a string 
					date = new SimpleDateFormat("dd/MM/yyyy").parse(bDate);
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//set the DateChooser to the employee's date of birth
				txtBirthDate.setDate(date);
			}
		
		
		JDateChooser txtStartDate = new JDateChooser();
		txtStartDate.setDateFormatString("dd/MM/yyyy");
		//if Employee's startDate day is 0...
		if(this.startDate.getDay() == 0)
		{
			//set the JDateChooser to the current date
			txtStartDate.setDate(cDate);
		}
		else
		{
			//else if Employee's startDate day is NOT 0, set the JDateChooser to the Employee's startDate
			//Create a string of the employee's start date
			String sDate = this.startDate.getDay() + "/" + this.startDate.getMonth() + "/" + this.startDate.getYear();
			//create a new Date object from java.util package
			java.util.Date date = new java.util.Date() ;
			
			try {
				
				//format the date and parse the employee's start date which is a string 
				date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//set the DateChooser to the employee's start date
			txtStartDate.setDate(date);
		}
		
		
		JTextField txtSalary = new JTextField();
		txtSalary.setText("" + this.getSalary());

		
	
		
		
		Object[] message = {
		          "Employee Number:", txtNumber,
		          "Employee Name", 
		           panel,
		          "Date of Birth:", txtBirthDate,
		          "Start Date:", txtStartDate,
		          "Salary:", txtSalary,
		      };
		
		int option = JOptionPane.showConfirmDialog(null, message, "Enter Employee details", JOptionPane.OK_CANCEL_OPTION);
		
		DateFormat day = new SimpleDateFormat("dd");
		DateFormat month = new SimpleDateFormat("MM");
		DateFormat year = new SimpleDateFormat("yyyy");
		
		if(option == JOptionPane.OK_OPTION) {
			this.number = Integer.parseInt(txtNumber.getText());
			
			try
			{
				//set the Employee's name
				this.name = new Name(txtTitle.getText(),txtFirstName.getText(),txtSurname.getText());

				//set the Employee's salary
				this.salary = Double.parseDouble(txtSalary.getText()); 
				
				//set the Employee's dateOfBirth
				this.dateOfBirth = new Date(Integer.parseInt(day.format(txtBirthDate.getDate())), Integer.parseInt(month.format(txtBirthDate.getDate())), Integer.parseInt(year.format(txtBirthDate.getDate())));

				//set the Employee's startDate
				this.startDate = new Date(Integer.parseInt(day.format(txtStartDate.getDate())), Integer.parseInt(month.format(txtStartDate.getDate())), Integer.parseInt(year.format(txtStartDate.getDate())));

				//throw an error if the txtTitle is empty
				if(txtTitle.getText().isEmpty()) {
					throw new IllegalArgumentException("Please enter a Title");
				}
				
				//throw an error if the txtFirstName is empty
				if(txtFirstName.getText().isEmpty()) {
					throw new IllegalArgumentException("Please enter a First Name");
				}
				
				//throw an error if the txtSurname is empty
				if(txtSurname.getText().isEmpty()) {
					throw new IllegalArgumentException("Please enter a Surname");
				}
				
				//throw an error if the txtSalary is empty
				if(txtSalary.getText().isEmpty()) {
					throw new IllegalArgumentException("Please enter a valid salary");
				}
				
				//throw an error if the txtSalary is 0 or less
				if(Double.parseDouble(txtSalary.getText()) <= 0) {
					throw new IllegalArgumentException("Salary must be more than 0");
				}
				
				//throw an error if the txtSalary is more than 150000
				if(Double.parseDouble(txtSalary.getText()) > 150000.00) {
					throw new IllegalArgumentException("Salary cannot exceed 150000.00");
				}
				
				//throw an error if the start Year is earlier that the birth year
				if(txtBirthDate.getDate().getYear() > txtStartDate.getDate().getYear()) {
					throw new IllegalArgumentException("Start Date cannot be before Birth Date");
				}

			}
			catch(IllegalArgumentException iFE)
			{
				//show an error message and call read method again
				JOptionPane.showMessageDialog(null, iFE.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				this.read();
			}
			catch(NullPointerException nPE)
			{
				//show an error message and call read method again
				JOptionPane.showMessageDialog(null, "Please enter valid dates", "Error", JOptionPane.ERROR_MESSAGE);
				this.read();
			}
				
			
		}
		//if the Cancel button is clicked
		else if (option == JOptionPane.CANCEL_OPTION) {
				//set Employee number to 0
				this.number = 0;
		}

	}
}
