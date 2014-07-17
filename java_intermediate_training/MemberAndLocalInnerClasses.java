package java_intermediate_training;

import java.util.ArrayList;

public class MemberAndLocalInnerClasses {
	// using instance field initializer  
	// this is a way of executing code that executes no matter 
	// which constructor method is called, it will be called
	// before constructors, no matter which version of the constructor method is called.
	public  ArrayList<Olive> olives3;

	{
		System.out.println("Initializing...");
		olives3 =  new ArrayList<>();
		olives3.add(new Olive("Golden",0xDA9100));

	}

	public MemberAndLocalInnerClasses(){
		System.out.println("constructor...");
	}

	public MemberAndLocalInnerClasses(int nOlives, String oliveName, long color){
		for (int i = 1; i <= nOlives; i++) {
			olives3.add(new Olive(oliveName,color));	
		}
	}

	public void addOlive(String oliveName, long color){
		olives3.add(new Olive(oliveName, color));
	}

	public void reportOlives(){
		// automatically private, local inner class
//		class JarLid{
//			public  void open(){
//				System.out.println("Twist, Twist, Twist...");
//				System.out.println("Pop!");
//			}
//		}
//		new JarLid().open();
			
		// An anonymous class is just that it does not have a name, it's defined 
		// and used exactly once.
		// anonymous classes constructor method,
		new Object(){
			public  void open(){
				System.out.println("Twist, Twist, Twist...");
				System.out.println("Pop!");
			}
		}.open(); //instantly call its method
		
		for(Olive o: olives3){
			System.out.println("It's a " + o.oliveName);
		}
	}
	
	
	
	// it is only visible to the class in which it's contained
	class Olive {

		public static final long BLACK = 0x000000;

		public String oliveName = "Kalamata";
		public long color = BLACK;

		public Olive() {
		}

		public Olive(String oliveName) {
			this.oliveName = oliveName;
		}

		public Olive(String oliveName, long color) {
			this(oliveName);
			this.color = color;
		}

		public String toString() {
			return "name: " + this.oliveName + ": " + "color: " +  this.color;
		}

	}
}
