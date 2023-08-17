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

		System.out.println();
		System.out.println("상품을 등록하시겠습니까?");
		Check();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("등록하신 상품 번호를 입력해주세요.");
		System.out.println();
		GetStuff();
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("1.제목 수정하기\t\t2.상품 설명 수정하기\r\n3.판매 가격 수정하기\t4.삭제하기\t0.돌아가기");
		
		modifyDetail.Screen();
	}
	
	private void Check() {
		SellMenu sellMenu = new SellMenu();
		System.out.println("1.등록하기\t0.돌아가기");
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
	
	private void GetStuff() {
		System.out.print("번호입력: ");
		String no = scan.nextLine();
		
//		TODO 판매물품 번호로 판매물품 정보 쭈루루루룩 밑에 띄우기
	}
	
}
