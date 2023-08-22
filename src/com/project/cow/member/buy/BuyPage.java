package com.project.cow.member.buy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import com.project.cow.constant.Constant;

public class BuyPage {
    public static void sellpage() {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("[구매할 물품의 번호를 입력하세요]");
        System.out.println("구매할 물품>");
        int input = sc.nextInt();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int aaa;
        ArrayList<String[]> numList = new ArrayList<>();
        ArrayList<String> test = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/oseunghyeon/Downloads/sellingStuff.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                numList.add(data);
                test.add(data[0]);

                //SellingStuff sellingStuff = new SellingStuff(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[9], data[10], data[11]);
                //list.add(sellingStuff);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        aaa = -1;

        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).equals(input + "")) {
                aaa = 1;
            }
        }

        if (aaa > 0) {
            System.out.println("판매 페이지로 이동합니다.");
            System.out.println("판매 페이지로 이동하려면 Enter를 눌러주세요");

            sc.nextLine();
            sc.nextLine(); // 두번하지 않으면 한번에 엔터 안눌러도 나와
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            StuffInfo.listLoad();

            System.out.println("\t[제목]\t\t\t    [카테고리]\t\t[물건 상태]\t[판매 가격]\t[판매자명]\t[상품 거래 방식]\t[결제 방식]\t[등록 날짜]  \t [마감 날짜]\t [찜]");


            System.out.printf("%s %20s %7s %13s %10s %12s %13s %13s %12s %4s\n", StuffInfo.list.get(input - 1).getName(), Constant.Category(StuffInfo.list.get(input - 1).getCategory())
                    , Constant.Condition(StuffInfo.list.get(input - 1).getCondition()), StuffInfo.list.get(input - 1).getPrice(), StuffInfo.list.get(input - 1).getSellerNo(), Constant.Method(StuffInfo.list.get(input).getMethod())
                    , Constant.Payment(StuffInfo.list.get(input - 1).getPayment()), StuffInfo.list.get(input - 1).getFrom(), StuffInfo.list.get(input - 1).getUntil(), StuffInfo.list.get(input - 1).getLike());


            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("물품 거래 날짜를 선택하세요");
            System.out.println("날짜 설정하기");

            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            Scanner scanner = new Scanner(System.in);


            String startDateStr = StuffInfo.list.get(input - 1).getFrom();


            String endDateStr = StuffInfo.list.get(input - 1).getUntil();

            System.out.print("확인할 날짜 (yyyy-MM-dd): ");
            String checkDateStr = scanner.next();

            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);
            LocalDate checkDate = LocalDate.parse(checkDateStr);

            StuffInfo.listLoad();

            if (isWithinDateRange(checkDate, startDate, endDate)) {
                System.out.println("물품을 구매를 진행합니다.");
                System.out.println();
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("이전화면으로 돌아가려면 0번을 누르세요.");
                int num=0;
                num = sc.nextInt();
                BuyMenu.FirstScreen();



            } else {
                System.out.println("해당 기간에 물품을 판매하지 않습니다.");
            }


        }

    }

    public static boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}

