package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.data.object.Member;

public class InfoChange {  //회원 정보 수정
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }
    Member user;

    public InfoChange(Member user) {
        this.user = user;
    }



    public void changeMyInfo(Member user) {// 아이디,비밀번호 , 휴대폰번호 , 동네
        System.out.println();
        while (true) {
            System.out.println("━━━━━━━━━━━━━━━━회원 정보 수정━━━━━━━━━━━━━━━━━━━━━");
            System.out.println(" 1. 아이디 변경 ");
            System.out.println(" 2. 비밀번호 변경 ");
            System.out.println(" 3. 휴대폰 번호 변경 ");
            System.out.println(" 4. 동네 변경 ");
            System.out.println(" 0. 마이페이지로 돌아가기");
            System.out.print("변경할 정보를 선택해주세요(번호입력) : ");
            String input = scan.nextLine();
            switch (input) {
                case "0":
                    MyPageList myPageList = new MyPageList(user);
                    myPageList.myPageScreen();
                case "1":
                    changeId(user);
                    break;
                case "2":
                    changePw(user);
                    break;
                case "3":
                    changePhoneNumber(user);
                    break;
                case "4":
                    changeLivingArea(user);
                    break;
                default:
                    System.out.println("1~4의 숫자를 입력해주세요!");
                    continue;
            }
            break;
        }

    }

    private void changeId(Member user){ // 아이디 변경 메서드
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                  아이디 변경");
        System.out.println("현재 아이디 : " + user.getId());
        System.out.println("(변경을 취소하실려면 0을 입력하세요)");
        System.out.print("변경 하실 아이디  : " );
        String input = scan.nextLine().trim();
        if (input.equals("0")) {
            changeMyInfo(user);
        }
        user.setId(input);
        com.project.cow.data.Data.memberSave(); // 변경된 아이디 덮어씌우기
        System.out.println("메이페이지로 돌아갑니다 (엔터)");
        scan.nextLine();
        returnPage(user);

    }

    private void changePw(Member user) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("                  비밀번호 변경");
        System.out.println("현재 비밀번호 : " + user.getPwd());
        System.out.println("(변경을 취소하실려면 0을 입력하세요)");
        System.out.print("변경 하실 비밀번호 : ");
        String input = scan.nextLine().trim();
        if (input.equals("0")) {
            changeMyInfo(user);
        }
        user.setPwd(input);
        com.project.cow.data.Data.memberSave();
        System.out.println("메이페이지로 돌아갑니다 (엔터)");
        scan.nextLine();
        returnPage(user);

    }
private void changePhoneNumber(Member user){
    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    System.out.println("                 휴대폰 번호 변경");
    System.out.println("현재 전화번호 : " + user.getTel());
    System.out.println("(변경을 취소하실려면 0을 입력하세요)");
    System.out.print("변경 하실 전화번호 : ");
    String input = scan.nextLine().trim();
    if (input.equals("0")) {
        changeMyInfo(user);
    }
    user.setTel(input);
    com.project.cow.data.Data.memberSave();
    System.out.println("메이페이지로 돌아갑니다 (엔터)");
    scan.nextLine();
    returnPage(user);

}
private void changeLivingArea(Member user){
    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    System.out.println("                    동네 변경");
    System.out.println("현재 동네 : " + user.getAddress());
    System.out.println();
    System.out.println("지역을 선택해 주세요");
    areaList();
    System.out.print("번호 선택 : ");
    String input = scan.nextLine();
    areaSelect(user, input);
    com.project.cow.data.Data.memberSave();
}

    private void areaSelect(Member user, String input) {
        switch (input) {
            case "0":
                changeMyInfo(user);
            case "1":
                user.setAddress("종로구");
                break;
            case "2":
                user.setAddress("중구");
                break;
            case "3":
                user.setAddress("용산구");
                break;
            case "4":
                user.setAddress("성동구");
                break;
            case "5":
                user.setAddress("광진구");
                break;
            case "6":
                user.setAddress("동대문구");
                break;
            case "7":
                user.setAddress("중랑구");
                break;
            case "8":
                user.setAddress("성북구");
                break;
            case "9":
                user.setAddress("강북구");
                break;
            case "10":
                user.setAddress("도봉구");
                break;
            case "11":
                user.setAddress("노원구");
                break;
            case "12":
                user.setAddress("은평구");
                break;
            case "13":
                user.setAddress("서대문구");
                break;
            case "14":
                user.setAddress("마포구");
                break;
            case "15":
                user.setAddress("양천구");
                break;
            case "16":
                user.setAddress("강서구");
                break;
            case "17":
                user.setAddress("구로구");
                break;
            case "18":
                user.setAddress("금천구");
                break;
            case "19":
                user.setAddress("영등포구");
                break;
            case "20":
                user.setAddress("동작구");
                break;
            case "21":
                user.setAddress("관악구");
                break;
            case "22":
                user.setAddress("서초구");
                break;
            case "23":
                user.setAddress("강남구");
                break;
            case "24":
                user.setAddress("송파구");
                break;
            case "25":
                user.setAddress("강동구");
                break;
            default:
                System.out.println("1~25숫자를 입력해주세요.");
            return;
        }
        System.out.println(user.getAddress()+"로 지역이 변경되었습니다.");
        System.out.println();
        System.out.println("메이페이지로 돌아갑니다 (엔터)");
        scan.nextLine();
        returnPage(user);
    }

    private void areaList(){
    String area = "1.종로구 " + " 2.중구 " + " 3.용산구 " + " 4.성동구 " + " 5.광진구\n"
            + "6.동대문구 " + " 7.중랑구 " + "8.성북구 " + " 9.강북구 " + " 10.도봉구\n"
            + "11.노원구 " + " 12.은평구 " + " 13.서대문구 " + " 14.마포구 " + " 15.양천구\n"
            + "16.강서구 " + " 17.구로구 " + " 18.금천구 " + " 19.영등포구 " + " 20.동작구\n"
            + "21.관악구 " + " 22.서초구 " + " 23.강남구 " + " 24.송파구 " + " 25.강동구\n";
    System.out.println(area);
        System.out.println("0.이전으로 돌아가기");
}

private void returnPage(Member user){
    MyPageList myPageList = new MyPageList(user);
    myPageList.myPageScreen();
}

}
