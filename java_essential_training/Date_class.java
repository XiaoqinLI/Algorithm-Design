package java_essential_training;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date_class {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		// you can do math on GregorianCalendar
		// no formatting 
		GregorianCalendar gc = new GregorianCalendar(2009, 1, 28);
		gc.add(GregorianCalendar.DATE, 1);
		// Date class have formatting functions
		Date d2 = gc.getTime();

		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String sd = df.format(d2);
		System.out.println(sd);

	}

}
