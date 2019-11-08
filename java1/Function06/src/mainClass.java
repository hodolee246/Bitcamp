
public class mainClass {

	public static void main(String[] args) {
		
		
		String str = "12345";
		System.out.println("실수 입니까?" + isDouble(str));
		String str2 = "481159.0";
		System.out.println("실수 입니까?" + isDouble(str2));
//		boolean a,b;
//		a =isNumber(str);
//		b =isNumber(str2);
//		if(a == true) {
//			System.out.println("정수입니다.");
//			}
//			else {
//				System.out.println("실수입니다.");
//			}if(b == true) {
//				System.out.println("정수입니다.");
//			}
//			else {
//				System.out.println("실수입니다.");
//			}

	}

	static boolean isDouble(String str) {
		boolean b = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if( c == '.') {
				b = true;
				break;
			}
			
		}
		return b;
	}
//	static boolean isNumber(String str) {
//		boolean abc ;
//		int a = 0;
//		
//
//		for (int i = 0; i < str.length(); i++) {
//			char ab = str.charAt(i);
//			if(ab == 46 ) {
//				a = a+1;
//			}
//		}
//		
//		if(a == 0) {
//			abc = true;
//		}
//		else {
//			abc = false;
//		}
//		
//		return abc;
//	}
	
}
