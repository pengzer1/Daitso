package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.GoodReview;

public class GoodReviewData {
	public static ArrayList<GoodReview> goodReview;   //좋은 리뷰 배열
	static {
		GoodReviewData.goodReview = new ArrayList<GoodReview>();
	}

	public static void goodReviewLoad() {   // 리뷰 txt를 배열에 load.
		try {
			BufferedReader reader= new BufferedReader(new FileReader("data\\goodReview.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				GoodReview review = new GoodReview(temp[0], temp[1], temp[2], temp[3]);
				GoodReviewData.goodReview.add(review);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void goodReviewSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\goodReview.txt"));
			
			for(GoodReview review : GoodReviewData.goodReview) {
				writer.write(String.format("%s,%s,%s,%s\r\n", review.getNo(), review.getBuyerNo(), review.getSellerNo(), review.getReview()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
	
}
