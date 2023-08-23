package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.data.Data;
import com.project.cow.data.object.Member;
public class DeleteAccount { //회원탈퇴 클래스

    static Scanner scan;
    static {
        scan = new Scanner(System.in);
    }

    public void deleteAccountScreen(Member user){
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                  탈퇴하기 ");
        System.out.println(".."+user.getName()+"님 이제 새거 사러가시는건가요?");
        System.out.println(" "+user.getName()+"님이 탈퇴하시려는 이유가 궁금해요");
        System.out.println();
        System.out.println(" 1.너무 많이 이용해요");
        System.out.println(" 2.물품이 안팔려요 ");
        System.out.println(" 3.주머니가 무거워져서 이제 중고가 눈에안들어와요");
        System.out.println(" 0.돌아가기");
        System.out.print(" 번호입력 : ");
        String input = scan.nextLine().trim();

        ment(user, input);

        System.out.println("계속하실려면 엔터");
        scan.nextLine();
        System.out.println(" 진짜 계정을 삭제하시겠습니까?");
        System.out.println();
        System.out.println(" 1.계정을 삭제하시면 그동안의 회원님의 기록은 삭제되며 데이터 복구는 불가능합니다.");
        System.out.println(" 2.회원 탈퇴시 회원님이 보유하고있던 Daitso 페이는 모두소멸되며 , 복구가 불가능합니다.");
        System.out.println(" 남은 Daitso 페이 : " + user.getMoney());
        System.out.println();
        System.out.println(" 1.탈퇴하기");
        System.out.println(" 0.돌아가기");
        System.out.println(" 번호입력 : ");
        String select = scan.nextLine().trim();
        if (select.equals("1")) {
           // Data.deleteMember(user);
        } else if (select.equals("0")) {
            MyPageList myPageList = new MyPageList(user);
        }
    }


    private static void ment(Member user, String input) {
            switch (input) {
                case "0":
                    MyPageList myPageList = new MyPageList(user);
                    myPageList.myPageScreen();
                case "1":
                    System.out.println("앗 그렇다면 저희와 함께 덜사용하는 방법을 고려해보면 어떨까요?");
                    System.out.println("이대로 떠나긴 아쉬운걸요.. 계정삭제대신 좀쉬어보는건 어떠세요?");
                    break;
                case "2":
                    System.out.println("가격을 합리적으로 설정해보는건 어떨까요?");
                    System.out.println("Daitso 에서 유사한 물건을 검색하는것도 도움이 된답니다.");
                    break;
                case "3":
                    System.out.println("우와! 축하드려요 ");
                    System.out.println("저희는 고객님이 다시 중고물품이 필요할수도있으니 기다리고있을게요.");
                    break;
                default:
                    System.out.println("0~3 숫자를 입력해주세요");
            }


    }


}

