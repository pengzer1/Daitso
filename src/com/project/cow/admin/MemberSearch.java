package com.project.cow.admin;

import java.util.Scanner;

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
	 * - 검색한 회원 정보를 출력하고 검색 결과 개수를 보여준다.
	 */

	/**
	 * 회원 검색 기능을 수행하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	public static void searchMember(Scanner scan) {
		SoldOutStuffData.load();
		SellingStuffData.load();
		
		AdminMenu.printMenu("회원 검색");

		System.out.print("검색할 회원 번호, 이름 또는 아이디 입력: ");
		String searchKeyword = scan.nextLine().trim();

		// 검색 결과 출력
		displaySearchResult(scan, searchKeyword);
	}

	private static void displaySellingStuffForMember(Member member) {
	    
		
	}

	private static void displaySoldOutStuffForMember(Member member) {
	    
		
	}
	
	/**
	 * 검색 결과를 출력하고 검색된 회원 수를 보여주는 메소드
	 * @param scan    Scanner 사용자 입력
	 * @param keyword 검색 키워드 (회원 번호, 이름 또는 아이디)
	 */
	private static void displaySearchResult(Scanner scan, String keyword) {
		int foundCount = 0;
		AdminMenu.printMenu("회원 목록");

		for (Member member : MemberData.list) {
			
			if (member.getNo().equals(keyword) || member.getName().equals(keyword) || member.getId().equals(keyword)) {
				MemberListDisplay.displayMemberHeader(); // 헤더 출력
				MemberListDisplay.printMemberInfo(member);
				foundCount++;
				
				int sellOrBuyCount = 0;
				for (SellingStuff stuff : SellingStuffData.sellingList) {
					if (member.getNo().equals(stuff.getSellerNo())) {
						sellOrBuyCount++;
					}
				}
				
				if (sellOrBuyCount > 0) {
					System.out.println();
					System.out.printf("[판매 물품]\n");
					System.out.println(
							"[번호]          [품명]          [카테고리]    [상품품질]      [가격]         [거래방법]       [지불방법]      [판매시작일]     [판매마감일]   [찜횟수]");

					for (SellingStuff stuff : SellingStuffData.sellingList) {

						if (member.getNo().equals(stuff.getSellerNo())) {

							System.out.printf("%5s\t%-14s\t%s\t%3s\t%9s\t%-4s\t\t%-13s\t%-15s\t%-14s\t%3s\r\n"
									, stuff.getNo(), stuff.getName(), Constant.Category(stuff.getCategory())
									, Constant.Condition(stuff.getCondition()), stuff.getPrice()
									, Constant.Method(stuff.getMethod()), Constant.Payment(stuff.getPayment())
									, stuff.getFrom(), stuff.getUntil(), stuff.getLike());

						}
					}
				}

				sellOrBuyCount = 0;
				for (SoldOutStuff stuff : SoldOutStuffData.soldOutList) {
					if (member.getNo().equals(stuff.getBuyerNo())) {
						sellOrBuyCount++;
					}
				}

				if (sellOrBuyCount > 0) {
					System.out.println();
					System.out.printf("[구매 물품]\n");
					System.out.println(
							"[번호]          [품명]          [카테고리]    [상품품질]      [가격]         [거래방법]       [지불방법]      [구매날짜]     [판매자]");

					for (SoldOutStuff stuff : SoldOutStuffData.soldOutList) {

						if (member.getNo().equals(stuff.getBuyerNo())) {

							System.out.printf("%5s\t%-14s\t%s\t%3s\t%9s\t%-6s\t\t%-6s\t%-10s"
									, stuff.getNo(), stuff.getName(), Constant.Category(stuff.getCategory())
									, Constant.Condition(stuff.getCondition()), stuff.getPrice()
									, Constant.Method(stuff.getMethod()), Constant.Payment(stuff.getPayment()), stuff.getWhen());

							for (Member seller : MemberData.list) {
								if (seller.getNo().equals(stuff.getSellerNo())) {
									System.out.printf("%6s(%s)\r\n", seller.getName(), stuff.getSellerNo());
								}
							}
						}
					}
				}

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
}
