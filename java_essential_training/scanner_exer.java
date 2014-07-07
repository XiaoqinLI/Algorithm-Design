package java_essential_training;
import java.util.*;

public class scanner_exer {
	public static void main(String[] args){
		System.out.println("step\tx\ty\ttime");
		Scanner console = new Scanner(System.in);
		System.out.println("This program computes monthly " + "mortgage payments.");
		System.out.print("loan amount : ");
		double loan = console.nextDouble();
		System.out.print("number of years : ");
		int years = console.nextInt();
		System.out.print("interest rate : ");
		double rate = console.nextDouble();
		System.out.println();
		int n = 12 * years;
		double c = rate / 12.0 / 100.0;
		double payment = loan * c * Math.pow(1 + c, n) / (Math.pow(1 + c, n)-1);
		System.out.println("payment = $" + (int) payment);
		
		System.out.print("How old are you? ");
		while (!console.hasNextInt()) {
			console.next(); // to discard the input
			System.out.println("Not an integer; try again.");
			System.out.print("How old are you? ");
		}
		console.close();
	}
	
}


