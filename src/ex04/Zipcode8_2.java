package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode8_2 {

	public static void main(String[] args)  {
		// 7. 부산 부산진구 우편번호를 파일로 출력
		String path = Zipcode07.class.getResource("").getPath();
		String inFname = "zipcode_utf8.csv";
		String outFname = "zipcode_busamjingu.csv";
		
		FileReader fr = null;;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		
		int cnt = 0;
		
		try {
		 	fr  = new FileReader(path + inFname);
		 	br = new BufferedReader(fr);
			 	
			 
			 br.readLine();
			 String line = "";
			 String prevSido = "";
			 while((line = br.readLine()) != null) {
				 PostVo postVo = new PostVo(line);
				 String sido = postVo.getSido();
				 String gugun = postVo.getGugun();
				 
				 if(!sido.equals(prevSido)) {
					 if(bw != null) bw.close();
					 if(fw != null) fw.close();
					 
					 outFname = path + sido + ".csv";
					 File oFile = new File(outFname);
					 if(oFile.exists()) {
						 oFile.delete();
					 }
					 fw = new FileWriter(oFile, true);
					 bw = new BufferedWriter(fw);
					 
					 prevSido = sido;
					 cnt++;
				 } else{
					bw.write(postVo.getAddress()+"\n"); 
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
		System.out.println(cnt + "개 파일 생성");
	}
		
}
