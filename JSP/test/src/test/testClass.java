package test;

public class testClass {

	public static void main(String[] args)
	{
		String s="try hello world";
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			if(i % 2 == 0) {
				if(s.charAt(i) == '')return;
				answer = answer + (char)((int)s.charAt(i)-32);
			}else {
				answer = answer + (char)((int)s.charAt(i)+32);
			}
		}
		
		System.out.println(answer);
		
	}   




}
