package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode06 {

	public static void main(String[] args) throws IOException {
		// 부산의 부전2동 우편번호만 화면 출력

		
		String 	path 		= Zipcode06.class.getResource("").getPath();
		String	 fname 		= "zipcode_utf8.csv";
		File	 inFile 	= new File(path + fname);
		
		if(!inFile.exists()) {
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader		fr  = new FileReader(inFile);
		BufferedReader  br  = new BufferedReader(fr);
		
		br.readLine(); // 제목줄 skip
		String line = "";
		int	   totcnt = 0;
		
		long startTime = System.nanoTime();
		
		while((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);

			String sido = vo.getSido();
			String dong = vo.getDong();
			
			if(sido.equals("부산") && dong.equals("부전2동")) {
		
			System.out.println(vo);
			totcnt++;
			}
		}
		
		long endTime    = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0; 
		
		br.close();
		fr.close();
		
		System.out.println("전체 자료수:" + totcnt);
		System.out.println("실행 시간:" + execTime + "sec");
	}

}
