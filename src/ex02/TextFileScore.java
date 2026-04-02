package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileScore {

	public static void main(String[] args) throws IOException {
		
		String path 		= "D:/dev/java/PrjIO/src/ex02/";
		String filename		= "data.txt";
		// 입력 파일
		FileReader fr 		= new FileReader(path + filename);
		BufferedReader br   = new BufferedReader(fr);
		
		// 출력 파일
		String filename2	= "result.txt";
		FileWriter  fw 		= new FileWriter(path + filename2, true);
		//append : false 나 생략 -> 생성되는 파일이 OverWrite 됨 -> 덮어쓴다
		// 기존 파일이 존재하면 덮어쓰고 없으면 새로 만듦
		//append : true -> 생성되는 파일이    Append 된다 -> 내용이 추가된다
		// 기존 파일이 존재하면 추가하고 없으면 새로 만듦
		BufferedWriter  bw 	= new BufferedWriter(fw); 
		
		String line = "";
		br.readLine(); //  제목줄 skip
		String title = "번호 이름 국어 영어 수학 총점 평균\n";
		System.out.println(title);
		bw.write(title);
		
		while( (line = br.readLine()) != null) {
			//System.out.println(line);
			String[] arr = line.trim().split(",");

		    int num = Integer.parseInt(arr[0].trim());
		    String name = arr[1].trim();
		    int kor = Integer.parseInt(arr[2].trim());
		    int eng = Integer.parseInt(arr[3].trim());
		    int mat = Integer.parseInt(arr[4].trim());
		    int sum = kor + eng + mat;
		    double avg = sum / 3.0;  // 소수 이하 두 자리로 반올림 : %.2f

		    String fmt = "%d %s %d %d %d %d %.2f\n";
		    String msg =String.format(fmt,
		    		num, name, kor, eng, mat, sum, avg);
			System.out.println(msg);
		    bw.write(msg);
		}
		
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();

	}

}
