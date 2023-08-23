package com.project.cow.mypage;

import com.project.cow.admin.AdminMenu;
import com.project.cow.data.Data;

import java.util.Scanner;

public class SelledList { //판매목록 클래스
    // 번호 , 제목 ,     카테고리 , 가격 , 거래방법 ,결제방식 , 물품상태 ,    거래일자,   판매자번호 , 구매자번호
    //  1, 삼성 전기포트,    1,   12000,  2,      3,      2,      2023-08-23,   417,    2990


    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public void selledScreen(User user) {

    	AdminMenu.printMenu("나의 판매목록");
        System.out.println(" 1.번호\t\t2.제목\t\t3.카테고리\t4.가격\t5.거래방법\t6.결제방식\t7.물품상태\t8.거래일자\t9.판매자번호\t10.구매자번호");
        for (int i = 0; i < Data.soldOutArrayList.size(); i++) {
            if (user.getNumber().equals(Data.soldOutArrayList.get(i).getSellNum())) {

                SoldOut item = Data.soldOutArrayList.get(i);
                System.out.printf("%5s %10s %8s %12s %8s %10s %11s %16s %9s %10s\n",
                        item.getNum(), item.getName(), item.getCategory(), item.getPrice(), item.getTransactionMethod()
                        , item.getPaymentMethod(), item.getStatus(), item.getTransactionData(), item.getSellNum(), item.getBuyNum());
            }

        }
        System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
        scan.nextLine().trim();
        BuyList buyList = new BuyList();
        buyList.buySellHistoryScreen(user);
    }


}