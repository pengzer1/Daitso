package com.project.cow.login;

import java.util.Scanner;

import com.project.cow.Main;
import com.project.cow.data.Data;
import com.project.cow.member.MemberMenu;
import com.project.cow.mypage.Member;

public class Login {

	public static com.project.cow.data.object.Member login; //로그인을 성공한 회원의 객체
	public static Member user;
	
	public static void login() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("             로그인");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.print("아이디:");
		String id = scan.nextLine().trim();
		
		System.out.print("비밀번호:");
		String pwd = scan.nextLine().trim();
	
		for (com.project.cow.data.object.Member m : Data.list) {
			
			if (m.getId().equals(id) && m.getPwd().equals(pwd)) {
				
				//회원O > static
				Login.login = m; //******
				break;
				
			}
			
		} //for
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		if (Login.login != null) {
			
			System.out.println("로그인 성공!");
			
			user = new Member(login.getNo(), login.getName(), login.getId(), login.getPwd(), login.getTel(), login.getJumin(), login.getEmail(), login.getAddress(), login.getAccount(), login.getMoney(), login.getGrade());
			
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
		
		Scanner scan = new Scanner(System.in);
		
		Login.login = null; //인증 티켓 제거 == 로그아웃
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("로그아웃 되었습니다.");
		System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
		scan.nextLine();
		
		Main.MainScreen();
	}
	
}
