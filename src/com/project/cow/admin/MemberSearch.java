package com.project.cow.admin;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.project.cow.constant.Constant;
import com.project.cow.data.MemberData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.SoldOutStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.data.object.SoldOutStuff;

public class MemberSearch {
	/**
	 * 관리자 회원 검색 클래스
	 * @author 이승원
	 * 목적: 관리자가 회원 정보를 검색하는 기능을 제공하는 클래스
	 * 기능:
	 * - 회원 번호, 이름, 아이디로 검색한 회원 정보를 출력한다.
	 * - 검색한 회원의 판매한 물품과 구매한 물품 정보를 출력한다.
	 */

	/**
	 * 회원 검색 기능을 수행하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	public static void searchMember(Scanner scan) {
		SellingStuffData.load(); // 판매 중인 물품 데이터 로드
		SoldOutStuffData.load(); // 판매 완료 물품 데이터 로드

		AdminMenu.printMenu("회원 검색");

		System.out.print("검색할 회원 번호, 이름 또는 아이디 입력: ");
		String searchKeyword = scan.nextLine().trim();

		displaySearchResult(scan, searchKeyword); // 검색 결과 출력
	}

	/**
	 * 검색 결과를 출력하고 검색된 회원 수를 보여주는 메소드
	 * @param scan    Scanner 사용자 입력
	 * @param keyword 검색 키워드 (회원 번호, 이름, 아이디)
	 */
	private static void displaySearchResult(Scanner scan, String keyword) {
		int foundCount = 0; // 검색된 회원 수
		AdminMenu.printMenu("회원 목록");

		Set<String> sellingStuffNo = new HashSet<>(); // 출력한 판매 물품 번호를 저장하는 Set
		Set<String> SoldOutStuffNo = new HashSet<>(); // 출력한 구매 물품 번호를 저장하는 Set

		for (Member member : MemberData.list) {

			// 회원 번호, 이름, 아이디 중 검색 키워드와 일치하는지 확인
			if (member.getNo().equals(keyword) || member.getName().equals(keyword) || member.getId().equals(keyword)) {
				foundCount++;

				MemberListDisplay.displayMemberHeader(); // 헤더 출력
				MemberListDisplay.printMemberInfo(member); // 회원 출력

				sellingStuffMember(member, sellingStuffNo); // 회원의 판매 물품 출력
				soldOutStuffMember(member, SoldOutStuffNo); // 회원의 구매 물품 출력

				AdminMenu.printLine();
			}
		}

		if (foundCount == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.printf("%d명의 회원이 검색되었습니다.%n", foundCount);
		}

		scan.nextLine();
	}

	/**
	 * 회원이 판매한 물품 목록을 출력하는 메소드
	 * @param member         회원 객체
	 * @param displayStuffNo 판매 물품 번호를 저장하는 Set
	 */
	private static void sellingStuffMember(Member member, Set<String> displayStuffNo) {
		int sellOrBuyCount = 0;

		for (SellingStuff stuff : SellingStuffData.sellingList) {
			// 판매자 번호와 물품 번호를 비교하여 이전에 출력한 물품이 아닌 경우에만 출력
			if (member.getNo().equals(stuff.getSellerNo()) && !displayStuffNo.contains(stuff.getNo())) {
				sellOrBuyCount++;

				if (sellOrBuyCount == 1) {
					System.out.println();
					System.out.printf("[판매 물품]\n");
					System.out.println(
							"[번호]          [품명]          [카테고리]    [상품품질]      [가격]         [거래방법]       [지불방법]      [판매시작일]     [판매마감일]   [찜횟수]");
				}

				System.out.printf("%5s\t%-14s\t%s\t%3s\t%9s\t%-4s\t%-13s\t%-15s\t%-14s\t%3s\r\n", stuff.getNo(),
						stuff.getName(), Constant.Category(stuff.getCategory()),
						Constant.Condition(stuff.getCondition()), stuff.getPrice(), Constant.Method(stuff.getMethod()),
						Constant.Payment(stuff.getPayment()), stuff.getFrom(), stuff.getUntil(), stuff.getLike());

				displayStuffNo.add(stuff.getNo()); // 출력한 물품 번호를 저장하여 중복 출력 방지
			}
		}
	}

	/**
	 * 회원이 구매한 물품 목록을 출력하는 메소드
	 * @param member         회원 객체
	 * @param displayStuffNo 구매 물품 번호를 저장하는 Set
	 */
	private static void soldOutStuffMember(Member member, Set<String> displayStuffNo) {
		int sellOrBuyCount = 0;

		for (SoldOutStuff stuff : SoldOutStuffData.soldOutList) {
			// 구매자 번호와 물품 번호를 비교하여 이전에 출력한 물품이 아닌 경우에만 출력
			if (member.getNo().equals(stuff.getBuyerNo()) && !displayStuffNo.contains(stuff.getNo())) {
				sellOrBuyCount++;

				if (sellOrBuyCount == 1) {
					System.out.println();
					System.out.printf("[구매 물품]\n");
					System.out.println(
							"[번호]          [품명]          [카테고리]    [상품품질]      [가격]         [거래방법]       [지불방법]      [구매날짜]     [판매자]");
				}

				System.out.printf("%5s\t%-14s\t%s\t%3s\t%9s\t%-6s\t%-6s\t%-10s", stuff.getNo(), stuff.getName(),
						Constant.Category(stuff.getCategory()), Constant.Condition(stuff.getCondition()),
						stuff.getPrice(), Constant.Method(stuff.getMethod()), Constant.Payment(stuff.getPayment()),
						stuff.getWhen());

				// 해당 물품의 판매자 정보 출력
				for (Member seller : MemberData.list) {
					if (seller.getNo().equals(stuff.getSellerNo())) {
						System.out.printf("%6s(%s)\r\n", seller.getName(), stuff.getSellerNo());
					}
				}

				displayStuffNo.add(stuff.getNo()); // 출력한 물품 번호를 저장하여 중복 출력 방지
			}
		}
	}
}
