package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode05_2 {

	public static void main(String[] args) throws IOException {
		 // 4. 한국의 시도명 출력 - 17건 
		//      서울
		//      부산
		//      ... 
		//      충북
   
   String  path    =  Zipcode05.class.getResource("").getPath();
   String  fname   = "zipcode_utf8.csv";
   File    infile  =  new File(path + fname);
   if(!infile.exists()) {
      System.out.println(fname + "이 없습니다");
      System.exit(-1);
   }
   
   FileReader  fr     =  new FileReader(infile);
   BufferedReader br  = new BufferedReader(fr);
   
   br.readLine();
   String line   = "";
   int    cnt = 0;
   String prevSido = "";
   
   long  startTime =  System.nanoTime();
   
   //HashSet<String>  set  =  new HashSet<>();
   
   // TreeSet<String>  set  =  new TreeSet<>();
   
   while((line = br.readLine()) != null) {
      PostVo  vo    =  new PostVo(line);
      String  sido  =  vo.getSido();
      if(!sido.equals(prevSido)) {
         prevSido  = sido;
         System.out.println(sido);
         cnt++;   
      }

   }
   long  endTime =  System.nanoTime();
   double execTime  =  (endTime - startTime)/1000.0;
   
   br.close();
   fr.close();

   
   System.out.println("도시수: " + cnt);
   System.out.println("전체 자료수: " + execTime + "s");
	}

}
