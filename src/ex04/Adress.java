package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Adress {

	public static void main(String[] args) throws IOException {
		String path = "D:/dev/java/PrjIO/src/ex04/";
		String filename = "zipcode.txt";
		
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		
		
		String filename2	= "result.txt";
		FileWriter  fw 		= new FileWriter(path + filename2, true);
		//append : false 나 생략 -> 생성되는 파일이 OverWrite 됨 -> 덮어쓴다
		// 기존 파일이 존재하면 덮어쓰고 없으면 새로 만듦
		//append : true -> 생성되는 파일이    Append 된다 -> 내용이 추가된다
		// 기존 파일이 존재하면 추가하고 없으면 새로 만듦
		BufferedWriter  bw 	= new BufferedWriter(fw); 
		
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("검색할 동 또는 건물명 입력 : ");
		String keyword = in.nextLine().trim();
		
		int totalCount = 0; // 전체 자료수
		int searchCount = 0; // 검색된 자료수
		
		String		line  = "";
		br.readLine(); //  제목줄 skip
		String title = "ZIPCODE	SIDO	GUGUN	DONG	BUNJI	SEQ";
		System.out.println(title);
		bw.write(title);
		while( (line = br.readLine()) != null) {
			totalCount++;
			//System.out.println(line);
			String[] li = line.trim().split(",");

			String zipcode  = li[0].trim();
			String sido 	= li[1].trim();
			String gugun	= li[2].trim();
			String dong		= li[3].trim();
			String bunzi 	= li[4].trim();
			String seq 		= li[5].trim();
			  
			if (dong.contains(keyword) || bunzi.contains(keyword)) {
				searchCount++;
			
		    String fmt = "%s %s %s %s %s %s";
		    String msg =String.format(fmt,
		    		zipcode, sido, gugun, dong, bunzi, seq);
			System.out.println(msg);
		    bw.write(msg);
		    bw.newLine(); 
		}
		}
			
		System.out.println("검색된 자료수 : " + searchCount);
		System.out.println("전체 자료수 : " + totalCount);

		bw.write("검색된 자료수 : " + searchCount);
		bw.newLine();
		bw.write("전체 자료수 : " + totalCount);

		bw.close();
		fw.close();
		
		br.close();
		fr.close();

}
}
