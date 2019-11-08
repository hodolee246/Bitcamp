package function04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mainClass {

	public static void main(String[] args) {
		
		int array[] = {3,2,-9,-4,-7};
		
		System.out.println(max(array));
		

	}
	
	
	static int max(int array[]) {

		if(array == null || array.length == 0) {
				return -999999;
		}
			int m = array[0];
				
				for (int i = 0; i < array.length; i++) {
					if(m < array[i]) {
						m = array[i];
					}
				}
				return m;
		}
		
		
			
	}
	
	/*
	  package function04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mainClass {

	public static void main(String[] args) {
		
		int data[] = {3,2,9,4,7};
		
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:"  max(data));
		

	}
	
	
	static void max(int array[]) {
		
		for (int i = 0; i < array.length; i++) {
			
			
			if(array[i] == 0) {
				array[i] = -999999;
				System.out.println("배열이 0이거나 비어있습니다.");
			}
		}
			Arrays.sort(array);
		
			
	}
	}
	*/
	 





