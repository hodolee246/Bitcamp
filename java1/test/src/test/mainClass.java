package test;

import java.util.Arrays;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title[] = {"출석번호", "이름", "국어", "영어", "수학" };
		
		for (int i = 0; i < namescore.length; i++) { //5명의 데이터
			System.out.println((i + 1) + "번째 학생의");
			for (int j = 0; j < namescore[0].length; j++) {
				System.out.print(title[j] + ":");
				namescore[i][j] = sc.next();
			}
		
		
		
		arrtemp[0] = Integer.parseInt(namescore[0][2]);
		arrtemp[1] = Integer.parseInt(namescore[1][2]);
		arrtemp[2] = Integer.parseInt(namescore[2][2]);
		arrtemp[3] = Integer.parseInt(namescore[3][2]);
		arrtemp[4] = Integer.parseInt(namescore[4][2]);
		Arrays.sort(arrtemp);
		for (int j = 0; j < arrtemp.length; j++) {
			System.out.println(arrtemp[i]);
		}

	}

}
