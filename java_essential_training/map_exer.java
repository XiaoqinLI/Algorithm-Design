package java_essential_training;

import java.util.HashMap;

public class map_exer {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String,String>(); // Key could be any subject
		map.put("california", "Sacramento");
		map.put("Oregon", "Salem");
		map.put("Washington", "Olympia");
		
		System.out.println(map);
		
		String cap = map.get("Oregon");
		System.out.println(cap);
	}

}
