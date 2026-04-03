package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode7_2 {

	public static void main(String[] args)  {
		// 7. 부산 부산진구 우편번호를 파일로 출력
		String path = Zipcode07.class.getResource("").getPath();
		String inFname = "zipcode_utf8.csv";
		String outFname = "zipcode_busamjingu.csv";
		
		FileReader fr = null;;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		
		try {
			 	fr  = new FileReader(path + inFname);
			 	fw = new FileWriter(path + outFname);
			 	
			 br = new BufferedReader(fr);
			 bw = new BufferedWriter(fw);
			 
			 br.readLine();
			 String line = "";
			 while((line = br.readLine()) != null) {
				 PostVo postVo = new PostVo(line);
				 String sido = postVo.getSido();
				 String gugun = postVo.getGugun();
				 
				 if(sido.equals("부산")) {
					 if(gugun.contains("진구")) {
						 String result = postVo.getAddress();
						 System.out.println(result);
						 bw.write(result + "\n");
						 
					 } else {
						 
					 }
				 } else {
					 
				 }
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		try {
			if(br != null) br.close();
			if(fr != null) fr.close();
			if(bw != null) bw.close();
			if(fw != null) fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

}
