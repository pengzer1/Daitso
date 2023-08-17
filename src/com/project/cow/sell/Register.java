package com.project.cow.sell;

import java.util.Scanner;

import com.project.cow.constant.Constant;
import com.project.cow.data.object.SellingStuff;

public class Register {
	
	private static String sellingStuff = "";
	
	public static void Screen() {
		
<<<<<<< HEAD
		System.out.println("등록화면");
		
=======
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("상품등록화면");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		Category();
>>>>>>> main
		
	}
	
	private static void Category() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("상품 카테고리 설정");
		System.out.println("1.가구/인테리어/생활/주방\t2.디지털기기\n3.여성잡화\t4.남성잡화\t5.가공식품\n6.스포츠/레저\t7.취미/게임/음반\t8.뷰티/미용\n9.반려동물용품\t10.티켓/교환권/도서\t11.기타");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("카테고리 번호:");
		String category = scan.nextLine();
		String temp = Constant.Category(category);
		
		if (temp.equals("")) {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			System.out.println();
			Category();
		}
		else {
			System.out.println("카테고리를 " + temp + "로(으로) 설정하였습니다.");
			sellingStuff += temp;
		}
	}
}
