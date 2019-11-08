package Student;

public class Student {
	
	public String name, num, xrc;
	public int ban, no, kor, eng, math;

	
	
	public int getTotal(int kor,int eng,int math) {
		int total = kor + eng + math;
		return total;
	}
	
	public double getAverage() {	
		double avg = (double)getTotal(kor, eng, math) / 3;
		avg = Math.round(avg *10)/10.0;
		return avg;
	}
	
	
}
