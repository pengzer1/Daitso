package com.project.cow.admin;

import java.util.Scanner;

public class ProhibitedItems {
    public static void prohibitScreen() {
        String prohibitedItemsFilePath = "data\\prohibited_items.txt"; // 금지물품 파일 경로
 
        ProhibitedItemsManager prohibitedItemsManager = new ProhibitedItemsManager(prohibitedItemsFilePath);

        Scanner scanner = new Scanner(System.in);
        while (true) {
        	AdminMenu.printMenu("중고거래 제한물품 관리창");
        	
            System.out.println("1. 금지물품 추가하기");
            System.out.println("2. 물품 금지여부 확인하기");
            System.out.println("3. 추가된 금지물품 명단 확인하기");
            System.out.println("4. 금지물품 선정기준 확인하기");
            System.out.println("0. 돌아가기");
            System.out.println();
            System.out.print("원하시는 항목을 입력하여 주세요.\r\n");
            AdminMenu.printLine();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
            case 0:
                System.out.println("관리자 메인 페이지로 이동합니다.");
                scanner.nextLine();
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.adminMenu();
                case 1:
                    System.out.print("금지된 물품 목록에 추가할 물품 입력하십시오: ");
                    String newItem = scanner.nextLine();
                    prohibitedItemsManager.addProhibitedItem(newItem);
                    System.out.println("금지물품 항목에 추가 되었습니다.");
                    
                    System.out.println();
                    System.out.println("Enter를 눌러 이전화면으로 돌아가기");
                    scanner.nextLine();
                    break;         
                case 2:
                    System.out.print("금지여부를 확인할 항목을 입력하십시오: ");
                    String itemToCheck = scanner.nextLine();
                    if (prohibitedItemsManager.isProhibited(itemToCheck)) {
                        System.out.println(itemToCheck + "은" + " 금지되었습니다.");
                    } else {
                        System.out.println(itemToCheck +  "은" + " 금지되지않았습니다."); 
                    }
                    
                    System.out.println();
                    System.out.println("Enter를 눌러 이전화면으로 돌아가기");
                    scanner.nextLine();
                    break;
                case 3:
                    String filePath = "data\\prohibited_items.txt"; 
                    String fileContent = TextProhibitFileReader.readTextFile(filePath);
                    if (fileContent != null) {
                        System.out.println(fileContent);
                        System.out.println();
                        System.out.println("Enter를 눌러 이전화면으로 돌아가기");
                        scanner.nextLine();
                    } else {
                        System.out.println("파일을 읽는데 오류가 발생하였습니다.");
                    }
                    break;       
                case 4:
                	AdminMenu.printMenu("금지물품 선정기준");
            		System.out.println("사용자, 판매자의 안전을 위협하는 물품 : \r\n"
            				+ "총포류, 화약류, 도검류, 유통기한이 명시되지않은 식품류, 유통기한이 지난 식품류, 화학제품류, 인/허가 받지않은 약품류,폭발물 등\r\n");
            		System.out.println("외설적인 요소가 첨가되어있는 물품 : \r\n"
            				+ "시청연령이 제한되어있는  비디오, dvd, 라디오카세트, 책, 잡지, cd  등 일반인이 보기에 성적인 불쾌감을 주는 일체의 물건들\r\n");
            		System.out.println("법적으로 소지 및 취급이 금지되어있는 물품 : \r\n"
            				+ "마약(어떠한 형태든지 유통이 금지된 마약류 일체)\r\n,반체제 선전물(대한민국 헌법상 휴전선 이북을 강제점거하고있는 반국가 단체의 선전물\r\n,"
            				+ "반국가 단체의 정부수반을 찬양 공모하는 글, 동영상 등)정치적 성향이나 색깔이 담겨있는 모든형태의 물품일체\r\n,"
            				+ "사이비라고 명시된 집단에서 공유되고 유통되고있는 일체의 물품들\r\n");
            		System.out.println("법적인 제약사항은 없으나 제품의 하자를 명시하지 않거나 제품의 상세 정보를 속인 물품들\r\n");
            		break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}