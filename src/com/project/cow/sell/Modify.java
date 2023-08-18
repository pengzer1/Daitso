package com.project.cow.sell;

import java.util.Scanner;

public class Modify {
	
	Scanner scan = new Scanner(System.in);

	public void Screen() {
		ModifyDetail modifyDetail = new ModifyDetail();
		
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("[판매 등록 현황]");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		//TODO 회원 정보 받아와서 등록 상품 list 조금 띄우기
		System.out.println("[번호]\t[제목]\t[카테고리]\t[물건 상태]\t[판매 가격]\t[판매자명]\t[상품 거래 방식]\t[결제 방식]\t[등록 날짜]\t[마감 날짜]\t[찜");

		System.out.println();
		System.out.println("상품 정보를 수정하시겠습니까?");
		Check();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("수정하실 상품 번호를 입력해주세요.");
		System.out.println();
		String num = GetStuff();
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("1.제목 수정하기\t\t2.판매 기간 수정하기\r\n3.판매 가격 수정하기\t4.삭제하기\t0.돌아가기");
		
		modifyDetail.Screen(num);
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
	
	private String GetStuff() {
		System.out.print("번호입력: ");
		String no = scan.nextLine();
		
//		TODO 판매물품 번호로 판매물품 정보 쭈루루루룩 밑에 띄우기
		return no;
	}
	
}
