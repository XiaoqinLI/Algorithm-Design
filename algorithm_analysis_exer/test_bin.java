package algorithm_analysis_exer;

import java.util.PriorityQueue;

public class test_bin {

	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.remove(4);
		for(int i: q){
			System.out.println(i);
		}
		
	}

}
