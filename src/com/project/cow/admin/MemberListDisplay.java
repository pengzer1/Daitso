package com.project.cow.admin;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

import com.project.cow.admin.Member;

public class MemberListDisplay {
	/**
	 * 관리자 전체 회원 목록 조회 클래스
	 * @author 이승원
	 * 목적: 관리자가 전체 회원 목록을 조회하고 정렬하는 기능을 제공하는 클래스
	 * 기능:
	 * - 사용자 선택에 따라 다양한 정렬 방식으로 회원 정보를 출력한다.
	 * - 등급, 이름, 나이, 주소별 등의 기준으로 회원 정보를 정렬하여 출력한다.
	 * - 회원 정보를 화면에 표시할 때 페이지 단위로 나눠서 보여주고 다음/이전 페이지로 이동할 수 있다.
	 */
	
	/**
	 * 회원 목록 조회 메인 메소드
	 * @param scan                 Scanner 사용자 입력
	 * @param defaultSortCriterion 기본 정렬 기준
	 * @param rateCriterionList    등급 정렬 기준 리스트
	 */
	public static void sortMemberList(Scanner scan, String defaultSortCriterion, String[] rateCriterionList) {
		while (true) {
			// 회원 목록 옵션 표시 및 사용자 선택
			AdminMenu.printMenu("전체 회원 목록 조회");
			String sortProcess = chooseSortProcess(scan);

			if (!Pattern.matches("[1234]", sortProcess)) {
				return;
			}

			// 정렬 기준 선택
			String sortCriterion = getSortCriterion(scan, sortProcess, rateCriterionList);

			// 사용자 선택에 따라 정렬 및 출력 수행
			sortAndPrintMember(scan, sortCriterion);
		}
	}

	/**
	 * 정렬 기준 선택 메소드
	 * @param scan              Scanner 사용자 입력
	 * @param sortProcess       정렬 옵션
	 * @param rateCriterionList 등급 정렬 기준 리스트
	 * @return 선택된 정렬 기준
	 */
	private static String getSortCriterion(Scanner scan, String sortProcess, String[] rateCriterionList) {
		String sortCriterion = "0";

		if (sortProcess.equals("1")) { // 등급 옵션 표시 및 사용자 선택
			displayRateCriterionList();
			String rateCriterion = scan.nextLine().trim();

			if (Pattern.matches("[1234]", rateCriterion)) {
				sortCriterion = rateCriterionList[Integer.parseInt(rateCriterion)];
			}
		} else if (sortProcess.equals("2")) {
			sortCriterion = "이름순";
		} else if (sortProcess.equals("3")) {
			sortCriterion = "나이순";
		} else if (sortProcess.equals("4")) {
			sortCriterion = "주소별";
		}

		return sortCriterion;
	}

	/**
	 * 회원을 정렬하고 출력하는 메소드
	 * @param scan          Scanner 사용자 입력
	 * @param sortCriterion 정렬 기준
	 */
	private static void sortAndPrintMember(Scanner scan, String sortCriterion) {
		int groupDataCount = 0;
		String groupChoice;

		Stack<Integer> lastRangeData = new Stack<>(); // 화면에 출력된 마지막 회원 번호
		lastRangeData.push(0);

		// 회원 정렬 수행
		performSorting(sortCriterion);

		while (true) {
			if (!sortCriterion.equals("0")) {
				AdminMenu.printMenu("회원 목록");

				// 회원 정보 출력
				displayMemberInfo(sortCriterion, lastRangeData, groupDataCount);
			} else {
				return;
			}

			groupChoice = scan.nextLine();
			groupDataCount = 0;

			if (groupChoice.equals("1")) { // 다음 100명 보기
			} else if (lastRangeData.size() > 1 && groupChoice.equals("2")) { // 이전 100명 보기
				lastRangeData.pop();
				lastRangeData.pop();

				if (lastRangeData.isEmpty()) {
					lastRangeData.push(0);
				}
			} else { // 돌아가기
				return;
			}
		}
	}

	/**
	 * 정렬 방식 선택 메소드
	 * @param scan Scanner 사용자 입력
	 */
	private static String chooseSortProcess(Scanner scan) {
		displaySortMemberList(); // 정렬 방식 옵션 표시 및 사용자 선택
		return scan.nextLine().trim();
	}

	/**
	 * 정렬 기준별 회원 정보 출력 메소드
	 * @param sortCriterion 정렬 기준
	 * @param lastData      마지막 데이터 스택
	 * @param dataCount     출력된 데이터 개수
	 */
	private static void displayMemberInfo(String sortCriterion, Stack<Integer> lastData, int dataCount) {
		displayMemberHeader(); // 헤더 출력

		// 회원 정보 출력
		for (Member member : MemberData.list) {
			if (dataCount <= 100) {
				if (lastData.isEmpty() || Integer.parseInt(member.getNo()) > lastData.peek()) {
					if (sortCriterion.matches("^(이름순|나이순|주소별)$")) {
						// 이름순, 나이순, 주소별 출력
						printMemberInfo(member);
						dataCount++;
					} else {
						// 등급순 출력
						if (member.getGrade().equals(sortCriterion)) {
							printMemberInfo(member);
							dataCount++;
						}
					}
				}
				if (dataCount > 100) {
					lastData.push(Integer.parseInt(member.getNo()));
				}
			}
		}

		if (!sortCriterion.equals("0")) { // 정보 출력 및 다음 동작 선택
			System.out.printf("정렬: %s (총 회원 수 %d명)%n", sortCriterion, MemberData.list.size());
			displayDataList(sortCriterion, lastData.size());
		} else {
			return;
		}
	}

	/**
	 * 등급별, 이름순, 나이순, 주소별 정렬 메소드
	 * @param sortCriterion 정렬 기준
	 */
	private static void performSorting(String sortCriterion) {
		if (sortCriterion.equals("이름순")) {
			MemberData.list.sort(Comparator.comparing(member -> member.getName()));

		} else if (sortCriterion.equals("나이순")) {
			MemberData.list.sort((member1, member2) -> {
				int ageComparison = Integer.compare(calculateAge(member1.getJumin()), calculateAge(member1.getJumin()));

				if (ageComparison == 0) { // 생일년도가 같은 경우 생일월로 내림차순 정렬
					int month1 = Integer.parseInt(member1.getJumin().substring(2, 4));
					int month2 = Integer.parseInt(member2.getJumin().substring(2, 4));

					if (month1 == month2) { // 생일월이 같은 경우 생일일로 내림차순 정렬
						int day1 = Integer.parseInt(member1.getJumin().substring(4, 6));
						int day2 = Integer.parseInt(member2.getJumin().substring(4, 6));
						return Integer.compare(day2, day1);
					}
					return Integer.compare(month2, month1);
				}
				return ageComparison;
			});
		} else if (sortCriterion.equals("주소별")) {
			MemberData.list.sort(Comparator.comparing(member -> member.getAddress()));

			String currentAddress = "";
			System.out.print("주소 정렬 순서:");

			for (Member member : MemberData.list) {
				String address = member.getAddress();
				if (!address.equals(currentAddress)) {
					System.out.printf(" %s", address);
					currentAddress = address;
				}
			}
			System.out.println();
		} else {
			MemberData.list.sort(Comparator.comparing(member -> member.getGrade()));
		}
	}

	/**
	 * 주민번호를 이용한 나이 계산 메소드
	 * @param jumin 주민번호
	 * @return 계산된 나이
	 */
	private static int calculateAge(String jumin) {
		int birthYear = Integer.parseInt(jumin.substring(0, 2));
		int currentYear = 2023;
		int age = currentYear - (1900 + birthYear) + 1;

		if (age > 100) {
			age = age - 100;
		}

		return age;
	}
	
	/**
	 * 회원 정보를 출력하는 메소드
	 * @param member 회원 정보 데이터 객체
	 */
	static void printMemberInfo(Member member) {
		System.out.printf(" %-4s %5s %-16s %-12s %13s %14s %-24s %-5s", member.getNo(), member.getName(), member.getId(), member.getPwd(), member.getTel(), member.getJumin(), member.getEmail(), member.getAddress());

		for (int i = 0; i < 4 - member.getAddress().length(); i++) { // 띄어쓰기 간격 조절
			System.out.print(" ");
		}

		System.out.printf("%16s %,9d %7s\r\n", member.getAccount(), Integer.parseInt(member.getMoney()), member.getGrade());
	}

	/**
	 * 회원 목록의 헤더를 출력하는 메소드
	 */
	public static void displayMemberHeader() {
		System.out.println(
				"[번호]  [이름]      [아이디]      [비밀번호]  [전화번호]     [주민번호]           [이메일]          [주소]      [계좌번호]     [보유금액] [회원등급]");
	}

	/**
	 * 회원 목록 정렬 화면을 출력하는 메소드
	 */
	private static void displaySortMemberList() {
		System.out.println("[회원 목록 정렬]");
		AdminMenu.printOption("등급별 정렬", "이름순 정렬", "나이순 정렬", "주소별 정렬");
	}

	/**
	 * 등급별 정렬 방법을 화면에 출력하는 메소드
	 */
	private static void displayRateCriterionList() {
		System.out.println("[등급별 정렬]");
		AdminMenu.printOption("1++등급 정렬", "1+등급 정렬", "1등급 정렬", "2등급 정렬", "3등급 정렬");
	}

	/**
	 * 회원 정보 범위를 출력하는 화면을 표시하는 메소드
	 * @param sortCriterion     정렬 기준
	 * @param lastRangeDataSize 마지막 범위 데이터 크기
	 */
	private static void displayDataList(String sortCriterion, int lastRangeDataSize) {
		AdminMenu.printLine();
		System.out.println("1. 다음 100명 보기");
		if (lastRangeDataSize > 2) {
			System.out.println("2. 이전 100명 보기");
		}
		System.out.println("0. 돌아가기");
		AdminMenu.printLine();
		System.out.print("번호 입력: ");
	}
}
