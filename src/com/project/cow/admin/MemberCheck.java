package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MemberCheck {

	/*
	 * 관리자 회원 관리 클래스
	 * 
	 * @author 이승원
	 */

	private static final String GUEST_LIST = "C:\\Class\\code\\java\\Daitso\\src\\com\\project\\cow\\admin\\Data\\member.txt";
	private static ArrayList<String[]> memberDataList = new ArrayList<>(); // 전체 회원 정보 배열

	// 전체 회원 목록 조회 메소드
	public static void adminMemberManage() {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		String sortprocess = "1"; // 기본 정렬 방법: 등급별 정렬
		String sortCriterion = "1++등급"; // 기본 정렬 기준: 1++등급
		String[] rateCriterionList = { "돌아가기", "1++등급", "1+등급", "1등급", "2등급", "3등급" }; // 등급별 정렬 기준
		int memberCount = 0; // 정렬하는 멤버 누적

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("              전체 회원 목록 조회");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		while (loop) {

			try {
				BufferedReader reader = new BufferedReader(new FileReader(GUEST_LIST));
				String member;

				System.out.println(
						"[번호] [이름]    [아이디]      [비밀번호]  [전화번호]     [주민번호]           [이메일]          [주소]      [계좌번호]     [보유금액] [회원등급]");

				if (sortprocess.equals("1")) {
					// 등급별로 정렬하여 출력
					for (String[] data : memberDataList) {

						if (data[10].equals(sortCriterion)) {
							printMemberInfo(data);
							memberCount++;
						}
					}
				} else if (sortprocess.equals("2")) {
					// 이름순으로 정렬하여 출력
					sortAndPrintByName();
				} else if (sortprocess.equals("3")) {
					// 나이순으로 정렬하여 출력
					sortAndPrintByAge();
				} else if (sortprocess.equals("4")) {
					// 주소별로 정렬하여 출력
					sortAndPrintByAddress();
				} else {
					// 돌아가기
					loop = false;
				}

				if (sortprocess.equals("1")) {
					System.out.printf("정렬: %s (총 회원 수 %d명 / %d명)\r\n", sortCriterion, memberDataList.size(),
							memberCount);
				} else {
					System.out.printf("정렬: %s (총 회원 수 %d명)\r\n", sortCriterion, memberDataList.size());
				}
				reader.close();

			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}

			/*
			 * System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			 * System.out.println("[회원 목록 정렬]"); System.out.println("1. 등급별 정렬");
			 * System.out.println("2. 이름순 정렬"); System.out.println("3. 나이순 정렬");
			 * System.out.println("4. 주소별 정렬"); System.out.println("0. 돌아가기");
			 * System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			 * System.out.print("번호 입력 : ");
			 */
			// 회원 목록 정렬 방법 선택
			displaySortMemberList();
			sortprocess = scan.nextLine().trim();
			scan.skip("\r\n");

			if (sortprocess.equals("1")) {
				/*
				 * System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				 * System.out.println("[등급별 정렬]"); System.out.println("1. 1++등급 정렬");
				 * System.out.println("2. 1+등급 정렬"); System.out.println("3. 1등급 정렬");
				 * System.out.println("4. 2등급 정렬"); System.out.println("5. 3등급 정렬");
				 * System.out.println("0. 돌아가기");
				 * System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				 * System.out.print("번호 입력 : ");
				 */
				// 등급별 정렬
				displayRateCriterionList();
				String rateCriterion = scan.nextLine().trim();
				scan.skip("\r\n");

				if (Integer.parseInt(rateCriterion) >= 0
						&& Integer.parseInt(rateCriterion) < rateCriterionList.length) {
					sortCriterion = rateCriterionList[Integer.parseInt(rateCriterion)];

					if (sortCriterion.equals("돌아가기")) {
						loop = false;
					}
				} else {
					sortprocess = "1";
					sortCriterion = "1++등급";
					loop = false;
				}
			} else if (sortprocess.equals("2")) {
				// 이름순 정렬
				sortCriterion = "이름순";
			} else if (sortprocess.equals("3")) {
				// 나이순 정렬
				sortCriterion = "나이순";
			} else if (sortprocess.equals("4")) {
				// 주소별 정렬
				sortCriterion = "주소별";
			} else {
				// 돌아가기
				loop = false;
			}
		}
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

	// 이름순 정렬 및 출력
	private static void sortAndPrintByName() {
		memberDataList.sort(Comparator.comparing(data -> data[1]));
		memberDataList.forEach(MemberCheck::printMemberInfo);
	}

	// 나이순 정렬 및 출력
	private static void sortAndPrintByAge() {
		memberDataList.sort((data1, data2) -> Integer.compare(calculateAge(data1[5]), calculateAge(data2[5])));
		memberDataList.forEach(MemberCheck::printMemberInfo);
	}

	// 주소별 정렬 및 출력
	private static void sortAndPrintByAddress() {
		memberDataList.sort(Comparator.comparing(data -> data[7]));
		String currentAddress = "";

		for (String[] data : memberDataList) {
			String address = data[7];
			if (!address.equals(currentAddress)) {
				System.out.printf("주소: %s%n", address);
				currentAddress = address;
			}
			printMemberInfo(data);
		}
	}

	// 주민번호 나이 계산 메소드
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

		System.out.printf("%4s %5s %-14s %-12s %13s %14s %-24s %-5s", no, name, id, pw, tel, jumin, email, region);

		// 띄어쓰기 간격 조절
		for (int i = 0; i < 4 - region.length(); i++) {
			System.out.print(" ");
		}

		System.out.printf("%16s %,9d %7s\r\n", account, Integer.parseInt(money), rating);
	}
}
