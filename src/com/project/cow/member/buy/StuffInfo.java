package com.project.cow.member.buy;
import java.util.*;

import com.project.cow.admin.AdminMenu;
import com.project.cow.constant.Constant;
import com.project.cow.data.MemberData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.SellingStuff;

public class StuffInfo {
	
	public static void stuffInfo() {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		SellingStuff a;
		
		System.out.println("[번호]           [품명]             [상품품질]  [가격]  [판매자]    [거래방법]            [지불방법]           [판매시작일]    [판매마감일]   [찜횟수]");
		int index=0;
		for (SellingStuff s : SellingStuffData.sellingList) {
				System.out.printf(" %4s  %-16s\t\t%s %10s", s.getNo(), s.getName(), Constant.Condition(s.getCondition()), s.getPrice());
				
				// 해당 물품의 판매자 정보 출력
				for (Member seller : MemberData.list) {
					if (seller.getNo().equals(s.getSellerNo())) {
						System.out.printf(" %6s ", seller.getName());
					}
				}
				System.out.printf("  %-9s  \t %-13s\t%-15s %-15s %3s\r\n", Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
						s.getLike());
				
				
				index++;
				if(index==100) break;
		}
		
		int flag=0;
		while (loop) {
			System.out.println();
			AdminMenu.printLine();
			System.out.println("구매할 물품의 번호를 입력하세요.");
			System.out.println("이전 화면으로 돌아가시려면 0을 입력해 주세요.");
			System.out.print("번호 입력 : ");
			String num = sc.nextLine();

			for(SellingStuff stuff : SellingStuffData.sellingList) {
				if (num.equals("0")) {  
					BuyMenu.Screen(); //이전화면
					break;
				} else if(num.equals(stuff.getNo())){
					a = stuff;
					System.out.println("판매 페이지로 이동하시려면 Enter를 눌러주세요.");
                	sc.nextLine();
                	AdminMenu.printLine();
                    BuyPage.buyPage(a);  //판매 페이지로 이동.
                    loop = false;  // 루프 종료
                    flag=1;
                    break;
				} else flag=0;
			}
			if(flag==0) {
				System.out.println("번호를 바르게 입력해 주십시오.");
				AdminMenu.printLine();
			}
		}
	
	loop=false;   //추가
		
	}
	
}
