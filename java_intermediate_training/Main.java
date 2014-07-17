package java_intermediate_training;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Main {


	public static void simplifiedGenerics(){
		Olive o1 = new Olive(OliveName.KALAMATA, OliveColor.BLACK);
		Olive o2 = new Olive(OliveName.PICHOLINE, OliveColor.GREEN);
		Olive o3 = new Olive(OliveName.LIGURIO, OliveColor.BLACK);

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
		Olive o1 = new Olive(OliveName.KALAMATA, OliveColor.BLACK);
		Olive o2 = new Olive(OliveName.PICHOLINE, OliveColor.GREEN);
		Olive o3 = new Olive(OliveName.LIGURIO, OliveColor.BLACK);

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
		ArrayList<Olive> olives = new OliveJarNonStatic(3,OliveName.KALAMATA,OliveColor.BLACK).olives2;
		
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
	
	// reflection API
	public static void classClass(){
		Olive o = new Olive(OliveName.PICHOLINE, OliveColor.GREEN);
		// using Class Class
		Class<?> c = o.getClass();
		
		System.out.println(c);
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		
		ArrayList<Integer> aa = new ArrayList<>();
		Class<?> bb = aa.getClass();
		System.out.println(bb);
		System.out.println(bb.getName());
		System.out.println(bb.getSimpleName());
		
		// instantiating classes dynamically
		Constructor<?>[] constructors = c.getConstructors();
		System.out.println("Number of constructors " + constructors.length);
		Constructor<?> con = constructors[0];
		
		Object obj = null;
		
		try {
			obj = con.newInstance(OliveName.PICHOLINE, OliveColor.GREEN);
			System.out.println(obj);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// Navigating inheritance trees
		
		Object oo = new Ligurio();
		
		Class<?> cc = oo.getClass();
		System.out.println("Class name: " + c.getName());
		
		Class<?> sup = cc.getSuperclass();
		System.out.println("super name: " + sup.getName());
		
		Class<?> top = sup.getSuperclass();
		System.out.println("top name: " + top.getName());
		
		Package p = cc.getPackage();
		System.out.println("package: " + p.getName());

	}
	
	// compared to TreeSet, HashSet is faster, but unordered.
	public static void usingHashSet(){
		Olive lig = new Ligurio();
		Olive kal = new Kalamata();
		Olive pic = new Picholine();
		HashSet<Olive> set = new HashSet<>();
		set.add(lig);
		set.add(kal);
		System.out.println("There are " + set.size() + " olives in the set");		
		set.add(pic);
		System.out.println("There are " + set.size() + " olives in the set");
		set.add(lig);
		System.out.println("There are " + set.size() + " olives in the set");
		set.add(null);
		System.out.println("There are " + set.size() + " olives in the set");
		set.remove(lig);
		System.out.println("There are " + set.size() + " olives in the set");
	}
	
	public static void usingTreeSet(){		
		Olive lig = new Ligurio();
		Olive kal = new Kalamata();
		Olive pic = new Picholine();
		// automatically be alphabetized
		TreeSet<Olive> set = new TreeSet();
		try {
			set.add(pic);
			set.add(kal);
			set.add(lig);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		System.out.println(set);	
	};
	
	public static void usingLinkedList(){
		LinkedList<Olive> list = new LinkedList<>();
		list.add(new Picholine());
		list.add(new Kalamata());
		list.add(1,new Golden());
		list.addFirst(new Ligurio());
		display(list);
		
		Olive o1 = list.peek(); // no removing
		System.out.println(list);
		
		Olive o2 = list.poll(); // no removing
		System.out.println(list);
	}
	
	static private void display(Collection<Olive> col){
		System.out.println("List order: ");
		Iterator<Olive> iterator = col.iterator();
		while (iterator.hasNext()) {
			Olive olive = (Olive) iterator.next();
			System.out.println(olive.oliveName.toString());
		}
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
		System.out.println("--------------usingTreeSet-----------------");
		usingTreeSet();
		System.out.println("--------------usingLinkedList-----------------");
		usingLinkedList();		
	}
}
