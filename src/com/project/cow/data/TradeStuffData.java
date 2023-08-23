package com.project.cow.data;
import java.io.*;
import java.util.ArrayList;
import com.project.cow.data.object.LikeItem;
import com.project.cow.data.object.TradeStuff;

public class TradeStuffData {
	public static ArrayList<TradeStuff> tradeList;   //거래 예정 물품 목록
	static {
		TradeStuffData.tradeList = new ArrayList<TradeStuff>();
	}
	
	public static void tradeStuffLoad() {  // 판매 예정된 물품 목록
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\code\\java\\Project\\data\\tradeStuff.txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                TradeStuff tradeStuff = new TradeStuff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                tradeList.add(tradeStuff);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("at Data.load");
            e.printStackTrace();
        }
    }
	
	public static void tradeStuffSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\code\\java\\Project\\data\\tradeStuff.txt"));
			
			for(TradeStuff tradeStuff : TradeStuffData.tradeList) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", tradeStuff.getNo(), tradeStuff.getName(), tradeStuff.getCategory(), tradeStuff.getPrice(), tradeStuff.getMethod(), tradeStuff.getPayment(), tradeStuff.getCondition(), tradeStuff.getTradedate(), tradeStuff.getSellerNO(), tradeStuff.getBuyerNo()));
				writer.newLine();
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
	
}
