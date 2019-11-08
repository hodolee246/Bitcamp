
public class mainClass {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		/*arr = shuffle(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] =" + arr[i]);
		*/
		shuffle(arr);
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
		
	}

	

	static int[] shuffle(int[] original) {
		for (int i = 0; i < 1000; i++) {
			int x = (int) (Math.random() * 9);
			int y = (int) (Math.random() * 9);

			int temp = original[x];
			original[x] = original[y];
			original[y] = temp;
		}
			return original;
		}

		/*
		 * static int[] shuffle(int array[]) { int r = 0 ; int w = 0; boolean abc[] =
		 * new boolean[array.length]; for (int i = 0; i < abc.length; i++) { abc[i] =
		 * false; } while(w < abc.length) { r = (int)(Math.random()*9); if(abc[r] ==
		 * false) { abc[r] = true;
		 * 
		 * array[w] = r;
		 * 
		 * w++; } } return array;
		 */
	}


