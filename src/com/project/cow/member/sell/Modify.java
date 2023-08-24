package com.project.cow.member.sell;

import java.util.Scanner;

import com.project.cow.admin.AdminMenu;
import com.project.cow.constant.Constant;
import com.project.cow.data.object.Member;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.login.Login;

public class Modify {
	Member seller = Login.login;
	Scanner scan = new Scanner(System.in);
	private String no;
	SellingStuff s;

	public void Screen() {
		ModifyDetail modifyDetail = new ModifyDetail();
		
		System.out.println();
		AdminMenu.printMenu("판매 등록 현황");
		
		System.out.println("[번호]\t[제목]\t\t[카테고리]\t[물건 상태]\t[판매 가격]\t[판매자명]\t[상품 거래 방식]\t[결제 방식]\t[등록 날짜]\t[마감 날짜]\t[찜]");
		for (SellingStuff s : SellingStuffData.sellingList) {
			if (s.getSellerNo().equals(seller.getNo())) {
				System.out.printf("%s\t%s\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t%s\n", s.getNo(), s.getName(), Constant.Category(s.getCategory()), Constant.Condition(s.getCondition()), s.getPrice(), "판매자번호", Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(), s.getLike());
			}
		}

		System.out.println();
		System.out.println("상품 정보를 수정하시겠습니까?");
		Check();
		AdminMenu.printLine();
		System.out.println();
		System.out.println("수정하실 상품 번호를 입력해주세요.");
		System.out.println();
		
		GetStuff();
		
		AdminMenu.printLine();
		System.out.println();

		modifyDetail.Screen(s);
	}
	
	private void Check() {
		SellMenu sellMenu = new SellMenu();
		AdminMenu.printOption("수정하기");
//		System.out.print("번호입력: ");
		String check = scan.nextLine();
		
		if (check.equals("0")) {
			System.out.println();
			System.out.println();
			sellMenu.Screen();
		} else if (check.equals("1")) {} 
		else {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
			AdminMenu.printLine();
			Check();
		}
	}
	
	private void GetStuff() {
		System.out.println("선택을 취소하려면 0을 입력하세요.");
		System.out.print("상품번호입력: ");
		
		this.no = scan.nextLine().trim();
		
		
		SellingStuff sellingStuff = new SellingStuff("", null, null, null, null, null, null, null, null, null, null);
		
		if(no.equals("0")) {
			Screen();
		}
		
		for (SellingStuff s : SellingStuffData.sellingList) {
			if (s.getSellerNo().equals(seller.getNo()) && s.getNo().equals(no)) {
				sellingStuff = s;
				break;
			}
		}

		this.s = sellingStuff;
		if(sellingStuff.getNo().equals("")) {
			System.out.println();
			System.out.println("잘못된 상품 번호입니다. 다시 입력해주세요.");
			AdminMenu.printLine();
			GetStuff();
		}
		else {
			this.s = sellingStuff;
		}
	}
	
}
