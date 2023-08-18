package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class MemberCheck {

	/*
	 * 관리자 회원 관리 클래스
	 * 
	 * @author 이승원
	 */

	// 회원 정보 파일 경로
	private static final String GUEST_LIST = "C:\\이승원\\Isaac portfolio\\8 AWS 클라우드 & Elasticsearch\\project\\Daitso\\data\\member.txt";
	private static ArrayList<String[]> memberDataList = new ArrayList<>(); // 전체 회원 정보 배열

	// 관리자 회원 관리 메소드
	public static void adminMemberManage() {
		Scanner scan = new Scanner(System.in);
		String sortCriterion = "1++등급";
		String[] rateCriterionList = { "돌아가기", "1++등급", "1+등급", "1등급", "2등급", "3등급" }; // 등급별 정렬 기준

		while (true) {
			// 메인 메뉴 표시 및 사용자 선택
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("                    회원 관리");
			memberManagementFunctionList();
			String functionChoice = scan.nextLine().trim();
			scan.skip("\r\n");

			switch (functionChoice) {
			case "1":
				manageMemberList(scan, sortCriterion, rateCriterionList);
				break;
			case "2":
				break;
			case "3":
				break;
			default:
				return; // 로그인 메뉴
			}
		}
	}

	// 회원 목록 관리 메소드
	private static void manageMemberList(Scanner scan, String defaultSortCriterion, String[] rateCriterionList) {
		boolean loop = true;

		while (loop) {
			// 회원 목록 옵션 표시 및 사용자 선택
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("              전체 회원 목록 조회");
			String sortProcess = chooseSortProcess(scan);

			if (sortProcess.equals("0")) {
				return; // 관리자 메인메뉴
			}

			String sortCriterion = getSortCriterion(scan, sortProcess, rateCriterionList);

			// 사용자 선택에 따라 정렬 및 출력 수행
			try {
				BufferedReader reader = new BufferedReader(new FileReader(GUEST_LIST));

				if (sortProcess.equals("1")) {
					sortAndPrintMember(sortCriterion);
				} else if (sortProcess.equals("2")) {
					sortAndPrintMember(sortCriterion);
				} else if (sortProcess.equals("3")) {
					sortAndPrintMember(sortCriterion);
				} else if (sortProcess.equals("4")) {
					sortAndPrintMember(sortCriterion);
				}

				reader.close();
			} catch (IOException e) {
				System.out.println("manageMemberList Error");
				e.printStackTrace();
			}
		}
	}

	// 정렬 방식 선택 메소드
	private static String chooseSortProcess(Scanner scan) {
		// 정렬 방식 옵션 표시 및 사용자 선택
		displaySortMemberList();
		return scan.nextLine().trim();
	}

	// 정렬 기준 선택 메소드
	private static String getSortCriterion(Scanner scan, String sortProcess, String[] rateCriterionList) {
		String sortCriterion = "0";

		if (sortProcess.equals("1")) {
			// 등급 옵션 표시 및 사용자 선택
			displayRateCriterionList();
			String rateCriterion = scan.nextLine().trim();
			scan.skip("\r\n");

			if (Integer.parseInt(rateCriterion) > 0) { //  Integer.parseInt(rateCriterion)< rateCriterionList.length
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

	// 정렬 기준별 회원 정보 출력 메소드
	private static void displayMemberInfo(String sortCriterion, Stack<Integer> lastData, int dataCount) {
		// 헤더 출력
		System.out.println(
				"[번호]  [이름]    [아이디]      [비밀번호]  [전화번호]     [주민번호]           [이메일]          [주소]      [계좌번호]     [보유금액] [회원등급]");

		// 회원 정보 출력
		for (String[] data : memberDataList) {
			if (dataCount <= 100 && dataCount < memberDataList.size()) {
				if (lastData.isEmpty() || Integer.parseInt(data[0]) > lastData.peek()) {
					// 등급이 정렬 기준과 일치하는 회원 출력
					if (sortCriterion.equals("이름순") || sortCriterion.equals("나이순") || sortCriterion.equals("주소별")) {
						printMemberInfo(data);
						dataCount++;
					} else {
						if (data[10].equals(sortCriterion)) {
							printMemberInfo(data);
							dataCount++;
						}
					}
				}
				if (dataCount > 100) {
					lastData.push(Integer.parseInt(data[0]));
				}
			}
		}

		// 정보 출력 및 다음 동작 선택
		System.out.printf("정렬: %s (총 회원 수 %d명)%n", sortCriterion, memberDataList.size());
		displayDataList(sortCriterion, lastData.size());
	}

	// 회원을 정렬하고 출력하는 메소드
	private static void sortAndPrintMember(String sortCriterion) {
		Scanner scan = new Scanner(System.in);

		boolean groupLoop = true;
		int groupDataCount = 0;
		String groupChoice;

		Stack<Integer> lastRangeData = new Stack<>();
		lastRangeData.push(0);

		// 정렬 수행
		performSorting(sortCriterion);
		
		while (groupLoop) {
			// 회원 정보 출력
			displayMemberInfo(sortCriterion, lastRangeData, groupDataCount);

			groupChoice = scan.nextLine();
			scan.skip("\r\n");
			groupDataCount = 0;

			if (groupChoice.equals("1")) {
				// 다음 100명 보기
			} else if (lastRangeData.size() > 1 && groupChoice.equals("2")) {
				// 이전 100명 보기
				lastRangeData.pop();
				lastRangeData.pop();

				if (lastRangeData.isEmpty()) {
					lastRangeData.push(0);
				}
			} else {
				// 돌아가기
				groupLoop = false;

				while (!lastRangeData.isEmpty()) {
					lastRangeData.pop();
				}
			}
		}
	}

	// 등급별, 이름순, 나이순, 주소별 정렬 메소드
	private static void performSorting(String sortCriterion) {
		if (sortCriterion.equals("이름순")) {
			memberDataList.sort(Comparator.comparing(data -> data[1]));
			
		} else if (sortCriterion.equals("나이순")) {
			memberDataList.sort((data1, data2) -> Integer.compare(calculateAge(data1[5]), calculateAge(data2[5])));
			
		} else if (sortCriterion.equals("주소별")) {
			memberDataList.sort(Comparator.comparing(data -> data[7]));
			
			String currentAddress = "";
			for (String[] data : memberDataList) {
				String address = data[7];
				if (!address.equals(currentAddress)) {
					System.out.printf("주소: %s%n", address);
					currentAddress = address;
				}
			}
		} else {
			memberDataList.sort(Comparator.comparing(data -> data[10]));
		}
	}
	
	// 주민번호를 이용한 나이 계산 메소드
	private static int calculateAge(String jumin) {
		int birthYear = Integer.parseInt(jumin.substring(0, 2));
		int currentYear = 2023;
		int age = currentYear - (1900 + birthYear) + 1;

		if (age > 100) {
			age = age - 100;
		}

		return age;
	}

	// 회원 정보 로드 메소드
	public static void loadMemberInfo() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(GUEST_LIST));
			String member;

			while ((member = reader.readLine()) != null) {
				String[] data = member.split(",");
				memberDataList.add(data);
			}

			reader.close();

		} catch (IOException e) {
			System.out.println("loadMemberInfo Error");
			e.printStackTrace();
		}
	}

	// 회원 정보 출력 메소드
	private static void printMemberInfo(String[] data) {
		String no = data[0];
		String name = data[1];
		String id = data[2];
		String pw = data[3];
		String tel = data[4];
		String jumin = data[5];
		String email = data[6];
		String region = data[7];
		String account = data[8];
		String money = data[9];
		String rating = data[10];

		System.out.printf(" %-4s %5s %-16s %-12s %13s %14s %-24s %-5s", no, name, id, pw, tel, jumin, email, region);

		// 띄어쓰기 간격 조절
		for (int i = 0; i < 4 - region.length(); i++) {
			System.out.print(" ");
		}

		System.out.printf("%16s %,9d %7s\r\n", account, Integer.parseInt(money), rating);
	}
	
	// 회원 목록 정렬 화면 출력
	private static void displaySortMemberList() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[회원 목록 정렬]");
		System.out.println("1. 등급별 정렬");
		System.out.println("2. 이름순 정렬");
		System.out.println("3. 나이순 정렬");
		System.out.println("4. 주소별 정렬");
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력 : ");
	}

	// 등급별 정렬 방법 화면 출력
	private static void displayRateCriterionList() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[등급별 정렬]");
		System.out.println("1. 1++등급 정렬");
		System.out.println("2. 1+등급 정렬");
		System.out.println("3. 1등급 정렬");
		System.out.println("4. 2등급 정렬");
		System.out.println("5. 3등급 정렬");
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력 : ");
	}

	// 등급별 정렬 방법 화면 출력
	private static void memberManagementFunctionList() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[회원 관리 기능]");
		System.out.println("1. 전체 회원 목록 조회");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 삭제");
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력 : ");
	}

	// 회원 정보 범위 출력 화면 출력
	private static void displayDataList(String sortCriterion, int lastRangeDataSize) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.printf("[%s 별 정렬]\n", sortCriterion);
		System.out.println("1. 다음 100명 보기");
		if (lastRangeDataSize > 2) {
			System.out.println("2. 이전 100명 보기");
		}
		System.out.println("0. 돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호 입력 : ");
	}
}
