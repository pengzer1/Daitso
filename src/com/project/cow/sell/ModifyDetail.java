package com.project.cow.sell;

import java.util.Calendar;
import java.util.Scanner;

import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class ModifyDetail {
//	TODO 추후 로그인 된 사용자 번호로 변경해야 함


	Scanner scan = new Scanner(System.in);

	Modify modify = new Modify();
	
	public void Screen(SellingStuff s) {
		System.out.println("[번호]\t[제목]\t\t[카테고리]\t[물건 상태]\t[판매 가격]\t[판매자명]\t[상품 거래 방식]\t[결제 방식]\t[등록 날짜]\t[마감 날짜]\t[찜]");
		System.out.printf("%s\t%s\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t%s\n", s.getNo(), s.getName(), Constant.Category(s.getCategory()), Constant.Condition(s.getCondition()), s.getPrice(), "판매자번호", Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(), s.getLike());
		System.out.println();
		
		System.out.println("1.제목 수정하기\t\t2.판매 기간 수정하기\r\n3.판매 가격 수정하기\t4.삭제하기\t0.돌아가기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("번호입력: ");
		Check(s);
	}
	
	private void Check(SellingStuff s) {
		
		String check = scan.nextLine();
		
		if (check.equals("1")) {
			ChangeName(s);
		}
		else if (check.equals("2")) {
			ChangeDate(s);
		}
		else if (check.equals("3")) {
			ChangePrice(s);
		}
		else if (check.equals("4")) {
			DeleteStuff(s);
		}
		else if (check.equals("0")) {
			modify.Screen();
		}
		else {
			System.out.println("재입력");
			Check(s);
		}
	}

	private void ChangeName(SellingStuff s) {
//		TODO 판매 등록에서 썼던 이름 유효성 검사 여기서도 해야댐
		System.out.println();
		System.out.println("변경하고 싶은 제목을 입력하세요.");
		System.out.print("제목: ");
		String name = scan.nextLine();
		
		s.setName(name);
		
		System.out.println();
		System.out.println("변경이 완료되었습니다.");
		System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
		scan.nextLine();
		
		modify.Screen();
	}

	private void ChangeDate(SellingStuff s) {
		System.out.println();
		System.out.println("변경하실 기간을 입력하세요. (1~30일 사이)");
		System.out.println("기간은 변경하신 당일부터 시작되는 것으로 변경됩니다.");
		System.out.print("일 수: ");
		String date = scan.nextLine();
		
		if (Integer.parseInt(date) < 1 || Integer.parseInt(date) > 30) {
			System.out.println();
			System.out.println("잘못된 일 수입니다. 다시 입력해 주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			ChangeDate(s);
		}
		
		Calendar until = Calendar.getInstance();
		s.setFrom(String.format("%tF", until));
		
		until.add(Calendar.DATE, Integer.parseInt(date));
		s.setUntil(String.format("%tF", until));
		
		System.out.println();
		System.out.println("변경이 완료되었습니다.");
		System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
		scan.nextLine();
		
		modify.Screen();
	}

	private void ChangePrice(SellingStuff s) {
		System.out.println();
		System.out.println("변경하실 금액을 입력하세요. (0 ~ 999,999,999원)");
		System.out.println("0원일 경우, 무료 나눔으로 적용됩니다.");
		System.out.println("1,000원 단위만 가능합니다.");
		System.out.print("금액: ");
		int price = scan.nextInt();
		scan.nextLine();
		
		if(price < 0 || price > 999999999) {
			System.out.println();
			System.out.println("잘못된 가격 범위입니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			ChangePrice(s);
		} else if(price % 1000 != 0) {
			System.out.println();
			System.out.println("잘못된 가격 범위입니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			ChangePrice(s);
		} else {
			s.setPrice(price + "");
			
			System.out.println();
			System.out.println("변경이 완료되었습니다.");
			System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
			scan.nextLine();
			
			modify.Screen();
		}
		
	}

	private void DeleteStuff(SellingStuff s) {
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("정말 삭제하시겠습니까?");
		System.out.println("1.네\t\t0.아니오");
		System.out.print("번호입력: ");
		
		String check = scan.nextLine();
		
		if(check.equals("1")) {
			String num = s.getNo();
//			SellingStuffData.sellingList.remove(s);
			
			for (int i = Integer.parseInt(num); i < SellingStuffData.sellingList.size(); i++) {
				SellingStuff sellingStuff = SellingStuffData.sellingList.get(i);
				sellingStuff.setNo(i + "");
				SellingStuffData.sellingList.set(i - 1, SellingStuffData.sellingList.get(i));
			}
			SellingStuffData.sellingList.remove(SellingStuffData.sellingList.size() - 1);
			System.out.println();
			System.out.println("삭제가 완료되었습니다.");
			System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
			scan.nextLine();
			
			modify.Screen();
		}
		else if (check.equals("0")) {
			modify.Screen();
		}
		else {
			System.out.println();
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			DeleteStuff(s);
		}
		
	}
	
}
