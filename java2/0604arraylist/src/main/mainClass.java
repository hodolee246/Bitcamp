package main;

import java.util.ArrayList;
import java.util.List;

public class mainClass {

	public static void main(String[] args) {
		/*
		  		list : 목적
		  		
		  		목적 : 데이터를 관리하기 위한 (도구)
		  		STL : Standard Template Library
		  		
		  		Collection(수집)
		  		ArrayList  == Vector(단방향) // 컬렉션의 일종
		  			배열목록
		  			선형구조 0-0-0-0-0-0 (단방향으로 선으로 이루어짐)
		  			검색속도가 빠르다.(List중에서)
		  			관리 : IndexNumber 0, 1, 2, 3
		  			1-2-3-4-5-6
		  				 31		31을 중간에 끼고싶다면
		  			1-2-3-31-4-5-6		indexnum 3이 31이 들어간다
		  			// 단점 하나의 데이터를 넣을때 앞으로 땡기거나 뒤로 밀어야한다.
		  			// ? == 4번째에 데이터를 넣어서 5 6 7 번째 데이터를 전부다한칸씩 밀어줘야해서
		  			// 실시간 처리가 느리다
		  			
		  		LinkedList	// 컬렉션의 일종2
		  			연결목록
		  			선형구조
		  			검색속도가 약간 느리다.
		  			LinkedList 장점 : 실시간으로 추가/삭제
		  			
		  			실시간으로 추가 삭제해야하는 작업을 할때에는 ArrayList 보다는 LinkedList 를 사용한다.
		  			근데 보통 실시간일 처리하는 경우가 없어서 ArrayList를 사용한다.
		  			
		  		HashMap			== json    // 컬렉션의 일종3
		  			2진 Tree = 구조
		  			검색속도가 엄청 빠르다
		  			pair(1쌍) 으로 관리되고 key, value 로 관린된다.
		  			
		  			평상시에 HashMap을 선호한다.
		  		TreeMap	// 컬렉션의 일종 4
		  			
					HashMap 비해서 무겁다.
					Sorting이 가능하다.		
	  			
		 */
		
	//	ArrayList<Integer> list = new ArrayList<Integer>();

		// 부모클래스 인스턴스에 자식클래스 인스턴스 가 가능하다.
		List<Integer> list = new ArrayList<Integer>();
		
		// 추가 list.add (index number);
		
		Integer in = new Integer(142);
		list.add(in);
		
		list.add(222);
		list.add(333);
		
		int len =list.size(); // 리스트의 길이를 len에 대입한다.
		System.out.println("list의 길이는 " + len);
		
		
		// array[0], array[1]....array[n] 이런식으로 indexnumber를 입력해줘서 하나하나 데이터를 꺼낸다.
		// list.get(0), list.get(1)... 리스트도 indexnumber로 입력을해서 관리가된다.
		// 출력
		for (int i = 0; i < list.size(); i++) {
			Integer n = list.get(i);
			System.out.println("n = " + n);
		}
		System.out.println();
		list.add(123); 
		for (int i = 0; i < list.size(); i++) {
			Integer n = list.get(i);
			System.out.println("n = " + n);
		}
		
		// 중간추가 list.add(indexnumber(몇번째의 추가할꺼인지) value
		System.out.println();
		list.add(1,new Integer(199));
		// list.add(1, 199); 래퍼클래스라 이렇게 입력도 가능
		for (int i = 0; i < list.size(); i++) {
			Integer n = list.get(i);
			System.out.println("n = " + n);
		}
		// 삭제 list.remove(indexnumber)
		System.out.println();
		list.remove(2);
		
		for (int i = 0; i < list.size(); i++) {
			Integer n = list.get(i);
			System.out.println("n = " + n);
		}
		
		Integer ri = list.get(1);
		list.remove(ri);	// Object remove remove(obj o) 로도 삭제가  가능하다.
		
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			Integer n = list.get(i);
			System.out.println("n = " + n);
		}
		// 검색
		// int findIndex = list.indexOf(333);	// 어떻게 적든지 상관은 없다
		int findIndex = list.indexOf(new Integer(333));	// 정석은 이거
		System.out.println("검색된 indexnumber = " + findIndex);
		// 수정 // 몇번째 (인덱스넘버) 바꾸고 싶은 Value
		list.set(0, 111);
		
		System.out.println(list.get(0));
	
		
		
		
		
		
		String cls = new String("test");
		
		Object obj = (Object)cls;
		// 모든클래스는 obj 클래스에 상속받아있다.
		
		
		
		
		
		
		ArrayList<String> strlist = new ArrayList<String>();
	// String   자료형이 아니라 오브젝트이다. 오브젝트만 들어오게 설정한게 제너릭이다.
		// 추가, 삭제, 검색, 수정 -> 확인
		ArrayList<String> str2list = new ArrayList<String>();
		// 추가 add( 111 ) add( "hello" )	add( new Integer(111) ) add( new String("abd") )
		str2list.add(new String("lions"));
		str2list.add(new String("twins"));
		str2list.add(new String("tigers"));
		// 원하는 곳(indexnum)에 추가 가능
		str2list.add(1, new String("giants"));
		
		// 삭제(indexnun, obj)
		// str2list.remove(2);
		String ss =str2list.get(2);
		str2list.remove(ss);
		
		// 검색
		int findindex = str2list.indexOf(new String("giants"));
		
		System.out.println("findindex = " + findindex);
		
		for (int i = 0; i < str2list.size(); i++) {
			String str = str2list.get(i);
			if(str.equals("tigers")) {
				findindex = i;
				break;
			}
		}
		System.out.println("findindex = " + findindex);
		// 수정
		String ss501 = "bears";
		str2list.set(0, ss501);
		
		for (int i = 0; i < str2list.size(); i++) {
			String str = str2list.get(i);
			System.out.println("str2list[" + i + "] = " + str);
		}
		strlist.add("hel lo");
		
		String str = new String(" seeyou");
		strlist.add(str);
		strlist.add("b ye");
		strlist.add(3, "good day");
		System.out.println();
		for (int i = 0; i < strlist.size(); i++) {
			String sr = strlist.get(i);
			System.out.println("strlist [" + i + "] = " + sr);
		}
		
		strlist.remove(0);
		String ig = strlist.get(0);
		strlist.remove(ig);
		System.out.println();
		for (int i = 0; i < strlist.size(); i++) {
			String sr = strlist.get(i);
			System.out.println("strlist [" + i + "] = " + sr);
		}
		
		int findnum = strlist.indexOf(new String("b ye"));
		System.out.println("b ye의 indexnumber = " + findnum);
		
		findnum = strlist.indexOf(new String("bbye"));
		System.out.println("bbye의 indexnumber = " + findnum);
		
		findnum = strlist.indexOf(new String("bbsye"));
		System.out.println("bbye의 indexnumber = " + findnum);
		
		strlist.set(1, "not good");
		
		 System.out.println("strlist[1]" + strlist.get(1)); 
		
		 ArrayList<Double> dlist = new ArrayList<Double>();
		 
		 Double dd = new Double(0.8);
		 dlist.add(0.5);
		 dlist.add(0.6);
		 dlist.add(0.7);
		 dlist.add(0.9);
		 dlist.add(dd);
		 double s = dlist.get(0);
		 System.out.println(s);
		 s = dlist.get(1);
		 System.out.println(s);
		 
		 dlist.remove(0);
		 System.out.println();
		 dlist.remove(0.8);
		 
		 for (int i = 0; i < dlist.size(); i++) {
			double s2 = dlist.get(i);
			System.out.println(s2);
		}
		
		 int abc = dlist.indexOf(0.9);
		 System.out.println(abc);
		 
		 dlist.set(1, 1.7);
		 
		 System.out.println(dlist.get(1));
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
