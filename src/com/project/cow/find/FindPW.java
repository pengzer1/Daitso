package com.project.cow.find;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.cow.data.Member;

public class FindPW {
	
	/*
	  비밀번호 찾기 클래스
	  @author 이슬아
	  이 클래스는 입력된 아이디, 이름, 전화번호로 회원 비밀번호를 찾는 기능을 제공합니다.
	  기능:
	  - 입력된 아이디, 이름, 전화번호로 가입 시 등록한 회원 비밀번호를 찾아 출력합니다.
	  - 회원 정보 파일에서 데이터를 읽어와 검색을 수행합니다.
	 */
	

	public static void findpw() {
		
		/*
	     * 비밀번호 찾기 기능을 수행하는 메인 메소드
	     * @param scan Scanner 객체를 사용하여 사용자 입력을 처리합니다.
	     */
		
		
		Scanner scan = new Scanner(System.in);
		
		  System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	      System.out.println("           비밀번호 찾기 ");
	      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.println("[가입시 등록한 회원정보를 입력하세요.]");
		System.out.print("아이디: ");
		String id = scan.nextLine();
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String tel = scan.nextLine();
		
	
		 
			 
		     ArrayList<Member> members = memberpwd("data\\member.txt");

	        boolean foundpwd = false;
	        for (Member member : members) {
	            if (member.getId().equals(id)&&member.getName().equals(name) && member.getTel().equals(tel)) {
	            	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	            	System.out.println();
	            	System.out.println("입력하신 회원정보의 비밀번호는  " + member.getPwd()+"입니다.");
	                System.out.println();
	            	foundpwd = true;
	            	
	                System.out.println();
	                System.out.println("메인 화면으로 돌아가려면 엔터를 입력하시오.");
	                scan.nextLine();
	                break;
	            }
	        }

	        if (!foundpwd) {
	            System.out.println("입력하신 회원정보의 비밀번호를 찾을 수 없습니다.");
	            
	            System.out.println();
	            System.out.println("메인 화면으로 계속하려면 엔터를 입력하시오.");
	            scan.nextLine();
	        }
    }
	
	 /*
     * 회원 정보를 파일에서 읽어와 ArrayList로 반환하는 메소드
     * @param filename 회원 정보가 저장된 파일의 경로
     * @return ArrayList<Member> 회원 정보가 저장된 ArrayList
     */

	private static ArrayList<Member> memberpwd(String filename) {
        ArrayList<Member> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) { // 예상하는 데이터 형식에 맞는지 확인
                    String id = data[2];
                    String name = data[1];
                    String tel = data[4];
                    String pwd = data[3];
                    members.add(new Member(id, name, tel, pwd));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return members;
    }

}
