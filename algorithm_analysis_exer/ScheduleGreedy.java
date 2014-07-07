package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

public class ScheduleGreedy {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("jobs.txt"));
		int number =  Integer.parseInt(br.readLine());
		final Integer[][] schedule1 = new Integer[number][3];
		final Double[][] schedule2 = new Double[number][3];
		long sum_weight1 = 0, sum_weight2 = 0;
		String line;
		int counter =0;
		while((line = br.readLine())!=null){
			String[] split = line.trim().split("(\\s)+");
			schedule1[counter][0] = Integer.parseInt(split[0]);
			schedule1[counter][1] = Integer.parseInt(split[1]);
			schedule1[counter][2] = schedule1[counter][0] - schedule1[counter][1];
			schedule2[counter][0] = Double.parseDouble(split[0]);
			schedule2[counter][1] = Double.parseDouble(split[1]);
			schedule2[counter][2] = schedule2[counter][0] / schedule1[counter][1];		
			counter++;
		}
		br.close();

	    final Comparator<Integer[]> arrayComparator1 = new Comparator<Integer[]>() {
	        @Override
	        public int compare(Integer[] int1, Integer[] int2) {
	        	if (int1[2] != int2[2]){
	        		return int1[2].compareTo(int2[2]);
	        	}
	        	else return int1[0].compareTo(int2[0]);	
	        }
	    };
	    
	    final Comparator<Double[]> arrayComparator2 = new Comparator<Double[]>() {
	        @Override
	        public int compare(Double[] dou1, Double[] dou2) {
	        	if (dou1[2] != dou2[2]){
	        		return dou1[2].compareTo(dou2[2]);
	        	}
	        	else return dou1[0].compareTo(dou2[0]);	
	        }
	    };
	    Arrays.sort(schedule1, arrayComparator1);
	    Arrays.sort(schedule2, arrayComparator2);
	    
	    for(int i = 0; i < number; i++){
	    	System.out.print(schedule1[i][0] + " ");
	    	System.out.print(schedule1[i][1] + " ");
	    	System.out.print(schedule1[i][2]);
	    	System.out.println();
	    }
	    
	    int current_length = 0;
	    for(int i = number - 1; i >= 0; i--){
	    	current_length += schedule1[i][1];
	    	sum_weight1 += current_length*schedule1[i][0];
	    }
	    current_length = 0;
	    for(int i = number - 1; i >= 0; i--){
	    	current_length += schedule2[i][1];
	    	sum_weight2 += current_length*schedule2[i][0];
	    }
	    System.out.println(sum_weight1);
	    System.out.println(sum_weight2);
	}

}
