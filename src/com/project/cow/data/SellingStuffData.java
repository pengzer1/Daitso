package com.project.cow.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.cow.data.object.SellingStuff;

public class SellingStuffData {

	public static ArrayList<SellingStuff> list;
	
	static {
		list = new ArrayList<SellingStuff>();
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/green/Desktop/sellingStuff.txt"));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				SellingStuff s = new SellingStuff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				
				SellingStuffData.list.add(s);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\sellingStuff.txt"));
			
			for (SellingStuff s : SellingStuffData.list) {
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", s.getNo(), s.getName(), s.getCategory(), s.getPrice(), s.getMethod(), s.getPayment(), s.getCondition(), s.getFrom(), s.getUntil(), s.getLike(), s.getSellerNo()));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
