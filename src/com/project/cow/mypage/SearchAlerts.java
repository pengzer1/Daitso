package com.project.cow.mypage;


import com.project.cow.data.Data;
import com.project.cow.data.MemberData;
import com.project.cow.admin.AdminMenu;
import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.SellingStuff;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchAlerts {
    static Scanner scan;
    static {
        scan = new Scanner(System.in);}
    static ArrayList<String> select;
    static {
        select = new ArrayList<>();
    }



  void searchScreen(User user){
      while (true) {

    	  AdminMenu.printMenu("알림 키워드 설정");
    	  AdminMenu.printOption("나의 현재 알림 키워드");
          String input = scan.nextLine().trim();
          switch (input) {
              case "0":
                  MyPageList myPageList = new MyPageList(user);
                  myPageList.myPageScreen();
                  break;
              case "1":
                  myKeyWord(user);
                  break;
              default:
                  System.out.println("0~1 숫자를 입력해주세요.");
                  continue;
          }

          break;
      }
  }
  

    private void myKeyWord(User user) {
        int count = 1;
        int userNum = Integer.valueOf(user.getNumber())-1;
        System.out.println();
        for (int i = 0; i < Data.keyWordList.get(userNum).getWord().length; i++) {
            System.out.println(count+"."+Data.keyWordList.get(userNum).getWord()[i]);
            select.add(Data.keyWordList.get(userNum).getWord()[i]);
            count++;
        }
        
        System.out.println("판매목록을 보시려면 해당 키워드의 번호를 입력해주세요.");
        System.out.println("0. 돌아가기");
        String input = scan.nextLine();
        int peek = Integer.valueOf(input);
        if (input.equals("0")){
            searchScreen(user);
        }
        if (peek > count - 1) {
            System.out.println("해당 키워드의 번호를 제대로 입력해주세요.");
            myKeyWord(user);
        }
        keyWordItemList(user, input);


    }
    private void keyWordItemList(User user,String num) {
        int number = (Integer.valueOf(num)) -1;
        System.out.println(number);
        String item = select.get(number);
        System.out.println(item);
        System.out.println("[번호]           [품명]             [상품품질]  [가격]  [판매자]    [거래방법]            [지불방법]           [판매시작일]    [판매마감일]   [찜횟수]");
		
        for (SellingStuff s : SellingStuffData.sellingList) {
          if (s.getName().toUpperCase().replace(" ", "").contains(item.toUpperCase().replace(" ", ""))) {
        	  System.out.printf(" %4s  %-16s\t\t%s %10s", s.getNo(), s.getName(), Constant.Condition(s.getCondition()), s.getPrice());
				
				// 해당 물품의 판매자 정보 출력
				for (Member seller : MemberData.list) {
					if (seller.getNo().equals(s.getSellerNo())) {
						System.out.printf(" %6s ", seller.getName());
					}
				}
				System.out.printf("  %-9s  \t %-13s\t%-15s %-15s %3s\r\n", Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
						s.getLike());
          }

        }
        System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
        scan.nextLine().trim();
        myKeyWord(user);
    }







}
