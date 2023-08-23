package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.data.Data;

public class MyTrade {
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }

    public void tradeScreen(User user){
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                현재 진행중인 거래");
        System.out.println("[번호]\t\t[품명]\t\t[카테고리]\t[가격]\t[거래방법]\t[결제방식]\t[물품상태]\t[거래일자]\t[판매자번호]\t[구매자번호]");
        
        for (int i = 0; i < Data.tradeList.size(); i++) {
            if (user.getNumber().equals(Data.tradeList.get(i).getBuyNum())) {
                TradeStuff item = Data.tradeList.get(i);
                System.out.printf("%2s %-8s %8s %12s %8s %10s %11s %16s %7s %10s\n",
                        item.getNum(), item.getName(), item.getCategory(), item.getPrice(), item.getTransactionMethod()
                        , item.getPaymentMethod(), item.getStatus(), item.getTransactionData(), item.getSellNum(), item.getBuyNum());
            }
            }
        System.out.println("마이페이지로 돌아가기(엔터)");
        scan.nextLine().trim();
        MyPageList myPageList = new MyPageList(user);
        myPageList.myPageScreen();

    }
    }

