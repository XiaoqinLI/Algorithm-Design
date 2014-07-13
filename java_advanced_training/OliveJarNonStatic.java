package java_advanced_training;

import java.util.ArrayList;

public class OliveJarNonStatic {
	// using instance field initializer  
	// this is a way of executing code that executes no matter 
	// which constructor method is called, it will be called
	// before constructors
	public  ArrayList<Olive> olives2;
	
	{
		System.out.println("Initializing...");
		olives2 =  new ArrayList<>();
		olives2.add(new Olive("Golden",0xDA9100));

	}
	
	public OliveJarNonStatic(){
		System.out.println("constructor...");
	}
	
	public OliveJarNonStatic(int nOlives, String oliveName, long color){
		for (int i = 1; i <= nOlives; i++) {
			olives2.add(new Olive(oliveName,color));	
		}
	}
	
	
}
