package java_essential_training;

import java.util.ArrayList;

public class Main_Olive {

	public static void main(String[] args) {
		// only contain <Olive> class, if remove this, it can contain
		// any type of virables.
		ArrayList<Olive> olives = new ArrayList<Olive>();
		
		Olive olive;
		
		olive = new Kalamata();
		System.out.println(olive.name);
		olives.add(olive);

		olive = new Ligurian();
		System.out.println(olive.name);
		olives.add(olive);

		olive = new Kalamata();
		System.out.println(olive.name);
		olives.add(olive);
	
		OlivePress press = new OlivePress();
		press.getOil(olives);
		
		System.out.println("You got " + press.getTotalOil() + 
				" units of oil");
		
		press.getOil(olives);
		
		System.out.println("You got " + press.getTotalOil() + 
				" units of oil");
		// downward casting, you need to do this:
		// tell complier: treat it as a subclass
		Kalamata olive1 = (Kalamata)olives.get(0);
		System.out.println("Olive 1 is from " + olive1.getOrigin());
		// can not instantiate abstract directly
		// the reason to implement abstract class is to promise that
		// in its subclass, they certainlu
//		Olive olive2 = new Olive();
		
	}

}
