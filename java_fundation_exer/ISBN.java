package java_fundation_exer;

import java.io.*;

public class ISBN {

	public static void main(String[] args) 
			throws FileNotFoundException, IOException {

		FileReader fr = new FileReader("isbn_input.txt");
		BufferedReader br = new BufferedReader(fr);
		File outFile = new File("isbn_output.txt");
		FileWriter fWriter = new FileWriter(outFile, true);
		PrintWriter pWriter = new PrintWriter (fWriter);

		String curr_line;
		while((curr_line = br.readLine()) != null){
			int s1 = 0;
			int s2 = 0;
			String str = new String();
			for (int i = 0; i < curr_line.length(); i++){
				if (curr_line.charAt(i) != '-'){
					str = str + curr_line.charAt(i);
				}
			}
			
			System.out.println(str);
			
			if (str.length() != 10){
				pWriter.println(curr_line + " invalid");
				continue; // move to next whileloop
			}
			boolean flag = true;
			for (int i = 0; i < str.length(); i++){
				if (i < 9){
					if(!Character.isDigit(str.charAt(i))){
						pWriter.println(curr_line + " invalid");
						flag= false;
						break; 
					}
				}else{
					if(!Character.isDigit(str.charAt(i)) && 
							(str.charAt(i) != 'X' && str.charAt(i) != 'x')){
						pWriter.println(curr_line + " invalid");
						flag = false;
						break;
					}
				}
			}
			if (!flag){
				continue;
			}else{
				for (int i = 0; i < str.length(); i++){
					if (str.charAt(i) != 'X' && str.charAt(i) != 'x'){
						s1 = s1 + Integer.parseInt(String.valueOf(str.charAt(i)));
					}else{
						s1 = s1 + 10;
					}
					s2 = s2 + s1;
				}			 
			}
			
			if (s2%11 == 0){
				pWriter.println(curr_line + " valid");
			}
			else{
				pWriter.println(curr_line + " invalid");
			}
					
		} // end of while loop
		br.close();
		pWriter.close();
	}
}
