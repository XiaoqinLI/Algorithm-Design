package algorithm_analysis_exer;
import java.io.*;
import java.util.*;
public class division_conquer_inversions {
	
	public static long inversion_counter = 0;
	
	public static void main(String[] args) 
			throws FileNotFoundException{
		Scanner input = new Scanner(new File("IntegerArray.txt"));
		ArrayList<Integer> num_array = new ArrayList<Integer>();
		while (input.hasNext()){	
			num_array.add(Integer.parseInt((input.next())));
		}
		input.close();
		// brute force method to double check the answer: 2407905288
//		long inversion_counter = 0;
//		for (int i = 0; i < num_array.size(); i++){
//			for (int j = i+1; j < num_array.size(); j++){
//				if (num_array.get(j) < num_array.get(i)){
//					inversion_counter = inversion_counter+1;
//				}
//			}
//		}
//		System.out.println(inversion_counter);

		// mergeSort implementation 		
		// division conquer methods to get inversion number
		mergeSort(num_array, 0, num_array.size()-1);
		for (int i = 0; i < num_array.size(); i++){
			System.out.println(num_array.get(i));
		}
		System.out.println(inversion_counter);
	}
	
	public static void mergeSort(ArrayList<Integer> arr, int left, int right){
		if (left < right){
			int center  = (int)((left + right) / 2);
			mergeSort (arr, left, center);
			mergeSort (arr, center + 1, right);
			merge (arr, left, center, right);
		}	
	}
	
	public static void merge(ArrayList<Integer> arr, int left, int center, int right){
		int first1 = left;
		int last1 = center;
		int first2 = center + 1;
		int last2 = right;
		ArrayList<Integer> b =  new ArrayList<Integer>();
		while((first1 <= last1) && (first2 <= last2)){
			if(arr.get(first1) < arr.get(first2)){
				b.add(arr.get(first1));
				first1 = first1 + 1;
			}else{
				 b.add(arr.get(first2));
			     first2 = first2 + 1;
			     inversion_counter = inversion_counter + 1 + last1 - first1;
			}			     
		}
		
		while (first1 <= last1){
			b.add(arr.get(first1));
		    first1 = first1 + 1;
		}
		
		while (first2 <= last2){
			b.add(arr.get(first2));
		    first2 = first2 + 1;
		}
		
		int index_arr = left;
		for (int i = 0; i < b.size(); i ++){
			arr.set(index_arr,b.get(i));
			index_arr++;
		}		
	}
}
