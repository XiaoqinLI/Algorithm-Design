package java_essential_training;
import java.io.*;
import java.util.*;
import java.net.URL;
public class File_processing {

	public static void main(String[] args) 
			throws FileNotFoundException {
		File file = new File("example.txt");
		if (file.exists() && file.length() > 1000) {
			file.delete();
		}
		System.out.println("exists returns " + file.exists());
		System.out.println("canRead returns " + file.canRead());
		System.out.println("length returns " + file.length());
		System.out.println("getAbsolutePath returns " + file.getAbsolutePath());
//		file.renameTo("example.txt");
		Scanner input = new Scanner(file);
		int count = 0;
		while (input.hasNext()){
			if (input.hasNextDouble()){
				input.nextDouble(); 
				count++;
			}else{
				input.next(); // throw away unwanted token
			}
		}
		System.out.println("total words = " + count);
		input.close();
		printWorkingDirectory();  // showing working directory
		
		// Avoiding type mismatches:
		Scanner console = new Scanner(System.in);
		System.out.print("How old are you? ");
		if (console.hasNextInt()) {
		    int age = console.nextInt();   // will not crash!
		    System.out.println("Wow, " + age + " is old!");
		} else {
		    System.out.println("You didn't type an integer.");
		}
		console.close();
		
		readFromWeb();// read data from web
		
		readFromString(); // Simple example of a Scanner reading from a String.
		
		// output to a file
		PrintStream output = new PrintStream(new File("out.txt"));
		PrintStream out1 = System.out;
		out1.println("Hello, console!");   
		output.println("Hello, file!");
		output.println("This is a second line of output.");
		output.close();
	}
	
	public static void readFromString() {
		Scanner input = new Scanner("18.4 17.9 8.3 2.9");
		while (input.hasNextDouble()) {
			double next = input.nextDouble();
			System.out.println(next);
			}		
		input.close();
	}
	
	public static void readFromWeb() {
		try {
            System.out.println("change and %, average volume, volume, "
                + "dividend yield, PE ratio, market cap, symbol");
            String urlAsString = "http://finance.yahoo.com/d/quotes.csv?s=AAPL+INTC+MSFT+AMZN&f=ca2vyrj1s";
            URL url = new URL(urlAsString);
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }
        catch(IOException e) {
            System.out.println("UH OH: " + e);
        }
	} 
	
	public static void printWorkingDirectory() {
		System.out.println("Working Directory = " +
				System.getProperty("user.dir"));
	} 
}


