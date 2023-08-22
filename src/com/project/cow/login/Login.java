package com.project.cow.login;

import java.util.Calendar;
import java.util.Scanner;

import com.project.cow.data.Data;
import com.project.cow.data.Member;
import com.project.cow.data.object.BlackList;
import com.project.cow.member.MemberMenu;

public class Login {

	public static Member login; //로그인을 성공한 회원의 객체

	public static void login() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("             로그인");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.print("아이디:");
		String id = scan.nextLine().trim();
		
		System.out.print("비밀번호:");
		String pwd = scan.nextLine().trim();
		
		//관리자 로그인 화면
		if(id.equals("admin")&&pwd.equals("admin")) {
			System.out.println("관리자로 로그인 되었습니다");
			System.out.println("엔터를 누르면 관리자 메뉴로 이동합니다.");
			scan.nextLine();
			
			return;
		}
		
////	블랙리스트 회원 조회
    for(BlackList bl : Data.blackList) {
    	
    	int vanValue = Integer.parseInt(bl.getVan());
    
    	if(bl.getId().equals(id)) {
    	
    		if(vanValue==0) {
        		System.out.println("영구제한 회원입니다.");
                System.out.println();
                System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
                scan.nextLine();
        		//TODO 화면 초기화면
        	}else {
        		if(isBlocked(bl)) {
            		System.out.println("사용이 제한된 회원입니다.");
                    System.out.println();
                    System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
                    scan.nextLine();
            		//TODO 초기화면 돌리기
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
		

		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		if (Login.login != null) {
			
			System.out.println("로그인 성공!");
			
		      System.out.println("엔터를 누르면 회원 메뉴로 이동됩니다.");
		      scan.nextLine();
		      
		      MemberMenu.membermenu();
		      
		} else {
			System.out.println("회원 정보가 일치하지 않습니다.");
            System.out.println();
            System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
            scan.nextLine();
		}
		
	
	
	    }
	
	
	public static void logout() {
		
		Login.login = null; //인증 티켓 제거 == 로그아웃
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("로그아웃 되었습니다.");
		System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
		
		
	}
	
	
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
    	
    	if(now1>present1) {
    		return true;
    	}

    	return false;
     }

	
}
