package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.BadReview;

public class BadReviewData {
	public static ArrayList<BadReview> badReview;   //좋은 리뷰 배열
	static {
		BadReviewData.badReview = new ArrayList<BadReview>();
	}

	public static void badReviewLoad() {   // 리뷰 txt를 배열에 load.
		try {
			BufferedReader reader= new BufferedReader(new FileReader("C:\\class\\code\\java\\Project\\data\\badReview.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				BadReview review = new BadReview(temp[0], temp[1], temp[2], temp[3]);
				BadReviewData.badReview.add(review);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void badReviewSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\code\\java\\Daitso\\data\\badReview.txt"));
			
			for(BadReview review : BadReviewData.badReview) {
				writer.write(String.format("%s,%s,%s,%s\r\n", review.getNo(), review.getBuyerNo(), review.getSellerNo(), review.getWarningCnt()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}

}
