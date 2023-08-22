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

	/**
	 * 검색 결과를 출력하고 검색된 회원 수를 보여주는 메소드
	 * @param scan    Scanner 사용자 입력
	 * @param keyword 검색 키워드 (회원 번호, 이름 또는 아이디)
	 */
	private static void displaySearchResult(Scanner scan, String keyword) {
		int foundCount = 0;
		AdminMenu.printMenu("회원 목록");

		MemberListDisplay.displayMemberHeader(); // 헤더 출력

		for (Member member : MemberData.list) {
			if (member.getNo().equals(keyword) || member.getName().equals(keyword) || member.getId().equals(keyword)) {
				MemberListDisplay.printMemberInfo(member);
				foundCount++;
				
				int sellorBuyCount = 0;
				for (SellingStuff stuff : SellingStuffData.sellingList) {
					if (member.getNo().equals(stuff.getSellerNo())) {
						sellorBuyCount++;
					}
				}
				
				if (sellorBuyCount > 0) {
					System.out.println();
					System.out.printf("[%s번 %3s 회원의 판매 물품]\n", member.getNo(), member.getName());
					System.out.println("[번호]               [품명]     [상품품질]      [가격]    [판매자]         [거래방법]       [지불방법]      [판매시작일]     [판매마감일]   [찜횟수]");
	
					for (SellingStuff stuff : SellingStuffData.sellingList) {
						if (member.getNo().equals(stuff.getSellerNo())) {
							System.out.printf("%5s %15s %11s %9s %10s %13s %13s %13s %13s %8s\r\n", stuff.getNo(), stuff.getName(),
									Constant.Condition(stuff.getCategory()), stuff.getPrice(), stuff.getSellerNo(),
									Constant.Method(stuff.getMethod()), Constant.Payment(stuff.getPayment()), stuff.getFrom(), stuff.getUntil(),
									stuff.getLike());
						}
					}
				}
					
				sellorBuyCount = 0;
				for (SoldOutStuff stuff : SoldOutStuffData.soldOutList) {
					if (member.getNo().equals(stuff.getSellerNo())) {
						sellorBuyCount++;
					}
				}
				
				if (sellorBuyCount > 0) {
					System.out.println();
					System.out.printf("[%s번 %3s 회원의 구매 물품]\n", member.getNo(), member.getName());
				}
			}
		}

		AdminMenu.printLine();
		if (foundCount == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.printf("%d명의 회원이 검색되었습니다.%n", foundCount);
		}

		scan.nextLine();
	}
}
