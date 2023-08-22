package com.project.cow.member.buy;
import java.util.*;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.constant.Constant;

public class StuffCategory { // 카테고리별 물품 확인하기

	public static void Screen() {
		SellingStuffData.load();
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		ArrayList<SellingStuff> choiceCategory = new ArrayList<SellingStuff>();

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("카테고리 선택하기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("1.가구/인테리어/생활/주방\t\t2.디지털기기\n3.여성잡화\t\t4.남성잡화\t\t5.가공식품\n6.스포츠/레저\t7.취미/게임/음반\t8.뷰티/미용\n9.반려동물용품\t10.티켓/교환권/도서\t11.기타\n0.돌아가기");
		
		while(loop) {
			System.out.print("번호 입력 : ");
			String input = sc.nextLine();

			if (Integer.parseInt(input) == 0) {
				BuyMenu.FirstScreen();
			} else if (Integer.parseInt(input) > 11) {
				System.out.println();
				System.out.println("Enter를 누르고 알맞은 번호를 다시 입력해 주십시오.");
				sc.nextLine();
				Screen();
			} else {
				System.out.println("[번호]               [품명]     [상품품질]      [가격]    [판매자]         [거래방법]       [지불방법]      [판매시작일]     [판매마감일]   [찜횟수]");

				for (SellingStuff s : SellingStuffData.sellingList) {
					if (s.getCategory().equals(input)) {
						choiceCategory.add(s);
						System.out.printf("%5s %15s %11s %9s %10s %13s %13s %13s %13s %8s\r\n", s.getNo(), s.getName(),
								Constant.Condition(s.getCategory()), s.getPrice(), s.getSellerNo(),
								Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
								s.getLike());
					}
				}
				int flag=0;
				while (loop) {
					System.out.println();
					System.out.println("구매하고 싶은 상품의 키워드를 입력하세요.");
					System.out.println("이전 화면으로 돌아가시려면 0을 입력해 주세요.");
					System.out.print("번호 입력 : ");
					String num = sc.nextLine();

					for(SellingStuff stuff : choiceCategory) {
						if (num.equals("0")) {  
							StuffCategory.Screen();  //이전화면
							break;
						} else if(num.equals(stuff.getNo())){
							System.out.println("판매 페이지로 이동하시려면 Enter를 눌러주세요.");
	                    	sc.nextLine();
	                    	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	                        BuyMenu.FirstScreen();  //판매 페이지로 이동.
	                        flag=1;
	                        loop = false;  // 루프 종료
						} else continue; flag=0;
					}
					if(flag==0) {
						System.out.println("번호를 바르게 입력해 주십시오.");
						System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
					}
				}
			}
			loop=false;   //추가
		}
	}

}
