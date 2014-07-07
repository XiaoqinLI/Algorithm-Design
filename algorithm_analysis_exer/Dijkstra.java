// solving Dijkstra with brute-force way
// so many unnecessary repeat checking on each vertex under this method
package algorithm_analysis_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Dijkstra {
	
	public static void main(String[] args)
		throws IOException, FileNotFoundException{
				
		final int N = 200; // total number of vertice
		int visited[] = new int[N]; // record whether the vertice is visited/visited or not		
		int dijk[] = new int[N]; // shortest path from each vertice to the source
		int adjmat[][] = new int[N][N];// adjadjmat initializing, cost more but easy to organize
		
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
		
        for (int i=0; i<N; i++){
            dijk[i] = 1000000;
        }
        
        // initially only shortest distance for source 
     	//vertex is known, and the shortest distance is always 0
        visited[0] = 1;
        dijk[0] = 0;
        
        // execute 200-1 times so that shortest distance to all vertices are visited
        for (int i=0; i<N-1; i++){
            int min = 1000000;
            int min_start = 0;
            int min_end = 0;       
            
            //for each vertex 'v' which already has a shortest distance visited...
            for (int v = 0; v < N; v++){ //  iterates all staring points
            	if (visited[v] == 1){
            		// for each vertex 'z' to which the shortest distance has not yet been visited...        		
            		for (int z = 0; z < N; z++){ // iterates unvisited end points which have an edge to starting point
            			if(visited[z] == 0 && adjmat[v][z] != 0){
            				int cost = dijk[v] + adjmat[v][z];
            				// compute the minimum value of (dijk[v] + adjmat[v][z])
            				if(cost < min){
            					min = cost;
            					min_start = v;
            					min_end = z;
            				}
            			}
            		}
            	}
            }           
            visited[min_end] = 1; // found one path with shortest cost from origin, flag it
            dijk[min_end] = dijk[min_start] + adjmat[min_start][min_end];
        }               
        int t[] = {7,37,59,82,99,115,133,165,188,197};
        for(int i : t){
        	System.out.print(dijk[i-1] + " ");
        }     
	}
}
