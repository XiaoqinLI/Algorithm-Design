package java_essential_training;

public class Lawyer extends Employee{ 
	// overrides getVacationDays from Employee class
	public int getVacationDays() {
		
		return super.getVacationDays()+5;
	}

	// overrides getVacationForm from Employee class
	public String getVacationForm() {
		return "pink";
	}
	// this is the Lawyer's added behavior
	public void sue() {
		System.out.println("I'll see you in court!");
	}
}
