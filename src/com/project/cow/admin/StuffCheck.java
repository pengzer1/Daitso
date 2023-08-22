package com.project.cow.admin;

import java.util.Scanner;

import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class StuffCheck {

	public static void adminStuffCheck() {
		SellingStuffData.load();

		Scanner scan = new Scanner(System.in);

		itemStatusCheck(scan);
	}

	private static void itemStatusCheck(Scanner scan) {
		while (true) {
			AdminMenu.printMenu("중고 물품 관리");
			AdminMenu.printOption("판매중인 물품 현황", "판매된 물품 현황");
			String searchChoice = scan.nextLine().trim();

			if (searchChoice.equals("1")) { // 판매중인 물품 현황
				analyzeSellingStuff(scan);
			} else if (searchChoice.equals("2")) { // 판매된 물품 현황
				analyzeSoldOutStuff(scan);
			} else {
				return;
			}
		}
	}
	
	private static void analyzeSoldOutStuff(Scanner scan) {
		
	}

	/**
	 * 물품 분석 기능을 수행하는 메인 메소드.
	 * @param scan Scanner 사용자 입력
	 */
	private static void analyzeSellingStuff(Scanner scan) {
		String startDate = null;
		String endDate = null;

		// 가장 처음 물품과 마지막 물품을 찾음
		for (SellingStuff item : SellingStuffData.sellingList) {
			String itemStartDate = item.getFrom();
			String itemEndDate = item.getUntil();

			if (startDate == null || itemStartDate.compareTo(startDate) < 0) {
				startDate = itemStartDate;
			}
			if (endDate == null || itemEndDate.compareTo(endDate) > 0) {
				endDate = itemEndDate;
			}
		}

		// 판매중인 물품 현황 출력
		displayStuff(scan, startDate, endDate);
	}
	
	/**
	 * 물품 현황을 출력하는 메소드.
	 * @param scan Scanner 사용자 입력
	 * @param startDate 검색 시작 날짜
	 * @param endDate 검색 종료 날짜
	 */
	private static void displayStuff(Scanner scan, String startDate, String endDate) {
	    int count = 0;
	    boolean hasItems = false;
	    int[] category = new int[12];
		String[] name = new String[SellingStuffData.sellingList.size()];

	    System.out.printf("%s ~ %s까지의 매물 현황을 조회합니다.\n", startDate, endDate);
	    scan.nextLine();

	    for (SellingStuff item : SellingStuffData.sellingList) {
	        updateCategoryCount(category, item);
	        name[count] = item.getName();
	        count++;
	        hasItems = true;
	    }

	    if (!hasItems) {
	        System.out.println("판매중인 물품이 없습니다.");
	        scan.nextLine();
	    } else {
	        AdminMenu.printMenu("물품 현황 조회");
	        System.out.printf("검색 기간: %s ~ %s\n", startDate, endDate);
	        System.out.printf("판매중인 전체 물품 수: %,d개\n", count);

	        int[] topCategories = calculateTopCategory(category);

	        displayCategoryRanking(topCategories);

	        String[] popularItems = new String[5];
	        int[] popularItemCounts = new int[5];

	        for (SellingStuff item : SellingStuffData.sellingList) {
	            updatePopularItem(item, popularItems, popularItemCounts, category);
	        }

	        displayPopularItemRanking(popularItems, popularItemCounts);

	        AdminMenu.printLine();
	        System.out.println("물품 현황 조회가 완료되었습니다.");
	        scan.nextLine();
	    }
	}

	/**
	 * 물품의 카테고리별 개수를 업데이트하는 메소드.
	 * @param category 카테고리 배열
	 * @param item 물품 정보 객체
	 */
	private static void updateCategoryCount(int[] category, SellingStuff item) {
	    int index = Integer.parseInt(item.getCategory()) - 1;
	    category[index] += 1;
	}

	/**
	 * 인기 물품을 업데이트하는 메소드.
	 * @param item 물품 정보 객체
	 * @param popularItems 인기 물품 배열
	 * @param popularItemCounts 인기 물품 카운트 배열
	 * @param category 카테고리 배열
	 */
	private static void updatePopularItem(SellingStuff item, String[] popularItems, int[] popularItemCounts, int[] category) {
	    for (int i = 0; i < 5; i++) {
	        if (popularItems[i] == null || popularItemCounts[i] < category[Integer.parseInt(item.getCategory()) - 1]) {
	            for (int j = 4; j > i; j--) {
	                popularItems[j] = popularItems[j - 1];
	                popularItemCounts[j] = popularItemCounts[j - 1];
	            }
	            popularItems[i] = item.getName();
	            popularItemCounts[i] = category[Integer.parseInt(item.getCategory()) - 1];
	            break;
	        }
	    }
	}

	/**
	 * 인기 물품 순위를 출력하는 메소드.
	 * @param popularItems 인기 물품 배열
	 * @param popularItemCounts 인기 물품 카운트 배열
	 */
	private static void displayPopularItemRanking(String[] popularItems, int[] popularItemCounts) {
	    System.out.println();
	    System.out.println("[인기 물품 순위]");
	    for (int i = 0; i < 5; i++) {
	        if (popularItems[i] != null) {
	            System.out.printf("%d위 %s - 물품 수: %d\n", i + 1, popularItems[i], popularItemCounts[i]);
	        }
	    }
	}
	
	/**
	 * 인기 카테고리 순위를 계산하는 메소드.
	 * @param category 카테고리 배열
	 * @return 상위 카테고리 배열
	 */
	private static int[] calculateTopCategory(int[] category) {
	    int[] topCategory = new int[5];
	    for (int i = 0; i < 5; i++) {
	        int maxCount = -1;
	        int maxIndex = -1;
	        for (int j = 0; j < category.length; j++) {
	            if (category[j] > maxCount && !contains(topCategory, j)) {
	                maxCount = category[j];
	                maxIndex = j;
	            }
	        }
	        topCategory[i] = maxIndex;
	    }
	    return topCategory;
	}

	/**
	 * 인기 카테고리 순위를 출력하는 메소드.
	 * @param topCategories 상위 카테고리 배열
	 */
	private static void displayCategoryRanking(int[] topCategories) {
	    System.out.println();
	    System.out.println("[인기 카테고리 순위]");
	    for (int i = 0; i < 5; i++) {
	        System.out.printf("%d위 %s\n", i + 1, getCategoryName(topCategories[i] + 1));
	    }
	}

	/**
	 * 배열 내에서 특정 값이 존재하는지 확인하는 메소드.
	 * @param array 배열
	 * @param value 확인할 값
	 * @return 값의 존재 여부
	 */
	private static boolean contains(int[] array, int value) {
		for (int element : array) {
			if (element == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 카테고리 번호에 해당하는 카테고리 이름을 반환하는 메소드.
	 * @param category 카테고리 번호
	 * @return 카테고리 이름
	 */
	private static String getCategoryName(int category) {
		switch (category) {
		case 1:
			return "가구/인테리어/생활/주방";
		case 2:
			return "디지털 기기";
		case 3:
			return "여성잡화";
		case 4:
			return "남성잡화";
		case 5:
			return "가공식품";
		case 6:
			return "스포츠/레저";
		case 7:
			return "취미/게임/음반";
		case 8:
			return "뷰티/미용";
		case 9:
			return "반려동물용품";
		case 10:
			return "티켓/교환권/도서";
		case 11:
			return "기타 중고물품";
		default:
			return "카테고리 미등록";
		}
	}

	/*
	private static void displayStuff(Scanner scan, String startDate, String endDate) {
		int count = 0;
		boolean hasItems = false; // 물품이 있는지 확인
		int[] category = new int[12];
		String[] name = new String[SellingStuffData.sellingList.size()];

		System.out.printf("%s ~ %s까지의 매물 현황을 조회합니다.\n", startDate, endDate);
		scan.nextLine();

		for (SellingStuff item : SellingStuffData.sellingList) {
			category[Integer.parseInt(item.getCategory()) - 1] += 1;
			name[count] = item.getName();
			count++;
			hasItems = true;
		}

		if (!hasItems) {
			// 물품이 없을 경우
			System.out.println("판매중인 물품이 없습니다.");
			scan.nextLine();
		} else {
			String[] popularItems = new String[5];
			int[] popularItemCounts = new int[5];

			AdminMenu.printMenu("물품 현황 조회");
			System.out.printf("검색 기간: %s ~ %s\n", startDate, endDate);
			System.out.printf("판매중인 전체 물품 수: %,d개\n", count);

			int[] topCategories = new int[5];
			for (int i = 0; i < 5; i++) {
				int maxCount = -1;
				int maxIndex = -1;
				for (int j = 0; j < category.length; j++) {
					if (category[j] > maxCount && !contains(topCategories, j)) {
						maxCount = category[j];
						maxIndex = j;
					}
				}
				topCategories[i] = maxIndex;
			}

			System.out.println();
			System.out.println("[인기 카테고리 순위]");
			for (int i = 0; i < 5; i++) {
				System.out.printf("%d위 %s\n", i + 1, getCategoryName(topCategories[i] + 1));
			}

			for (SellingStuff item : SellingStuffData.sellingList) {
				for (int i = 0; i < 5; i++) {
					if (popularItems[i] == null
							|| popularItemCounts[i] < category[Integer.parseInt(item.getCategory()) - 1]) {
						for (int j = 4; j > i; j--) {
							popularItems[j] = popularItems[j - 1];
							popularItemCounts[j] = popularItemCounts[j - 1];
						}
						popularItems[i] = item.getName();
						popularItemCounts[i] = category[Integer.parseInt(item.getCategory()) - 1];
						break;
					}
				}
			}

			System.out.println();
			System.out.println("[인기 물품 순위]");
			for (int i = 0; i < 5; i++) {
				if (popularItems[i] != null) {
					System.out.printf("%d위 %s - 물품 수: %d\n", i + 1, popularItems[i], popularItemCounts[i]);
				}
			}
			
			AdminMenu.printLine();
			System.out.println("물품 현황 조회가 완료되었습니다.");
			scan.nextLine();
		}
	}
	*/
	
	/*
	private static void stuffDateSearch(Scanner scan) {
		System.out.println("날짜 입력 형식: XXXXXXXX or XXXX-XX-XX (년-월-일)");
		System.out.print("시작 날짜 입력: ");
		String startDate = scan.nextLine();
		System.out.print("끝 날짜 입력: ");
		String endDate = scan.nextLine();

		if (!isValidDate(startDate) || !isValidDate(endDate)) {
			System.out.println("유효하지 않은 날짜 형식입니다.");
			scan.nextLine();
			return;
		}

		displayStuff(scan, startDate, endDate);
	}
	*/

	/*
	private static boolean isValidDate(String date) {
		Pattern pattern = Pattern.compile(DATE_PATTERN);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	*/

	/*
	private static boolean isWithinDateRange(String sellDate, String startDate, String endDate) {
		Calendar setStartDate = parseDate(startDate);
		Calendar setEndDate = parseDate(endDate);
		Calendar setSellDate = parseDate(sellDate);

		int sellYear = setSellDate.get(Calendar.YEAR);
	    int sellMonth = setSellDate.get(Calendar.MONTH);
	    int sellDay = setSellDate.get(Calendar.DAY_OF_MONTH);

	    int startYear = setStartDate.get(Calendar.YEAR);
	    int startMonth = setStartDate.get(Calendar.MONTH);
	    int startDay = setStartDate.get(Calendar.DAY_OF_MONTH);

	    int endYear = setEndDate.get(Calendar.YEAR);
	    int endMonth = setEndDate.get(Calendar.MONTH);
	    int endDay = setEndDate.get(Calendar.DAY_OF_MONTH);

	    boolean withinYearRange = (sellYear >= startYear && sellYear <= endYear);
	    boolean withinMonthRange = (sellMonth >= startMonth && sellMonth <= endMonth);
	    boolean withinDayRange = (sellDay >= startDay && sellDay <= endDay);
	  
		return (setSellDate.equals(setStartDate) || setSellDate.after(setStartDate))
				&& (setSellDate.equals(setEndDate) || setSellDate.before(setEndDate));
	}
	*/
	/*
	private static Calendar parseDate(String date) {
		int year, month, day;

		if (date.length() == 8) {
			year = Integer.parseInt(date.substring(0, 4));
			month = Integer.parseInt(date.substring(4, 6));
			day = Integer.parseInt(date.substring(6, 8));
		} else {
			String[] dateComponents = date.split("-");
			year = Integer.parseInt(dateComponents[0]);
			month = Integer.parseInt(dateComponents[1]);
			day = Integer.parseInt(dateComponents[2]);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);

		return calendar;
	}
	*/
}
