// using hash to solve two sum problem
package algorithm_analysis_exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Hash2SUM {
	public Hashtable<Long, Long> htb = new Hashtable<Long, Long>();
	public final int N = 1000000;
    public long[] a = new long[N];
    public int count = 0; // count how many of them succeed
    public final String fileName = "prob2sum.txt";
    
    Hash2SUM() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        int k = 0;

        // store all numbers in an array, and hash them into a hash table
        while((str = br.readLine()) != null){
            a[k] = Long.parseLong(str);
            htb.put((a[k]),(a[k])); // hashing each value
            k++;
        }
        br.close();
    }
    public void find(long sum){
    	// for each element "ele" in the array
        for (int i=0; i<a.length; i++){
        	if(htb.containsKey(sum-a[i]) == true && a[i] != (sum-a[i]))
        	{
        		count += 1;
        		break;        		
        	}
        }
    }    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Hash2SUM Htable = new Hash2SUM();
		for(int i = -10000; i <= 10000; i++){
			Htable.find(i);			
		}
		System.out.println(Htable.count); //427
	}
}
