package com.project.cow.admin;

import java.util.Scanner;

public class BLACK_LIST {
	
	public static final String BLACK_LIST = "C:\\git\\Daitso\\blackList.txt";
	
	public static void main(String[] args) {
		
		blacklist_list();
	
		
	}

	private static void blacklist_list() {
		
		Scanner scan = new Scanner(System.in);
		
	
		
		
		
		 boolean loop = true;

	      while (true) {
	         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	         System.out.println("              블랙리스트 현황");
	         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	         for (int i=0; i)
	         
	         
	         
	         System.out.println("1. 페이지 앞으로 넘기기");
	         System.out.println("2. 뒤로가기");
	         System.out.println("3. 회원 상세정보 확인하기");
	         System.out.println("0. 돌아가기");
	         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	         System.out.print("번호 입력: ");
	         String input = scan.nextLine().trim();
	         scan.skip("\r\n");
	         
	         System.out.println();
	         System.out.println();
		
		
	}

}