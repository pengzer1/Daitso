package com.project.cow.mypage;

import com.project.cow.constant.Constant;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.data.object.Member;
import java.util.Scanner;

public class BuyList {
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }
    public void buySellHistoryScreen(Member user){
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

    private void myBuyList(Member user) {

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                   나의 구매목록");
        System.out.println(" 1.번호\t\t2.제목\t\t3.카테고리\t4.가격\t5.거래방법\t6.결제방식\t7.물품상태\t8.거래일자\t9.판매자번호\t10.구매자번호");
        for (int i = 0; i < Data.soldOutArrayList.size(); i++) {
            if (user.getNo().equals(Data.soldOutArrayList.get(i).getBuyNum())) {

                SoldOut item = Data.soldOutArrayList.get(i);
                System.out.printf("%5s %10s %8s %12s %8s %10s %11s %16s %9s %10s\n",
                        item.getNum(), item.getName(), item.getCategory(), item.getPrice(), item.getTransactionMethod()
                        , item.getPaymentMethod(), item.getStatus(), item.getTransactionData(), item.getSellNum(), item.getBuyNum());
            }
        }
        System.out.println(" 이전으로 돌아가실려면 (엔터)");
        scan.nextLine().trim();
        buySellHistoryScreen(user);
    }

    public void buyTest(SellingStuff s) {
        System.out.println("[번호]\t\t[품명]\t\t[상품품질]\t[가격]\t\t[판매자]\t[거래방법]\t\t[지불방법]\t\t[판매시작일]\t\t[판매마감일]\t\t[찜횟수]");

                System.out.printf("%5s\t%-14s\t%s\t%9s\t%8s\t%-6s\t\t%-13s\t%-15s\t%-14s\t%3s\r\n", s.getNo(), s.getName(),
                        Constant.Condition(s.getCondition()), s.getPrice(), s.getSellerNo(),
                        Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
                        s.getLike());

        }


}
