package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode6_2 {

	public static void main(String[] args)  {
		// 부산의 부전2동 우편번호만 화면 출력

		
		String fn = "D:/dev/java/PrjIO/src/ex04/zipcode_utf8.csv";
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fn);
			br = new BufferedReader(fr);
			
			br.readLine(); // 제목줄 skip
			String line = "";
			while ((line = br.readLine()) != null) {
				PostVo postVo = new PostVo(line);
				System.out.println(postVo);
				String sido = postVo.getSido();
				String dong = postVo.getDong();
				
				if(sido.equals("부산")
					&& dong.startsWith("부전2동")){
						System.out.println(postVo);
					}
			}
		} catch (FileNotFoundException e) {
			System.out.println(fn + "파일이 없습니다");
		} catch (IOException e) {
			System.out.println("데이터 입력에 문제가 있습니다");
		} catch (Exception e) {
			System.out.println("문제발생: " +e.getMessage());
		} finally { // Exception 발생과 상관없이 무조건 실행
			
			try {
				 if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			System.out.println("작업 끝");
	}

}
