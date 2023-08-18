package com.project.cow.member.sell;

import java.util.Scanner;

import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class Modify {
	private static final int SELLER = 6023;
	Scanner scan = new Scanner(System.in);

	public void Screen() {
		ModifyDetail modifyDetail = new ModifyDetail();
		
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[판매 등록 현황]");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.println("[번호]\t[제목]\t\t[카테고리]\t[물건 상태]\t[판매 가격]\t[판매자명]\t[상품 거래 방식]\t[결제 방식]\t[등록 날짜]\t[마감 날짜]\t[찜]");
		for (SellingStuff s : SellingStuffData.sellingList) {
			if (s.getSellerNo().equals(SELLER + "")) {
				System.out.printf("%s\t%s\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t%s\n", s.getNo(), s.getName(), Constant.Category(s.getCategory()), Constant.Condition(s.getCondition()), s.getPrice(), "판매자번호", Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(), s.getLike());
			}
		}

		System.out.println();
		System.out.println("상품 정보를 수정하시겠습니까?");
		Check();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("수정하실 상품 번호를 입력해주세요.");
		System.out.println();
		
		SellingStuff s = GetStuff();
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();

		modifyDetail.Screen(s);
	}
	
	private void Check() {
		SellMenu sellMenu = new SellMenu();
		System.out.println("1.수정하기\t0.돌아가기");
		System.out.print("번호입력: ");
		String check = scan.nextLine();
		
		if (check.equals("0")) {
			System.out.println();
			System.out.println();
			sellMenu.Screen();
		} else if (check.equals("1")) {
			
		} else {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Check();
		}
	}
	
	private SellingStuff GetStuff() {
		System.out.print("번호입력: ");
		String no = scan.nextLine();
		
		SellingStuff sellingStuff = new SellingStuff("", null, null, null, null, null, null, null, null, null, null);
		
		for (SellingStuff s : SellingStuffData.sellingList) {
			if (s.getSellerNo().equals(SELLER + "") && s.getNo().equals(no)) {
				sellingStuff = s;
				break;
			}
		}
		
		if(sellingStuff.getNo().equals("")) {
			System.out.println();
			System.out.println("잘못된 상품 번호입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			GetStuff();
		}
		
		return sellingStuff;
	}
	
}
