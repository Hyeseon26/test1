package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice3() {
		// 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요

		// 정수를 하나 입력하세요 : 8
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();

		int sum = 0;

		for(int i = 1; i <= num; i++) {
			
			if(i == num) {
				System.out.print(i + " = ");
			}else {
				System.out.print(i + " + ");
			}

			sum += i;
		}
		System.out.printf(" %d", sum);
	}
	
	public void practice9() {
	
		//정수 입력 : 4
		//    *
		//   **
		//  ***
		// ****
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1; x <= input ; x++) {
			
			// 1) for문 하나 더 작성
			// * 1개 출력 전에 띄어쓰기 3번
			// * 2개 출력 전에 띄어쓰기 2번
			// * 3개 출력 전에 띄어쓰기 1번
			// * 4개 출력 전에 띄어쓰기 0번
			
			/*
			for(int y = input - x; y >= 1; y--) {
				System.out.print(" ");
			}
			
			for(int i = 1; i <= x; i++ ) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
			*/
			
			// 2) for + if else
			for(int i = 1; i <= input; i++) {
				
				if(i <= input - x) {
					System.out.print(" ");
					
				}else {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
		
	}
	
	public void practice10() {
		/*
		다음과 같은 실행 예제를 구현하세요.
		ex.
		정수 입력 : 3
		*
		**
		***
		**
		*
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 위쪽 삼각형
		for(int x = 1; x <= input; x++) {
			
			for(int i = 1; i <= x; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 아래쪽 삼각형
		for(int y = input - 1; y >= 1; y--) {
			
			for(int i = 1; i <= y; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice11() {
		/*
		다음과 같은 실행 예제를 구현하세요.
		ex.
		정수 입력 : 4
		   *
		  ***
		 *****
		*******
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1; x <= input; x++) { // 입력 받은 input 만큼 줄 출력
			// 공백 출력 for문
			for(int i = input - x; i >= 1; i-- ) {
				System.out.print(" ");
			}
				
			// * 출력 for문
			// 1, 3, 5, 7, 9
			for(int i = 1; i <= 2 * x - 1 ; i++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	
	public void practice12() {
		/* 
		다음과 같은 실행 예제를 구현하세요.
		ex.
		정수 입력 : 5
		*****
		*   *
		*   *
		*   *
		*****
		
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// row : 행(줄)
		// col(column) : 열(칸)
		
		for(int row = 1; row <= input; row++) {
			
			for(int col = 1; col <= input; col++ ) {
				// row 또는 col이 1 또는 input인 경우 * 출력
				// == 테두리
				if(col == 1 || row == 1 || row == input || col == input) {
					System.out.print("*");
					
				} else { // 내부
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
	}
	
	
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수를 하나 입력하세요 : ");
		int input = sc.nextInt();	
		
		int count = 0; // 2와 3의 공배수의 개수를 세기 위한 변수
		
		for(int i = 1 ; i <= input ; i++) {
			
			// i가 2의 배수 또는 3의 배수
			if( i % 2 == 0  ||  i % 3 == 0) {
				System.out.print(i + " ");
				
				
				// 2와 3의 공배수인 경우
				if( i % 2 == 0 && i % 3 == 0) {
					count++; // count 1 증가
				}
			}
		}
		
		System.out.println("\ncount : " + count);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
