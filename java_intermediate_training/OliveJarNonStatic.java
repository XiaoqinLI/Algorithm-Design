package java_intermediate_training;

import java.util.ArrayList;

public class OliveJarNonStatic {
	// using instance field initializer  
	// this is a way of executing code that executes no matter 
	// which constructor method is called, it will be called
	// before constructors, no matter which version of the constructor method is called.
	public  ArrayList<Olive> olives2;
	
	{
		System.out.println("Initializing...");
		olives2 =  new ArrayList<>();
		olives2.add(new Olive(OliveName.GOLDEN,OliveColor.GOLDEN));

	}
	
	public OliveJarNonStatic(){
		System.out.println("constructor...");
	}
	
	public OliveJarNonStatic(int nOlives, OliveName oliveName, OliveColor color){
		for (int i = 1; i <= nOlives; i++) {
			olives2.add(new Olive(OliveName.KALAMATA,color));	
		}
	}
		
}
