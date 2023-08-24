package com.project.cow.admin;

import java.util.Scanner;

public class BlackListManagement {
    public static void blackListScreen() {
        String blacklistFilePath = "data\\blacklist.txt"; // 텍스트 파일 경로
        String memberFilePath = "data\\member.txt";

        BlackListManager blacklistManager = new BlackListManager(blacklistFilePath, memberFilePath);

        Scanner scanner = new Scanner(System.in);
        while (true) {
        	AdminMenu.printMenu("블랙리스트 관리창");
        	
        	AdminMenu.printOption("블랙리스트 추가하기", "추가된 블랙리스트 명단 확인하기", "블랙리스트 징계 양정 기준");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    String sourceFilePath = "member.txt"; // 원본 파일 경로
                    String destinationFilePath = "blacklist.txt"; // 복사될 파일 경로
                    
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.adminMenu();
                    break;
                case 1:
                    System.out.print("블랙리스트에 추가할 사용자 번호 입력: ");
                    scanner.nextLine(); // Consume newline left-over
                    String username = scanner.nextLine();
                    blacklistManager.addToBlacklist(username);
                    System.out.println("사용자가 블랙리스트에 추가 되었습니다.");
                    
                    System.out.println();
        			System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
                    scanner.nextLine();
                    break;

                case 2:
                    String filePath = "data\\blacklist.txt"; 
                    String fileContent = TextFileReader.readTextFile(filePath);

                    if (fileContent != null) {
                        System.out.println(fileContent);
                        
                        System.out.println();
            			System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
                        scanner.nextLine();
                        
                    } else {
                        System.out.println("파일을 읽는데 오류가 발생하였습니다.");
                    }
                    break;    
                case 3:
                	AdminMenu.printMenu("블랙리스트 선정 기준");
            		System.out.println("1.판매자의 허위/도난매물 판매(부당거래),원가보다 높은 가격책정,비용 수령 후 잠수,상품을 되돌려달라고 하는 행위");
            		System.out.println("2.판매자가 책정한 가격을 임의로 내려달라고 하는 행위");
            		System.out.println("3.구매후 사용도중 본인의 과실로 생긴 물건손실을 판매자의 과실로 전가하는 행위, 물건수령 후 돈을 지급하지 않는행위");
            		System.out.println("4.거래 수락후 거래 장소에 나타나지 않는행위");
            		System.out.println();
            		

                	AdminMenu.printMenu("회원징계양정기준");
            		System.out.println("1회적발: 사이트3일 이용제한");
            		System.out.println("2회적발: 사이트7일 이용제한");
            		System.out.println("3회적발: 사이트30일 이용제한");
            		System.out.println("4회적발: 사이트영구 이용제한 및 회원정보 말소");
            		System.out.println();
            		System.out.println();
                    
                    System.out.println();
        			System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해 주세요.");
            }
        }
    }
}