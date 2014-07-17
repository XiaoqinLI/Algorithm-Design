package java_intermediate_training;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReaderWithTryCatchFinally {

	public static String readFile(String filename) throws IOException {
		//		FileReader fr = null;
		//		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try(
				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr); 
				)
				{
			String s;
			while((s = br.readLine()) != null) { 
				sb.append(s); 
				//			} 
			}
			//		try {
			//			fr = new FileReader(filename);
			//			br = new BufferedReader(fr); 
			//			String s;
			//			while((s = br.readLine()) != null) { 
			//				sb.append(s); 
			//			} 
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
		//		finally {
		//			if (fr != null) {
		//				fr.close();
		//			}
		//			if (br != null) {
		//				br.close();	
		//			}
		//		}
		return sb.toString();
	}

}
