package java_essential_training;

public class Strings {

	public static void main(String[] args) {
		String s1 = "Welcome to California!";
		String s2 = new String("WELCOME to California!");
		System.out.println(s2);
		
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("They match!");
		}
		else {
			System.out.println("They don't match!");
		}
		
		char[] chars = s1.toCharArray();
		// the easier way creating a for loop.
		for(char c : chars){
			System.out.println(c);
		}
		
		String s11 = "Welcome to California!";
		
		System.out.println("Length of string: " + s11.length());
		
		int pos = s11.indexOf("California");
		System.out.println("Position of California: " + pos);
		
		String sub = s11.substring(pos);
		System.out.println(sub);
		
		String s21 = "Welcome!       ";
		int len1 = s21.length();
		System.out.println(len1);
		String s3 = s21.trim();
		System.out.println(s3.length());
		
	}
}
