package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode07 {

	public static void main(String[] args) throws IOException {
		// 부산 부산진구 우편번호를 파일( .csv )로 출력

		
		String 	path 		= Zipcode07.class.getResource("").getPath();
		String	 fname 		= "zipcode_utf8.csv";
		File	 inFile 	= new File(path + fname);
		
		if(!inFile.exists()) {
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader		fr  = new FileReader(inFile);
		BufferedReader  br  = new BufferedReader(fr);
		
		String outName = "busan_jingu.csv";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path + outName));
		
		br.readLine(); // 제목줄 skip
		String line = "";
		int	   totcnt = 0;
		
		long startTime = System.nanoTime();
		
		while((line = br.readLine()) != null) {
			PostVo vo = new PostVo(line);

			String sido = vo.getSido();
			String gugun = vo.getGugun();
			
			if(sido.trim().equals("부산") && gugun.trim().equals("부산진구")) {
		
			bw.write(vo.toString());
			bw.newLine();
			
			totcnt++;
			}
		}
		
		long endTime    = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0; 
		
		bw.close();
		br.close();
		fr.close();
		
		System.out.println("전체 자료수:" + totcnt);
		System.out.println("실행 시간:" + execTime + "sec");
	}

}
