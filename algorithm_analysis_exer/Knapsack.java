package algorithm_analysis_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Knapsack {
	
	public static int[][] buildKnapsackMatrix(int[] value, int[] weight, int capacity){
		int[][] knapsackMatrix = new int[value.length][capacity+1];
		
		for(int i =0 ; i <= capacity; i++ ){
			knapsackMatrix[0][i] = 0;
		}
		
		for(int i = 1; i < value.length; i++){
			for(int j = 0; j <= capacity; j++){
				if (j < weight[i]){
					knapsackMatrix[i][j] = knapsackMatrix[i-1][j];
				}else{
					knapsackMatrix[i][j] = Math.max(knapsackMatrix[i-1][j], knapsackMatrix[i-1][j-weight[i]]+value[i]);
				}
			}			
		}
		
		return knapsackMatrix;	
	}
	
	public static void findItems(int[][] matrix, int[] value, int[] weight, int capacity){
		ArrayList<Integer> items = new ArrayList<Integer>();
		int itemIndex = value.length-1;
		int capacityIndex = capacity;
		int target = matrix[value.length-1][capacity];
		
		while (target > 0){
			if (target > matrix[itemIndex-1][capacityIndex]){
				items.add(itemIndex);
				target -= value[itemIndex];
				capacityIndex -= weight[itemIndex];
				itemIndex--;
			}
			else{
				itemIndex--;			
			}
		}
		
		int total = 0;
		for(int i = 0; i<items.size();i++){
			total += value[items.get(i)];
			System.out.print(items.get(i).toString() + " ");
		}
		System.out.println();
		System.out.println(total);
	}
	
	public static void main(String[] args) throws IOException,FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("knapsack1.txt"));
		String[] split = br.readLine().trim().split("(\\s)+");
		int weightCapacity = Integer.parseInt(split[0]);
		int numItem = Integer.parseInt(split[1]);
		
		int[] valueArray = new int[numItem+1];
		int[] weightArray = new int[numItem+1];
		int kk = 1;
		String line;
		while((line = br.readLine())!=null){
		    split = line.trim().split("(\\s)+");
		    valueArray[kk] = Integer.parseInt(split[0]);
		    weightArray[kk] = Integer.parseInt(split[1]);
			kk++;
		}
		br.close(); // done with reading
		
		int[][] kMatrix = new int[numItem+1][weightCapacity+1];		
		kMatrix = buildKnapsackMatrix(valueArray, weightArray, weightCapacity);		
		System.out.println(kMatrix[numItem][weightCapacity]);
		
		findItems(kMatrix, valueArray, weightArray, weightCapacity);

	}

}
