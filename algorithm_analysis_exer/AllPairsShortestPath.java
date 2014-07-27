package algorithm_analysis_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * implement APSP problem using Floyd-Warshall Algorithm
 */
public class AllPairsShortestPath {

	public static void main(String[] args) throws IOException, FileNotFoundException{
		
		int count =1;		
		while (count <= 3 ){
			long startTime = System.currentTimeMillis();
			BufferedReader br;
			if (count == 1){br = new BufferedReader(new FileReader("g1AllPairs.txt"));}
//			if (count == 1){br = new BufferedReader(new FileReader("graphBigAllPairs.txt"));}// taking too much time, need better algo for this, johnson's algo is better
//			if (count == 1){br = new BufferedReader(new FileReader("graphTestAllPairs.txt"));}
			else if (count == 2) {br = new BufferedReader(new FileReader("g2AllPairs.txt"));}
			else {br = new BufferedReader(new FileReader("g3AllPairs.txt"));}
			int numV = Integer.parseInt(br.readLine().split(" ")[0]);
			
			// initializing 2D array A
			// just need two 2-D array, which is enough since it 
			// only cares the direct substructure 
			int[][] A = new int[numV][numV];			
			for (int i = 0; i < numV; i++)
				for (int j =0; j < numV; j++)
					if (i==j) A[i][j] = 0;
					else
						A[i][j] = 1000000;		
			String str;
			StringTokenizer st;
			int x,y,z;
			while((str=br.readLine())!= null){
				st = new StringTokenizer(str);
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());			
				A[x-1][y-1] = z;		
			}

			// Floyd-Warshall Algorithm
			for (int k = 0; k < numV; k++){
				for (int i = 0; i < numV; i++)
					for (int j = 0; j < numV; j++){
						A[i][j] = Math.min(A[i][j],A[i][k]+A[k][j]);							
					}
			}
			int i = 0;
			for (; i <numV;i++){
				if(A[i][i] < 0){
					System.out.println(" A[i][i] = " + i + " " + A[i][i]);
					System.out.println("graph " + count + " has a -ve cycle");
					break;
				}
			}
			if (i == numV){
				System.out.println("graph " + count + " has NO -ve cycle");
				int min = 0;
				for (int ii = 0; ii < numV; ii++)
					for (int jj = 0; jj < numV; jj++){
						min = Math.min(min,A[ii][jj]);
					}
				System.out.println("min cost "+ min);					
			}
			count++;
			long stopTime = System.currentTimeMillis();
			System.out.println("running time: " + (stopTime-startTime));	
		}	
	}
}