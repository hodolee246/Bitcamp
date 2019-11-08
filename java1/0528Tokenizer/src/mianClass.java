import java.util.StringTokenizer;

public class mianClass {

	public static void main(String[] args) {
	
		
		String str = "홍길동--2001/03/14-서울시";
		
		String split[] = str.split("-");
		
		for (int i = 0; i < split.length; i++) {
			
			System.out.println(split[i]);
		}
		
		StringTokenizer st = new StringTokenizer(str, "-");
		
		int len = st.countTokens(); // 자르고 넘긴 문자열의 길이 == 배열이 몇개인지
		System.out.println("len = " + len);
		
		String s = st.nextToken();	// 0
		System.out.println(s);
		
		s = st.nextToken();			// 1
		System.out.println(s);
		
		s = st.nextToken();  		// 2
		System.out.println(s);
		
		/*
		
			tokneizer 이랑 split 차이점
			
			split : 빈물자열도 문자로 취급
			StringTokenizer : 빈 문자열을 무시한다
		
		*/
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



















































