package algorithm_analysis_exer;

import java.util.*;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		double[] weight = {0.05, 0.4, 0.08, 0.04, 0.1, 0.1, 0.23};
		int numNode = weight.length;
		double[][] matrix = new double[numNode][numNode];

		for (int s = 0; s < numNode; s++){
			
			for (int i = 0; i < numNode - s; i++){
				
				double[] temp = new double[s+1];
				
				for (int j = 0; j < s + 1; j++){
					
					int r = i + j;
					int up = Math.min(numNode-1, i+s);
					
					for(int k = i; k < up+1; k++){
						temp[j] += weight[k];
					}
					if (i <= r-1){
						temp[j] += matrix[i][r-1];
					}
					if ((i+s < numNode) && (r+1 <= i+s)){
						temp[j] += matrix[r+1][i+s];
					}
				}
				
				double min=temp[0];
				for(int o = 0; o<temp.length; o++){
					if (temp[o] < min){
						min = temp[o];
					}
				}
				matrix[i][i+s] = min;
			}
		}
		
		System.out.println(matrix[0][matrix[0].length-1]);

	}

}
