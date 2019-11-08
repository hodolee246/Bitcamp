import student.Student;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Student s = new Student();
		/*
		s.name = "전인우";
		s.ban = 1;
		s.no = 1;
		s.kor = 70;
		s.eng = 82;
		s.math = 90;
		*/
		// 다른 값을 넣고싶으면 클래스 변수만 추가해서 다른 값을 넣으면된다.
		s.setName("전인우");
		s.setBan(1);
		s.setNo(14);
		s.setKor(72);
		s.setEng(87);
		s.setMath(54);
		/*
		System.out.println("이름:" + s.name);
		System.out.println("총점:" + s.getTotal(s.kor, s.eng, s.math));
		System.out.println("평균:" + s.getAverage());
		*/
		System.out.println("이름:" + s.getName());
		System.out.println("총점:" + s.getTotal(s.getKor(), s.getEng(), s.getMath()));
		System.out.println("평균:" + s.getAverage());
		
		
	}

}


