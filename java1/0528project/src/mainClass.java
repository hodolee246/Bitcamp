import java.io.ObjectInputStream.GetField;

import Student.Student;

public class mainClass {

	public static void main(String[] args) {
		
		Student s = new Student();
		Student s1 = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		System.out.println("이름:" + s.name);
		System.out.println("총점:" + s.getTotal(s.kor, s.eng, s.math));
		System.out.println("평균:" + s.getAverage() + "\n");
		

		s1.name = "전인우";
		s1.num = "17-76041819";
		s1.xrc = "22XX 53R 3BN HQ";
		
		System.out.println("이름:" + s1.name);
		System.out.println("번호:" + s1.num);
		System.out.println("소속:" + s1.xrc);
		
	}

}
