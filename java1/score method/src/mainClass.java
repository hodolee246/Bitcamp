import java.lang.reflect.Array; 	

import java.util.Arrays;

import java.util.Scanner;

		 

		public class mainClass {

		 

			public static void main(String[] args) {

					String namescore[][] = new String[5][5];

		 

					int sum = 0;

		 

					input(namescore);

		 

					sum = sum(namescore);

		 

					average(sum, namescore);

		 

					numberone(namescore);

		 

					allprint(namescore);

				}


				static void input(String namescore[][]) {

					Scanner sc = new Scanner(System.in);

		 

					String title[] = {"이름", "국어", "영어", "수학" };

		 

					for (int i = 0; i < namescore.length; i++) { //5명의 데이터

		 

						namescore[i][0] = Integer.toString(i + 1);

						System.out.print((i + 1) + "번째 학생의 ");

						for (int j = 1; j < namescore[0].length; j++) {

							

							System.out.print(title[j - 1] + " : ");

							

							if ((j - 1) != 0) {

								String str = sc.next();

								

								if (isNumber(str)) {

									

									namescore[i][j] = str;

								} else {

									

									System.out.println("숫자를 입력해 주세요");

									j--;

								}

							} else {

								namescore[i][j] = sc.next();

							}

		 

						}

					}


				}

				static boolean isNumber(String str) {

					try {

						Integer.parseInt(str);

						return true;

					} catch(NumberFormatException e) {

						return false;

					}

				}

				static int sum(String namescore[][]) {

		 

					Scanner sc = new Scanner(System.in);

		 

					int sum = 0;

		 

					System.out.println("출석번호를 입력하시면 그 학생의 총점이 출력됩니다.");

		 

					while(true) {


						String no = sc.next();

						

						if(no.equals("1")) {

			

							sum = Integer.parseInt(namescore[0][2]) + Integer.parseInt(namescore[0][3]) + Integer.parseInt(namescore[0][4]);
		
							break;
						}

						else if(no.equals("2")) {

			

							sum = Integer.parseInt(namescore[1][2]) + Integer.parseInt(namescore[1][3]) + Integer.parseInt(namescore[1][4]);

			
							break;
						}

			

						else if(no.equals("3")) {

			

							sum = Integer.parseInt(namescore[2][2]) + Integer.parseInt(namescore[2][3]) + Integer.parseInt(namescore[2][4]);

			
							break;
						}

			

						else if(no.equals("4")) {

			

							sum = Integer.parseInt(namescore[3][2]) + Integer.parseInt(namescore[3][3]) + Integer.parseInt(namescore[3][4]);

			
							break;
						}

			

						else if(no.equals("5")) {

			

							sum = Integer.parseInt(namescore[4][2]) + Integer.parseInt(namescore[4][3]) + Integer.parseInt(namescore[4][4]);

							break;

						}

						

						else {

							System.out.println("1 ~ 5 를 입력하세요.");

							

						}

							

					}
					
					
					System.out.println(sum);

					

					return sum;

				}

		 

				 // sum

		 

				static void average(int sum, String namescore[][]) {

		 

					Scanner sc = new Scanner(System.in);

		 

					int avg = 0;

		 

					System.out.println("평균을 확인하고 싶은 학생의 출석번호를 입력해 주세요.");

		 

		 

					while(true) {

		 

						String no = sc.next();

		 

						if( no.equals("1")) {

		 

							sum = Integer.parseInt(namescore[0][2]) + Integer.parseInt(namescore[0][3]) + Integer.parseInt(namescore[0][4]);

			

							avg = sum / 3;

			

							System.out.println(namescore[0][1] + "의 평균은 " + avg);

			

							break;

		 

						}

		 

						else if( no.equals("2")) {

		 

							sum = Integer.parseInt(namescore[1][2]) + Integer.parseInt(namescore[1][3]) + Integer.parseInt(namescore[1][4]);

		 

							avg = sum / 3;

		 

							System.out.println(namescore[1][1] + "의 평균은 " + avg);	

		 

							break;

		 

						}

		 

						else if( no.equals("3")) {

		 

							sum = Integer.parseInt(namescore[2][2]) + Integer.parseInt(namescore[2][3]) + Integer.parseInt(namescore[2][4]);

		 

							avg = sum / 3;

		 

							System.out.println(namescore[2][1] + "의 평균은 " + avg);

		 

							break;

		 

						}

		 

						else if( no.equals("4")) {

		 

							sum = Integer.parseInt(namescore[3][2]) + Integer.parseInt(namescore[3][3]) + Integer.parseInt(namescore[3][4]);

		 

							avg = sum / 3;

		 

							System.out.println(namescore[3][1] + "의 평균은 " + avg);

		 

							break;

		 

						}

		 

						else if( no.equals("5")) {

		 

							sum = Integer.parseInt(namescore[4][2]) + Integer.parseInt(namescore[4][3]) + Integer.parseInt(namescore[4][4]);

		 

							avg = sum / 3;

		 

							System.out.println(namescore[4][1] + "의 평균은 " + avg);

		 

							break;

								

						}

						

						else {

							System.out.println("1 ~ 5 사이를 입력해 주세요.");

						}

		 

					}

		 

				} // average

		 

				static void numberone(String namescore[][]) {

		 

					Scanner sc = new Scanner(System.in);

		 

					System.out.println("어떤 과목의 1등을 보시겠습니까?");

		 

					System.out.println("국어(1), 영어(2), 수학(3)");

		 

		 

					while(true) {

		 

						String no = sc.next();

						

						

						int arrtemp[]=new int[5];

		 

						int arrtemp2[]=new int[5];

						

						int index = Integer.parseInt(no) + 1;

		 

						arrtemp[0] = Integer.parseInt(namescore[0][index]);

		 

						arrtemp[1] = Integer.parseInt(namescore[1][index]);

		 

						arrtemp[2] = Integer.parseInt(namescore[2][index]);

		 

						arrtemp[3] = Integer.parseInt(namescore[3][index]);

		 

						arrtemp[4] = Integer.parseInt(namescore[4][index]);

		 

						

		 

						arrtemp2[0] = Integer.parseInt(namescore[0][index]);

		 

						arrtemp2[1] = Integer.parseInt(namescore[1][index]);

		 

						arrtemp2[2] = Integer.parseInt(namescore[2][index]);

		 

						arrtemp2[3] = Integer.parseInt(namescore[3][index]);

		 

						arrtemp2[4] = Integer.parseInt(namescore[4][index]);

		 

						Arrays.sort(arrtemp);

						

		 

						if(arrtemp[arrtemp.length-1] == arrtemp2[0]) {

		 

							System.out.println("출석번호 :"+namescore[0][0] + " 이름 : " + namescore[0][1] + " 가 " + namescore[0][index] + " 점으로 1등 입니다.");

		 

							break;

		 

						}

		 

						else if(arrtemp[arrtemp.length-1] == arrtemp2[1]) {

		 

							System.out.println("출석번호 :"+namescore[1][0] + " 이름 : " + namescore[1][1] + " 가 " + namescore[1][index] + " 점으로 1등 입니다.");

		 

							break;

		 

						}

		 

						else if(arrtemp[arrtemp.length-1] == arrtemp2[2]) {

		 

							System.out.println("출석번호 :"+namescore[2][0] + " 이름 : " + namescore[2][1] + " 가 " + namescore[2][index] + " 점으로 1등 입니다.");

		 

							break;

		 

						}

		 

						else if(arrtemp[arrtemp.length-1] == arrtemp2[3]) {

		 

							System.out.println("출석번호 :"+namescore[3][0] + " 이름 : " + namescore[3][1] + " 가 " + namescore[3][index] + " 점으로 1등 입니다.");

		 

							break;

		 

						}

		 

						else if(arrtemp[arrtemp.length-1] == arrtemp2[4]) {

		 

							System.out.println("출석번호 :"+namescore[4][0] + " 이름 : " + namescore[4][1] + " 가 " + namescore[4][index] + " 점으로 1등 입니다.");

		 

							break;

		 

						}


							}

		 

								}

		 

				static void allprint(String namescore[][]) {

		 

					String title[] = {"출석번호", "이름", "국어", "영어", "수학" };

		 

					for (int i = 0; i < namescore.length; i++) {

		 

						System.out.println((i + 1) + "번째 학생의");

		 

						for (int j = 0; j < namescore[0].length; j++) {

		 

							System.out.print(title[j] + ":" + namescore[i][j]+" ");

		 

						}

		 

						System.out.println();


					}


				}

		 

				/*

		 

				 * static int sum(int no) { // 국, 영, 수

				 * } static void avg(int no) { // 총점의 평균


				 * } static int numberOne( 과목 번호 ) // 과목번호 입력시 총점의 1등을 출력하여라

				 * static void allPrint() { // 학생의 이름과 번호 점수가 전부다 출력


		 

				 */

		 
		}
		
		
		
		
		


	


