package file1;

import java.io.File;
import java.io.IOException;

public class mainClass {
	public static void main(String[] args) {
		/*
			file : 저장매체 == 기능 -> 가져다 사용
			Database : oracle -> 파일
			
			*.txt  -> 2진수 -> 	
					dll(Dynamic Link Lib 동적), lib(Library 정적), jar	
		*/
		
		File file = new File("c:\\");
		
		// 경로의 파일 명을 조사
		/*
		String filelist[] = file.list();
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		
		// 파일과 폴더를 조사
		/*
		File filelist[] = file.listFiles();		
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {	// 파일이었을 경우
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) {
				System.out.println("[폴더]" + filelist[i].getName());
			}
			else {
				System.out.println("[?]" + filelist[i].getName());
			}
		}
		*/
		
		// 파일 생성
		File newFile = new File("d:\\tmp\\newFile.txt");
		
		try {
			if(newFile.createNewFile()) {
				System.out.println("newFile.txt 파일 생성 성공!");
			}
			else {
				System.out.println("newFile.txt 파일 생성 실패");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		// 폴더 생성
		String dirStr = "d:\\tmp2";
		File newDir = new File(dirStr);
		
		if(newDir.mkdirs()) {
			System.out.println("폴더 생성 성공!");
		}else {
			System.out.println("폴더 생성 실패");
		}
		
		// file 존재 여부
		if(newFile.exists()) {
			System.out.println("파일이 존재합니다");
		}else {
			System.out.println("파일이 존재하지 않습니다");
		}
		
		// file 쓰기/읽기 가능여부
		if(newFile.canWrite()) {
			System.out.println("파일쓰기가 가능합니다");
		}else {
			System.out.println("파일쓰기가 불가능합니다");
		}
		
		// file 삭제
		if(newFile.delete()) {
			System.out.println("파일을 삭제하였습니다");
		}else {
			System.out.println("파일을 삭제하지 못했습니다");
		}
		
		
		
	}

}





