package com.project.cow.member.buy;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import com.project.cow.constant.Constant;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class StuffSort {
	public static void stuffSortChoice() {
		SellingStuffData.load();  //물품 불러오기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("물품을 정렬할 기준을 선택하세요.");
        System.out.println("1. 가격 낮은 순 정렬"); //오름차순
        System.out.println("2. 가격 높은 순 정렬");
        System.out.println("3. 날짜별 정렬");
        System.out.println("4. 인기별 정렬");     //찜 개수 기준
        System.out.println("5. 나눔만 보기");
        System.out.println("0을 입력하시면 이전화면으로 돌아갑니다.");
        System.out.print("번호 입력 : ");
        String input = sc.nextLine();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
        if(input.equals("1")) {
    		System.out.println();
    		//Collections.sort(SellingStuffData.sellingList, (a, b) -> Integer.compare(Integer.parseInt(a.getPrice()), Integer.parseInt(b.getPrice())));
			//SellingStuffData.sellingList.sort((a,b) -> Integer.parseInt(a.getPrice()) - Integer.parseInt(b.getPrice()));
			
    		// 가격이 0인 것을 필터링한 후 정렬
    		List<SellingStuff> filteredList = SellingStuffData.sellingList.stream()
    	        .filter(stuff -> Integer.parseInt(stuff.getPrice()) > 0)
    	        .collect(Collectors.toList());
    	    
    	    filteredList.sort((a, b) -> Integer.parseInt(a.getPrice()) - Integer.parseInt(b.getPrice()));
    	    SellingStuffData.sellingList = (ArrayList<SellingStuff>) filteredList; // 필터링된 리스트로 대체
    	}else if(input.equals("2")) {
    		System.out.println();
    		Collections.sort(SellingStuffData.sellingList, (a, b) -> Integer.compare(Integer.parseInt(b.getPrice()), Integer.parseInt(a.getPrice())));
    	}else if(input.equals("3")) {
    		System.out.println();
    		Collections.sort(SellingStuffData.sellingList, new DateComparator());
    		//SellingStuffData.sellingList.sort((a,b) -> Integer.parseInt(b.getFrom().replace("-","")) - Integer.parseInt(a.getFrom().replace("-","")));
    	}else if(input.equals("4")) {
    		System.out.println();
    		SellingStuffData.sellingList.sort((a,b) -> Integer.parseInt(b.getLike()) - Integer.parseInt(a.getLike()));
    	}else if(input.equals("5")) {
    		System.out.println();
    		// 가격이 0인 것만 필터링한 후 정렬
    		List<SellingStuff> filteredList2 = SellingStuffData.sellingList.stream()
    	        .filter(stuff -> Integer.parseInt(stuff.getPrice()) == 0)
    	        .collect(Collectors.toList());
    	    
    	    filteredList2.sort((a, b) -> Integer.parseInt(a.getPrice()) - Integer.parseInt(b.getPrice()));
    	    SellingStuffData.sellingList = (ArrayList<SellingStuff>) filteredList2; // 필터링된 리스트로 대체
    	}else if(input.equals("0")) {
    		System.out.println();
    		BuyMenu.Screen();
   		}else {
   			System.out.println();
   			System.out.println("올바른 번호를 입력하세요.");
   			stuffSortChoice();
   		}

       	System.out.println("[번호]               [품명]     [상품품질]      [가격]    [판매자]         [거래방법]       [지불방법]      [판매시작일]     [판매마감일]   [찜횟수]");
       int index = 0;
       	for(SellingStuff s : SellingStuffData.sellingList) {
    			System.out.printf("%5s %15s %11s %9s %10s %13s %13s %13s %13s %8s\r\n", s.getNo(), s.getName(),
						Constant.Condition(s.getCondition()), s.getPrice(), s.getSellerNo(),
						Constant.Method(s.getMethod()), Constant.Payment(s.getPayment()), s.getFrom(), s.getUntil(),
						s.getLike());
    			index++;
    			if(index == 100) {
    				break;
    			}
        }
       	int flag=0;
       	boolean loop = true;
		while (loop) {
			System.out.println();
			System.out.println("구매하고 싶은 상품의 키워드를 입력하세요.");
			System.out.println("이전 화면으로 돌아가시려면 0을 입력해 주세요.");
			System.out.print("번호 입력 : ");
			String num = sc.nextLine();

			for(SellingStuff stuff : SellingStuffData.sellingList) {
				if (num.equals("0")) {  
					StuffCategory.Screen();  //이전화면
					break;
				} else if(num.equals(stuff.getNo())){
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println("판매 페이지로 이동하시려면 Enter를 눌러주세요.");
                	sc.nextLine();
                    BuyMenu.FirstScreen();  //판매 페이지로 이동.
                    flag=1;
                    loop = false;  // 루프 종료
				} else continue; flag=0;
			}
			if(flag==0) {
				System.out.println("번호를 바르게 입력해 주십시오.");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			}
		}
       
	}
	public static void Exception() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("이전화면으로 돌아가시려면 0을 입력해주세요.");
			System.out.print("번호 입력 : ");
			int num=sc.nextInt();
			
			if(num==0) {
				stuffSortChoice();
			}else System.out.println("알맞은 번호를 입력하십시오.");
		}
	}
	
	static class DateComparator implements Comparator<SellingStuff> {
	    @Override
	    public int compare(SellingStuff a, SellingStuff b) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            Date dateA = dateFormat.parse(a.getFrom());
	            Date dateB = dateFormat.parse(b.getFrom());
	            return dateA.compareTo(dateB);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0; // 날짜 변환 실패 시 같은 것으로 취급
	        }
	    }
	}
	
}
