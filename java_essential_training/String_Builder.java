package java_essential_training;

public class String_Builder {

	public static void main(String[] args) {
		// String obj can't be changed once assigned.
		// s1 = s1 + "XXXX", wasted some memory
		String s1 = "Welcome";
		// StringBuffer needs more memory.
		StringBuilder sb = new StringBuilder(s1);
		
		sb.append(" to California!");
		
		System.out.println(sb);
	}

}
