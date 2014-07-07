package java_essential_training;

public class Employee {
	
	public String getAttributes(){
		return attributes;
	}
	
	public int getHours() {
		return 40;
	}
	public double getSalary() {
		return 50000.0;
	}

	public int getVacationDays() {
		return 10;
	}
	public String getVacationForm() {
		return "yellow";
	}
	
	private static String attributes = "slave";
	
}
