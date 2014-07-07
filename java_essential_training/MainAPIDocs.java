package java_essential_training;
// find APIDocs online, know to use dynamic help, F2 pop-up window.
public class MainAPIDocs {

	public static void main(String[] args) { // either from command line, or from run configuration set up.
		System.out.println("Number of args: " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}		
		
		String expireMe = "Won't be around for long";
		expireMe = null; //eligible for garbage collection.
		//Runtime.maxMemory()
		//Runtime.totalMemory()
		//Runtime.freeMemory()
		System.out.println(expireMe);
	}

}
