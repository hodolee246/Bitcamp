package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClass {
	
	private String filename;
	private File myfile;
	
	public FileClass() {		
		myfile = new File("d:\\tmp\\baseballmember.txt");
		filename = "baseballmember.txt";		
		createFile();
	}
	
	public FileClass(String filename) {
		myfile = new File("d:\\tmp\\" + filename + ".txt");
		this.filename = filename;		
		createFile();
	}

	// 파일 생성
	public File createFile() {
		try {
			if(myfile.createNewFile()) {
				System.out.println(filename + "파일 생성 성공");
			}else {
				System.out.println(filename + "파일 생성 실패");
			}			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return myfile;
	}
	
	
	// 쓰기
	public void writeFile(String datas[]) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(myfile)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(filename + ".txt 파일에 데이터를 저장하였습니다");
	}
	
	
	// 읽기
	public String[] readFile() {
		
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(myfile));
			
			// 데이터의 수를 조사
			int count = 0;
			String str;
			
			while((str = br.readLine())!= null) {
				count++;
			}
			br.close();
			
			// 데이터의 수만큼 배열할당
			datas = new String[count];
			System.out.println("데이터의 갯수:" + datas.length);
			
			// 배열에 저장
			int w = 0;
			br = new BufferedReader(new FileReader(myfile));
			while((str = br.readLine())!= null) {
				datas[w] = str;
				w++;
			}
			br.close();			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println(filename + ".txt 파일로부터 데이터를 정상적으로 읽었습니다");
		
		return datas; 
	}
	
}








