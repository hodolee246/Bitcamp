package fileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class mainClass {

	public static void main(String[] args) {
		
		
		File File = new File("e:\\tmp\\newFile.txt");
							// 경로 설정할때 / 도 상관없지만 \\ 도 상관없다
		
			try {
				if(checkBeforeReadFile(File)) {
					/*
					FileReader fileReader = new FileReader(File);
				
				// 한글자씩 읽어 옴	
					int ch = fileReader.read();
					while(ch != -1) { // -1 파일의 끝
						System.out.print((char)ch);
						ch = fileReader.read();
					}
					*/
					
					// 한글자씩 읽는 방식 보다는 문장으로 읽는 방식을 조금더 많이 사용한다.
					// 문장으로 읽어 들인다 한글자 -> 저장
					BufferedReader br = new BufferedReader(new FileReader(File));
				
					String str;
					while((str = br.readLine()) != null) { //비어있지 않을때 까지 읽어라
						System.out.println(str);
					}
					br.close();
				
				}
				else {
					System.out.println("파일을 읽을 수 없습니다.");
				}
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
			}
			
	
		static boolean checkBeforeReadFile(File f) { // utility 함수 프로그램에 직접적인 영향은 주지않고 검사용 함수를 유틸리티라고 한다.
		if(f.exists()) { // exists 존재여부
			if(f.isFile() && f.canRead()) { // is file == 파일인지 유무 확인 canRead 읽기 가능한지
				return true;
			}
		}
		return false;
	}



}