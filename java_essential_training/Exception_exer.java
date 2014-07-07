package java_essential_training;

public class Exception_exer {

	public static void main(String[] args) {

		try {
			String[] strings = {"Welcome!"};
			System.out.println(strings[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println("There was an error");
		}
		finally{
			System.out.println("blablablabla");
		}
		
		System.out.println("The application is still running!");
		
	}

}
