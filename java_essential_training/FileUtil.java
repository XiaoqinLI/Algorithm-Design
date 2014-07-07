package java_essential_training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static void main(String[] args) {
		try {
			File f1 = new File("loremipsum.txt");
			File f2 = new File("target.txt");
			
			FileUtils.copyFile(f1,f2);
			
			System.out.println("File copied!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
