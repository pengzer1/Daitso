package com.project.cow.join;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.project.cow.admin.AdminMenu;
import com.project.cow.data.Data;
import com.project.cow.data.object.Member;


/*
 * 회원가입 클래스
 * 이 클래스는 사용자로부터 입력을 받아 회원 정보를 등록하는 기능을 제공합니다.
 * 기능:
 * - 아이디, 비밀번호, 이름, 주민등록번호, 전화번호, 이메일, 지역, 계좌번호를 입력받아 회원 정보를 등록합니다.
 * - 중복된 아이디는 등록할 수 없습니다.
 * 목적:
 * - 사용자의 정보를 입력받아 회원으로 등록하여 서비스 이용을 가능하게 합니다.
 */
public class Join {
	
    private String id;
    private String pwd;
    private String name;
    private String tel;
    private String jumin;
    private String email;
    private String address;
    private String account;
    
    /*
      회원가입 기능을 수행하는 메인 메소드

     */

	public void join() {
		
		Scanner scan = new Scanner(System.in);
		
		
		  System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	      System.out.println("             회원가입");	      
	      
	      // 아이디 입력 받음
	      id();
	      

	      System.out.println();
	      System.out.println("회원가입이 완료되었습니다.");
	      
	      System.out.println();
	      System.out.println("계속하려면 엔터를 입력하세요.");
	      scan.nextLine();
	      
	      // 회원 번호 생성 로직
	      String maxNo = Data.list.stream()
	               .map(s->s.getNo())
	               .max((a,b)->Integer.parseInt(a)-Integer.parseInt(b))
	               .get();
	   int no = Integer.parseInt(maxNo)+1;
	   
	   // 회원 등급 설정 및 생성
	   String maxmemberNo = Data.list.stream()
	                  .map(s->s.getNo())
	                  .max((a,b)->Integer.parseInt(a)-Integer.parseInt(b))
	                  .get();
	   
	   int memberNo = Integer.parseInt(maxmemberNo)+1;
	      
	        // 회원 정보 생성
	      Member newMember = new Member(Integer.toString(no),name,id, pwd,tel, jumin,email, address, account,"0","3등급");

	        // 회원 정보를 데이터 리스트에 추가
	        Data.list.add(newMember);

	        // 데이터 저장
	        Data.memberSave();
	        
	}

	private  void account() {
		
		Scanner scan = new Scanner(System.in);
		AdminMenu.printLine();

		System.out.println("[계좌번호] 은행 1.가나 2.다라 3.마바 4.사아 5.자차 ");
		System.out.println("Ex) 가나-1234567891234");
		AdminMenu.printLine();
	      System.out.print("계좌번호: ");
	      String account = scan.nextLine().trim();
	      
	      if (account.matches("(가나|다라|마바|사아|자차)-\\d{13}")) {
	    	  this.account=account;
	    	  
	      }else {
	    	  System.out.println();
	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
	    	  account();
	      }
		
	}
	

	private void address() {
		
	    Scanner scan = new Scanner(System.in);
	    AdminMenu.printLine();

	      System.out.println("[지역설정] 서울시 25개 자치구만 설정 가능합니다. ");
	      System.out.println("다음 중 원하는 지역 번호를 입력하세요 ");
	      System.out.println();
	      areaList();
	      AdminMenu.printLine();
	      System.out.print("지역 설정: ");
	      String address = scan.nextLine().trim();
	      areaSelect(address);
	      System.out.println();   
	      account();
	      }


	private void areaSelect(String address) {
        switch (address) {
            case "1":
                this.address="종로구";
                break;
            case "2":
            	this.address="중구";
                break;
            case "3":
            	this.address="용산구";
                break;
            case "4":
            	this.address="성동구";
                break;
            case "5":
            	this.address="광진구";
                break;
            case "6":
            	this.address="동대문구";
                break;
            case "7":
            	this.address="중랑구";
                break;
            case "8":
            	this.address="성북구";
                break;
            case "9":
            	this.address="강북구";
                break;
            case "10":
            	this.address="도봉구";
                break;
            case "11":
            	this.address="노원구";
                break;
            case "12":
            	this.address="은평구";
                break;
            case "13":
            	this.address="서대문구";
                break;
            case "14":
            	this.address="마포구";
                break;
            case "15":
            	this.address="양천구";
                break;
            case "16":
            	this.address="강서구";
                break;
            case "17":
            	this.address="구로구";
                break;
            case "18":
            	this.address="금천구";
                break;
            case "19":
            	this.address="영등포구";
                break;
            case "20":
            	this.address="동작구";
                break;
            case "21":
            	this.address="관악구";
                break;
            case "22":
            	this.address="서초구";
                break;
            case "23":
            	this.address="강남구";
                break;
            case "24":
            	this.address="송파구";
                break;
            case "25":
            	this.address="강동구";
                break;
                
            default:
            	System.out.println();
                System.out.println("올바른 지역 번호를 다시 입력하세요");
                address();
        }
        
        
    }


	    private void areaList(){
	    String area = "1.종로구" + "\t2.중구" + "\t3.용산구" + "\t4.성동구" + "\t5.광진구\n"
	            + "6.동대문구" + "\t7.중랑구" + "\t8.성북구" + "\t9.강북구" + "\t10.도봉구\n"
	            + "11.노원구" + "\t12.은평구" + "\t13.서대문구"+"\t14.마포구" + "\t15.양천구\n"
	            + "16.강서구" + "\t17.구로구" + "\t18.금천구" + "\t19.영등포구" + "\t20.동작구\n"
	            + "21.관악구" + "\t22.서초구" + "\t23.강남구" + "\t24.송파구" + "\t25.강동구\n";
	    System.out.println(area);
	}
	      
	

	private void email() {
		
		Scanner scan = new Scanner(System.in);
		AdminMenu.printLine();
		System.out.println("[이메일] @를 포함하여 입력하세요");
		System.out.println("Ex) ssangyong@naver.com");
		AdminMenu.printLine();
	      System.out.print("이메일: ");
	      String email = scan.nextLine().trim();
	      
	      if(email.length()>3&&Pattern.matches("[a-z0-9]+@[a-z]+.[a-z]+",email)) {
	    	  this.email=email;
	    	  System.out.println();
	    	  address();
	    	  
	      }else {
	    	  System.out.println();
	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
	    	  email();
	      }
	      
	}

	private void jumin() {

		Scanner scan = new Scanner(System.in);
		AdminMenu.printLine();
	      System.out.println("[주민등록번호] '-' 포함해서 입력해주세요. \r\n Ex)000000-000000");
	      AdminMenu.printLine();
	      System.out.print("주민등록번호: ");
	      String jumin = scan.nextLine().trim();
	      Random rd = new Random();
	      
	      if(jumin.matches("\\d{6}-[1234]\\d{6}")) {

	    	  String[] temp = jumin.split("-");
	    	  
             int month =Integer.valueOf(temp[0].substring(2, 4)) ;
            int day =Integer.valueOf(temp[0].substring(4, 6));
            int gender = Integer.valueOf(temp[1].substring(0, 1));
            
            if(month >= 1 && month <= 12 ) {
            	if (day >= 1 && day <= 30 ) {
            	
            		
            		this.jumin=jumin;
      	    	  System.out.println();
      	    	  email();
            	}
            	else {
                    System.out.println();
        	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
        	    	  jumin();
            	}
            }  
            else {
                System.out.println();
    	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
    	    	  jumin();
            }
	    	  
	    	  
	      }else {
	    	  System.out.println();
	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
	    	  jumin();
	      }
		
	}

	private void tel() {
		
		Scanner scan = new Scanner(System.in);
		AdminMenu.printLine();
	      System.out.println("[전화번호] -를 포함해서 입력하세요.  "
	      		+ "\r\n Ex) 010-1234-5678 ");
	      AdminMenu.printLine();
	      System.out.print("전화번호: ");
	      String tel = scan.nextLine().trim();
	      
	      if(tel.matches("010-\\d{4}-\\d{4}")) {
	    	  this.tel=tel;
	    	  System.out.println();
	    	  jumin();
	    	  
	      }else {
	    	  System.out.println();
	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
	    	  tel();
	      }
	      
		
	}

	private void name() {
		
		Scanner scan = new Scanner(System.in);
		AdminMenu.printLine();
		System.out.println("[이름] 한글만 입력 가능합니다. ");
		AdminMenu.printLine();
		System.out.print("이름:");
	      String name = scan.nextLine().trim();
	      if(name.length()>1&&name.length()<7&&Pattern.matches("[가-힣]*", name)) {
	    	  this.name=name;
	    	  System.out.println();
	    	  tel();
	    	  
	      }else {
	    	  System.out.println();
	    	  System.out.println("올바른 형식으로 다시 입력하세요.");
	    	  name();
	      }
		
	}

	private void password() {
		
		Scanner scan = new Scanner(System.in);
		AdminMenu.printLine();

	      System.out.println("[비밀번호] 4~12 글자 사이 영어+숫자로만 입력하세요.");
	      AdminMenu.printLine();
	      System.out.print("비밀번호: ");
	      String pwd = scan.nextLine().trim();
	      
	      
	      
	      if(pwd.length()>3&&pwd.length()<13&&Pattern.matches("[A-Za-z0-9]*", pwd)){
	    	  this.pwd=pwd;
	    	  System.out.println();
	  	    name();
	  	    
		    }else {
		    	System.out.println();
		    	System.out.println("올바른 형식으로 다시 입력하세요.");
		    	password();
		    }
		
	}
	// 아이디 입력 및 중복 체크
	private void id() {
		Scanner scan=new Scanner(System.in);
		AdminMenu.printLine();
		System.out.println("[아이디] 4~16 글자 사이 영어+숫자로만 입력하세요.");
		System.out.println("중복 아이디는 불가능합니다.");
		AdminMenu.printLine();
		
	    System.out.print("아이디: ");
	    String id = scan.nextLine().trim();
	    this.id = id;
	    
	    // 아이디 길이와 형식 검사
	    if(id.length()>3&&id.length()<=16&&Pattern.matches("[A-Za-z0-9]*", id)){
	    	
	    	// 중복 체크
	    	if(doublecheck(id)) {
	    		this.id = id;
	    		System.out.println();
	    		password();
	    		
	    	}else {
	    		AdminMenu.printLine();
	    		System.out.println("이미 사용 중인 아이디입니다.");
	    		System.out.println();
	    		id();
	    	}
	    	
	    }else {
	    	System.out.println();	
	    	System.out.println("올바른 형식으로 다시 입력하세요.");
	    	id();
	    }
		
	}
	
	// 중복 아이디 체크 메소드
	private static boolean doublecheck(String id) {
		
		for(Member member : Data.list){
			if(member.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	
	
}