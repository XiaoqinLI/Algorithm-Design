package java_essential_training;
import java.util.*;
public class exception_exer1 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int x;
		System.out.println( "Enter an integer: " );
		try
		{
			String oneLine = in.nextLine();
			x = Integer.parseInt(oneLine);
			System.out.println( "Half of x is " + ( x / 2 ) );
		}
		catch(NumberFormatException e)
		{
			System.out.println( e );
		}
		in.close();

		// ------------------------------
		Scanner in1 = new Scanner( System.in );

		System.out.println( "Enter 2 ints: " );

		try{
			int x1 = in1.nextInt( );
			int y = in1.nextInt( );

			System.out.println( "Max: " + Math.max( x1, y ) );
		}
		catch( NumberFormatException e )
		{ System.err.println( "Error: need two ints" ); }
		in1.close();
	}

}
