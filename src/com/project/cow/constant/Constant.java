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
	
}
