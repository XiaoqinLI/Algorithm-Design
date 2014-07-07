package java_essential_training;

import java.io.*;

import org.apache.commons.io.FileUtils;

public class CopyFile {
	// use only core java library
	public static void main(String[] args) {
		// handled possible  exceptions: surround with try-catch block.
		copy_using_core_java_lib();
		copy_using_apache_lib();
		
	}

	private static void copy_using_apache_lib() {
		// TODO Auto-generated method stub
		try {
			File f1 = new File("loremipsum.txt");
			File f2 = new File("target.txt");
			
			FileUtils.copyFile(f1,f2);
			
			System.out.println("File copied!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copy_using_core_java_lib() {
		// TODO Auto-generated method stub
		try {
			File f1 = new File("loremipsum.txt");
			File f2 = new File("target.txt");

			// object input and output
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			// reading from source file to fill byte array
			// if value > 0, means we got something
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len); // 0: begin index of array
			}

			in.close();
			out.close();

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
