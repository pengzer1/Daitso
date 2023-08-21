package com.project.cow.member.sell;

import java.util.Calendar;
import java.util.Scanner;

import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class Register {
	SellingStuffData sellingStuffData = new SellingStuffData();
	
	Scanner scan = new Scanner(System.in);
	
	private String category;
	private String name;
	private String method;
	private String payment;
	private String condition;
	private String price;
	private String from;
	private String until;
	
	public void Screen() {
		SellMenu sellMenu = new SellMenu();
		
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("상품등록화면");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		Check();
		
		String maxNo = SellingStuffData.sellingList.stream().map(s -> s.getNo()).max((a, b) -> Integer.parseInt(a) - Integer.parseInt(b)).get();
		
		int no = Integer.parseInt(maxNo) + 1;
		
//		TODO 마지막 sellerNo는 로그인되어 있는 사용자 번호로 변경해야함
		SellingStuff s = new SellingStuff(no + "", name, category, price, method, payment, condition, from, until, "0", "6000");
		
		SellingStuffData.sellingList.add(s);
		
		System.out.println("등록이 완료되었습니다.");
		System.out.println("Enter를 누르면 초기화면으로 돌아갑니다.");
		
		scan.nextLine();
		sellingStuffData.save();
		sellMenu.Screen();
	}
	
	private void Check() {
		SellMenu sellMenu = new SellMenu();
		
		System.out.println();
		System.out.println("상품을 등록하시겠습니까?");
		System.out.println("1.등록하기\t0.돌아가기");
		System.out.print("번호입력: ");
		String check = scan.nextLine();
		
		if (check.equals("0")) {
			System.out.println();
			System.out.println();
			sellMenu.Screen();
		} else if (check.equals("1")) {
			Registering();
		} else {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Check();
		}
	}
	
	private void Registering() {
		Category();
		Name();
		Method();
		Payment();
		Condition();
		Price();
		Until();
	}
	
	private void Category() {
		System.out.println();
		System.out.println("상품 카테고리 설정");
		System.out.println("1.가구/인테리어/생활/주방\t2.디지털기기\n3.여성잡화\t4.남성잡화\t5.가공식품\n6.스포츠/레저\t7.취미/게임/음반\t8.뷰티/미용\n9.반려동물용품\t10.티켓/교환권/도서\t11.기타");
		System.out.println("");
		System.out.print("카테고리 번호: ");
		this.category = scan.nextLine();
		
		if (Constant.Category(this.category).equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Category();
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	private void Name() {
		System.out.println();
		System.out.print("제목: ");
		this.name = scan.nextLine();
		//TODO 제목에 검열 시스템 추가해야됨
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	private void Method() {
		System.out.println();
		System.out.println("거래방식 설정");
		System.out.println("1.대면거래 2.택배거래 3.제3자 안전 거래");
		System.out.println();
		System.out.print("거래방식 번호: ");
		this.method = scan.nextLine();
		
		if (Constant.Method(this.method).equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Method();
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	private void Payment() {
		System.out.println();
		System.out.println("결제방식 설정");
		System.out.println("1.현금거래\t2.계좌이체\r3.ITSO페이\t4.제3자안전거래");
		System.out.println();
		System.out.print("결제방식 번호: ");
		this.payment = scan.nextLine();
		
		if(Constant.Payment(this.payment).equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Payment();
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	private void Condition() {
		System.out.println();
		System.out.println("물품상태 설정");
		System.out.println("1.상\t2.중\t3.하");
		System.out.println();
		System.out.print("물품상태 번호: ");
		this.condition = scan.nextLine();
		
		if(Constant.Condition(this.condition).equals("")) {
			System.out.println();
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Condition();
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	private void Price() {
		System.out.println();
		System.out.println("가격 설정(0 ~ 999,999,999원)");
		System.out.println("0원일 경우, 무료 나눔으로 적용됩니다.");
		System.out.println("1,000원 단위만 가능합니다.");
		System.out.println();
		System.out.print("가격: ");
		int price = scan.nextInt();
		scan.nextLine();
		
		if(price < 0 || price > 999999999) {
			System.out.println();
			System.out.println("잘못된 가격 범위입니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Price();
		} else if(price % 1000 != 0) {
			System.out.println();
			System.out.println("잘못된 가격 범위입니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Price();
		} else {
			this.price = price + "";
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		}
	}
	
	private void Until() {
		Calendar c = Calendar.getInstance();
		this.from = String.format("%tF", c);
		
		int date;
		
		System.out.println();
		System.out.println("날짜 설정");
		System.out.println("오늘부터 며칠 후까지 판매하실지 설정하세요.(최대 30일)");
		System.out.println();
		System.out.print("며칠: ");
		date = scan.nextInt();
		if (date < 0 || date > 30) {
			System.out.println();
			System.out.println("잘못된 날짜입니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			Until();
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		scan.nextLine();
		
		c.add(Calendar.DATE, date);
		this.until = String.format("%tF", c);
	}
	
}
