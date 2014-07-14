package java_essential_training;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add( "Olivia" );
		list.add( 2);
		list.add('a');
		ArrayList list1 = new ArrayList();
		list1.add( "Olivia" );
		list1.add( 2);
		list1.add('a');
		System.out.println(list.get(2));
		if ((Integer)list.get(1) < (Integer)list.get(2)){
			System.out.println();
		}
		
	}

}
