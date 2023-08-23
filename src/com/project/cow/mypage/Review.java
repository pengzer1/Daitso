package com.project.cow.mypage;

import java.util.Scanner;

public class Review { // 상품 거래 후기
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }

    User user;
    User a = Data.userList.get(1);

    void reviewScreen(User user){
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                   상품 거래 후기");
        System.out.println(" 1. 내리뷰 보기");
        System.out.println(" 2. 리뷰 남기기");
        System.out.println(" 0. 돌아가기");
        System.out.print(" 번호 입력 : ");
        String input = scan.nextLine();
        switch (input) {
            case "0":
                MyPageList myPageList = new MyPageList(user);
                myPageList.myPageScreen();
                break;
            case "1":
                // 내리뷰 보기
                break;
            case "2":
                // 리뷰 남기기
                break;

        }
    }


}
