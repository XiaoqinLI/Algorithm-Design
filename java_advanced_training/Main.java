package java_advanced_training;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {


	public static void simplifiedGenerics(){
		Olive o1 = new Olive(OliveName.KALAMATA, 0x000000);
		Olive o2 = new Olive(OliveName.PICHOLINE, 0x00FF00);
		Olive o3 = new Olive(OliveName.LIGURIO, 0x000000);

		Olive[] olives = {o1, o2, o3};
		ArrayList<Olive> olives2 =  new ArrayList<>();// no need redeclare again
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
		Olive o1 = new Olive(OliveName.KALAMATA, 0x000000);
		Olive o2 = new Olive(OliveName.PICHOLINE, 0x00FF00);
		Olive o3 = new Olive(OliveName.LIGURIO, 0x000000);

		ArrayList<Olive> list =  new ArrayList<>();

		list.add(o1);
		list.add(o2);
		list.add(o3);

		Random generator = new Random();
		int index = generator.nextInt(3);
		System.out.println("random value: " + index);

		Olive o = list.get(index);

		switch (o.oliveName){
		case KALAMATA:
			System.out.println("It's Greek!");
			break;
		case PICHOLINE:
			System.out.println("It's French!");
			break;
		case LIGURIO:
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
		ArrayList<Olive> olives = new OliveJarNonStatic(3,OliveName.KALAMATA, 0x000000).olives2;
		
		for(Olive o:olives){
			System.out.println("It's a " + o.oliveName + " olive!");
		}
		
		ArrayList<Olive> olives1 = new OliveJarNonStatic().olives2;
		for(Olive o:olives1){
			System.out.println("It's a " + o.oliveName + " olive!");
		}
	}
	
	// Class class allows you to dynamically instantiate classes.
	public static void memberAndLocalInnerClasses(){
		MemberAndLocalInnerClasses jar = new MemberAndLocalInnerClasses();
		jar.addOlive("Kalamata", 0x000000);
		jar.addOlive("Kalamata", 0x000000);
		jar.addOlive("Kalamata", 0x000000);
		jar.addOlive("Kalamata", 0x000000);
		jar.reportOlives();
	}
	
	public static void classClass(){
		Olive o = new Olive(OliveName.PICHOLINE, 0x00FF00);
		
		Class<?> c = o.getClass();
		
		System.out.println(c);
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("--------------simplifiedGenerics-----------------");
		simplifiedGenerics();		
		System.out.println("--------------numericLiteralDemo-----------------");
		numericLiteralDemo();
		System.out.println("--------------stringInSwitch-----------------");
		stringInSwitch();		
		System.out.println("--------------olivesJarStaticDemo-----------------");
		olivesJarStaticDemo();		
		System.out.println("--------------olivesJarNonStaticDemo-----------------");
		olivesJarNonStaticDemo();	
		System.out.println("--------------memberClasses-----------------");
		memberAndLocalInnerClasses();
		System.out.println("--------------classClass-----------------");
		classClass();
		System.out.println("--------------usingHashSet-----------------");
		usingHashSet();
		
	}
}
