package algorithm_analysis_exer;

import java.io.*;
import java.util.*;

public class ClusteringHammingDistance {
	static HashMap<BitSet, ArrayList> clusters = new HashMap<BitSet, ArrayList>();  
	static int n;  
	static int numBits;  

	public static BitSet getBitSet(String str){  
		String str2[] = str.split(" ");  
		BitSet b = new BitSet(numBits);  
		int j = numBits-1;// j = 23
		b.clear();
		for (int i = 0; i < str2.length; i++){  
			if (Integer.parseInt(str2[i]) == 1){  
				b.flip(j); // 
			}  
			j--;  
		}  
		return b;  
	}  

	public static BitSet find(BitSet i){  
		ArrayList<BitSet> tempIndexPath = new ArrayList<BitSet>();
		while (!i.equals(clusters.get(i).get(0))){  
			//b = (BitSet) clusters.get(b).clone();
			tempIndexPath.add(i);
			i = (BitSet) clusters.get(i).get(0);  
		}
		for(int j = 0; j < tempIndexPath.size(); j++){
			clusters.get(tempIndexPath.get(j)).set(0,i);
		}
		return i;
	}  

	public static void union (BitSet a, BitSet b){  
		//actually smaller cluster should be merged with bigger one. Here do it randomly. Cluster sizes should be maintained for  
		//it to work.  
		BitSet pa = find(a);  
		BitSet pb = find(b);
		
		if (!pa.equals(pb)){
			// if i's rank is less than j, then i's leader is j			
			if ((Integer)(clusters.get(pa).get(1)) < (Integer)(clusters.get(pb).get(1))){
				clusters.get(pa).set(0,pb);
			}
			// if j's rank is less than i, then j's leader is i
			else if ((Integer)(clusters.get(pa).get(1)) > (Integer)(clusters.get(pb).get(1))){
				clusters.get(pb).set(0,pa);
			}
			// if j's rank is equal to i, then j's rank +1 and make j be i's leader
			else if ((Integer)(clusters.get(pa).get(1)) == (Integer)(clusters.get(pb).get(1))){
				int currRank = (Integer)clusters.get(pb).get(1) + 1;
				clusters.get(pb).set(1,currRank);
				clusters.get(pa).set(0,pb);
			}  
		}  
	}  

	public static ArrayList<BitSet> getMembers(BitSet s){  
		BitSet sbackup = (BitSet) s.clone();  
		ArrayList<BitSet> ret = new ArrayList<BitSet>();  
		for(int i = 0; i <= numBits-1; i++){  
			BitSet s1 = new BitSet();  
			s1.clear();  
			s1 = (BitSet) sbackup.clone();  
			s1.flip(i);  
			if (clusters.containsKey(s1)){  
				ret.add(s1);  
			}  
		}  
		//now flip 2 bits to create distance of 2  
		for(int i = 0; i <= numBits-1; i++){  
			BitSet s1 = new BitSet();  
			s1.clear();  
			s1 = (BitSet) sbackup.clone();  
			s1.flip(i);  
			for (int j = i+1; j<=numBits-1; j++){  
				BitSet s2 = new BitSet();  
				s2 = (BitSet) s1.clone();  
				s2.flip(j);  
				if (clusters.containsKey(s2)) ret.add(s2);  
			}  
		}  
		return ret;  
	}   

	public static void main(String[] args) throws IOException, FileNotFoundException{ 
		long startTime = System.currentTimeMillis();
		//int distance = 2; //must be <= 2      
		BufferedReader br = new BufferedReader(new FileReader("clustering_big.txt"));  
		String line = br.readLine();  
		n = Integer.parseInt(line.split("(\\s)+")[0]);  
		numBits = Integer.parseInt(line.split("(\\s)+")[1]);  

		while((line = br.readLine())!= null){  
			BitSet b = getBitSet(line);  
			clusters.put(b, new ArrayList());
			for (int kk = 0; kk < 3; kk++ ){
				clusters.get(b).add(b); // first ele in the list is bitset itself
				clusters.get(b).add(0); // third ele is the rank of this bitset
			}
		} 
		// should have round almost 200,000 vertex, 
		// scan each bitset in the hushmap
		for (BitSet bitEntry : clusters.keySet()){ 
			//get all bitsets for all at distance of 1 or 2 from s  
			ArrayList<BitSet> members = getMembers(bitEntry);  
			//System.out.println(" members sizes "+members.size());  
			
			for (BitSet bitMember : members){  
				union(bitEntry,bitMember);  
			}  
		}  

		int count = 0;  
		//parent of a parent is itself..each cluster has a single parent.   
		for(Map.Entry<BitSet, ArrayList> e : clusters.entrySet()){			
			if (e.getKey().equals(e.getValue().get(0))){  
				count++;  
			}  
		}
		long stopTime = System.currentTimeMillis();
		System.out.println(" running time: " + (stopTime-startTime));		
		//6118
		System.out.println(" num clusters " + count);     
	}  
}
