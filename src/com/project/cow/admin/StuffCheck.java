package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class StuffCheck {

	public static void adminStuffCheck() {
		Scanner scan = new Scanner(System.in);
		
		SellingStuffData.load(); // 중고 물품 로드
		
		AdminMenu.printMenu("중고 물품 관리");
		AdminMenu.printOption("중고 물품 현황 조회", "평판지수가 높은 회원 조회");
		
		String manageChoice = scan.nextLine().trim();
		
		if (manageChoice.equals("1")) { // 중고 물품 현황 조회
			displayStuff(scan);
			
		} if (manageChoice.equals("2")) { // 평판지수가 높은 회원 조회
			displayReputableMember(scan);
			
		} else {
			return;
		}
		scan.nextLine();
	}

	private static void displayStuff(Scanner scan) {
		/*
		판매번호,제목,카테고리,가격,거래방식,결제방식,물품상태,판매가능날짜(시작),판매가능날짜(종료),찜된수,판매자번호
		1,삼성 전기포트,1,34000,3,1,2,2023-08-22,2023-08-27,15,1208
		2,다이슨 다리미,1,40000,3,1,1,2023-08-23,2023-08-25,0,2673
		3,LG 전기포트,1,0,2,4,1,2023-08-21,2023-08-26,22,5545
		4,LG 책상,1,30000,3,4,1,2023-08-25,2023-08-26,28,6121
		
		# 카테고리
		1. 가구/인테리어/생활/주방
		2. 디지털 기기
		3. 여성잡화,
		4. 남성잡화,
		5. 가공식품, 
		6. 스포츠/레저, 
		7. 취미/게임/음반, 
		8. 뷰티/미용, 
		9. 반려동물용품, 
		10. 티켓/교환권/도서 
		11. 기타 중고물품
		*/
		
		String popularCategory = "";
	    String popularItem = "";
	    String popularKeyword = "";
	    
		AdminMenu.printMenu("중고 물품 현황 조회");
		System.out.println("검색 기간: 0000년 00월 00일 ~ 0000년 00월 00일");
		System.out.println("0년 0개월 0일의 검색 결과입니다.");
	    System.out.println("인기 카테고리: " + popularCategory);
	    System.out.println("인기 물품: " + popularItem);
	    System.out.println("인기 키워드: " + popularKeyword);
		
		AdminMenu.printOption("검색 날짜 지정");
		String searchChoice = scan.nextLine().trim();
		
		if (searchChoice.equals("1")) { // 검색 날짜 지정
			
		} else {
			return;
		}
	}

	private static boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
	
	private static void displaySearchDate(Scanner scan) {
		String startDate = LocalDate.parse(); // 판매 시작 날짜
		
		String endDate = ""; // 판매 끝 날짜
		
		String checkDate = ""; // 구매할 날짜
		
		
		boolean isWithinRange = isWithinDateRange(checkDate, startDate, endDate);
		
		System.out.println("해당 날짜가 범위 내에 있는가? " + isWithinRange);
	    
	    List<SellingStuff> itemsInDateRange = new ArrayList<>();
	    for (SellingStuff item : SellingStuffData.getAllItems()) {
	        if (isWithinDateRange(item.getDatePosted(), startDate, endDate)) {
	            itemsInDateRange.add(item);
	        }
	    }
	}
	
	private static void displayReputableMember(Scanner scan) {
		
		AdminMenu.printMenu("평판지수가 높은 회원 조회");
		System.out.println("평판지수가 높은 판매자:");
		System.out.println("평판지수가 높은 구매자:");
	}
}
