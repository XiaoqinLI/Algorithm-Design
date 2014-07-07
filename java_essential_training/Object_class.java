package java_essential_training;
import java.awt.Point;


public class Object_class {
	public static void main(String[] args) {
		//-----------point object------------
		Point p = new Point(3,8);
		// The instanceof operator performs a runtime test. The result of
		if (p instanceof Point){
			System.out.println("initially p = " + p);
		}	
		//-----------------------------
		p.translate(-1, -2);
		System.out.println("after translating p = " + p);
		System.out.println("p is " + p.toString());
		System.out.println(p.getX());
		p.setLocation(14,15);
		//-----------timespan object------------	
		Timespan time1 = new Timespan();
		System.out.println("time1 is " + time1.toString());
		//-----employment--------
		Employee ed = new Lawyer();
		System.out.println(ed.getSalary());        
		System.out.println(ed.getVacationDays());   
		Employee[] e = { new Lawyer(), new Secretary(), new LegalSecretary() };
		for (int i = 0; i < e.length; i++) {
			System.out.println("salary: " + e[i].getSalary());
			System.out.println("v.days: " + e[i].getVacationDays());
			System.out.println();
			
		
}

	}
	
}
