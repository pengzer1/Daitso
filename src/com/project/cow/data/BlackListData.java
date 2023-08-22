package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.BlackList;

public class BlackListData {
	public static ArrayList<BlackList> blackList;   //블랙리스트 배열
	static {
		BlackListData.blackList = new ArrayList<BlackList>();
	}

	public static void blackListLoad() {   // 블랙리스트 배열
		try {
			BufferedReader reader= new BufferedReader(new FileReader("C:\\class\\code\\java\\Daitso\\data\\blackList.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				BlackList bl = new BlackList(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12], temp[13]);
				BlackListData.blackList.add(bl);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void blackListSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\code\\java\\Daitso\\data\\blackList.txt"));
			
			for(BlackList bl : BlackListData.blackList) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", bl.getNo(), bl.getName(), bl.getId(), bl.getPwd(), bl.getTel(), bl.getJumin(), bl.getEmail(), bl.getAddress(), bl.getAccount(), bl.getMoney(), bl.getGrade(), bl.getYellowCard(), bl.getAgo(), bl.getVan()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
	
}
