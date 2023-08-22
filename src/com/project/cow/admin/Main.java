package com.project.cow.admin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String prohibitedItemsFilePath = "C:\\git\\Daitso\\prohibited_items.txt"; // 금지물품 파일 경로

        ProhibitedItemsManager prohibitedItemsManager = new ProhibitedItemsManager(prohibitedItemsFilePath);

        Scanner scanner = new Scanner(System.in);
        while (true) {
        	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        	System.out.println("                 중고거래 제한물품 관리창");
        	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        	System.out.println();
        	System.out.println("0. 뒤로가기");
            System.out.println("1. 금지물품 추가하기");
            System.out.println("2. 물품 금지여부 확인");
            System.out.println("3. 다른클래스로 이동하기");
            System.out.println();
            System.out.print("원하시는 항목을 입력하여 주세요.\r\n");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
            case 0:
                System.out.println("뒤로가기");
                scanner.close();
                System.exit(0);
                case 1:
                    System.out.print("금지된 물품 목록에 추가할 물품 입력하십시오: ");
                    String newItem = scanner.nextLine();
                    prohibitedItemsManager.addProhibitedItem(newItem);
                    System.out.println("금지물품 항목에 추가 되었습니다.");
                    break;
                case 2:
                    System.out.print("금지여부를 확인할 항목을 입력하십시오: ");
                    String itemToCheck = scanner.nextLine();
                    if (prohibitedItemsManager.isProhibited(itemToCheck)) {
                        System.out.println(itemToCheck + "은" + " 금지되었습니다.");
                    } else {
                        System.out.println(itemToCheck +  "은" + " 금지되지않았습니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}