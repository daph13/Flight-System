package ie.lyit.flight;

public interface Payable {
	public abstract double calculateWage(double taxPercentage);
	//Don't have to put in public abstract 
	double incrementSalary(double incrementAmount); 
	
	// A java interface can contain only abstract methods, i.e. methods without a body
	//It describes what an implementing class will do and NOT how it will do it
}

