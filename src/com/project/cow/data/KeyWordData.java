package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.KeyWord;

public class KeyWordData {
	public static ArrayList<KeyWord> keyWordList;   //키워드 배열
	static {
		KeyWordData.keyWordList = new ArrayList<KeyWord>();
	}

	public static void keyWordListLoad() {   // 키워드 배열
		try {
			BufferedReader reader= new BufferedReader(new FileReader("data\\keyWord.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				String no = temp[0];
	            String keyWords = temp[1]; // 첫 번째 요소는 no이므로 제외
	            
	            // temp 배열의 1번 인덱스부터 keyWords 배열로 복사
	            KeyWord key = new KeyWord(no, keyWords);
				KeyWordData.keyWordList.add(key);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void keyWordListSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\keyWord.txt"));
			
			for(KeyWord key : KeyWordData.keyWordList) {
				writer.write(String.format("%s,%s\r\n", key.getNo(), key.getKeyWord()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
}
