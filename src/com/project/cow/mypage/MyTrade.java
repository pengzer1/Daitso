package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.admin.AdminMenu;
import com.project.cow.constant.Constant;
import com.project.cow.data.Data;
import com.project.cow.data.MemberData;
import com.project.cow.data.TradeStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.TradeStuff;

public class MyTrade {
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}

	public void tradeScreen(User user) {
		AdminMenu.printMenu("현재 진행중인 거래");
		System.out.println("[번호]\t\t[품명]\t\t[카테고리]\t[가격]\t[거래방법]\t[결제방식]\t[물품상태]\t[거래일자]\t[판매자]\t[구매자]");

//		for (int i = 0; i < Data.tradeList.size(); i++) {
//			if (user.getNumber().equals(Data.tradeList.get(i).getBuyNum())) {
//				TradeStuff item = Data.tradeList.get(i);
//				System.out.printf("%2s %-8s %8s %12s %8s %10s %11s %16s %7s %10s\n", item.getNum(), item.getName(),
//						item.getCategory(), item.getPrice(), item.getTransactionMethod(), item.getPaymentMethod(),
//						item.getStatus(), item.getTransactionData(), item.getSellNum(), item.getBuyNum());
//			}
//		}
		
		for (TradeStuff item : TradeStuffData.tradeList) {
			if (item.getBuyerNo().equals(user.getNumber()) || item.getSellerNO().equals(user.getNumber())) {
				System.out.printf("%2s %-8s %8s %12s %8s %10s %11s %16s %7s %10s", item.getNo(), item.getName(),
						Constant.Category(item.getCategory()), item.getPrice(), Constant.Method(item.getMethod()), Constant.Payment(item.getPayment()), Constant.Condition(item.getCondition()),
						item.getTradedate(), item.getSellerNO(), item.getBuyerNo());
				// 해당 물품의 판매자 정보 출력
				for (Member seller : MemberData.list) {
					if (seller.getNo().equals(item.getSellerNO())) {
						System.out.printf(" %6s ", seller.getName());
						break;
					}
				}
				
				// 해당 물품의 판매자 정보 출력
				for (Member buyer : MemberData.list) {
					if (buyer.getNo().equals(item.getBuyerNo())) {
						System.out.printf(" %6s \n", buyer.getName());
						break;
					}
				}
			}
		}

		System.out.println("Enter를 누르면 마이페이지로 돌아갑니다.");
		scan.nextLine().trim();
		MyPageList myPageList = new MyPageList(user);
		myPageList.myPageScreen();

	}
}
