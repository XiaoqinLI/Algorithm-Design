package java_fundation_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DNASquence {
	
	public static void allSubstrings (String s)
	{
	  int window = s.length();
	  while (window > 0)
	  {
	    int start = 0;
	    while ((start + window) <= s.length())
	    {
	      System.out.println (s.substring(start, start + window));
	      start++;
	    }
	    window--;
	  }
	}
	
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("dna.txt");
		BufferedReader br = new BufferedReader(fr);
		int num_pair = Integer.parseInt(br.readLine());
		for (int i = 0; i < num_pair; i++){
			String dna1 = br.readLine();
			String dna2 = br.readLine();
			ArrayList<String> finalresult  = longestSubstr(dna1,dna2);
			if (finalresult.size() == 0){
				System.out.println("Pair " + (i+1) + ": No Common Sequence Found");
			}
			else{				
				for(int j = 0; j < finalresult.size(); j++){
					if (j == 0){
						System.out.println("Pair " + (i+1) + ": " + finalresult.get(j));
					}else{
						System.out.println("        " + finalresult.get(j));
					}
				}
					
			}
		}
		br.close();		
	}
	
	// non-recursion method
	public static ArrayList<String> longestSubstr(String S1, String S2) {
		ArrayList<String> result = new ArrayList<String>();		
		if (S1 == null || S2 == null || S1.length() == 0 || S2.length() == 0) {
			return result;
		}		
		int Start = 0; // start index for a matching
		int Max = 1;
		//int Max_all = 1;
		int temp_i_record = 0;
		for (int i = 0; i < S1.length(); i++)
		{
			for (int j = 0; j < S2.length(); j++)
			{
				int x = 0;// matching counter
				while (S1.charAt(i + x) == S2.charAt(j + x))
				{
					x++;
					if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
				}
				if (x > Max)
				{	
					Max = x;
					Start = i;
					temp_i_record = i;
					result.clear();
 					result.add(S1.substring(Start, (Start + Max)));
				}
				if (x == Max){
					if (i != temp_i_record){
						Start = i;
						result.add(S1.substring(Start, (Start + Max)));
					}					
				}
			}// end of loop j
		}// end of loop j	 	
		return result;
	}

}
