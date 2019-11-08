package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.text.MaskFormatter;

import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) {
		
		/*
			TreeMap : HashMap + upgrade
			sorting이 필요하면 TreeMap 으로 사용하다가 그 외에는 HashMap 으로 바꾸어서 사용한다.
			
		*/

		HashMap<Integer, MemberDto> map = new HashMap<Integer, MemberDto>();		
		
		
		// 추가
		MemberDto dto = new MemberDto(10, "홍길동");
		map.put(1001, dto);
		map.put(1002, new MemberDto(2, "일지매"));
		map.put(1000, new MemberDto(3, "성춘향"));
		
		map.put(1001, new MemberDto(2, "임꺽정")); // 이러면 수정이된다 중복을 안시키고
		
		// 삭제
		map.remove(1001);
		map.remove(1001, map.getClass());
		// 검색
		
		Iterator<Integer> iter = map.keySet().iterator();
		Integer k = 0;
		while(iter.hasNext()) {
			Integer key = iter.next();
			MemberDto m = map.get(key);
			if(m.getName().equals("성춘향")); {
				k = key;
				break;
		}
		// 수정 -> value key 값을 수정하는건 불가능 value값만 수정
		
		
		// 출력
		
		}
		MemberDto rdto = map.get(k);
		System.out.println("key" + k + "value" + rdto.toString()) ;
		
		// sorting -> key  value 는 따로 만들어야 한다.
		TreeMap<Integer, MemberDto> tMap = new TreeMap<Integer, MemberDto>(map);
		System.out.println();
		// 오름차순 정렬 // 그냥 TreeMap 을 keyset 으로 정렬하면 오름차순 정렬이된다.
		iter = tMap.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			MemberDto m = map.get(key);
			System.out.println("tmap :" + key + " " + m.toString());
		}
		System.out.println();
		// 내림차순
		iter = tMap.descendingKeySet().iterator(); // TreeMap을 descendingKeySet으로 정렬하면 내림차순 정렬이 된다.
		while(iter.hasNext()) {
			Integer key = iter.next();
			MemberDto m = map.get(key);
			System.out.println("tmap :" + key + " " + m.toString());
		}
		
		TreeMap<Integer, MemberDto> numMap = new TreeMap<Integer, MemberDto>();
		
		iter = tMap.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			MemberDto d = tMap.get(key);
			
			numMap.put(d.getNumber(), d);
		}
		System.out.println();
		iter = numMap.keySet().iterator();
		while(iter.hasNext()) { // number 값으로 정렬 하는데 만약에 number가 같으면 수정이되버린다. 
			Integer Key = iter.next();
			MemberDto d = numMap.get(Key);
			System.out.println("key:" + Key + "value:" + d.toString());
			// 중복 number을 막기 위해서는 Time 을 사용해서 붙여준다.
		}
		HashMap<String, ArrayList<MemberDto>> maplist = new HashMap<String, ArrayList<MemberDto>>();
		
		ArrayList<MemberDto> lions = new ArrayList<MemberDto>();
		lions.add(new MemberDto(1, "강아지"));
		lions.add(new MemberDto(2, "고양이"));
		
		ArrayList<MemberDto> tigers = new ArrayList<MemberDto>();
		lions.add(new MemberDto(1, "송아지"));
		lions.add(new MemberDto(2, "망아지"));
		
		maplist.put("삼성", lions);
		maplist.put("기아", tigers);
		
	/*	int array2[3][5] = { // 차원 배열
					{1, 2, 3, 4, 5},
					{},
					{}
		}*/
		// Collection의 2차원 배열
		HashMap<Integer, ArrayList<Integer>> mapArr = new HashMap<Integer, ArrayList<Integer>>();
			// 키값이 0이였을때 array2[0][0~5]
			// 키값이 1이였을때 array2[1][0~5]
			// ...
	}

}












