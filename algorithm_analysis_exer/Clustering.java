package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

// algo complexity: m*logn(m: number of edges, n: number of nodes)
// Lazy Union by rank optimization method to solve clustering problem
// get a cache to fasten find function on the top of lazy Union by rank:

public class Clustering {
	/**
	 * using static method to declare a global int array for parents
	 * parents[i][0]:  if it is a negative value, then "i" is the leader of this cluster
	 * (could be the leader alone with itself); then the negative value indicates 
	 * the size of this cluster. If parents[i] is positive, then it indicates the index 
	 * of i's parent. it is parent to itself.
	 * parents[i][1]: the rank of node i
	 **/
	static int[][] parents;
	static int cluster_fusion_counter = 0;
	/** Edge class:
	 * implement Compareble to sort edges.
	 **/
	static class Edge implements Comparable<Edge>{
		int fr;
		int to;
		int cost;
		public Edge(int fr, int to, int cost){
			this.fr = fr;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge argEdge) {
			// TODO check the order
			final int BEFORE = 1;
			final int AFTER = -1;
			if(this.cost >= argEdge.cost){
				return BEFORE;
			}else{
				return AFTER;
			}
		}
	}

	// find each node's final parent, which in another word is the leader of 
	// this cluster. This function the key of this algo: to get the leader index
	// added path compression:
	public static int find(int i){
		ArrayList<Integer> tempIndexPath = new ArrayList<Integer>();
		while (parents[i][0]>0){
			tempIndexPath.add(i);
			i = parents[i][0];			
		}
		for(int j = 0; j < tempIndexPath.size(); j++){
			parents[tempIndexPath.get(j)][0] = i; // cache implementation
		}
		return i;
	}

	// union method
	public static void union(int i, int j){
		//find parents of i and j..if same..they are in same cluster, update the count
		//else in diff clusters..choose the one with less count and change its parent to the other parent

		int pi = find(i); // get index of i's leader
		int pj = find(j); // get index of j's leader

		// if i and j's leader is the same, we do not need to do anything, just pass
		if (pi != pj){
			cluster_fusion_counter += 1;
			// if i's rank is less than j, then i's leader is j
			if (parents[pi][1] < parents[pj][1]){
				parents[pi][0] = pj;
			}
			// if j's rank is less than i, then j's leader is i
			else if (parents[pi][1] > parents[pj][1]) {
				parents[pj][0] = pi;				
			}
			// if j's rank is equal to i, then j's rank +1 and make j be i's leader
			else if (parents[pi][1] == parents[pj][1]) {
				parents[pj][1] += 1;
				parents[pi][0] = pj;
			}
		}
		
	}

	public static void main(String[] args) throws IOException, FileNotFoundException {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		final int K = 4;
		int n;

		BufferedReader br = new BufferedReader(new FileReader("clustering1.txt"));

		n =  Integer.parseInt(br.readLine());
		parents = new int[n][2];

		for(int i = 0; i < n ; i++){
			parents[i][0] = -1; // initialized parent for each node at begining, -1 indicates self-parent
			parents[i][1] = 0; // initialized parent for each node at begining, -1 indicates self-parent
		}

		String line;

		while((line = br.readLine())!=null){
			String[] split = line.trim().split("(\\s)+");
			int i = Integer.parseInt(split[0]);
			int j = Integer.parseInt(split[1]);
			int dist = Integer.parseInt(split[2]);
			edges.add(new Edge(i-1, j-1, dist));
		}
		br.close(); // done with reading

		Collections.sort(edges); // sorted from min to max by overrode method

		for(Edge e : edges){
			union(e.fr,e.to);
			if ((cluster_fusion_counter + K) == n) {
				System.out.println( K + " clusters were found ");
				break;				
			}
		}

		// print the max space among clusters.
		// scan through all edges again, find the min distance between any two clusters
		int max = Integer.MAX_VALUE;
		for (Edge e : edges){
			if (find(e.fr)!=find(e.to)) max=Math.min(max, e.cost);				
		}
		System.out.println("max spacing "+max);

	}

}
