package com.project.cow.admin;

import java.util.Scanner;

public class blackListMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlacklistManager blacklistManager = new BlacklistManager(null);

        while (true) {
        	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        	System.out.println("                   블랙리스트 관리창");
        	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        	System.out.println();
        	System.out.println("0. 뒤로가기");
            System.out.println("1. 블랙리스트 추가하기");
            System.out.println("2. 블랙리스트 이름 확인하기");
            System.out.println("3. 현재 총 블랙리스트 명단 확인하기");
            System.out.println("4. 블랙리스트 징계 양정 기준");
            System.out.println("5. 나가기");
            System.out.println();
            System.out.print("                버튼을 눌러 선택해주세요\n");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("블랙리스트 이름 : ");
                    String name = scanner.nextLine();
                    blacklistManager.addToBlacklist(name);
                    break;
                case 2:
                    System.out.print("블랙리스트 확인하기 : ");
                    name = scanner.nextLine();
                    if (blacklistManager.isBlacklisted(name)) {
                        System.out.println(name + " 해당 회원은 현재 블랙리스트로 등록되어 있습니다.");
                    } else {
                        System.out.println(name + " 해당 회원은 블랙리스트가 아닙니다.");
                    }
                    break;
                case 3:
                	//UserRecord();
                    String filePath = "C:\\git\\Daitso\\blacklist.txt"; 
                    String fileContent = TextFileReader.readTextFile(filePath);

                    if (fileContent != null) {
                        System.out.println("File content:");
                        System.out.println(fileContent);
                    } else {
                        System.out.println("파일을 읽는데 오류가 발생하였습니다.");
                    }
                    break;
                case 4:

                    break;        
                case 5:
                    System.out.println("안녕히가세요~ Daitso 였습니다!");
                    scanner.close();
                    System.exit(0); 
                default:
                    System.out.println("잘못된 선택입니다.다시 선택해 주세요");
            }
        }
 
	}

}


	

	


