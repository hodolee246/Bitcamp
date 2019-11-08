package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainClass {

	public static void main(String[] args) {
		/*
		 
		 	Calendar, Data  (
		 
		 
		
	// 첫번째	Calendar cal = new GregorianCalendar();

		Calendar cal = Calendar.getInstance(); // 두번째
		// 일정관리 = 예약 시스템에 많이 사용한다
				
		// 날짜 취득 == getter 
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11
		int day = cal.get(Calendar.DATE);
			
		
		System.out.println(year + "년" + month + "월" + day + "일");				
		// 날짜 설정 == setter
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DATE, 27);
				
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1 ; // 0 ~ 11
		day = cal.get(Calendar.DATE);
				
		System.out.println(year + "년" + month + "월" + day + "일");
		// 오전(0):오후(1)	
		String ampm = cal.get(Calendar.AM_PM)==0?"오전":"오후";
		System.out.println("ampm = " + ampm + " " + cal.get(Calendar.AM_PM));	
	
		// 요일
		int weekday = cal.get(Calendar.DAY_OF_WEEK); // 1 ~ 7
		System.out.println(weekday);
	
		switch (weekday) {
		case 1:
			System.out.println("일요일 입니다.");
			break;
		case 2:
			System.out.println("월요일 입니다.");
			break;
		case 3:
			System.out.println("화요일 입니다.");
			break;
		case 4:
			System.out.println("수요일 입니다.");
			break;
		case 5:
			System.out.println("목요일 입니다.");
			break;
		case 6:
			System.out.println("금요일 입니다.");
			break;
		case 7:
			System.out.println("토요일 입니다.");
			break;	
		}
	
		cal.set(Calendar.MONTH, 5 - 1);
		
		
		
		// 지정한 달의 마지막 날짜를 취득(31, 30, 29, 28)
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		
		
		
		// 연월일을 설정하면, 달력의 빈칸이 몇개 있는지 취득
		year = 2020;
		month = 2;
		day = 1; // 위에 빈칸은 달력의 일을 1일로 잡아야함
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month -1);
		cal.set(Calendar.DATE, day);
		
		weekday = cal.get(Calendar.DAY_OF_WEEK); // 요일을 구한다. 1 ~ 7
		int _day = (weekday - 1) % 7;
		System.out.println("위쪽의 빈칸은" + _day + "칸 입니다.");
		
		// 밑의 빈칸을 구할때에는 마지막 날짜로 기준으로 해야한다
		// 마지막 날짜
		lastday = cal.getActualMaximum(cal.DAY_OF_MONTH);
		cal.set(Calendar.DATE, lastday);
		
		// 요일
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("weekday = " + weekday);

		int _lastday = 7 - weekday;
		System.out.println(month + "월의 아래쪽 빈칸은" + _lastday + "입니다.");
	*/
		
		
		
		
		
		
		
		/*
		
			*	*	*	1	2	3	4
			
			5	6	7	8	9	10	11
		
			12	13	14	15	16	17	18
			
			19	20	21	22	23	24	25
			
			26	27	28	29	30	31	*
		*/
		
		
	
		
		
		
	}

}
