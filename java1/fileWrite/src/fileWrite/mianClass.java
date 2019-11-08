package fileWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mianClass {

	public static void main(String[] args) {
		
		File file = new File("e:/tmp/newFile.txt");
		
		// 위에 기입이 된다. 생성과 같이 기입이된다
		
		// readonly 설정
		// file.setReadOnly();
		// readonly 해제
		// file.setWritable(true);

		// 쓰기 이거는 새롭게 이것만 나오게 하는거고
		try {
			/*
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("안녕하세요 반갑습니다 \n");
			fileWriter.write("hi good day");
			fileWriter.close(); // write ()의 경우는 close 를 안할경우 작성의 마무리를 할 수 가 없습니다.
			*/
			 
			/*
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			pw.print("안녕");
			pw.println("안녕하세요");
			pw.print("hello");
			pw.close();
			*/
			
			// 추가 기입은 실행 시킬때마다 추가 기입문구들이 계속 생성된다.
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write("안녕하세요 반갑습니다 \n");
			fileWriter.write("hi good day");
			fileWriter.close();
			
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
