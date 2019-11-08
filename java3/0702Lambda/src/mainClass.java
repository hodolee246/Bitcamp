import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class mainClass {

	static int sum = 0;
	public static void main(String[] args) {
		/*
		 * Lambda 표현식
		 * 
		 * 람다 표현식 Java SE 8 도입 java 커뮤니티에서는 closure 라고 부른다 ** closure == 폐쇄 함수형
		 * interface에서 메소드를 1개만 가지는 메소드 구현하는데 사용할 수있다.
		 * 
		 * 인터페이스를 만들고 interface human{ public void method(); }
		 * 
		 * (구현하는 메소드의 인수) -> { 처리 }
		 * 
		 * 인수의 종류 인수가 없으면 ()-> {처리}
		 * 
		 * 인수가 하나 있을경우 (str)-> {처리}, str->{처리} ** 괄호 생략방법도 있다.
		 * 
		 * 인수가 두개 이상일 경우 (str, n)->{처리}, (String str, int n)->{처리} ** 자료형을 붙여서 쓸수도있다.
		 * 
		 * 
		 * 
		 * 
		 */

		// 1
		/*
		  Consumer<String> cons = new Consumer<String>() {
		  
		  @Override public void accept(String str) { // TODO Auto-generated method stub
		  System.out.println(str); } };
		  
		  cons.accept("Hello Lambda");
		 */

		// Lambda
		/*
		  Consumer<String> cons = (str)->{ System.out.println(str); };
		  
		  cons.accept("Hello Lambda");
		 */
		// 2 번째 예제

		/*
		  List<String> strs = Arrays.asList("tiger", "bear", "lion");
		  
		  strs.forEach(new Consumer<String>() {
		  
		  @Override public void accept(String t) { // TODO Auto-generated method stub
		  System.out.println(t); } });
		 */

		/*
		  List<String> strs = Arrays.asList("tiger", "bear", "lion"); Consumer<String>
		  cons = str->System.out.println(str); strs.forEach(cons); // list data를
		  foreach문으로 cons 형식으로 출력해라 라는 느낌이다.
		 */

		/*
		  //// 3 Comparator<Integer> com1 = new Comparator<Integer>() {
		  
		  @Override public int compare(Integer o1, Integer o2) { // TODO Auto-generated
		  method stub return o1 * o2; } };
		  
		  int r = com1.compare(7, 17); System.out.println("r =" + r);
		  
		  
		  
		 */
		/*
		  Comparator<Integer> com2 = (o1, o2)->{return o1 * o2;}; int r =
		  com2.compare(3, 7); System.out.println("r = " + r);
		 */

		/*
		  Comparator<Integer> com2 = (Integer o1, Integer o2)->{return o1 * o2;}; int r
		  = com2.compare(7, 7); System.out.println("r = " + r);
		 */

		/*
		  Comparator<Integer> com2 = ( o1, o2)->o1 * o2; int r = com2.compare(4, 7);
		  System.out.println("r = " + r);
		 */

		//// 4
		/*
		List<String> arrList = Arrays.asList("a", "b", "c", "d");
		StringBuilder builder = new StringBuilder();
		for (String s : arrList) {
			builder.append(s);
		}
		
		System.out.println();
		*/
		/*
		List<String> arrList = Arrays.asList("a", "b", "c", "d");
		StringBuilder builder = new StringBuilder();
		arrList.forEach(s->builder.append(s));
		System.out.println(builder.toString());
		*/
		// 숫자 5개 -> list
		// lambda 합계
		// 인수가 하나 있을경우 (str)-> {처리}, str->{처리}
		List<Integer> arrs = Arrays.asList(6, 12, 74, 16, 2);
		arrs.forEach(n->sum += n);	// sum 같은경우 스태틱으로 설정후 멤버 변수로 주어야한다.
		System.out.println(sum);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		// 포문과 아래 람다식이랑 같은 처리를 한다.
		IntStream.range(0, 10).forEach(num->System.out.println(num));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
