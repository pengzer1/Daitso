package com.project.cow.mypage;

import com.project.cow.data.BadReviewData;
import com.project.cow.data.Data;

import java.util.Scanner;

public class Review { // 상품 거래 후기
    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }

    User user;

    void reviewScreen(User user){
        while (true) {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("                   상품 거래 후기");
            System.out.println(" 1. 내 리뷰 보기");
            System.out.println(" 0. 돌아가기");
            System.out.print(" 번호 입력 : ");
            String input = scan.nextLine().trim();
            switch (input) {
                case "0":
                    MyPageList myPageList = new MyPageList(user);
                    myPageList.myPageScreen();
                    break;
                case "1":
                    myReview(user);
                    break;
                case "2":
                    // 리뷰 남기기
                    break;
                default:
                    System.out.println("1 또는 0번을 입력해주세요.");
                    continue;
            }
            break;
        }
    }
    private void myReview(User user){
int count = 1;
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                 받은 매너 평가");
        for (int i = 0; i < Data.ReviewList.size(); i++) {
            if (user.getNumber().equals(Data.ReviewList.get(i).getSeller())) {
                System.out.print(count+".");
            String  peek =  Data.ReviewList.get(i).getSelect();
                check(peek);
                count++;
            }
        }
        for (int i = 0; i < Data.badList.size(); i++) {
            if (user.getNumber().equals(Data.badList.get(i).getSellerNo())) {
                System.out.print("신고 누적 횟수 : ");
                System.out.println(Data.badList.get(i).getWarningCnt());
            }
        }
        System.out.println("이전으로 돌아가기 (엔터)");
        scan.nextLine().trim();
        reviewScreen(user);
    }
    private void check(String peek){
        switch (peek) {
            case "1":
                System.out.println("시간약속을 잘지켜요.");
                break;
            case "2":
                System.out.println("응답이 빨라요.");
                break;
            case "3":
                System.out.println("좋은 상품을 저렴하게 판매해요.");
                break;
            case "4":
                System.out.println("친절하고 매너가 좋아요.");
                break;
            case "5":
                System.out.println("상품상태가 설명한 것과 같아요");
                break;

        }

}

}
