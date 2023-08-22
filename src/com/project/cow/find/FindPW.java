package com.project.cow.find;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.cow.data.object.Member;

public class FindPW {
	

	public static void findpw() {
		
		
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
