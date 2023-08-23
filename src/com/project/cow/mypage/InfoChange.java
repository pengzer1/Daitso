package com.project.cow.mypage;

import java.util.Scanner;

import com.project.cow.admin.AdminMenu;
import com.project.cow.data.Data;

public class InfoChange {  //회원 정보 수정
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public void changeMyInfo(User user) {// 아이디,비밀번호 , 휴대폰번호 , 동네
        System.out.println();
        while (true) {
        	AdminMenu.printMenu("회원 정보 수정");
        	AdminMenu.printOption("아이디 변경", "비밀번호 변경", "휴대폰 번호 변경", "동네 변경");
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

    private void changeId(User user){ // 아이디 변경 메서드
    	AdminMenu.printMenu("아이디 변경");
        System.out.println("현재 아이디: " + user.getId());
        System.out.println("(변경을 취소하시려면 0을 입력하세요.)");
        System.out.print("변경할 아이디: " );
        String input = scan.nextLine().trim();
        if (input.equals("0")) {
            changeMyInfo(user);
        }
        user.setId(input);
        Data.memberSave(); // 변경된 아이디 덮어씌우기
        System.out.println("Enter를 누르면 마이페이지로 돌아갑니다.");
        scan.nextLine();
        returnPage(user);

    }

    private void changePw(User user) {
    	AdminMenu.printMenu("비밀번호 변경");
        System.out.println("현재 비밀번호: " + user.getPassword());
        System.out.println("(변경을 취소하시려면 0을 입력하세요.)");
        System.out.print("변경할 비밀번호: ");
        String input = scan.nextLine().trim();
        if (input.equals("0")) {
            changeMyInfo(user);
        }
        user.setPassword(input);
        Data.memberSave();
        System.out.println("Enter를 누르면 마이페이지로 돌아갑니다.");
        scan.nextLine();
        returnPage(user);

    }
private void changePhoneNumber(User user){
	AdminMenu.printMenu("휴대폰 번호 변경");
    System.out.println("현재 전화번호: " + user.getPhoneNumber());
    System.out.println("(변경을 취소하시려면 0을 입력하세요.)");
    System.out.print("변경할 전화번호: ");
    String input = scan.nextLine().trim();
    if (input.equals("0")) {
        changeMyInfo(user);
    }
    user.setPhoneNumber(input);
    Data.memberSave();
    System.out.println("Enter를 누르면 마이페이지로 돌아갑니다.");
    scan.nextLine();
    returnPage(user);

}
private void changeLivingArea(User user){
	AdminMenu.printMenu("동네 변경");
    System.out.println("현재 동네: " + user.getLivingArea());
    System.out.println();
    System.out.println("지역을 선택해 주세요.");
    areaList();
    System.out.print("번호 선택 : ");
    String input = scan.nextLine();
    areaSelect(user, input);
    Data.memberSave();
}

    private void areaSelect(User user, String input) {
        switch (input) {
            case "0":
                changeMyInfo(user);
            case "1":
                user.setLivingArea("종로구");
                break;
            case "2":
                user.setLivingArea("중구");
                break;
            case "3":
                user.setLivingArea("용산구");
                break;
            case "4":
                user.setLivingArea("성동구");
                break;
            case "5":
                user.setLivingArea("광진구");
                break;
            case "6":
                user.setLivingArea("동대문구");
                break;
            case "7":
                user.setLivingArea("중랑구");
                break;
            case "8":
                user.setLivingArea("성북구");
                break;
            case "9":
                user.setLivingArea("강북구");
                break;
            case "10":
                user.setLivingArea("도봉구");
                break;
            case "11":
                user.setLivingArea("노원구");
                break;
            case "12":
                user.setLivingArea("은평구");
                break;
            case "13":
                user.setLivingArea("서대문구");
                break;
            case "14":
                user.setLivingArea("마포구");
                break;
            case "15":
                user.setLivingArea("양천구");
                break;
            case "16":
                user.setLivingArea("강서구");
                break;
            case "17":
                user.setLivingArea("구로구");
                break;
            case "18":
                user.setLivingArea("금천구");
                break;
            case "19":
                user.setLivingArea("영등포구");
                break;
            case "20":
                user.setLivingArea("동작구");
                break;
            case "21":
                user.setLivingArea("관악구");
                break;
            case "22":
                user.setLivingArea("서초구");
                break;
            case "23":
                user.setLivingArea("강남구");
                break;
            case "24":
                user.setLivingArea("송파구");
                break;
            case "25":
                user.setLivingArea("강동구");
                break;
            default:
                System.out.println("1~25 숫자를 입력하세요.");
            return;
        }
        System.out.println(user.getLivingArea()+"로 지역이 변경되었습니다.");
        System.out.println();
        System.out.println("Enter를 누르면 마이페이지로 돌아갑니다.");
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
        System.out.println("0. 돌아가기");
}

private void returnPage(User user){
    MyPageList myPageList = new MyPageList(user);
    myPageList.myPageScreen();
}

}
