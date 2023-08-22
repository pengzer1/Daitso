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

	/**
	 * 관리자 메인 메뉴 메소드
	 */
	public static void main(String[] args) {
		MemberListDisplay.loadMemberInfo(); // 전체 회원 정보 로드
		MemberQuestion.loadFAQInfo(); // FAQ 정보 로드
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			// 관리자 메인 메뉴 화면 출력
			AdminMenu.printMenu("관리자 메인 메뉴");
			AdminMenu.printOption("회원 관리", "블랙리스트 관리", "중고 물품 관리", "고객센터 F A Q", "각 지역 우편함", "중고거래 제한물품");
			String input = scan.nextLine().trim();

			if (input.equals("1")) {
				// 회원 관리
				MemberCheck.adminMemberCheck();
			} else if (input.equals("2")) {
				// 블랙리스트 관리
				
			} else if (input.equals("3")) {
				// 중고 물품 관리
				StuffCheck.adminStuffCheck();
			} else if (input.equals("4")) {
				// 고객센터 F A Q
				MemberQuestion.adminFAQCheck();
			} else if (input.equals("5")) {
				// 중고거래 제한물품
				
			} else {
				// 돌아가기
				return;
			}
		}
		// TODO 로그인 기능에서 통합할 때 adminMain 메소드로 이름을 변경하고 실행하게 하면 됩니다!
		// TODO 전체 회원 정보를 로드하는 부분을 다른 클래스에서 만들 예정이므로 추후 수정해야 할 수 있습니다.
	}

	/**
	 * 메뉴의 주어진 옵션과 '돌아가기' 옵션을 출력하는 메소드
	 * @param options 출력할 옵션
	 */
	public static void printOption(String... options) {
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
		System.out.println("0. 돌아가기");
		AdminMenu.printLine();
		System.out.print("번호 입력: ");
	}

	/**
	 * 주어진 문자열을 가운데 정렬하여 출력하는 메소드
	 * @param text 출력할 문자열
	 */
	public static void printMenu(String text) {
		String line = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
		int totalWidth = line.length() / 2; // 총 출력 폭 설정(24)

		String formattedText = centerText(text, totalWidth);

		AdminMenu.printLine();
		System.out.println(formattedText);
		AdminMenu.printLine();
	}

	/**
	 * 주어진 문자열을 주어진 폭에 맞게 가운데 정렬하여 반환하는 메소드
	 * @param text  가운데 정렬할 문자열
	 * @param width 문자열을 정렬할 폭
	 * @return 가운데 정렬된 문자열
	 */
	public static String centerText(String text, int width) {
		return String.format("%" + width + "s", text);
	}
	
	/**
	 * 가운데 정렬된 선을 출력하는 메소드
	 */
	public static void printLine() {
	    String line = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
	    System.out.println(line);
	}
}
