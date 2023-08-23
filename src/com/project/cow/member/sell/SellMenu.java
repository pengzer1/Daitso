package com.project.cow.member.sell;

import java.util.Scanner;

import com.project.cow.admin.AdminMenu;
import com.project.cow.member.MemberMenu;

public class SellMenu {

	public void Screen() {
		AdminMenu.printMenu("판매하기");
		AdminMenu.printOption("상품 정보 등록", "상품 정보 수정/삭제");
		
		Answer();
	}
	
	private void Answer() {
		Register register = new Register();
		Modify modify = new Modify();
		
		Scanner scan = new Scanner(System.in);
		
		String answer = scan.nextLine();
		
		if(answer.equals("1")) {
			System.out.println("상품 정보 등록 화면으로 이동합니다.");
			System.out.println();
			
			register.Screen();
		}
		else if (answer.equals("2")) {
			System.out.println("상품 정보 수정/삭제 화면으로 이동합니다.");
			System.out.println();
			
			modify.Screen();
		}
		else if (answer.equals("0")) {
			MemberMenu.membermenu();
		}
		else {
			System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
			AdminMenu.printLine();
			System.out.print("번호입력: ");
			
			Answer();
		}
	}
	
}
