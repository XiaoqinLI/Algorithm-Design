package java_advanced_training;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {


	public static void simplifiedGenerics(){
		Olive o1 = new Olive("Kalamata", 0x000000);
		Olive o2 = new Olive("Picholine", 0x00FF00);
		Olive o3 = new Olive("Ligurio", 0x000000);

		Olive[] olives = {o1, o2, o3};
		ArrayList<Olive> olives2 =  new ArrayList<>();
		olives2.add(o1);
		olives2.add(o2);
		olives2.add(o3);
		System.out.println(olives2); // this will output the string. not hashcode of list
	}

	public static void numericLiteralDemo(){
		int numberOflives = 1_000_000_000;
		NumberFormat formatter = NumberFormat.getInstance();
		System.out.println(formatter.format(numberOflives));
	}

	public static void stringInSwitch(){
		Olive o1 = new Olive("Kalamata", 0x000000);
		Olive o2 = new Olive("Picholine", 0x00FF00);
		Olive o3 = new Olive("Ligurio", 0x000000);

		ArrayList<Olive> list =  new ArrayList<>();

		list.add(o1);
		list.add(o2);
		list.add(o3);

		Random generator = new Random();
		int index = generator.nextInt(3);
		System.out.println("random value: " + index);

		Olive o = list.get(index);

		switch (o.oliveName){
		case "Kalamata":
			System.out.println("It's Greek!");
			break;
		case "Picholine":
			System.out.println("It's French!");
			break;
		case "Ligurio":
			System.out.println("It's Italian!");
			break;

		default:
			System.out.println("I don't know where it's from!");
			break;
		}
	}

	public static void olivesJarStaticDemo(){
		System.out.println("Statrting application...");
		ArrayList<Olive> olives = OliveJar.olives;
		for(Olive o:olives){
			System.out.println("It's a " + o.oliveName + " olive!");
		}
	}
	
	public static void olivesJarNonStaticDemo(){
		System.out.println("Statrting application...");
		ArrayList<Olive> olives = new OliveJarNonStatic(3,"Kalamata", 0x000000).olives2;
		for(Olive o:olives){
			System.out.println("It's a " + o.oliveName + " olive!");
		}
	}
	
	public static void main(String[] args) throws Exception {
		simplifiedGenerics();
		numericLiteralDemo();
		stringInSwitch();
		olivesJarStaticDemo();
		olivesJarNonStaticDemo();
	}
}
