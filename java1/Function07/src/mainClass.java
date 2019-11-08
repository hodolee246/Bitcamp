import javax.swing.text.StyledEditorKit.ForegroundAction;

public class mainClass {

	public static void main(String[] args) {

		String abc, aa;
		abc = "48asb";
		aa = "";
		System.out.print(abc +"암호와는");
		aa = encoder(abc);
		System.out.println(aa);
		System.out.print(abc +"복호와는");
		aa = decoder(abc);
		System.out.println(aa);
		// 암호화된 문자열 aa
	}
	
	
	
	static String encoder(String str) {

		int asnum = 0;
		
		String opstr;
		
		
		opstr = "";
		// abcdefghijklmnopqrstuvwxyz
		char[] abcCode = { '`', '~', '!', '@', '#', '$',
				'%', '^', '&', '*', '(', ')', '-', '_',
				'+', '=', '|', '[',']', '{', '}', ';',
				':', ',', '.', '/' };

		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't',
				'y', 'u', 'i', 'o', 'p' };

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			asnum = (int) ch;
			if (asnum > 47 && asnum < 58) {
				asnum = asnum - 48;
				opstr = opstr + numCode[asnum];
			} else if (asnum > 96 && asnum < 121) {
				asnum = asnum - 97;
				opstr = opstr + abcCode[asnum];
			}
		}
		return opstr;
	}
//		static String decoder(String str) { 복호화 다시하자
//			int asnum = 0;
//			
//			
//			
//			
//			
//			// abcdefghijklmnopqrstuvwxyz
//			char[] abcCode = { '`', '~', '!', '@', '#', '$',
//					'%', '^', '&', '*', '(', ')', '-', '_',
//					'+', '=', '|', '[',']', '{', '}', ';',
//					':', ',', '.', '/' };
//
//			// 0 1 2 3 4 5 6 7 8 9
//			char[] numCode = { 'q', 'w', 'e', 'r', 't',
//					'y', 'u', 'i', 'o', 'p' };
//			String originalstr = "";
//			for (int i = 0; i < str.length(); i++) {
//				char ch = str.charAt(i);
//				asnum = (int) ch;
//				// 알파벳인경우 --> 숫자
//				if(asnum >= 97 && asnum <=122) {
//					int index = 0;
//					// 암호표를 대조 하면서 몇번째 있는지  찾는 코드
//					for (int j = 0; j < abcCode.length; j++) {
//						if(ch == abcCode[j]) {
//							index = j;
//							break;
//						}
//					}
//					// 아스키 코드로 맞춰준다
//					index = index + 48; //2 -> 50
//					// 원본의 문자를 추가한다.
//					originalstr = originalstr + (char)index;
//				}
//				// 아닌경우 --> 문자
//				else if(  asnum >= 48 && asnum <= 57 ) {
//						int index = 0;
//						// 암호표 대조하면서 몇번째 있는지 찾는코드
//						for (int j = 0; j < numCode.length; j++) {
//							if( ch == numCode[j]) {
//								index = index + j;
//								break;
//							}
//						}
//						// 아스키 코드로 맞춰준다.
//						index = index + 97;
//						// 원본의 문자를 추가한다.
//						originalstr = originalstr + (char)index;
//					}
//					
//				}
//			
//				return originalstr;
//	
//		/*static String decoder(String str) {
//			String opstr = "" ;
//		char[] abcCode = { '`', '~', '!', '@', '#', '$',
//				'%', '^', '&', '*', '(', ')', '-', '_',
//				'+', '=', '|', '[',']', '{', '}', ';',
//				':', ',', '.', '/' };
//
//		// 0 1 2 3 4 5 6 7 8 9
//		char[] numCode = { 'q', 'w', 'e', 'r', 't',
//				'y', 'u', 'i', 'o', 'p' };
//		String originalstr = "" ;
//		for (int i = 0; i < opstr.length(); i++) {
//			// 한문자씩 산출
//			char c = opstr.charAt(i);
//			// ascii code로 변환
//			int ascCode = (int)c;
//			
//			// 알파벳인경우 --> 숫자
//			if(ascCode >= 97 && ascCode <=122) {
//				int index = 0;
//				// 암호표를 대조 하면서 몇번째 있는지  찾는 코드
//				for (int j = 0; j < numCode.length; j++) {
//					if(c == numCode[j]) {
//						index = j;
//						break;
//					}
//				}
//				// 아스키 코드로 맞춰준다
//				index = index + 48; //2 -> 50
//				// 원본의 문자를 추가한다.
//				originalstr = originalstr + (char)index;
//			}
//			// 아닌경우 --> 문자
//			else {
//				if( ascCode >= 48 && ascCode <= 57) {
//					int index = 0;
//					// 암호표 대조하면서 몇번째 있는지 찾는코드
//					for (int j = 0; j < abcCode.length; j++) {
//						if( c == abcCode[j]) {
//							index = index + j;
//							break;
//						}
//					}
//					// 아스키 코드로 맞춰준다.
//					index = index + 97;
//					// 원본의 문자를 추가한다.
//					originalstr = originalstr + (char)index;
//				}
//				
//			}
//		}
//			return opstr;  */
//		}
	
	
		
		
		
}
