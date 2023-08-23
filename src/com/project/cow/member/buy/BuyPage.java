package com.project.cow.member.buy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.cow.constant.Constant;
import com.project.cow.data.LikeItemData;
import com.project.cow.data.TradeStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.data.object.TradeStuff;
import com.project.cow.login.Login;

public class BuyPage {

	public static void buyPage(SellingStuff stuff) {
		Scanner sc = new Scanner(System.in);
		String startDateStr = "", endDateStr = "";
		Member buyer = Login.login;
		com.project.cow.data.object.LikeItem likeItem;

		System.out.println("<   판매 페이지 입니다~!   >");
		System.out.println();
		System.out.println("[번호]\t\t[품명]\t\t[상품품질]\t[가격]\t\t[판매자]\t[거래방법]\t\t[지불방법]\t\t[판매시작일]\t\t[판매마감일]\t\t[찜횟수]");

		
			System.out.printf("%5s\t%-14s\t%s\t%9s\t%8s\t%-6s\t\t%-13s\t%-15s\t%-14s\t%3s\r\n", stuff.getName(),
					Constant.Category(stuff.getCategory()), Constant.Condition(stuff.getCondition()), stuff.getPrice(),
					stuff.getSellerNo(), Constant.Method(stuff.getMethod()), Constant.Payment(stuff.getPayment()),
					stuff.getFrom(), stuff.getUntil(), stuff.getLike());
			startDateStr = stuff.getFrom();
			endDateStr = stuff.getUntil();
		

		boolean loop = true;
		while (loop) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 구매하기\n2. 찜하기");
			System.out.print("번호를 선택해주세요. : ");
			String choice = sc.nextLine();

			if (choice.equals("1")) { // 구매하기
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("물품 거래 날짜를 선택하세요");
				System.out.println("날짜 설정하기");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("구매가 가능하신 날짜는 " + startDateStr + "부터 " + endDateStr + "까지입니다.");
				System.out.print("구매하고 싶은 날짜 (yyyy-MM-dd): "); // 유효성 검사..?
				String checkDateStr = sc.nextLine();

				LocalDate startDate = LocalDate.parse(startDateStr);
				LocalDate endDate = LocalDate.parse(endDateStr);
				LocalDate checkDate = LocalDate.parse(checkDateStr);

				if (isWithinDateRange(checkDate, startDate, endDate)) {
					System.out.println("물품 구매를 진행합니다. 선택하신 제품이 마이페이지 알림설정에 등록되었습니다.");
					
					TradeStuff tradeStuff = new TradeStuff(stuff.getNo(), stuff.getName(), stuff.getCategory(),
									stuff.getPrice(), stuff.getMethod(), stuff.getPayment(), stuff.getCondition(),
									checkDateStr, stuff.getSellerNo(), buyer.getNo());

					TradeStuffData.tradeList.add(tradeStuff); // 한 번에 tradeList에 추가
					TradeStuffData.tradeStuffSave();
					// ->마이페이지 알림설정에 저장되게 하기
					while (loop) {
						System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
						System.out.println("처음으로 돌아가려면 0번을 누르세요.");
						System.out.print("번호 입력하기 : ");
						String input = sc.nextLine();
						if (input.equals("0")) {
							BuyMenu.FirstScreen(); // 구매자의 처음화면
							loop = false;
							break;
						} else
							System.out.println("올바른 번호를 입력해 주십시오.");
					}

				} else
					System.out.println("해당 기간에 물품을 판매하지 않습니다.");

			} else if (choice.equals("2")) { 
				likeItem = new com.project.cow.data.object.LikeItem((LikeItemData.likeList.size() + 1) + "", stuff.getNo(), buyer.getNo());
				LikeItemData.likeList.add(likeItem);
				LikeItemData.likeItemSave();
				System.out.println("찜 목록에 추가되었습니다.");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("엔터를 누르면 구매자 화면으로 돌아갑니다.");
				sc.nextLine();
				BuyMenu.FirstScreen();

			} else
				System.out.println("번호를 올바르게 입력해 주십시오.");
		}

	}

	private static boolean isWithinDateRange(LocalDate checkDate, LocalDate startDate, LocalDate endDate) {
		return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
	}

}
