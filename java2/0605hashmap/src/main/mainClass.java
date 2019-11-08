package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class mainClass {

	public static void main(String[] args) {
		/*
		  
		  
		  	
		  	map : dictionary(사전)
		  	
		  	HashMap  <-> json 서로 데이터를 넘겨받고 넘겨줄수있다.
		  	apple : 사과
		  	key		value 	-> pair 로 관리가 된다. (쌍으로 관리)
		  			String
		  			Integer		// value 에 다양한 obj를 집어넣을 수있다 (이게 map 이다.)
		  			MemberDto
		  
		  
		  
		  
		  
		  
		  	key 중복을 허용하지 않는다.
		  	apple <- 사과
		  	apple <- 능금	처음에 넣었던 사과라는 value 값이 없어지고 능금이라는 value 값이 들어간다
		  
		  	2진 Tree 구조
		  	
		  	TreeMap : hashMap + sorting
		  	
		  	ArrayList 랑 LinkedList 서로 바꿀 수 있듯이 hashMap TreeMap 서로 바꿀 수있다.
		  	
		  	관리 : Key로 관리된다.
		  	
		  	
		 */
		
		
			HashMap<Integer, String> hMap = new HashMap<Integer, String>();
			
	//		Map<Integer, String> hMap = new HashMap<Integer, String>(); 어느걸 써도 상관없다.
		// 장점 여기에다 다른 tree 맵을 담을 수 있다.
			// 관리가 필요할때에는 interface를 쓰는 것 이 정석이다.
		
			// 추가
			hMap.put(1234, "메론");
			hMap.put(1541, "복숭아");
			hMap.put(1999, "배");
			
			
			
			hMap.put(22111, "사과");
			hMap.put(112, "참외");
			
				// 이터레이터 제너릭에는 키값이 들어가야한다
			
			
			// 삭제
			String val = hMap.remove(112); // 지운 value 값을 return 한다.
			System.out.println("value =" + val);
			
		/*
		 * Iterator<Integer> it = hMap.keySet().iterator(); // 이건 규칙이라 외워야한다.
		 * while(it.hasNext()) { Integer key = it.next(); // 값을 넘겨주면서 다음 포인터로 이동한다.
		 * String value = hMap.get(key); System.out.println("Key:" + key + "  value:" +
		 * value); }
		 */
			// 검색
			// key 값을 검색을 할수있다.
			// Key 확인
		//	boolean b = hMap.containsKey(new Integer(112));
		//	System.out.println(b);
			// 수정
			hMap.replace(1999, "배ㅐ");
		//	hMap.put(1999, "배ㅐ");
			Iterator<Integer> it = hMap.keySet().iterator(); // 이건 규칙이라 외워야한다.
			while(it.hasNext()) {
				Integer key = it.next(); // 값을 넘겨주면서 다음 포인터로 이동한다.
				String value = hMap.get(key);
				System.out.println("Key:" + key + "  value:" + value);
			}
			
			for(Integer key : hMap.keySet()) { // key set key 값을 얻어와서 integer key에 대입한다.
				String value = hMap.get(key);
				System.out.println("key" + key + "value" + value);
			} // 이터레이터 대용으로 포이치문 사용가능
			
			
			HashMap<String, String> sMap = new HashMap<String, String>();
			System.out.println();
			// 사전
			System.out.println();
			// "apple" : "사과"
			//추가
			sMap.put("Apple", "사과");
			sMap.put("Peach", "복숭아");
			sMap.put("WaterMellon", "수박");
			sMap.put("Banana", "바나나");
			Iterator<String> iter = sMap.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				String value = sMap.get(key);
				System.out.println("key" + key + "  value" + value );
			}
			System.out.println();
			// 삭제
		String str2 = sMap.remove("Apple");
		System.out.println("내가 방금 지운거는?" + str2);
			// 검색
			boolean b = sMap.containsKey("Peach");
			System.out.println("Key = Peach is " + b);
			// 수정
			sMap.replace("Banana", "바난아");
			// 모두출력
			Iterator<String> iter2 = sMap.keySet().iterator();
			while(iter2.hasNext()) {
				String ssttrr = iter2.next();
				String Vaal = sMap.get(ssttrr);
				System.out.println("key = " + ssttrr + "  value = " + Vaal);
			}
			
			
			
			
			
			
	//		HashMap<String, Object> map = new HashMap<String, Object>();
		
	}

}







