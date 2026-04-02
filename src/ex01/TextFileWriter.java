package ex01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {

	public static void main(String[] args) throws IOException {
		
		String [] names = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
		
		
		//String filename = "bts.txt"; // D:\dav\java\PrjIO\bts.txt
		String filename = "D:\\dev\\java\\PrjIO\\src\\ex01\\bts.txt";
		FileWriter fw 	= new FileWriter(filename);
		
		for (int i = 0; i < names.length; i++) {
			fw.write(names[i] + "\n");			
		}

		fw.close();
		
		System.out.println(filename + "이 저장되었습니다");
		

	}

}
