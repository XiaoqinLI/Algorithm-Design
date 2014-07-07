package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

public class PrimHeapMST {
	// Edge class
	static class Edge{
		int toVert, weight;
		//constructor
		public Edge(int toVert, int weight) {
			this.toVert = toVert;
			this.weight = weight;
		}	
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new FileReader("prim_greedy.txt"));
		String[] splitLine = br.readLine().trim().split("(\\s)+");

		int numV =  Integer.parseInt(splitLine[0]);
		int numE =  Integer.parseInt(splitLine[1]);		
		int adjmat[][] = new int[numV][numV];// adjadjmat initializing, cost more but easy to organize
		for(int i = 0; i < adjmat.length; i++){
			for(int j = 0; j < adjmat.length; j++){
				adjmat[i][j] = 1000000;
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

		// creating adjlist
		List<Edge>[] adjlist = new List[numV];
		for (int i = 0; i < numV; i++){
			adjlist[i] = new ArrayList<Edge>();// each row is an arraylist
			for (int j = 0; j < numV; j++) {
				if (adjmat[i][j] < 1000000) {
					adjlist[i].add(new Edge(j, adjmat[i][j]));
				}
			}
		}
		primHeap(adjlist);
		long stopTime = System.nanoTime();
		System.out.println(stopTime-startTime);		

	}
	public static void primHeap(List<Edge>[] graph){
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		boolean isVisited[] = new boolean[graph.length];
		long cost = 0;
		Random rand = new Random();
		int s = 0;//rand.nextInt(500);// start from a random vertex.
		ArrayList<Integer> X = new ArrayList<Integer>();
		X.add(s);
		
		// firstly, initializing heap with all infinity
		for(int i=0; i< graph.length;i++){
			if(i!=s){
				q.add(((long) 1000000 << 32) + i);
			}
		}
		// modify heap with initial's adj vertices
		for(Edge e: graph[s]){
			q.remove(((long) 1000000 << 32) + e.toVert);
			q.add(((long) e.weight << 32) + e.toVert);		
		}
		
		isVisited[s]=true;
		
		while(X.size()<graph.length){
			long curKey = q.remove();		 
			int curVert = (int) curKey; // current vertex
			long cc = (curKey-curVert) >> 32; // the lowest cost for this vertex
			cost += cc;
			X.add(curVert);
			for(Edge e: graph[curVert]){
				if (!X.contains(e.toVert)){									
					int previous_cost = 1000000;
					int previous_counter = 0;
					for(Edge entry: graph[e.toVert]){
						if (isVisited[entry.toVert] && entry.weight < previous_cost){
							previous_counter++;
							previous_cost = entry.weight;
						}
					}
					if (previous_counter>0){
						q.remove(((long) previous_cost << 32) + e.toVert);
					}else{
						q.remove(((long) 1000000 << 32) + e.toVert); // if not visited yet then cost is infi
					}				
					if (e.weight < previous_cost){
						q.add(((long) e.weight << 32) + e.toVert);
					}else{
						q.add(((long) previous_cost << 32) + e.toVert);
					}			
				}		
			}
			isVisited[curVert]=true;		
		}	
		System.out.println(cost);		
	}

}
