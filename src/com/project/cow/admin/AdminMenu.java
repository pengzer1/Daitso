package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.xml.crypto.Data;

class AdminMenu {

	/*
	 * 관리자 메인 페이지 화면 출력 클래스
	 * 
	 * @author 이승원
	 */

	public static void main(String[] args) {
		// 전체 회원 정보 로드
		MemberCheck.loadMemberInfo();

		// 관리자 메인 메뉴
		adminMain();
	}

	// 관리자 메인 메뉴
	public static void adminMain() {
		Scanner scan = new Scanner(System.in);

		boolean loop = true;

		while (true) {
			displayMainMenu(); // 관리자 메인 메뉴 화면 출력
			String input = scan.nextLine().trim();

			if (input.equals("1")) {
				// 회원 관리
				MemberCheck.adminMemberManage();
			} else if (input.equals("2")) {
				// 블랙리스트 관리

			} else if (input.equals("3")) {
				// 중고 물품 관리

			} else if (input.equals("4")) {
				// 고객센터 Q & A

			} else if (input.equals("5")) {
				// 중고거래 제한물품

			} else {
				// 돌아가기
				loop = false;
			}
		}
	}

	// 관리자 메인 메뉴 화면 출력
	public static void displayMainMenu() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("               관리자 메인 메뉴");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("1. 회원 관리");
		System.out.println("2. 블랙리스트 관리");
		System.out.println("3. 중고 물품 관리");
		System.out.println("4. 고객센터 Q & A");
		System.out.println("5. 각 지역 우편함");
		System.out.println("6. 중고거래 제한물품");
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력: ");
	}
}
