package com.project.cow.mypage;

import com.project.cow.admin.AdminMenu;
import com.project.cow.constant.Constant;
import com.project.cow.data.Data;
import com.project.cow.data.MemberData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.SellingStuff;

import java.util.Scanner;

public class BuyList {
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }
    public void buySellHistoryScreen(User user){
        while (true) {

        	AdminMenu.printMenu("구매/판매 목록");
        	AdminMenu.printOption("구매 목록", "판매 목록");
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

    	AdminMenu.printMenu("나의 구매목록");
    	System.out.println("[번호]           [품명]             [카테고리]           [상품품질]   [가격]      [거래방법]      [지불방법]     [거래일자]      [판매자]      [구매자]");
        for (int i = 0; i < Data.soldOutArrayList.size(); i++) {
            if (user.getNumber().equals(Data.soldOutArrayList.get(i).getBuyNum())) {

                SoldOut item = Data.soldOutArrayList.get(i);
                
                System.out.printf("%5s %10s\t%8s\t  %12s\t   %8s  %10s %11s %16s",
                        item.getNum(), item.getName(), Constant.Category(item.getCategory()), Constant.Condition(item.getStatus()), item.getPrice(), Constant.Method(item.getTransactionMethod()),
                        Constant.Payment(item.getPaymentMethod()), item.getTransactionData());
                
                // 해당 물품의 판매자 이름 출력
				for (Member seller : MemberData.list) {
					if (seller.getNo().equals(item.getSellNum())) {
						System.out.printf(" %8s", seller.getName());
					}
				}
				
				// 해당 물품의 구매자 이름 출력
				for (Member buyer : MemberData.list) {
					if (buyer.getNo().equals(item.getBuyNum())) {
						System.out.printf(" %10s\n", buyer.getName());
					}
				}
            }
        }
        System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
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
