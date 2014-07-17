package java_intermediate_training;

import java.util.ArrayList;

public class OliveJar {
	
	public static ArrayList<Olive> olives;
	// using static initializer
	// static initializer are called the first time a static 
	// object is referenced. and only can be called for once
	static {
		System.out.println("Initializing...");
		olives =  new ArrayList<>();
		olives.add(new Olive(OliveName.KALAMATA,OliveColor.BLACK));
		olives.add(new Olive(OliveName.PICHOLINE,OliveColor.GREEN));
		olives.add(new Olive(OliveName.LIGURIO,OliveColor.GOLDEN));

	}
	
}
