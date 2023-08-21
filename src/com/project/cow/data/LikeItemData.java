package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.LikeItem;

public class LikeItemData {
	public static ArrayList<LikeItem> likeList;   //찜목록배열
	static {
		LikeItemData.likeList=new ArrayList<LikeItem>();
	}
	
	public static void likeItemLoad() {   // 찜목록txt를 배열에 load.
		try {
			BufferedReader reader= new BufferedReader(new FileReader("data\\likeItem.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				LikeItem likeItem = new LikeItem(temp[0], temp[1], temp[2]);
				LikeItemData.likeList.add(likeItem);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void likeItemSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\likeItem.txt"));
			
			for(LikeItem likeItem : LikeItemData.likeList) {
				writer.write(String.format("%s,%s,%s\r\n", likeItem.getNo(), likeItem.getItemNo(), likeItem.getBuyerNo()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}

}
