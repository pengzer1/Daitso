package com.project.cow.member.buy;
import java.util.*;

import com.project.cow.admin.AdminMenu;
import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.mypage.BuyList;

public class StuffSearch {
    public static void search() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        ArrayList<SellingStuff> sellChoice = new ArrayList<SellingStuff>();

        AdminMenu.printLine();
        System.out.println("구매하고 싶은 상품의 키워드를 입력하세요.");
        System.out.println("0을 입력하시면 이전화면으로 돌아갑니다.");
        System.out.print("검색 키워드 : ");
        String input = sc.nextLine();
        AdminMenu.printLine();

        for (SellingStuff s : SellingStuffData.sellingList) {
        	if (input.equals("0")) {
                BuyMenu.Screen();
                sc.close();  
            }
            if (s.getName().toUpperCase().replace(" ", "").contains(input.toUpperCase().replace(" ",""))) {
                sellChoice.add(s);
                System.out.println("[번호]               [품명]     [상품품질]      [가격]    [판매자]         [거래방법]       [지불방법]      [판매시작일]     [판매마감일]   [찜횟수]");
				System.out.printf("%5s %15s %11s %9s %10s %13s %13s %13s %13s %8s\r\n", s.getNo(), s.getName(),
						Constant.Condition(s.getCategory()), s.getPrice(), s.getSellerNo(),
						Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
						s.getLike());
            }
        }
        while (loop) {
            int flag = 0;
            if (sellChoice.isEmpty()) {
                System.out.println("검색 결과가 없습니다. 알맞은 키워드를 입력하세요.");
                search();
            } else {
            	System.out.println();
            	AdminMenu.printLine();
                System.out.println("구매하고 싶은 상품의 번호를 입력하세요.");
                System.out.println("이전 화면으로 돌아가고 싶으시면 0을 입력하세요.");
                System.out.print("번호 입력 : ");
                String num = sc.nextLine();
                for (SellingStuff stuff : sellChoice) {
                   /*
                    BuyList buyList = new BuyList();
                    buyList.buyTest(stuff);
*/
                    if (num.equals("0")) {
                    	search();   //이전화면
                        break;  
                    } else if (num.equals(stuff.getNo())) {

                    	System.out.println("판매 페이지로 이동하시려면 Enter를 눌러주세요.");
                    	sc.nextLine();
                        BuyMenu.FirstScreen();  //판매 페이지로 이동.
                        flag=1;
                        loop = false;  // 루프 종료
                        //break;  // 검색 루프도 종료
                    } else continue; flag=0;   
                }
                if(flag==0) System.out.println("\n알맞은 판매 번호를 다시 입력하십시오.");
            }
        }
        
        sc.close();  
    }
}
