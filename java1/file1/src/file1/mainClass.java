package file1;

import java.io.File;
import java.io.IOException;

public class mainClass {

	public static void main(String[] args) {
		
/*
 		file : 저장매체 == 기능 -> 가져다 사용
 		
 		Database : oracle -> 파일

 		모든 file (*.txt -> 2진수 ->	dll(Dynamicv Link Lib(동적)), lib(Library(정적)), jar
  		
 */
		File file = new File("c:\\");
//			(객체)
		
		/*
		// 경로의 파일 명을 조사
		String filelist[] = file.list();
		
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		/*
		// 파일과 폴더를 조사
		File filelist[] = file.listFiles(); // 위랑 다른점 파일, 폴더(dir) 둘중 무엇인지 확인하기 위하여
		
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) { // 파일을 조사!
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) { // 폴더를 조사!
				System.out.println("[폴더]" + filelist[i].getName());

			}else { // 파일과 폴더 둘다 아닌것을 조사!
				System.out.println("[?]" + filelist[i].getName());

			}
		}
		*/
		
		
		
	/*	// 파일 생성
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
		}*/

		// 폴더 생성 
		/*
		
		String dirStr = "e:\\tmp";
		File newDir = new File(dirStr);
		// mkdir = 폴더 1개 만들기 mkdirs == 폴더 여러개 만들기 하지만 하나 만들때도 mkdirs 사용해도 된다
		if(newDir.mkdirs()) {
			System.out.println("폴더 생성 성공");
		}
		else {
			System.out.println("폴더 생성 실패");
		}
		
		// file 존재 여부
		
		if(newFile.exists()) {
			System.out.println("파일이 존재합니다.");
		}
		else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		// file 쓰기/ 읽기 가능여부
		if(newFile.canWrite()) {
			System.out.println("파일 쓰기가 가능합니다.");
		}else {
			System.out.println("파일 쓰기가 불가능합니다.");
		}
		
		
		// file 삭제
		if(newFile.delete()) {
			System.out.println("파일을 삭제하였습니다.");
		}else {
			System.out.println("파일을 삭제하지 못했습니다.");
		}
		
		*/
		
		
	}
	
}
	
