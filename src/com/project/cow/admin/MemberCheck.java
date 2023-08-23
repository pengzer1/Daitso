package com.project.cow.admin;

import java.util.Scanner;

public class MemberCheck {
	/**
	 * 관리자 회원 관리 클래스
	 * @author 이승원
	 * 목적: 관리자가 회원 관리 기능을 수행하는 클래스
	 * 기능:
	 * - 회원 관리 메뉴를 표시하고 사용자의 선택에 따라 회원 관리 기능을 실행한다.
	 * - 회원 목록 조회, 회원 검색, 회원 삭제 기능을 제공한다.
	 */

	/**
	 * 관리자 회원 관리 메소드
	 */
	public static void adminMemberCheck() {
		Scanner scan = new Scanner(System.in);
		String sortCriterion = "1++등급";
		String[] rateCriterionList = { "돌아가기", "1++등급", "1+등급", "1등급", "2등급", "3등급" }; // 등급별 정렬 기준

		while (true) {
			// 메인 메뉴 표시 및 사용자 선택
			AdminMenu.printMenu("회원 관리");
			System.out.println("[회원 관리 기능]");
			AdminMenu.printOption("전체 회원 목록 조회", "회원 검색", "회원 삭제");
			String manageChoice = scan.nextLine().trim();

			if (manageChoice.equals("1")) { // 전체 회원 목록 조회
				MemberListDisplay.sortMemberList(scan, sortCriterion, rateCriterionList);
			} else if (manageChoice.equals("2")) { // 회원 검색
				MemberSearch.searchMember(scan);
			} else if (manageChoice.equals("3")) { // 회원 삭제
				MemberRemove.removeMember(scan);
			} else { // 로그인 메뉴
				return;
			}
		}
	}
}
