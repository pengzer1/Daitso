package com.project.cow.admin;

import java.util.Scanner;

public class MemberSearch {
	/**
	 * 관리자 회원 검색 클래스
	 * @author 이승원
	 * 목적: 관리자가 회원 정보를 검색하는 기능을 제공하는 클래스
	 * 기능:
	 * - 검색한 회원 정보를 출력하고 검색 결과 개수를 보여준다.
	 */

	/**
	 * 회원 검색 기능을 수행하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	public static void searchMember(Scanner scan) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("                    회원 검색");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		System.out.print("검색할 회원 번호, 이름 또는 아이디 입력: ");
		String searchKeyword = scan.nextLine().trim();

		// 검색 결과 출력
		displaySearchResult(scan, searchKeyword);
	}

	/**
	 * 검색 결과를 출력하고 검색된 회원 수를 보여주는 메소드
	 * @param scan    Scanner 사용자 입력
	 * @param keyword 검색 키워드 (회원 번호, 이름 또는 아이디)
	 */
	private static void displaySearchResult(Scanner scan, String keyword) {
		int foundCount = 0;

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("                    회원 목록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		MemberListDisplay.displayMemberHeader(); // 헤더 출력

		for (String[] data : MemberListDisplay.memberDataList) {
			if (data[0].equals(keyword) || data[1].equals(keyword) || data[2].equals(keyword)) {
				MemberListDisplay.printMemberInfo(data);
				foundCount++;
			}
		}

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		if (foundCount == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.printf("%d명의 회원이 검색되었습니다.%n", foundCount);
		}

		scan.nextLine();
	}
}
