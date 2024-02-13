package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();

		if(input < 0) {
			System.out.println("양수만 입력해주세요.");

		}else {
			if(input%2 == 0) {
				System.out.println("짝수입니다.");
			}else {
				System.out.println("홀수입니다.");
			}
		}
	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();


		switch(month){
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : 
			System.out.printf("%d월은 31일까지 있습니다.", month); break;

		case 4 : case 6 : case 9 : case 11: 
			System.out.printf("%d월은 30일까지 있습니다.", month); break;

		case 2 : System.out.printf("%d월은 28일까지 있습니다.", month); break;

		default: System.out.printf("%d월은 잘못 입력된 달입니다.\n", month);

		}
	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);

		System.out.println("BMI 지수 : " + bmi);

		if(bmi < 18.5) {
			System.out.println("저체중");

		} else if(bmi < 23) {
			System.out.println("정상체중");

		} else if(bmi < 25) {
			System.out.println("과체중");

		} else if(bmi < 30) {
			System.out.println("비만");

		} else {
			System.out.println("고도 비만");
		}

	}

	public void practice5() {
//		중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
//		평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
//		이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
//		70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		double midTerm = sc.nextDouble();
		
		System.out.print("기말 고사 점수 : ");
		double finalTerm = sc.nextDouble();
		
		System.out.print("과제 점수 : ");
		double homework = sc.nextDouble();
		
		System.out.print("출석 횟수 : ");
		double attendance = sc.nextDouble();
		
		if(attendance <= 20 * (1 - 0.3)) { // 30% 이상 결석 <-> 70% 미만 출석
			System.out.println("Fail [출석 횟수 부족("+ (int)attendance +"/20)]");
			
		} else {
			midTerm *= 0.2;
			finalTerm *= 0.3;
			homework *= 0.3;
			attendance *= 5 * 0.2;
			
			// 합계
			double sum = midTerm + finalTerm + homework + attendance;
			
			System.out.println("================= 결과 =================");
			System.out.printf("중간 고사 점수(20) : %.1f\n", midTerm);
			System.out.printf("기말 고사 점수(30) : %.1f\n", finalTerm);
			System.out.printf("과제 점수(20) : %.1f\n", homework);
			System.out.printf("출석 점수(30) : %.1f\n", attendance);
			System.out.printf("총점 : %.1f\n", sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
				
			} else {
				System.out.println("Fail [점수 미달]");
			}
			
		}
		
		
		
		
	}






















}
