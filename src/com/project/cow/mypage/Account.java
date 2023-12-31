package com.project.cow.mypage;

import java.util.Scanner;
import java.util.function.Function;

import com.project.cow.admin.AdminMenu;
import com.project.cow.data.Data;

public class Account { // 다이소페이 클래스

	static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}
	String money = "";

	public void accountScreen(User user) {
		while (true) {

			AdminMenu.printMenu("Daitso Pay");
			System.out.printf("Daitso 페이 머니: %,d원\n", Integer.parseInt(user.getMoney()));
			AdminMenu.printOption("충전하기");
			String input = scan.nextLine();
			switch (input) {
			case "1":
				payCharging(user);
				break;
			case "0":
				MyPageList myPageList = new MyPageList(user);
				myPageList.myPageScreen();
				break;
			default:
				System.out.println("0~1 숫자를 입력해주세요.");
				continue;
			}
			break;
		}
	}

	private void payCharging(User user) {
		AdminMenu.printMenu("Daitso Pay");
		System.out.println("Daitso 페이 머니로 충전할 금액을 입력해주세요 ");
		System.out.println("최소금액 10,000원");
		System.out.print("금액 입력: ");
		money = scan.nextLine().trim();
		System.out.printf("%,d원 충전 하시겠습니까?\n", Integer.parseInt(money));
		AdminMenu.printOption("충전하기");
		System.out.print("번호 입력: ");
		String num = scan.nextLine();

		switch (num) {
		case "1":
			payChargingScreen(user);
			break;
		case "0":
			MyPageList myPageList = new MyPageList(user);
			myPageList.myPageScreen();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			payCharging(user);
		}
	}

	private void payChargingScreen(User user) {
		user.setMoney(money);
		Data.userSave();
		Function<String, Integer> f = i -> Integer.parseInt(i);
		int intMoney = f.apply(money);

		AdminMenu.printMenu("Daitso Pay");
		if (check()) {
			System.out.printf("내 Ditso 페이 머니로 %,d원 충전완료\n", intMoney);
		} else {
			System.out.println("충전에 실패하셨습니다.");
		}
		AdminMenu.printLine();
		int intMyMoney = f.apply(user.getMoney());
		System.out.printf("Daitso 페이 머니 잔액: %,d원\n", intMyMoney);
		System.out.println("출금 계좌: " + user.getAccountNumber());

		System.out.println("Enter를 입력하면 이전 화면으로 돌아갑니다.");
		scan.nextLine();
		MyPageList myPageList = new MyPageList(user);
		myPageList.myPageScreen();
	}

	private boolean check() {
		Function<String, Integer> f = i -> Integer.valueOf(i);

		return f.apply(money) > 9999;
	}
}
