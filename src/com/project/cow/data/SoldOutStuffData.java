package com.project.cow.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.cow.data.object.SoldOutStuff;


public class SoldOutStuffData {

	public static ArrayList<SoldOutStuff> soldOutList;
	
	static {
		soldOutList = new ArrayList<SoldOutStuff>();
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\soldOutStuff.txt"));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				SoldOutStuff s = new SoldOutStuff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
				
				SoldOutStuffData.soldOutList.add(s);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\soldOutStuff.txt"));
			
			for (SoldOutStuff s : SoldOutStuffData.soldOutList) {
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", s.getNo(), s.getName(), s.getCategory(), s.getPrice(), s.getMethod(), s.getPayment(), s.getCondition(), s.getWhen(),s.getSellerNo(), s.getBuyerNo()));
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
