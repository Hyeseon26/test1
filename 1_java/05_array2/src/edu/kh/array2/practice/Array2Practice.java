package edu.kh.array2.practice;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class Array2Practice {
	
	//	3행 3열짜리 문자열 배열을 선언 및 할당하고
	//	인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 
	//	“(0, 0)”과 같은 형식으로 저장 후 출력하세요.
	
//	(0, 0)(0, 1)(0, 2)
//	(1, 0)(1, 1)(1, 2)
//	(2, 0)(2, 1)(2, 2)
	public void practice1() {
		String[][] arr = new String[3][3];
		
		for(int row=0; row<arr.length; row++) {
			
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = "(" + row + ", " + col +")";
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		//	4행 4열 2차원 배열을 생성하여 
		//	0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
		//	아래의 내용처럼 처리하세요.
		
		int[][] arr = new int[4][4];
		
		final int ROW_LAST_INDEX = arr.length-1; // 행 마지막 인덱스
		final int COL_LAST_INDEX = arr[0].length-1; // 열 마지막 인덱스
		
		for(int row=0; row<arr.length; row++) { // 행 반복
							// 행의 길이
			
			for(int col=0; col<arr[row].length; col++) { // 열 반복
								// row번째 행의 열의 길이
				
				// 마지막 행, 마지막 열이 아닌 경우
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					
					int random = (int)(Math.random() * 10 + 1); // 1~10 난수
					arr[row][col] = random;
					
					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];
					
					// 각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					
					// 생성된 모든 난수를 마지막 행, 마지막 열에 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
				}
				
				System.out.printf("%4d", arr[row][col]);
				
			} // 열 반복 끝
			System.out.println(); // 줄바꿈
			
		} // 행 반복 끝
	}
	
	public void practice5() {
		//	2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
		//	“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
		//	크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
		//	(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("행 크기 : ");
			int row = sc.nextInt();
			
			System.out.print("열 크기 : ");
			int col = sc.nextInt();
			
			if(row < 1 || row > 10 || col < 1 || col > 10) { // 1~10사이 숫자가 아닌 경우
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				
			}else {
				char[][] arr = new char[row][col]; 
				
				for(int i=0; i<row; i++) {
					
					for(int j=0; j<col; j++) {
						arr[i][j] = (char)(int)(Math.random()* 26 + 65);
						
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
				break;
			}
			
		}
	}
	
	public void practice6() {
		
		//	사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
		//	문자형 가변 배열을 선언 및 할당하세요.
		//	그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int input = sc.nextInt();
		
		char[][] arr = new char[input][];
		
		char result = 'a';
		
		// 열 크기 정하는 for문
		for(int i=0; i<arr.length; i++) {
			System.out.print(i + "열의 크기 : ");
			int col = sc.nextInt();
			arr[i] = new char[col];
		}
		
		// 출력용 for문
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = result++;
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	
	/*실습문제7
	1차원 문자열 배열에 학생 이름 초기화되어 있다.
	3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
	학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
	(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
	String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
	"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
	[실행 화면]
	== 1분단 ==
	강건강 남나나
	도대담 류라라
	문미미 박보배
	== 2분단 ==
	송성실 윤예의
	진재주 차천축
	피풍표 홍하하
	*/
	public void practice7() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int index = 0;// students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수
		
		System.out.println("== 1분단 ==");
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {
				
				arr1[row][col] = students[index];
				// students 배열 index 번째 학생을 arr1[row][col]에 대입
				
				index++;
				
				System.out.print(arr1[row][col] + " ");
			}
			System.out.println(); // 줄바꿈
		}
		
		System.out.println("== 2분단 ==");
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {
				
				arr2[row][col] = students[index++];
				// students 배열 index번째 학생을 arr2[row][col]에 대입
				
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); // 줄바꿈
		}
	}
	
	public void practice8() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int index = 0;// students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수
		
		System.out.println("== 1분단 ==");
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {
				
				arr1[row][col] = students[index];
				// students 배열 index 번째 학생을 arr1[row][col]에 대입
				
				index++;
				
				System.out.print(arr1[row][col] + " ");
			}
			System.out.println(); // 줄바꿈
		}
		
		System.out.println("== 2분단 ==");
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {
				
				arr2[row][col] = students[index++];
				// students 배열 index번째 학생을 arr2[row][col]에 대입
				
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); // 줄바꿈
		}
		
		System.out.println("=========================================");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String inputName = sc.next();
		
		// 1분단
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {
				
				if(arr1[row][col].equals(inputName)) {

					if(col == 0) {
						
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 왼쪽에 있습니다.", inputName, row+1);
					} else {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 오른쪽에 있습니다.", inputName, row+1);
					}
				}
			}
		}
		
		// 2분단
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {
				
				if(arr2[row][col].equals(inputName)) {

					if(col == 0) {
						
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 왼쪽에 있습니다.", inputName, row+1);
					} else {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.", inputName, row+1);
					}
				}
				
			}
		}
	}
	
	//	String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
	//	그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String [6][6];
		
		System.out.print("행 인덱스 입력 : ");
		int rowIndex = sc.nextInt();
		
		System.out.print("열 인덱스 입력 : ");
		int colIndex = sc.nextInt();
		
		int num1 = 0;
		int num2 = 0;
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				
				if(row == 0 && col != 0) {
					arr[row][col] = num1++ + " ";
					
				}else if(col == 0 && row != 0) {
					arr[row][col] = num2++ + " ";
					
				}else {
					arr[row][col] = "  ";
				}
				
				arr[rowIndex+1][colIndex+1] = "X ";
				
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
		
	}
	
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];
		
		int num1 = 0;
		int num2 = 0;
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				
				if(row == 0 && col != 0) {
					arr[row][col] = num1++ + " ";
					
				}else if(col == 0 && row != 0) {
					arr[row][col] = num2++ + " ";
					
				}else {
					arr[row][col] = "  ";
				}
			}
		}
		
		
		System.out.print("행 인덱스 입력 : ");
		int rowIndex = sc.nextInt();
		
		do {
			
			System.out.print("열 인덱스 입력 : ");
			int colIndex = sc.nextInt();
			
			arr[rowIndex+1][colIndex+1] = "X ";
			
			for(int row=0; row<arr.length; row++) {
				for(int col=0; col<arr[row].length; col++) {
					
					System.out.print(arr[row][col]);
				}
				System.out.println();
			}
			
			System.out.print("\n행 인덱스 입력 >> ");
			rowIndex = sc.nextInt();
			if(rowIndex == 99) {
				System.out.println("\n프로그램 종료");
				break;
				
			}
			
		}while(rowIndex != 99);
	}
	
	
	// 빙고게임 
	public void bingoGame() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("빙고판 크기 지정 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		// 1차원 배열로 빙고판에 입력될 값 생성 + 중복제거 진행
		int[] tempArr = new int[num*num]; // 1차원 배열 생성
		// num*num --> 빙고판의 크기는 가로, 세로의 곱 만큼의 공간이 필요함
		
		// 중복값 제거하면서 랜덤값 집어넣기
		for(int i=0; i<tempArr.length; i++) {
			tempArr[i] = (int)(Math.random()*(num*num)+1);
			
			// 중복제거
			for(int j=0; j<i; j++) {
				if(tempArr[i] == tempArr[j]) {
					i--;
					break;
				}
			}
		}
		
		// 위에서 만들어진 중복제거한 1차원 배열을 --> 2차원 배열에 넣기
		// String 배열로 변경해서 대입 진행
		// 왜 String 배열? 빙고가 된 부분을 "★"로 변경하기 위해서
		String[][] bingoBoard = new String[num][num];
		
		int index = 0; // 1차원 배열 인덱스 지정을 위한 변수
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				
				// 1차원 배열은 0번 부터 num*num까지 반복 진행
				bingoBoard[i][j] = tempArr[index] + "";
				index++;
			}
		}
		
		//-----------------------------------------------------
		
		// 랜덤 배치된 빙고판 최초 1회 출력
		
		for(int i=0; i<bingoBoard.length; i++) {
			for(int j=0; j<bingoBoard[i].length; j++) {
				System.out.printf("%4s", bingoBoard[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("================빙고게임 시작===============");
		
		while(true) {
			System.out.print("정수를 입력하시오 : ");
			String input = sc.nextLine();
			
			boolean flag = true; // 검색된 값이 빙고판에 있는지 확인(잘못된 입력 확인)
			for(int i=0; i<bingoBoard.length; i++) {
				for(int j=0; j<bingoBoard[i].length; j++) {
					
					// 입력된 값과 일치되는 곳을 ★형태로 변환
					if(bingoBoard[i][j].equals(input)) {
						bingoBoard[i][j] = "★";
						flag = false;
					}
					
					System.out.printf("%4s", bingoBoard[i][j]);
				}
				System.out.println();
			}
			
			if(flag) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			// 빙고판 크기에 따라
			// 빙고 기준이 되는 문자열 생성
			// ex) 5 * 5 크기 빙고 -> 한 줄이 "★★★★★"이면 빙고
			String bingoLine = "";
			for(int i=0; i<num; i++) {
				bingoLine += "★"; 
			}
			
			// 빙고 검사
			int bingoCount = 0; // 빙고 수를 저장할 변수
			
			// 가로(행) 또는 세로(열)의 문자열을 더하여 하나의 문자열로 저장
			// --> 저장된 문자열의 모양이 "★★★★★"인 경우 == 빙고
			// --> bingoCount 증가
			
			for(int i=0; i<bingoBoard.length; i++) {
				
				// 매 반복 시 마다 row, col을 빈문자열로 초기화
				// --> 바깥쪽 for문이 반복될 때 마다 검사하는 행과 열이 이동하므로
				//     빙고 여부를 검사하기 위한 row, col을 빈 문자열로 초기화 해야함
				String row = "";
				String col = "";
				
				for(int j=0; j<bingoBoard[i].length; j++) {
					row += bingoBoard[i][j]; // 현재 행의 문자를 모두 더함
					
					col += bingoBoard[j][i];
					// i,j(행렬)를 반대로 하여 열의 모든 문자를 더함
				}
				
				if(row.equals(bingoLine)) {
					bingoCount++; // 가로 빙고가 존재 할 경우
				}
				
				if(col.equals(bingoLine)) {
					bingoCount++; // 세로 빙고가 존재 할 경우
				}
			}
			
			// 대각선 빙고 여부
			// 대각선 : diagonal(다이애그널)
			
			// 대각선은 빙고판에 두 개만 존재
			// --> 대각선 문자를 더해서 저장할 변수 두 개 선언 및 빈문자열로 초기화
			
			String dia1 = "";
			String dia2 = "";
			
			for(int i=0; i<bingoBoard.length; i++) {
				dia1 += bingoBoard[i][i]; // 좌상 우하
				dia2 += bingoBoard[bingoBoard.length -1 -i][i]; // 우상 좌하
			}
			
			if(dia1.equals(bingoLine)) {
				bingoCount++;
			}
			
			if(dia2.equals(bingoLine)) {
				bingoCount++;
			}
			
			// 빙고 카운트 출력
			System.out.println("현재 " + bingoCount + "빙고");
			
			if(bingoCount >= 3) { // 빙고 개수가 3개 이상인 경우
				System.out.println("**************** BINGO!! ***************");
				break;
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
