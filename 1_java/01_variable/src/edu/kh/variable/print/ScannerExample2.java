package edu.kh.variable.print;

import java.util.Scanner;

public class ScannerExample2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 사칙연산 계산기
		// -> 두 실수를 입력 받아 사칙연산 결과를 모두 출력
		
		System.out.print("실수 1 입력 : ");
		double input1 = sc.nextDouble();
		
		// nextDouble() : 입력 받은 다음 실수를 읽어옴
		
		System.out.print("실수 2 입력 : ");
		double input2 = sc.nextDouble();

		// ctrl + alt + 방향키 위 또는 아래 : 라인 복사
		System.out.printf("%.2f + %.2f = %.2f\n", input1, input2, input1 + input2);
		
		System.out.printf("%.2f - %.2f = %.2f\n", input1, input2, input1 - input2);
		
		System.out.printf("%.2f * %.2f = %.2f\n", input1, input2, input1 * input2);
		
		System.out.printf("%.2f / %.2f = %.2f\n", input1, input2, input1 / input2);
		
		
		
		
		
		
		
		
		
		
	}

}
