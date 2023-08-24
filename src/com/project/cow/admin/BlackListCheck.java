package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BlackListCheck {
	
    public static void adminBlackListCheck() {
    	
        String blacklistFilePath = "C:\\git\\Daitso\\blacklist.txt"; // 텍스트 파일 경로
        String memberFilePath = "C:\\git\\Daitso\\member.txt";

        BlacklistManager blacklistManager = new BlacklistManager(blacklistFilePath, memberFilePath);

        Scanner scanner = new Scanner(System.in);
        while (true) {
        	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        	System.out.println("                   블랙리스트 관리창");
        	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        	System.out.println();
        	System.out.println("[블랙리스트 관리 기능]");
        	System.out.println("0. 돌아가기");
            System.out.println("1. 블랙리스트 추가하기");
            System.out.println("2. 추가된 블랙리스트 명단 확인하기");
            System.out.println("3. 블랙리스트 징계 양정 기준");
            System.out.println("4. 나가기");
            System.out.println();
            System.out.print("                버튼을 눌러 선택해주세요\n");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("현재 블랙리스트 :  " + blacklistManager.getBlacklist());
                    String sourceFilePath = "member.txt"; // 원본 파일 경로
                    String destinationFilePath = "blacklist.txt"; // 복사될 파일 경로
                    break;
                case 1:
                    System.out.print("블랙리스트에 추가할 사용자 숫자 입력 : ");
                    scanner.nextLine(); // Consume newline left-over
                    String username = scanner.nextLine();
                    blacklistManager.addToBlacklist(username);
                    System.out.println("사용자가 블랙리스트에 추가 되었습니다.");
                    break;

                case 2:
                    String filePath = "C:\\git\\Daitso\\blacklist.txt"; 
                    String fileContent = BlackListTextFileReader.readTextFile(filePath);

                    if (fileContent != null) {
                        System.out.println("File content:");
                        System.out.println(fileContent);
                    } else {
                        System.out.println("파일을 읽는데 오류가 발생하였습니다.");
                    }
                    break;    
                case 3:
                	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            		System.out.println("                                      블랙리스트 선정 기준");
            		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            		System.out.println("1.판매자의 허위/도난매물 판매(부당거래),원가보다 높은 가격책정,비용 수령 후 잠수,상품을 되돌려달라고 하는 행위");
            		System.out.println("2.판매자가 책정한 가격을 임의로 내려달라고 하는 행위");
            		System.out.println("3.구매후 사용도중 본인의 과실로 생긴 물건손실을 판매자의 과실로 전가하는 행위, 물건수령 후 돈을 지급하지 않는행위");
            		System.out.println("4.거래 수락후 거래 장소에 나타나지 않는행위");
            		System.out.println();
            		
            		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            		System.out.println("                                         회원징계양정기준");
            		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            		System.out.println("1회적발 : 사이트3일 이용제한");
            		System.out.println("2회적발 : 사이트7일 이용제한");
            		System.out.println("3회적발 : 사이트30일 이용제한");
            		System.out.println("4회적발 : 사이트영구 이용제한 및 회원정보 말소");
            		System.out.println();
            		System.out.println();
                    break;          
                case 4:
                    System.out.println("프로그램 끝내기.");
                    scanner.close();
                    System.exit(0);
                    break;
   
                default:
                    System.out.println("잘못된 선택 입니다. 다시 입력해 주십시오.");
            }
        }
    }


}


