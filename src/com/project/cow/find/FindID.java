package com.project.cow.find;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.cow.data.Member;

public class FindID {


	/*
	 아이디 찾기 클래스
	 @author 이슬아
	 목적: 입력된 이름과 전화번호로 회원 아이디를 찾는 기능을 제공하는 클래스
	 기능:
	 - 입력된 이름과 전화번호로 가입 시 등록한 회원 아이디를 찾아 출력한다.
	 - 회원 정보 파일에서 데이터를 읽어와 검색을 수행한다.
	 */

	public static void findId() {
		
		
		/*
		  목적:
		  - 회원 아이디 찾기 기능을 구현하여 사용자에게 정보 제공을 도와줍니다.
		  매개변수:
		  - 없음
		  반환 값:
		  - 없음
		 */
		
		Scanner scan = new Scanner(System.in);
		
		  System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	      System.out.println("            아이디 찾기");
	      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		System.out.println("[가입시 등록한 회원정보를 입력하세요.]");
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호: ");
		String tel = scan.nextLine();
		
	
		 
			 
		     ArrayList<Member> members = memberId("data\\member.txt");

	        boolean found = false;
	        for (Member member : members) {
	            if (member.getName().equals(name) && member.getTel().equals(tel)) {
	            	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	            	System.out.println();
	            	System.out.println("입력하신 회원정보의 아이디는  " + member.getId()+"입니다.");
	                System.out.println();
	            	found = true;
	                System.out.println();
	                System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
	                scan.nextLine();
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("입력하신 회원정보의 아이디를 찾을 수 없습니다.");
                System.out.println();
                System.out.println("초기화면으로 돌아가려면 엔터를 입력하세요.");
                scan.nextLine();
	        }
	    }

		
		/*
		 * 회원 정보를 파일에서 읽어와 ArrayList로 반환하는 메소드
		 * @param filename 회원 정보가 저장된 파일의 경로
		 * @return ArrayList<Member> 회원 정보가 저장된 ArrayList
		 */
		private static ArrayList<Member> memberId(String filename) {
	        ArrayList<Member> members = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(",");
	                if (data.length >= 3) { // 예상하는 데이터 형식에 맞는지 확인
	                    String id = data[2];
	                    String name = data[1];
	                    String tel = data[4];
	                    members.add(new Member(id, name, tel));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return members;
	    }	
		
	}





		

