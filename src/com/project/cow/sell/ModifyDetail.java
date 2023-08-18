package com.project.cow.sell;

import java.util.Calendar;
import java.util.Scanner;

import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class ModifyDetail {
//	TODO 추후 로그인 된 사용자 번호로 변경해야 함
	private static final int SELLER = 3510;

	Scanner scan = new Scanner(System.in);

	Modify modify = new Modify();
	
	public void Screen(String n) {
		System.out.print("번호입력: ");
		Check(n);
	}
	
	private void Check(String n) {
		
		String check = scan.nextLine();
		
		if (check.equals("1")) {
			ChangeName(n);
		}
		else if (check.equals("2")) {
			ChangeDate(n);
		}
		else if (check.equals("3")) {
			ChangePrice(n);
		}
		else if (check.equals("4")) {
			DeleteStuff(n);
		}
		else if (check.equals("0")) {
			modify.Screen();
		}
		else {
			System.out.println("재입력");
			Check(n);
		}
	}

	private void ChangeName(String n) {
//		TODO 판매 등록에서 썼던 이름 유효성 검사 여기서도 해야댐
		System.out.println();
		System.out.println("변경하고 싶은 제목을 입력하세요.");
		System.out.print("제목: ");
		String name = scan.nextLine();
		
		for (SellingStuff s : SellingStuffData.sellingList) {
			if (s.getNo().equals(n) && s.getSellerNo().equals(SELLER + "")) {
				s.setName(name);
				
				SellingStuffData.sellingList.set(Integer.parseInt(n) - 1, s);
				break;
			}
		}
		
		System.out.println();
		System.out.println("변경이 완료되었습니다.");
		System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
		scan.nextLine();
		
		modify.Screen();
	}

	private void ChangeDate(String n) {
		System.out.println();
		System.out.println("변경하실 기간을 입력하세요. (1~30일 사이)");
		System.out.println("기간은 변경하신 당일부터 시작되는 것으로 변경됩니다.");
		System.out.print("일 수: ");
		String date = scan.nextLine();
		
		if (Integer.parseInt(date) < 1 || Integer.parseInt(date) > 30) {
			System.out.println();
			System.out.println("잘못된 일 수입니다. 다시 입력해 주세요.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			ChangeDate(n);
		}
		
		for (SellingStuff s : SellingStuffData.sellingList) {
			if (s.getNo().equals(n) && s.getSellerNo().equals(SELLER + "")) {
				Calendar until = Calendar.getInstance();
				s.setFrom(String.format("%tF", until));
				
				until.add(Calendar.DATE, Integer.parseInt(date));
				s.setUntil(String.format("%tF", until));
				
				SellingStuffData.sellingList.set(Integer.parseInt(n) - 1, s);
				break;
			}
		}
		
		System.out.println();
		System.out.println("변경이 완료되었습니다.");
		System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
		scan.nextLine();
		
		modify.Screen();
	}

	private void ChangePrice(String n) {
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
			ChangePrice(n);
		} else if(price % 1000 != 0) {
			System.out.println();
			System.out.println("잘못된 가격 범위입니다.");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			ChangePrice(n);
		} else {
			for (SellingStuff s : SellingStuffData.sellingList) {
				if (s.getNo().equals(n) && s.getSellerNo().equals(SELLER + "")) {
					s.setPrice(price + "");
					SellingStuffData.sellingList.set(Integer.parseInt(n) - 1, s);
					break;
				}
			}
			
			System.out.println();
			System.out.println("변경이 완료되었습니다.");
			System.out.println("Enter를 누르면 상품 정보 수정/삭제 화면으로 돌아갑니다.");
			scan.nextLine();
			
			modify.Screen();
		}
	}

	private void DeleteStuff(String n) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("정말 삭제하시겠습니까?");
		System.out.println("1.네\t\t0.아니오");
		System.out.print("번호입력: ");
		
		String check = scan.nextLine();
		
		if(check.equals("1")) {
			for (SellingStuff s : SellingStuffData.sellingList) {
				if (s.getNo().equals(n) && s.getSellerNo().equals(SELLER + "")) {
					SellingStuffData.sellingList.remove(s);
					break;
				}
			}
			
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
			DeleteStuff(n);
		}
		
	}
	
}
