package com.project.cow.member.buy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import com.project.cow.data.SellingStuffData;

public class StuffCategory {  //카테고리별 물품 확인하기
	
	public static void Screen() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String[]> stuffDataList = new ArrayList<>();
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("카테고리 선택하기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("1.가구/인테리어/생활/주방\t2.디지털기기\n3.여성잡화\t4.남성잡화\t5.가공식품\n6.스포츠/레저\t7.취미/게임/음반\t8.뷰티/미용\n9.반려동물용품\t10.티켓/교환권/도서\t11.기타");
		System.out.print("번호 입력 : ");
		String input=sc.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\code\\java\\Project\\data\\sellingStuff.txt"));
			
			String line;
			
			while((line=reader.readLine()) != null) {
				String[] data = line.split(",");
				stuffDataList.add(data);	
			}
			for(String[] data : stuffDataList) {
				if(data[2].equals(input)) {
					printStuffInfo(data);
				}
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at StuffCategory.java");
			e.printStackTrace();
		}
		
	}
	
	public static void printStuffInfo(String[] data) {
		String num = data[0];
	    String name = data[1];
	    String category = data[2];
	    String condition = data[3];      
	    String price = data[4];
	    String seller = data[5];
	    String method = data[6];
	    String payment = data[7];
	    String from = data[8];
	    String end = data[9];
	    String like = data[10];
	    
	    System.out.println("[카테고리] [번호]               [품명]     [가격]    [상품품질]    [판매자]    [거래방법]    [지불방법]    [판매시작일]    [판매마감일]      [찜 횟수]");
	    System.out.printf("%6s %6s %15s %9s %10s %8s %9s %6s %5s %7s\r\n", category, num, name, condition, price, seller, method, payment, from, end, like);
		
		
	}
	
	
	
}
