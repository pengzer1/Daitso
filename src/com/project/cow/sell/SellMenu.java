package com.project.cow.sell;

import java.util.Scanner;


public class SellMenu {

	public static void Screen() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[판매하기]");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("1. 상품 정보 등록");
		System.out.println("2. 상품 정보 수정/삭제");
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호입력: ");
		
		Answer();
	}
	
	private static void Answer() {
		Scanner scan = new Scanner(System.in);
		
		String answer = scan.nextLine();
		
		if(answer.equals("1")) {
			System.out.println("상품 정보 등록 화면으로 이동합니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println();
			
			Register.Screen();
		}
		else if (answer.equals("2")) {
			System.out.println("상품 정보 수정/삭제 화면으로 이동합니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println();
			
			Modify.Screen();
		}
		else if (answer.equals("0")) {
			
		}
		else {
			System.out.println("잘못된 선택입니다.");
			System.out.println("다시 선택해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호입력: ");
			
			Answer();
		}
	}
	
}
