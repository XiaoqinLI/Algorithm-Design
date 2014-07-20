package algorithm_analysis_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class KnapsackBig {
	
	public static void main(String[] args) throws IOException, FileNotFoundException{
		
		long startTime = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new FileReader("knapsack_big.txt"));
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
		
		int[][] knapsackMatrix = new int[2][weightCapacity+1];
		for(int i = 0; i <= weightCapacity; i++){
			knapsackMatrix[0][i] = 0;				
		}
		
		for (int i = 0; i < numItem; i++){
			for(int x = 0; x <= weightCapacity; x++){
				int j = 0;
				if (x < weightArray[i]){						
					knapsackMatrix[1][x] = knapsackMatrix[j][x];	
				}else{
					knapsackMatrix[1][x] = Math.max(knapsackMatrix[j][x], knapsackMatrix[j][x-weightArray[i]]+valueArray[i]);
				}
			} // end of x loop
			
			//cache knapsackMatrix[1] to knapsackMatrix[0] for next i loop
			for(int k = 0; k <= weightCapacity;k++)
				knapsackMatrix[0][k] = knapsackMatrix[1][k];
		}
		long stopTime = System.currentTimeMillis();
		System.out.println("running time: " + (stopTime-startTime));	
		System.out.println(knapsackMatrix[1][weightCapacity]);
	}
}
