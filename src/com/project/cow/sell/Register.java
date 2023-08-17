package com.project.cow.sell;

import java.util.Scanner;

import com.project.cow.constant.Constant;

public class Register {
	Scanner scan = new Scanner(System.in);
	
	private String category;
	private String name;
	private String method;
	private String payment;
	private String condition;
	private String price;
	
	public void Screen() {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("상품등록화면");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		Category();
		Name();
		Method();
		Payment();
		Condition();
		Price();
	}
	
	private void Category() {
		System.out.println();
		System.out.println("상품 카테고리 설정");
		System.out.println("1.가구/인테리어/생활/주방\t2.디지털기기\n3.여성잡화\t4.남성잡화\t5.가공식품\n6.스포츠/레저\t7.취미/게임/음반\t8.뷰티/미용\n9.반려동물용품\t10.티켓/교환권/도서\t11.기타");
		System.out.println("");
		System.out.print("카테고리 번호: ");
		String category = scan.nextLine();
		this.category = Constant.Category(category);
		
		if (this.category.equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			Category();
		}
	}
	
	private void Name() {
		System.out.println();
		System.out.print("제목: ");
		this.name = scan.nextLine();
	}
	
	private void Method() {
		System.out.println();
		System.out.println("거래방식 설정");
		System.out.println("1.대면거래 2.택배거래 3.제3자 안전 거래");
		System.out.println();
		System.out.print("거래방식 번호: ");
		String method = scan.nextLine();
		this.method = Constant.Method(method);
		
		if (this.method.equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			Method();
		}
	}
	
	private void Payment() {
		System.out.println();
		System.out.println("결제방식 설정");
		System.out.println("1.현금거래\t2.계좌이체\r3.ITSO페이\t제3자안전거래");
		System.out.println();
		System.out.print("결제방식 번호: ");
		String payment = scan.nextLine();
		this.payment = Constant.Payment(payment);
		
		if(this.payment.equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			Payment();
		}
	}
	
	private void Condition() {
		System.out.println();
		System.out.println("물품상태 설정");
		System.out.println("1.상\t2.중\t3.하");
		System.out.println();
		System.out.print("물품상태 번호: ");
		String condition = scan.nextLine();
		this.condition = Constant.Condition(condition);
		
		if(this.condition.equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			Condition();
		}
	}
	
	private void Price() {
		System.out.println();
		System.out.println("가격 설정(0 ~ 999,999,999원)");
		System.out.println("0원일 경우, 무료 나눔으로 적용됩니다.");
		System.out.print("가격: ");
		int price = scan.nextInt();
		scan.nextLine();
		
		if(price < 0 || price > 999999999) {
			System.out.println();
			System.out.println("잘못된 가격 범위입니다.");
			Price();
		}
		
		this.price = String.format("%,d", price);
	}
	
	
}
