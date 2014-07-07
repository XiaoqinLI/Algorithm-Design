// Using Priority queue to solve dijkstra algo
// from a given vertex to all other connected vertices
package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

public class DijkstraHeap {
	// Edge class
	static class Edge {
		int t, adjmat;
		//constructor
		public Edge(int t, int adjmat) {
			this.t = t;
			this.adjmat = adjmat;
		}
	}

	public static void shortestPaths(List<Edge>[] edges, int s, int[] prio) {

		Arrays.fill(prio, Integer.MAX_VALUE); // initializing with infinity
		prio[s] = 0; // set value to start itself as zero
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		q.add((long) s); // convert s to long type: encoding
		while (!q.isEmpty()) {
			long cur = q.remove();
			int curu = (int) cur; // cut out left 32 digits, which are all "1".

			for (Edge e : edges[curu]) {
				int v = e.t;
				// value of the tail vertex plus the adjmat of edge to head vertex
				int nprio = prio[curu] + e.adjmat; 
				if (prio[v] > nprio) {
					prio[v] = nprio;
					// mapping methods:add 32 "0" to the right. 
					// becomes a long type, so the one with lowest adjmat will be on
					// top of queue/heap.
					q.add(((long) nprio << 32) + v); 
				}
			}
		}
	}

	public static void main(String[] args)
			throws IOException, FileNotFoundException{

		final int N = 200; // total number of vertice
		int adjmat[][] = new int[N][N];// adjmatrix initializing.	

		BufferedReader br = new BufferedReader(new FileReader("dijkstraData.txt"));		
		String line, str;
		while((line = br.readLine()) != null){
			StringTokenizer st1 =  new StringTokenizer(line);
			int i = Integer.parseInt(st1.nextToken());
			while(st1.hasMoreTokens()){
				str = st1.nextToken();
				StringTokenizer st2 = new StringTokenizer(str, ",");
				int v = Integer.parseInt(st2.nextToken()); // head vertice
				int d = Integer.parseInt(st2.nextToken()); // edge weight
				adjmat[i-1][v-1] = d;
				adjmat[v-1][i-1] = d;
			}
		}
		br.close();
		
		// creating adjlist
		List<Edge>[] edges = new List[N];
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<Edge>(); // each row is an arraylist
			for (int j = 0; j < N; j++) {
				if (adjmat[i][j] != 0) {
					edges[i].add(new Edge(j, adjmat[i][j]));
				}
			}
		}

		int[] dist = new int[N];
		shortestPaths(edges, 0, dist);

		int t[] = {7,37,59,82,99,115,133,165,188,197};
		for(int i : t){
			System.out.print(dist[i-1] + " ");
		}  
	}
}
