package com.project.cow.mypage;



import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
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

          System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
          System.out.println("                 알림 키워드 설정");
          System.out.println(" 1.나의 현재 알림 키워드");
          System.out.println(" 2.알림 키워드 설정하기");
          System.out.println(" 0.돌아가기");
          System.out.print(" 번호 입력 : ");
          String input = scan.nextLine().trim();
          switch (input) {
              case "0":
                  MyPageList myPageList = new MyPageList(user);
                  myPageList.myPageScreen();
                  break;
              case "1":
                  myKeyWord(user);
                  break;
              case "2":
                  //알림 키워드 설정하기
                  break;
              default:
                  System.out.println("0~2숫자를 입력해주세요.");
                  continue;
          }

          break;
      }
  }

    private void myKeyWord(User user) {
        int userNum = Integer.valueOf(user.getNumber());
        for (int i = 0; i < Data.keyWordList.get(userNum).str.length; i++) {
            System.out.println((i+1)+"."+Data.keyWordList.get(userNum).getWord()[i]);
            select.add(Data.keyWordList.get(userNum).getWord()[i]);
        }
        System.out.println(" 1.판매목록을 보시려면 해당 키워드의 번호를 입력해주세요.");
        System.out.println(" 0.이전 페이지로 돌아가기");
        System.out.print(" 번호입력 : ");
        String input = scan.nextLine();
        if (input.equals("0")) {
            searchScreen(user);
        }
        keyWordItemList(user, input);


    }
    private void keyWordItemList(User user,String num) {
        int number = (Integer.valueOf(num)) -1;
        String item = select.get(number);
        System.out.println(item);
        System.out.println("[번호]\t\t[품명]\t\t[상품품질]\t[가격]\t\t[판매자]\t[거래방법]\t\t[지불방법]\t\t[판매시작일]\t\t[판매마감일]\t\t[찜횟수]");

        for (SellingStuff s : SellingStuffData.sellingList) {
          if (s.getName().toUpperCase().replace(" ", "").contains(item.toUpperCase().replace(" ", ""))) {

                System.out.printf("%5s\t%-14s\t%s\t%9s\t%8s\t%-6s\t\t%-13s\t%-15s\t%-14s\t%3s\r\n", s.getNo(), s.getName(),
                        Constant.Condition(s.getCondition()), s.getPrice(), s.getSellerNo(),
                        Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
                        s.getLike());
          }

        }
        System.out.println("돌아가실려면 (엔터)");
        scan.nextLine();
        myKeyWord(user);
    }
    private void numInput(){

    }

}
