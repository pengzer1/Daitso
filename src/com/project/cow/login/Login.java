package com.project.cow.login;

import java.util.Calendar;
import java.util.Scanner;

import com.project.cow.Main;
import com.project.cow.admin.AdminMenu;
import com.project.cow.data.BlackListData;
import com.project.cow.data.Data;
import com.project.cow.data.object.BlackList;
import com.project.cow.data.object.Member;
import com.project.cow.member.MemberMenu;
import com.project.cow.mypage.User;

public class Login {

	public static Member login; //로그인을 성공한 회원의 객체
	public static User user;
	
	 /*
     * 로그인 기능을 수행하는 메인 메소드
     * 이 메소드는 사용자로부터 아이디와 비밀번호를 입력받아 로그인을 시도하고, 회원 정보를 검증하여 로그인 여부를 결정합니다.
     */

	public static void login() {
		
		Scanner scan = new Scanner(System.in);
		AdminMenu.printMenu("로그인");
		
		System.out.print("아이디:");
		String id = scan.nextLine().trim();
		
		System.out.print("비밀번호:");
		String pwd = scan.nextLine().trim();
		
		//관리자 로그인 화면
		if(id.equals("admin")&&pwd.equals("admin")) {
			System.out.println("관리자로 로그인 되었습니다.");
			System.out.println("Enter를 누르면 관리자 메뉴로 이동합니다.");
			scan.nextLine();
			
			AdminMenu adminMenu = new AdminMenu();
			adminMenu.adminMenu();
		}
		
////	블랙리스트 회원 조회
    for(BlackList bl : BlackListData.blackList) {
    	
    	int vanValue = Integer.parseInt(bl.getVan());
    
    	if(bl.getId().equals(id)) {
    	
    		if(vanValue==0) {
    			AdminMenu.printLine();
        		System.out.println("영구제한 회원입니다.");
                System.out.println();
                System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
                scan.nextLine();
        		Main.MainScreen();
        	}else {
        		if(isBlocked(bl)) {
        			AdminMenu.printLine();
            		System.out.println("사용이 제한된 회원입니다.");
                    System.out.println();
                    System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
                    scan.nextLine();
            		Main.MainScreen();
            	}
        		
        	}
    	}
    	
   	}
        	
        	
        //회원 정보 조회
		for (Member m : Data.list) {
			
			if (m.getId().equals(id) && m.getPwd().equals(pwd)) {
				
				//회원O > static
				Login.login = m; //******
				break;
				
			}
			
		} //for
		

		
		AdminMenu.printLine();
		if (Login.login != null) {
			
			System.out.println("로그인 되었습니다.");
			
			 user = new User(login.getNo(), login.getName(), login.getId(), login.getPwd(), login.getTel(), login.getJumin(), login.getEmail(), login.getAddress(), login.getAccount(), login.getMoney(), login.getGrade());


             System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
		      scan.nextLine();
		      
		      MemberMenu.membermenu();
		      
		} else {
			System.out.println("회원 정보가 일치하지 않습니다.");
            System.out.println();
            System.out.println("메인화면으로 돌아가려면 엔터를 입력하세요.");
            scan.nextLine();
		}
		
	
	
	    }
	
    /*
      로그아웃 기능을 수행하는 메소드
     */
	
	public static void logout() {
		
		Login.login = null; //인증 티켓 제거 == 로그아웃
		
		AdminMenu.printLine();
		System.out.println("로그아웃 되었습니다.");
        System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
		System.out.println();
		
		
	}
	
	/*
    * 블랙리스트 회원이 사용 제한 상태인지를 확인하는 메소드
    *
    * @param blackList 블랙리스트 객체
    * @return 사용 제한 상태 여부
    */
	
	
    private static boolean isBlocked(BlackList blackList) {
    	Calendar now = Calendar.getInstance();  
    	Calendar present = Calendar.getInstance(); 
       
    	String[] temp =blackList.getAgo().split("-");
    		//2022-08-17,3
    	
   
    	//now.set(Calendar.YEAR,Integer.parseInt(temp[0]));
    	now.set(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2]));
       
    	now.add(now.DATE,Integer.parseInt(blackList.getVan()));  //2022-08-20
    	
    	long now1 = now.getTimeInMillis();
    	long present1 = present.getTimeInMillis();
    	
    	if(now1<present1) {
    		return true;
    	}

    	return false;
     }

	
}
