package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class blacklist1 {
   
   /*
      관리자 메인 페이지 화면 출력 클래스
      
      @author 이승원
   */
   
   public static final String GUEST_LIST = "C:\\Class\\code\\java\\Daitso\\src\\com\\project\\cow\\admin\\Data\\member.txt";
   
   public static void main(String[] args) {
      
      adminMain();
      
      }//main
   
   public static void adminMain() {
      Scanner scan = new Scanner(System.in);
      boolean loop = true;

      while (true) {
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
         System.out.println("               관리자 메인 메뉴");
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
         System.out.println("1. 회원 관리");
         System.out.println("2. 블랙리스트 관리");
         System.out.println("3. 중고 물품 관리");
         System.out.println("4. 고객센터 Q & A");
         System.out.println("5. 각 지역 우편함");
         System.out.println("6. 중고거래 제한물품");
         System.out.println("0. 돌아가기");
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

         System.out.print("번호 입력: ");
         String input = scan.nextLine().trim();
         scan.skip("\r\n");
         
         System.out.println();
         System.out.println();

         if (input.equals("1")) {
            //회원 관리
            adminMemberManage();
         } else if (input.equals("2")) {
            //블랙리스트 관리
            
         } else if (input.equals("3")) {
            //중고 물품 관리
            
         } else if (input.equals("4")) {
            //고객센터 Q & A 
            
         } else if (input.equals("5")) {
            //중고거래 제한물품
            
         } else {
            // 이전 화면
            loop = false;
         }
      }
   }//adminMain
   
   public static void adminMemberManage() {
      Scanner scan = new Scanner(System.in);
      
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.println("              전체 회원 목록 조회");
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      
      try {
         BufferedReader reader = new BufferedReader(new FileReader(GUEST_LIST));
         String member;
         
         System.out.printf("정렬등급: %s (총 회원 수 %d명 중 %d명)\r\n", "1++", 7000, 465);
         System.out.println("[번호] [이름]    [아이디]      [비밀번호]  [전화번호]     [주민번호]           [이메일]          [지역]      [계좌번호]     [보유금액] [회원등급]");
         
         while ((member = reader.readLine()) != null) {
            String[] data = member.split(",");   
            
            if (data[10].equals("1++등급")) {
               printMemberInfo(data); // 회원 정보 출력 메소드 호출
            }
         }

         reader.close();
         
      } catch (IOException e) {
         System.out.println("Error");
         e.printStackTrace();
      }
      
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.println("[회원 목록 정렬]");
      System.out.println("1. 등급별 정렬");
      System.out.println("2. 이름순 정렬");
      System.out.println("3. 나이순 정렬");
      System.out.println("4. 주소별 정렬");
      System.out.println("0. 돌아가기");
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.print("번호 입력 : ");
      String input = scan.nextLine();
      scan.skip("\r\n");
      
      System.out.println();
      System.out.println();

   }//adminMemberManage
   
   //회원 정보 출력 메소드
   private static void printMemberInfo(String[] data) {
      
      String no = data[0];
      String name = data[1];
      String id = data[2];
      String pw = data[3];
      String tel = data[4];
      String jumin = data[5];
      String email = data[6];
      String region = data[7];
      String account = data[8];
      String money = data[9];
      String rating = data[10];
      
      //지역 계좌번호 사이 띄어쓰기 출력이 제대로 되지 않음
      //System.out.printf("%4s %5s %-12s %-12s %13s %14s %-23s %-6s %16s %10s %6s\r\n", no, name, id, pw, tel, jumin, email, region, account, money, rating);
      
      System.out.printf("%4s %5s %-14s %-12s %13s %14s %-24s %-5s", no, name, id, pw, tel, jumin, email, region);
      
      for (int i=0; i<4-region.length(); i++) {
         System.out.print(" ");
      }
      
      System.out.printf("%16s %,9d %7s\r\n", account, Integer.parseInt(돈), rating);
   }
}
