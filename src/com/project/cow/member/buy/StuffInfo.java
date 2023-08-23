package com.project.cow.member.buy;
import java.util.*;
import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class StuffInfo {
	
	public static void stuffInfo() {
		SellingStuffData.load();  //데이터 불러오기
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		SellingStuff a;
		
		System.out.println("[번호]\t\t[품명]\t\t[상품품질]\t[가격]\t\t[판매자]\t[거래방법]\t\t[지불방법]\t\t[판매시작일]\t\t[판매마감일]\t\t[찜횟수]");
		int index=0;
		for (SellingStuff s : SellingStuffData.sellingList) {
				System.out.printf("%5s\t%-14s\t%s\t%9s\t%8s\t%-6s\t\t%-13s\t%-15s\t%-14s\t%3s\r\n", s.getNo(), s.getName(),
						Constant.Condition(s.getCondition()), s.getPrice(), s.getSellerNo(),
						Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
						s.getLike());
				index++;
				if(index==100) break;
		}
		int flag=0;
		while (loop) {
			System.out.println();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("구매할 물품의 번호를 입력하세요.");
			System.out.println("이전 화면으로 돌아가시려면 0을 입력해 주세요.");
			System.out.print("번호 입력 : ");
			String num = sc.nextLine();

			for(SellingStuff stuff : SellingStuffData.sellingList) {
				if (num.equals("0")) {  
					StuffCategory.Screen();  //이전화면
					break;
				} else if(num.equals(stuff.getNo())){
					a = stuff;
					System.out.println("판매 페이지로 이동하시려면 Enter를 눌러주세요.");
                	sc.nextLine();
                	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    BuyPage.buyPage(a);  //판매 페이지로 이동.
                    loop = false;  // 루프 종료
                    flag=1;
                    break;
				} else flag=0;
			}
			if(flag==0) {
				System.out.println("번호를 바르게 입력해 주십시오.");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}
		}
	
	loop=false;   //추가
		
	}
	
}
