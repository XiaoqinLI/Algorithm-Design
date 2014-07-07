package java_essential_training;

public class MainNumericTypes {

	public static void main(String[] args) {
		//Declaring bytes, shorts and ints
		byte bb = 1;
		short sh = 1;
		int i = 1;

		// Declaring longs, floats and doubles
		long l = 1L;
		float f = 1f;
		double d = 1d;

		System.out.print(
						"Byte: " + bb + "\n" +
						"Short: " + sh + "\n" +
						"Int: " + i + "\n" +
						"Long: " + l + "\n" +
						"Float: " + f + "\n" +
						"Double: " + d );
		
		//Declaring a literal byte value
		byte b = 127;
		System.out.println("the value of b is " + b);
		if (b < Byte.MAX_VALUE) {
			b++;
		}
		
		System.out.println("the value of b is " + b);
		
		//Declaring a short
		short sh1 = Short.MAX_VALUE;
		System.out.println("the value of sh is " + sh1);
		
		// Declaring an int
		int i1 = Integer.MAX_VALUE;
		System.out.println("the value of i is " + i1);

		// Declaring a long
		long l1 = Long.MAX_VALUE;
		System.out.println("the value of l is " + l1);
		
		// Declaring a long
		float f1 = Float.MAX_VALUE;
		System.out.println("the value of f is " + f1);
		
		// Declaring a long
		double d1 = Double.MAX_VALUE;
		System.out.println("the value of d is " + d1);
		
	}

}
