package com.project.cow.member;

import java.util.Scanner;

import com.project.cow.login.Login;
import com.project.cow.member.sell.SellMenu;

public class MemberMenu {

		
	public static void membermenu() {

		SellMenu sellMenu = new SellMenu();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("           회원 메뉴");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		
		System.out.println("1.구매하기");
		System.out.println("2.판매하기");
		System.out.println("3.마이페이지");
		System.out.println("4.로그아웃");
		
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력:");
		String sel = scan.nextLine();
		
		if(sel.equals("1")) {	
			
		}else if (sel.equals("2")) {
			sellMenu.Screen();
		}else if (sel.equals("3")) {

		}else if(sel.equals("4")){
			Login.logout();
			
			
		}
		
	}
		


}
