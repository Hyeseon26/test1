package edu.kh.variable.print;

public class PrintExample {
	
	public static void main(String[] args) {
		
		// System.out.print() : 단순 출력 (출력 후 줄바꿈 X)
		// System.out.println() : 한 줄 출력 (출력 후 줄바꿈 수행)
		
		// System.out.printf() : 출력될 문자열 형식을 패턴으로 지정하는 출력구문
		
		System.out.println("테스트1");
		System.out.println("테스트2");
		
		System.out.print("테스트3");
		System.out.println(); // 내용 없는 println (줄바꿈)
		System.out.print("테스트4");
		
		System.out.println();
		
		int iNum1 = 10;
		int iNum2 = 5;
		
		// 10 + 5 = 15
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2) );
		
		// System.out.printf("패턴", 패턴에 들어갈 값);
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1 + iNum2);
		
		// 10 + 10 * 5 / 2 = 35
		System.out.println(iNum1 + " + " + iNum1 + " * " + iNum2 + " / 2 = " + (iNum1 + iNum1 * iNum2 / 2));
		System.out.printf("%d + %d * %d / 2 = %d\n", iNum1, iNum1, iNum2, iNum1+iNum1*iNum2/2);
		
		
		// 패턴 연습
		int iNum3 = 3;
		System.out.printf("%d\n", iNum3);
		System.out.printf("%7d\n", iNum3); // 7칸 공간 확보 후 오른쪽 정렬
		System.out.printf("%-7d\n", iNum3);  // 7칸 공간 확보 후 왼쪽 정렬
		
		// 소수점 자리 제어 (반올림처리)
		System.out.printf("%f\n", 10 / 4.0);
		System.out.printf("%.2f\n", 10 / 4.0);
		System.out.printf("%.0f\n", 10 / 4.0);
		
		// 문자, 문자열, boolean
		boolean isTrue = false;
		char ch = '얍'; 
		String str = "지금은 2교시";
		
		// '' : char 리터럴 표기법
		// "" : String 리터럴 표기법
		
		System.out.printf("%b / %c / %s\n", isTrue, ch, str);
		
		// escape 문자 : 일반 문자가 아닌 특수 문자 표현
		System.out.println("\\"); // 백슬래시 출력 방법
		
		System.out.println("a\tb\tc\td"); // tab 출력
		
		System.out.println(" \" "); // 쌍따옴표 단순 문자 출력
		
		System.out.println(" \' "); // 홑따옴표 단순 문자 출력
		
		System.out.println("\u0041"); // 유니코드(16진수)번호로 출력
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
