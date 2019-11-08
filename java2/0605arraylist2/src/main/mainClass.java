package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) {
		
		List<MemberDto> list = new ArrayList<MemberDto>();
											// 두번째 제너릭은 안에 비워도됨
		// 추가 
		MemberDto dto = new MemberDto(1005, "전인우");
		list.add(dto);
		
		list.add(new MemberDto(2005, "전인우2"));
		
		dto = new MemberDto(2017, "강원도");
		list.add(dto);
		
		for (int i = 0; i < list.size(); i++) {
			MemberDto abc = list.get(i);
			System.out.println(abc.toString()); // toString 
		}
		System.out.println();
		for(MemberDto d2 : list) {
			System.out.println(d2.toString());
		}
		// for each 문은 indexnumber 가 넘어오는게 아니라 value 가 넘어온다.
		
		
		int array[] = { 1, 2, 3 };
		for(int i : array) {
			System.out.println(i);
		}
		
		// 원하는곳 추가
		
		dto = new MemberDto(2018, "고성");
		list.add(2, dto);
		
		for(MemberDto d2 : list) {
			System.out.println(d2.toString());
		}
		
		
	
		// 삭제
		System.out.println();
		list.remove(0);
		dto = list.get(0);
		list.remove(dto);
		
		for(MemberDto d2 : list) {
			System.out.println(d2.toString());
		}
		
		// 검색 indexof == indexnumber만 찾는거임
		int num = list.indexOf(new MemberDto(2017, "강원도"));
		System.out.println("num = " + num);
		for (int i = 0; i < list.size(); i++) {
			MemberDto doo = list.get(i);
		if(doo.equals(dto.getName())) {
			num = i;
		}
			
		}
		System.out.println("2018, 고성이 들어가있는 list의 indexnumber = " + num);
		
		dto = new MemberDto(2018, "고성");
		int fi = -1;
		for (int i = 0; i < list.size(); i++) {
			MemberDto d = list.get(i);
			if(d.getName().equals(dto.getName())) {	// obj 끼리 비교하지말고 obj.getName or getNumber 등으로 특정 value 값을 꺼내서 그거끼리 이큐얼즈로 비교하자
				fi = i;
				break;
			}
		}
		System.out.println(fi);
		
		
		// 수정
		
		dto = new MemberDto(2010, "경기도");
		
		list.set(1, dto);
		
		for (MemberDto d : list) {
			System.out.println(d.toString());
		}
		
		// vector == ArrayList
		// Linked List
		
		
		Vector<MemberDto> vec = new Vector<MemberDto>();
		
		vec.add(new MemberDto(1234, "악어"));
		vec.add(new MemberDto(1245, "강아지"));
		vec.add(new MemberDto(1895, "고양이"));
		System.out.println();
		for(MemberDto m2 : vec) {
			System.out.println(m2.toString() );
		}
		
		// Linked List <==> ArrayList (검색을 할때에는 어레이 리스트로, 추가삭제할때에는 링크드 리스트로)
		
		// 추가삭제 처리속도가 엄청 빠르다. == 실시간처리, 게임에 많이 사용된다.
		
		
		LinkedList<MemberDto> _list = new LinkedList<MemberDto>(list); // 이렇게 Array List값을 넣어줄수있다.
		
		if(_list.isEmpty()) {
			System.out.println("텅텅비였습니다~");
		}
		else {
			System.out.println("리스안에 뭔가 있네요");
		}
		
		_list.addFirst(new MemberDto(154789, "장마"));
		_list.addLast(new MemberDto(2221, "금요일"));
		
		
		for (MemberDto m : _list) {
			System.out.println("_list : " + m.toString());
		}
		
		// iterator == 반복자
		// pointer
		// int number = 1;  
		// int *p;
		// p = &number;      int number =1 이라는 주소값이 p로 들어간다
		// *p -> 1	(값)
		// p -> 1000 (주소)
		// p++;         만약의 p 의주소가 1000 이였다면 p ++ 를한다면 1004 가된다 (int 형이라 4바이트 만큼 이동한다.)
		System.out.println();
		Iterator<MemberDto> it = _list.iterator();
		
		while(it.hasNext()) { // 
		//	MemberDto d = it.next(); // 값을 넘겨주고 이동한다.
		//	System.out.println("it:" + d.toString());
			System.out.println("it:" + it.next()); // 포인터는 주소값으로 이동이 가능하고 value 값으로 뺴낼수있다.
		}
		it = _list.iterator();
		System.out.println("it:" + it.next());
		
		
		Iterator<MemberDto> iter = list.iterator();
		
		
		
		
	}

}









