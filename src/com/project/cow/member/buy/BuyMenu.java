package com.project.cow.member.buy;
import java.util.*;

import com.project.cow.admin.AdminMenu;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.member.MemberMenu;

public class BuyMenu {
   SellingStuff item;
   public BuyMenu(SellingStuff item) {
      this.item = item;
   }
   public BuyMenu()   {}
   
   static StuffInfo stuffInfo = new StuffInfo();
   
   public static void FirstScreen() {
        Scanner sc = new Scanner(System.in);
      
        LikeItem likeItem = new LikeItem();
        KeyWordSet keyWordSet = new KeyWordSet();
      
        AdminMenu.printMenu("구매하기");
        System.out.println("1.물품구매");
        System.out.println("2.카테고리 보기");
        System.out.println("3.찜목록");
        System.out.println("4.알림 키워드 설정");
        System.out.println("0.돌아가기");
        AdminMenu.printLine();
        
        System.out.print("번호 입력: ");
        String input = sc.nextLine().trim();

        if (input.equals("1")) {
           System.out.println();
            Screen();
        } else if (input.equals("2")) {  //카테고리 목록보기
           System.out.println();
            StuffCategory.Screen();
        } else if (input.equals("3")) {
           System.out.println();
           likeItem.Screen();
           
        } else if (input.equals("4")) {
            System.out.println();
            keyWordSet.Screen();

        } else if (input.equals("0")) {
           System.out.println();
           System.out.println("이전 화면으로 돌아가려면 Enter를 눌러주세요.");
            sc.nextLine();
            MemberMenu.membermenu();
        }else {
           System.out.println();
           System.out.println("잘못된 선택입니다.");
         System.out.println("다시 선택하려면 Enter를 눌러주세요.");
         AdminMenu.printLine();
         sc.nextLine();
         
         FirstScreen();
        }

    }

    public static void Screen() {
       Scanner sc = new Scanner(System.in);
       
        AdminMenu.printMenu("물품 구매 화면으로 이동합니다.");
        System.out.println("1.물품선택");
        System.out.println("2.물품검색");
        System.out.println("3.물품정렬");
        System.out.println("0.돌아가기");
        AdminMenu.printLine();
        
        System.out.print("번호 입력: ");
        String input = sc.nextLine().trim();

        if (input.equals("1")) {
        	stuffInfo.stuffInfo();
        } else if (input.equals("2")) {  // 물품검색
            System.out.println();
            StuffSearch.search();
        } else if (input.equals("3")) {
            System.out.println();
            StuffSort.stuffSortChoice();
        }else if (input.equals("0")) {
        	System.out.println();
            MemberMenu.membermenu();
        }else {
           System.out.println();
           System.out.println("잘못된 선택입니다.");
         System.out.println("다시 선택하려면 Enter를 눌러주세요.");
         AdminMenu.printLine();
         sc.nextLine();
         
         Screen();
        }
    }
    
    
}