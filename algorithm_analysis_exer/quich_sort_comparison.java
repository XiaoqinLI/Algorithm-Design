package algorithm_analysis_exer;
import java.io.*;
import java.util.*;
public class quich_sort_comparison {
	
	public static long sort_comparision = 0;
    
	public static void main(String[] args)
			throws FileNotFoundException{
		Scanner input = new Scanner(new File("QuickSort.txt"));
		ArrayList<Integer> num_array = new ArrayList<Integer>();
		while (input.hasNext()){	
			num_array.add(Integer.parseInt((input.next())));
		}
		input.close();
		// Quick sort implementation, division conquer methods to find total comparision.
		// <1> pivot is the first element in each recursion. total comparision: 162085
		//quickSort1(num_array, 0, num_array.size()-1);
		
		// <2> pivot is the last element in each recursion. total comparision: 164123
		//quickSort2(num_array, 0, num_array.size()-1);
		
		// <3> pivot is the last element in each recursion. total comparision: 138382
		quickSort3(num_array, 0, num_array.size()-1);
		
		for (int i = 0; i < num_array.size(); i++){
			System.out.println(num_array.get(i));
		}
		System.out.println("sort_comparision: " + sort_comparision);
	}
	
	public static void quickSort1(ArrayList<Integer> arr, int lo, int hi){
		if (lo >= hi){
			return;
		}		
		int pivot = arr.get(lo);
		sort_comparision = sort_comparision + hi-lo;
		int m = lo;
		for (int i = lo+1; i <= hi; i++){
			if(arr.get(i) < pivot){	
				m = m+1;
				Collections.swap(arr, m, i);					
			}
		}
		Collections.swap(arr, lo, m);

		quickSort1(arr, lo, m-1);
		quickSort1(arr, m+1, hi);	
	}
	
	public static void quickSort2(ArrayList<Integer> arr, int lo, int hi){
		if (lo >= hi){
			return;
		}
		Collections.swap(arr, lo, hi);
		int pivot = arr.get(lo);
		sort_comparision = sort_comparision + hi-lo;
		int m = lo;
		for (int i = lo+1; i <= hi; i++){
			if(arr.get(i) < pivot){	
				m = m+1;
				Collections.swap(arr, m, i);					
			}
		}
		Collections.swap(arr, lo, m);

		quickSort2(arr, lo, m-1);
		quickSort2(arr, m+1, hi);	
	}
	
	public static void quickSort3(ArrayList<Integer> arr, int lo, int hi){
		if (lo >= hi){
			return;
		}
		int median_index;
		if ((hi + lo) % 2 == 0){ // odd length
			median_index =  findMedian(arr, lo, hi, (lo+hi)/2);
		}
		else{ // even length
			median_index =  findMedian(arr, lo, hi, (int)((lo+hi)/2));
		}
		Collections.swap(arr, lo, median_index);
		
		int pivot = arr.get(lo);
		sort_comparision = sort_comparision + hi-lo;
		int m = lo;
		for (int i = lo+1; i <= hi; i++){
			if(arr.get(i) < pivot){	
				m = m+1;
				Collections.swap(arr, m, i);					
			}
		}
		Collections.swap(arr, lo, m);

		quickSort3(arr, lo, m-1);
		quickSort3(arr, m+1, hi);	
	}
	
	public static int findMedian(ArrayList<Integer> aa, int ll, int hh, int mm){
		int low = aa.get(ll);
		int high = aa.get(hh);
		int middle = aa.get(mm);
		if (low < high){
			if (middle > low){
				if (middle < high){return mm;}
				else{return hh;}
			}
			else{return ll;}
		}
		else{
			if (middle < low){
				if (middle < high){return hh;}
				else{return mm;}				
			}
			else{return ll;}
		}
	}
}
