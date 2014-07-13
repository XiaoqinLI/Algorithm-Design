package java_advanced_training;

import java.util.ArrayList;

public class OliveJar {
	
	public static ArrayList<Olive> olives;
	// using static initializer
	// static initializer are called the first time a static 
	// object is referenced. and only can be called for once
	static {
		System.out.println("Initializing...");
		olives =  new ArrayList<>();
		olives.add(new Olive("Kalamata",0x000000));
		olives.add(new Olive("Picholine",0x00FF00));
		olives.add(new Olive("Kalamata",0x000000));

	}
	
}
