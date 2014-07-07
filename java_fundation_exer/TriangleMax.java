package java_fundation_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TriangleMax {

	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("triangle.txt"));
		int len = Integer.parseInt(br.readLine());
		int[][] triangle = new int[len][];		
		String line;
		int currentRow = 0;
		
		while((line = br.readLine()) != null){
			String[] split =  line.trim().split("(\\s)+");
			triangle[currentRow] = new int[split.length];
			for (int i = 0; i < split.length; i++){				
				triangle[currentRow][i] = Integer.parseInt(split[i]);
			}
			currentRow++;
		}
		br.close();
		ArrayList<Integer> results = new ArrayList<Integer>();
		computeSumPath(triangle,results,0,0,len,0,false);
		System.out.print(Collections.max(results));	
	}	
	
	// save all path, bruto-force.
	public static void computeSumPath(int[][] array, ArrayList<Integer> results, int curr_row, int idx, int length, int path, boolean choice){
		if (curr_row == length){
			results.add(path);
		}
		else{
			if (curr_row == 0){
				path += array[curr_row][0];
			}
			else{
				if (choice == true){
					idx+=1;
					path += array[curr_row][idx];
				}
				else{
					path += array[curr_row][idx];
				}
			}
			computeSumPath(array,results,curr_row+1,idx,length,path,false);
			computeSumPath(array,results,curr_row+1,idx,length,path,true);	
		}			
	}
}
