package com.project.cow.mypage;

import java.util.Scanner;

public class BuyList {
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }
    public void buySellHistoryScreen(User user){
        while (true) {

            System.out.println("━━━━━━━━━━━━━━━━구매/판매 목록━━━━━━━━━━━━━━━━━━━━━");
            System.out.println(" 1.구매 목록");
            System.out.println(" 2.판매 목록");
            System.out.println(" 0.이전으로 돌아가기");
            System.out.print(" 번호 입력 : ");
            String input = scan.nextLine();

            switch (input) {
                case "0":
                    MyPageList myPageList = new MyPageList(user);
                    myPageList.myPageScreen();
                    break;
                case "1":
                    myBuyList(user);
                    break;
                case "2":
                    SelledList selledList = new SelledList();
                    selledList.selledScreen(user);
                    break;
                default:
                    System.out.println("0~2숫자를 입력해주세요.");
                    continue;
            }
            break;
        }
    }

    private void myBuyList(User user) {
        int count = (int) (Math.random() * 10) + 1;
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                   나의 구매목록");
        System.out.println(" 1.번호\t\t2.제목\t\t3.카테고리\t4.가격\t5.거래방법\t6.결제방식\t7.물품상태\t8.거래일자\t9.판매자번호\t10.구매자번호");
        for (int i = 0; i < count; i++) {
            SoldOut item = Data.soldOutArrayList.get((int) (Math.random()*1000)+1);
            System.out.printf("%5s %10s %8s %12s %8s %10s %11s %16s %9s %10s\n",
                    item.getNum(), item.getName(), item.getCategory(), item.getPrice(), item.getTransactionMethod()
                    , item.getPaymentMethod(), item.getStatus(), item.getTransactionData(), item.getSellNum(), user.getNumber());
        }
        System.out.println(" 이전으로 돌아가실려면 (엔터)");
        scan.nextLine();
        buySellHistoryScreen(user);
    }

}
