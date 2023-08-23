package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.Member;

import com.project.cow.data.object.BlackList;

public class Data {  //txt 파일을 받아서 조작하고 데이터 입출력을 담당.
	public static ArrayList<Member> list;  //회원배열
	//public static ArrayList<LikeItem> likeList;   //찜목록배열
	public static ArrayList<BlackList> blackList;   //블랙리스트 배열
	static {
		Data.list=new ArrayList<Member>();
//		Data.likeList=new ArrayList<LikeItem>();
//		Data.blackList = new ArrayList<BlackList>();
	}
	
	public static void memberLoad() {   // 회원정보txt를 배열에 load.
		try {
			BufferedReader reader= new BufferedReader(new FileReader("data\\member.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				Member m = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				Data.list.add(m);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void memberSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\member.txt"));
			
			for(Member m : Data.list) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", m.getNo(), m.getName(), m.getId(), m.getPwd(), m.getTel(), m.getJumin(), m.getEmail(), m.getAddress(), m.getAccount(), m.getMoney(), m.getGrade()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
	
//	public static void likeItemLoad() {   // 찜목록txt를 배열에 load.
//		try {
//			BufferedReader reader= new BufferedReader(new FileReader("C:\\class\\code\\java\\Daitso\\data\\likeItem.txt"));
//			
//			String line=null;
//			while((line=reader.readLine()) != null) {
//				String[] temp=line.split(",");
//				LikeItem likeItem = new LikeItem(temp[0], temp[1], temp[2]);
//				Data.likeList.add(likeItem);
//			}
//			
//			reader.close();
//		}catch(Exception e) {
//			System.out.println("at Data.load");
//			e.printStackTrace();
//		}
//	}
//	
//	public static void likeItemSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\code\\java\\Daitso\\data\\likeItem.txt"));
//			
//			for(LikeItem likeItem : Data.likeList) {
//				writer.write(String.format("%s,%s,%s,%s\r\n", likeItem.getNo(), likeItem.getItemNo(), likeItem.getBuyerNo()));
//			}  //배열에 새로운 내용들을 반영시키기.
//			
//			writer.close();
//		}catch(Exception e) {
//			System.out.println("at Data.save");
//			e.printStackTrace();
//		}
//	}
//	
	public static void blackListLoad() {   // 블랙리스트 배열
		try {
			BufferedReader reader= new BufferedReader(new FileReader("C:\\class\\code\\java\\Daitso\\data\\blackList.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				BlackList bl = new BlackList(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12],temp[13]);
				Data.blackList.add(bl);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void blackListSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\blackList.txt"));
			
			for(BlackList bl : Data.blackList) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", bl.getNo(), bl.getName(), bl.getId(), bl.getPwd(), bl.getTel(), bl.getJumin(), bl.getEmail(), bl.getAddress(), bl.getAccount(), bl.getMoney(), bl.getGrade(), bl.getYellowCard(),bl.getAgo(),bl.getVan()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	
	}
}
	
	
	 
	
	
