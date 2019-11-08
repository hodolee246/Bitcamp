package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import dao.DaoInterface;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class FileClass implements DaoInterface {

	private String filename;
	private File myfile;
	
	
	public FileClass() {
		myfile = new File("e:\\tmp\\baseballmember.txt");
		filename = "baseballmember.txt";		
		createFile();
	}
	
	public FileClass(String filename) {
		myfile = new File("e:\\tmp\\" + filename + ".txt");
		this.filename = filename;		
		createFile();
	}
	
	
	@Override
	public void Process() {
		Singleton ss = Singleton.getInstance();
		int size = 0;
		size = ss.TMap.size();
		String datas[] = new String[size];
		int len = 0;
		
			Iterator<Integer> it = ss.TMap.keySet().iterator();
			Integer k = 0;
			while(it.hasNext()) {
				Integer key = it.next();
				
				Human hu = ss.TMap.get(key);
				datas[k] = hu.toString();
				k++;
			}
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
		
			System.out.println(filename + " 파일에 저장했습니다.");
	}

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
		
		System.out.println(filename + "파일로부터 데이터를 정상적으로 읽었습니다");
		
		return datas; 
	}
	public void loadfile () {
		
		String datas[] = readFile();
		
		for (int i = 0; i < datas.length; i++) {
			String str = datas[i];
			String data[] = str.split("-");
			
			int number = Integer.parseInt(data[0]);
			if(number < 2000) {
				Pitcher p = new Pitcher(number, 
						data[1], 
						Integer.parseInt(data[2]), 
						Double.parseDouble(data[3]), 
						Integer.parseInt(data[4]), 
						Integer.parseInt(data[5]), 
						Double.parseDouble(data[6])); 
				Singleton ss = Singleton.getInstance();
				ss.TMap.put(number, p);
			}else {
				Batter b = new Batter(number, 	// number
						data[1], 	// name
						Integer.parseInt(data[2]),	// age 
						Double.parseDouble(data[3]), // height
						Integer.parseInt(data[4]), 	// bat
						Integer.parseInt(data[5]), 	// hit
						Double.parseDouble(data[6]));
				Singleton ss = Singleton.getInstance();
				ss.TMap.put(number, b);
			}
					
		}
	
	}
}
