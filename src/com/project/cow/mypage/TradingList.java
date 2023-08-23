package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.admin.AdminMenu;

public class TradingList { // 거래중인 내역 클래스
static Scanner scan;

static {
    scan = new Scanner(System.in);
}

    public void tradingScreen(User user) {
    	AdminMenu.printMenu("현재 내 거래");
    	AdminMenu.printOption("구매중인 거래", "판매중인 거래");
        String input = scan.nextLine();

        switch (input) {
            case "1":
                //구매중인거래
                break;
            case "2":
                //판매중인거래
                break;
        }

    }






}
