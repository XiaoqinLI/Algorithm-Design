package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

public class PrimMST {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		long startTime = System.nanoTime();

		BufferedReader br = new BufferedReader(new FileReader("prim_greedy.txt"));
		String[] splitLine = br.readLine().trim().split("(\\s)+");
		
		int numV =  Integer.parseInt(splitLine[0]);
		int numE =  Integer.parseInt(splitLine[1]);		
		int adjmat[][] = new int[numV][numV];// adjadjmat initializing, cost more but easy to organize
		for(int i = 0; i < adjmat.length; i++){
			for(int j = 0; j < adjmat.length; j++){
				adjmat[i][j] = Integer.MAX_VALUE;
			}
		}	
		int v1,v2,weight;	
		
		String line;
		while((line = br.readLine())!=null){
			splitLine = line.trim().split("(\\s)+");
			v1 = Integer.parseInt(splitLine[0])-1;
			v2 = Integer.parseInt(splitLine[1])-1;
			weight = Integer.parseInt(splitLine[2]);	
			adjmat[v1][v2] = weight;
			adjmat[v2][v1] = weight;
		}
		br.close();		
		primNaive(adjmat);	
		long stopTime = System.nanoTime();
		System.out.println(stopTime-startTime);		
	}
	
	public static void primNaive(int [][] graph){
		 int vNum = graph.length;
		 Random rand = new Random();
		 int s = rand.nextInt(500);
		 int cost = 0;
		 ArrayList<Integer> verList = new ArrayList<Integer>();
		 
		 boolean ifVisited[] = new boolean[vNum];
		 verList.add(s);
		 ifVisited[s] = true;
		 
		 while(verList.size() < vNum){
			 int cheapest = Integer.MAX_VALUE;
			 int visitedIndex = Integer.MAX_VALUE;
			 for(int v1: verList){
				 for( int i = 0; i < vNum; i++){
					 if (!ifVisited[i] && graph[v1][i] < cheapest){
						 cheapest = graph[v1][i];
						 visitedIndex = i;
					 }
				 }		
			 }
			 ifVisited[visitedIndex] = true;
			 verList.add(visitedIndex);
			 cost += cheapest;
		 }
		 System.out.println(cost);	 
	}
}
