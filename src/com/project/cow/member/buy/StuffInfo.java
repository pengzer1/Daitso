package com.project.cow.member.buy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.project.cow.constant.Constant;
import com.project.cow.data.object.SellingStuff;

public class StuffInfo {
	
	public static ArrayList<SellingStuff> list;
	    static {
	        StuffInfo.list = new ArrayList<>();
	    }

	public void listLoad(){
	    try (BufferedReader br = new BufferedReader(new FileReader("data\\sellingStuff.txt"))) {
	        String line;
	        while ((line = br.readLine()) != null ) {
	            String[] temp=line.split(","); //
	            SellingStuff s = new SellingStuff(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7], temp[8],temp[9],temp[10]);
	            StuffInfo.list.add(s);
	        }
	    }
	    catch (IOException e) {
	        e.printStackTrace();

	    }
	       // StuffInfo stuffInfo = new StuffInfo();

			//SellingStuffData.load();
	        try {
	        	
	        	BufferedReader br = new BufferedReader(new FileReader("data\\sellingStuff.txt"));
	            String line;
	            int lineRead = 0;

	            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	            System.out.println("[번호]\t [제목]\t\t\t[카테고리]\t\t [물건 상태]\t[판매 가격]\t[판매자 번호]\t  [상품 거래 방식] \t[결제 방식]\t\t[등록 날짜]\t\t[마감 날짜]\t\t[찜]");

	            while ((line = br.readLine()) != null && lineRead < 10) {

	                listLoad();

	                String[] data = line.split(",");

	                String num = data[0];
	                String name = data[1];
	                String category = data[2];
	                String condition = data[6];
	                String price = data[3];
	                String seller = data[10];
	                String method = data[4];
	                String payment = data[5];
	                String from = data[7];
	                String end = data[8];
	                String like = data[9];

	                System.out.printf("%3s %-10s %17s %6s %12s %11s %10s %14s %15s %15s %6s", num, name, Constant.Category(category), Constant.Condition(condition), price, seller, Constant.Method(method), Constant.Payment(payment)           , from, end, like);
	                System.out.println();

	                lineRead++;// 10줄 출력 하기 위해
	            }


	            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        Scanner sc = new Scanner(System.in);

	        System.out.println("[구매할 물품의 번호를 입력하세요]");
	        System.out.println("구매할 물품>");
	        
	        BuyPage.sellpage();
	        
	} 
}
