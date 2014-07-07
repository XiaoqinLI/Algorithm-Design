package java_essential_training;

public class print_formatting {

	public static void main(String[] args) {
		int x = 3; int y = -17;
		System.out.printf("x is %3d and y is %6s \n", x, y);
		// TODO Auto-generated method stub
		for (int i = 1; i <= 3; i++) {
		    for (int j = 1; j <= 10; j++) {
		        System.out.printf("%4d", (i * j));
		    }
		    System.out.println();   // to end the line
		}
		
		double gpa = 3.253764;
		System.out.printf("your GPA is %.1f\n", gpa);
		System.out.printf("more precisely: %8.3f\n", gpa);
		
		System.out.println((char)65);
		System.out.println((int)'A');
		
	}

}
