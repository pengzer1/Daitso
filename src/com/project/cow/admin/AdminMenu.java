package com.project.cow.admin;

import java.util.Scanner;

class AdminMenu {
	/**
	 * 관리자 메인 페이지 화면 출력 클래스
	 * @author 이승원
	 * 목적: 관리자의 메인 메뉴 화면을 출력하고 관리 기능을 실행하는 클래스
	 * 기능:
	 * - 회원 관리, 블랙리스트 관리, 중고 물품 관리, 고객센터 Q&A, 지역 우편함, 중고거래 제한물품 관리 등의 기능을 제공한다.
	 * - 사용자의 선택에 따라 해당 기능을 실행하거나 메인 메뉴로 돌아갈 수 있다.
	 */

	public static void main(String[] args) {
		MemberListDisplay.loadMemberInfo(); // 전체 회원 정보 로드
		MemberQuestion.loadFAQInfo(); // FAQ 정보 로드

		adminMain(); // 관리자 메인 메뉴
		
		// TODO 로그인 기능에서 통합할 때 main 메소드 내용을 adminMain 메소드로 이동한다.
		// TODO 전체 회원 정보를 로드하는 부분을 다른 클래스에서 만들 예정이므로 추후 수정한다.
	}

	/**
	 * 관리자 메인 메뉴
	 */
	public static void adminMain() {
		try (Scanner scan = new Scanner(System.in)) {

			while (true) {
				displayMainMenu(); // 관리자 메인 메뉴 화면 출력
				String input = scan.nextLine().trim();

				if (input.equals("1")) {
					// 회원 관리
					MemberCheck.adminMemberCheck();
				} else if (input.equals("2")) {
					// 블랙리스트 관리

				} else if (input.equals("3")) {
					// 중고 물품 관리

				} else if (input.equals("4")) {
					// 고객센터 F A Q
					MemberQuestion.manageFAQ();
				} else if (input.equals("5")) {
					// 중고거래 제한물품

				} else {
					// 돌아가기
					return;
				}
			}
		}
	}

	/**
	 * 관리자 메인 메뉴 화면 출력
	 */
	public static void displayMainMenu() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("               관리자 메인 메뉴");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("1. 회원 관리");
		System.out.println("2. 블랙리스트 관리");
		System.out.println("3. 중고 물품 관리");
		System.out.println("4. 고객센터 F A Q");
		System.out.println("5. 각 지역 우편함");
		System.out.println("6. 중고거래 제한물품");
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력: ");
	}
}
