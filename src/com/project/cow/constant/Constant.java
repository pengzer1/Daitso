package com.project.cow.constant;

public class Constant {
	
	final public static String Category(String s) {
		String category = "";
		
		switch (s) {
		case "1":
			category = "가구/인테리어/생활/주방";
			break;
			
		case "2":
			category = "디지털기기";
			break;
			
		case "3":
			category = "여성잡화";
			break;
			
		case "4":
			category = "남성잡화";
			break;
			
		case "5":
			category = "가공식품";
			break;
			
		case "6":
			category = "스포츠/레저";
			break;
			
		case "7":
			category = "취미/게임/음반";
			break;
			
		case "8":
			category = "뷰티/미용";
			break;
			
		case "9":
			category = "반려동물용품";
			break;
			
		case "10":
			category = "티켓/교환권/도서";
			break;
			
		case "11":
			category = "기타";
			break;

		default:
		}
		
		return category;
	}
	
	final public static String Method(String s) {
		String method = "";
		
		switch (s) {
		case "1":
			method = "대면거래";
			break;
			
		case "2":
			method = "택배거래";
			break;
			
		case "3":
			method = "제3자 안전 거래";
			break;

		default:
			break;
		}
		
		return method;
	}
	
	final public static String Payment(String s) {
		String payment = "";
		
		switch (s) {
		case "1":
			payment = "현금거래";
			break;
			
		case "2":
			payment = "계좌이체";
			break;
			
		case "3":
			payment = "ITSO페이";
			break;
			
		case "4":
			payment = "제3자안전거래";
			break;

		default:
			break;
		}
		
		return payment;
	}
	
	final public static String Condition(String s) {
		String condition = "";
		
		switch (s) {
		case "1":
			condition = "상";
			break;
			
		case "2":
			condition = "중";
			break;
			
		case "3":
			condition = "하";
			break;

		default:
			break;
		}
		
		return condition;
	}
	
}
