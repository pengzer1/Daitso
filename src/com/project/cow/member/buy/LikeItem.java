package com.project.cow.member.buy;

import java.util.Scanner;

import com.project.cow.constant.Constant;
import com.project.cow.data.LikeItemData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class LikeItem {
//	TODO 추후 로그인 된 사용자 번호로 변경해야 함
	private static final int BUYER = 3702;
	
	Scanner scan = new Scanner(System.in);
	
	public void Screen() {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[찜 목록 현황]");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.println("[번호]\t[제목]\t\t[카테고리]\t[물건 상태]\t[판매 가격]\t[판매자명]\t[상품 거래 방식]\t[결제 방식]\t[등록 날짜]\t[마감 날짜]\t[찜]");
		for (com.project.cow.data.object.LikeItem likeItem : LikeItemData.likeList) {
			if (likeItem.getBuyerNo().equals(BUYER + "")) {
				String no = likeItem.getItemNo();
				
				for(SellingStuff s : SellingStuffData.sellingList) {
					if(s.getNo().equals(no)) {
						System.out.printf("%s\t%s\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t%s\n", s.getNo(), s.getName(), Constant.Category(s.getCategory()), Constant.Condition(s.getCondition()), s.getPrice(), "판매자번호", Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(), s.getLike());
						break;
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("원하시는 찜 상품을 골라주세요.");
		System.out.println();
		
		GetStuff();
		
		System.out.println("구매 활동을 선택하세요.");
		
		Check();
	}

	private void GetStuff() {
		System.out.print("상품번호입력: ");
		String no = scan.nextLine();
		
		com.project.cow.data.object.LikeItem likeItem = new com.project.cow.data.object.LikeItem(null, "", null);
		
		for (com.project.cow.data.object.LikeItem l : LikeItemData.likeList) {
			if (l.getBuyerNo().equals(BUYER + "") && l.getItemNo().equals(no)) {
				likeItem = l;
				break;
			}
		}
		
		if (likeItem.getItemNo().equals("")) {
			System.out.println();
			System.out.println("잘못된 상품 번호입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			GetStuff();
		}
		
	}

	private void Check() {
		System.out.println("1.물품 구매\t2.물품 검색\t3.물품 정렬\r\n4.찜 물품 삭제\t0.돌아가기");
		System.out.print("번호입력: ");
		String check = scan.nextLine();
		
		if (check.equals("1")) {
			
		}
		else if (check.equals("2")) {
			
		}
		else if (check.equals("3")) {
			
		}
		else if (check.equals("4")) {
			DeleteLikeItem();
		}
		else if (check.equals("0")) {
			System.out.println();
			System.out.println();
			BuyMenu.FirstScreen();
		}
		else {
			System.out.println();
			System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			System.out.println();
			Check();
		}
	}

	private void DeleteLikeItem() {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("정말 삭제하시겠습니까?");
		System.out.println("1.네\t\t0.아니오");
		System.out.print("번호입력: ");
		
		String check = scan.nextLine();
		
		if (check.equals("1")) {
//			String
		}
		else if (check.equals("0")) {
			BuyMenu.FirstScreen();
		}
		else {
			System.out.println();
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			DeleteLikeItem();
		}
	}
	
}
