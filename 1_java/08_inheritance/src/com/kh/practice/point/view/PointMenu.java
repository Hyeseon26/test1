package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {

	private Scanner sc= new Scanner(System.in);

	private CircleController cc = new CircleController();

	private RectangleController rc = new RectangleController();

	public void mainMenu() {

		int menuNum = 0;

		while(menuNum != 9) {

			System.out.println("===== 메뉴 ===== ");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");

			System.out.print("메뉴 번호 : ");
			menuNum = sc.nextInt();

			switch(menuNum) {
			case 1 : circleMenu(); break;
			case 2 : rectangleMenu(); break;
			case 9 : System.out.println("프로그램 종료"); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}
		}
	}

	public void circleMenu() {
		System.out.println("===== 원 메뉴 ===== ");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");

		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();

		switch(menuNum) {
		case 1 : calcCircum(); break;
		case 2 : calcCircleArea(); break;
		case 9 : break;
		default : System.out.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다..\n");
		}
	}

	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 ===== ");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");

		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();

		switch(menuNum) {
		case 1 : calcPerimeter(); break;
		case 2 : calcRectArea(); break;
		case 9 : break;
		default : System.out.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다..\n");
		}
	}


	public void calcCircum() { // 원의 둘레 메소드 

		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); 

		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); 

		System.out.print("반지름 : ");
		int radius = sc.nextInt(); 

		System.out.println(cc.calcCircum(x, y, radius));
	}

	public void calcCircleArea() { // 원의 넓이 메소드

		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); 

		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); 

		System.out.print("반지름 : ");
		int radius = sc.nextInt(); 

		System.out.println(cc.calcArea(x, y, radius));
	}

	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();

		System.out.print("y 좌표 : ");
		int y = sc.nextInt();

		System.out.print("높이 : ");
		int height = sc.nextInt();

		System.out.print("너비 : ");
		int width = sc.nextInt();

		System.out.println( rc.calcPerimeter(x, y, height, width) );
	}

	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();

		System.out.print("y 좌표 : ");
		int y = sc.nextInt();

		System.out.print("높이 : ");
		int height = sc.nextInt();

		System.out.print("너비 : ");
		int width = sc.nextInt();

		System.out.println( rc.calcArea(x, y, height, width) );
	}
}