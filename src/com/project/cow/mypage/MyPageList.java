package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.member.MemberMenu;

public class MyPageList {
    //1,남승승,4chyz,iltxz3meo,010-2109-7033,580418-2907053,v6ztl78f@nate.com,광진구,사아-8689959395814,219000,2등급
    // 번호 , 이름 , 아이디 , 비번 , 전번 , 주민번호 , 이메일 , 동네 , 계좌 , 돈 , 등급
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    User user; // 로그인유저
    public MyPageList(User user){ // 로그인유저 생성자주입
        this.user = user;
    }




    public void myPageScreen(){

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                  마이페이지");
        System.out.printf("  이름 : %s\n", user.getName());
        System.out.printf("  아이디 : %s\n", user.getId());
        System.out.printf("  비밀번호 : %s\n",user.getPassword());
        System.out.printf("  연락처 : %s\n", user.getPhoneNumber());
        System.out.printf("  이메일 : %s\n", user.getEmail());
        System.out.printf("  주소 : %s\n", user.getLivingArea());
        select();

    }

    // 개인 정보 변경 : 닉네임 , 비번 , 동네 , 전화번호
// 판매내역
// 구매 내역
// 내약속 : 구매자와 판매자와의 약속 설정
// 당근페이 : 충전 및 결제
// 관심목록 : 구매하기에서 물건 찜하면 관심 목록에 저장 , 다른사람이 구매하면 판매완료로 변경
// 회원 탈퇴 :  확인메세지 물어보기
    public void select() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("            [마이 페이지 활동을 선택하세요]           ");
        System.out.println("     1. 회원 정보 수정                                 ");
        System.out.println("     2. 구매/판매 내역                             ");
        System.out.println("     3. 상품 거래 후기                             ");
        System.out.println("     4. 내 알림 키워드                       ");
        System.out.println("     5. 현재 내 거래                         ");
        System.out.println("     6. 다잇소 페이                                 ");
        System.out.println("     7. 회원 탈퇴            `                      ");
        System.out.println("     0. 돌아가기                                     "  );
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("     > 번호 입력:");
        String input = scan.nextLine();

        if (input.equals("1")) {
            InfoChange infoChange = new InfoChange();
            infoChange.changeMyInfo(user);
        } else if (input.equals("2")) {
            BuyList buyList = new BuyList();
            buyList.buySellHistoryScreen(user);
        } else if (input.equals("3")) {
            Review review = new Review();
            review.reviewScreen(user);
        } else if (input.equals("4")) {
            SearchAlerts searchAlerts = new SearchAlerts();
            searchAlerts.searchScreen(user);
        } else if (input.equals("5")) {
            MyTrade myTrade = new MyTrade();
            myTrade.tradeScreen(user);
        } else if (input.equals("6")) {
            Account account = new Account();
            account.accountScreen(user);
        } else if (input.equals("7")) {
            DeleteAccount deleteAccount = new DeleteAccount();
            deleteAccount.deleteAccountScreen(user);
        } else if (input.equals("0")) {
            MemberMenu.membermenu();
        } else {
            System.out.println("1~6의 번호를 입력해주세요");
            myPageScreen();
        }
    }



    private void TradeReview(){


    }
}