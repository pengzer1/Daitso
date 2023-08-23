package com.project.cow.admin;

import java.util.List;
import java.util.Scanner;

import com.project.cow.data.SellingStuffData;
import com.project.cow.data.SoldOutStuffData;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.data.object.SoldOutStuff;

public class StuffCheck {
	/**
	 * 중고 물품 현황 분석 클래스
	 * @author 이승원
	 * 목적: 판매 중 및 판매 완료된 물품의 현황을 분석하고 조회하는 클래스
	 * 기능:
	 * - 판매중인 물품 및 판매된 물품의 현황을 조회할 수 있다.
	 * - 물품의 카테고리별 판매 현황 및 인기 물품을 분석하여 1위부터 5위까지 출력한다.
	 */

	public interface Stuff {
		String getCategory();

		String getName();
	}

	/**
	 * 관리자가 중고 물품을 확인하는 메인 메소드
	 */
	public static void adminStuffCheck() {
		SellingStuffData.load(); // 판매중인 물품 로드
		SoldOutStuffData.load(); // 판매된 물품 로드

		Scanner scan = new Scanner(System.in);

		stuffStatusCheck(scan);
	}

	/**
	 * 중고 물품 관리 메뉴를 처리하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	private static void stuffStatusCheck(Scanner scan) {
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

	/**
	 * 판매중인 물품 분석 기능을 수행하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	private static void analyzeSellingStuff(Scanner scan) {
		String startDate = null;
		String endDate = null;

		// 처음 판매를 시작한 물품, 마지막에 판매를 종료하는 물품의 날짜를 찾음
		for (SellingStuff stuff : SellingStuffData.sellingList) {
			String sellStartDate = stuff.getFrom();
			String sellEndDate = stuff.getUntil();

			if (startDate == null || sellStartDate.compareTo(startDate) < 0) {
				startDate = sellStartDate; // 물품 검색을 시작할 날짜
			}
			if (endDate == null || sellEndDate.compareTo(endDate) > 0) {
				endDate = sellEndDate; // 물품 검색을 끝낼 날짜
			}
		}

		// 판매중인 물품 현황 출력
		displayStuffStatus(scan, SellingStuffData.sellingList, startDate, endDate);
	}

	/**
	 * 판매된 물품 분석 기능을 수행하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	private static void analyzeSoldOutStuff(Scanner scan) {
		String startDate = null;
		String endDate = null;

		// 처음 판매된 물품, 마지막에 판매된 물품의 날짜를 찾음
		for (SoldOutStuff stuff : SoldOutStuffData.soldOutList) {
			String soldDate = stuff.getWhen();

			if (startDate == null || soldDate.compareTo(startDate) < 0) {
				startDate = soldDate; // 물품 검색을 시작할 날짜
			}
			if (endDate == null || soldDate.compareTo(endDate) > 0) {
				endDate = soldDate; // 물품 검색을 끝낼 날짜
			}
		}

		// 판매중인 물품 현황 출력
		displayStuffStatus(scan, SoldOutStuffData.soldOutList, startDate, endDate);
	}

	/**
	 * 물품 현황을 출력하는 메소드
	 * @param scan      Scanner 사용자 입력
	 * @param stuffList 물품 정보 객체 리스트
	 * @param startDate 검색 시작 날짜
	 * @param endDate   검색 종료 날짜
	 */
	private static void displayStuffStatus(Scanner scan, List<? extends Stuff> stuffList, String startDate, String endDate) {
		int stuffCount = 0;
		int[] stuffCategory = new int[12]; // 카테고리별 물품 개수 배열
		int[] topStuffCategory; // 인기 있는 카테고리 배열

		String[] stuffName = new String[stuffList.size()]; // 물품 이름 배열
		String[] topStuffName = new String[5]; // 인기 있는 물품 이름 배열
		int[] topStuffCount = new int[5]; // 인기 있는 물품 판매 수 배열

		// 물품 정보 업데이트 및 물품 개수 계산
		stuffCount = updateStuffInfo(stuffList, stuffCategory, stuffName);

		System.out.printf("%s ~ %s까지의 매물 현황을 조회합니다.\n", startDate, endDate);
		scan.nextLine();

		if (stuffCount <= 0) {
			System.out.println("판매중인 물품이 없습니다.");
			scan.nextLine();
		} else {
			AdminMenu.printMenu("물품 현황 조회");
			System.out.printf("검색 기간: %s ~ %s\n", startDate, endDate);
			System.out.printf("검색된 물품 수: %,d개\n", stuffCount);

			topStuffCategory = calculateTopCategory(stuffCategory); // 상위 카테고리 계산
			displayCategoryRanking(topStuffCategory, stuffCategory); // 카테고리별 순위 및 개수 출력

			// 인기 있는 물품 이름 업데이트
			for (Stuff stuff : stuffList) {
				updateTopStuff(stuff, topStuffName, topStuffCount, stuffCategory);
			}

			displayStuffRanking(topStuffName, topStuffCount); // 인기 물품 순위 출력

			AdminMenu.printLine();
			System.out.println("물품 현황 조회가 완료되었습니다.");
			scan.nextLine();
		}
	}

	/**
	 * 물품 정보를 업데이트하고 물품 개수를 계산하는 메소드
	 * @param stuffList     물품 정보 객체 리스트
	 * @param stuffCategory 카테고리별 물품 개수를 저장하는 배열
	 * @param stuffName     물품 이름을 저장하는 배열
	 * @return 업데이트된 물품 개수
	 */
	private static int updateStuffInfo(List<? extends Stuff> stuffList, int[] stuffCategory, String[] stuffName) {
		int stuffCount = 0;

	    for (Stuff stuff : stuffList) {
	        updateCategoryCount(stuffCategory, stuff); // 카테고리별 물품 개수 업데이트

	        stuffName[stuffCount] = stuff.getName(); // 물품 이름 저장

	        stuffCount++; // 물품 개수 누적
	    }

	    return stuffCount;
	}

	/**
	 * 물품의 카테고리별 개수를 업데이트하는 메소드
	 * @param stuffCategory 카테고리 배열
	 * @param stuff         물품 정보 객체
	 */
	private static void updateCategoryCount(int[] stuffCategory, Stuff stuff) {
		// 물품의 카테고리를 가져와 해당 카테고리 인덱스로 초기화
		int index = Integer.parseInt(stuff.getCategory()) - 1;
		
		stuffCategory[index] += 1; // 해당 카테고리의 물품 개수 증가
	}

	/**
	 * 인기 물품을 업데이트하는 메소드
	 * @param stuff         물품 정보 객체
	 * @param topStuffName  인기 물품 배열
	 * @param topStuffCount 인기 물품 카운트 배열
	 * @param stuffCategory 카테고리 배열
	 */
	private static void updateTopStuff(Stuff stuff, String[] topStuffName, int[] topStuffCount, int[] stuffCategory) {
		for (int i = 0; i < 5; i++) {
			// 인기 물품 배열의 i번째가 비어있거나 카테고리의 판매 수가 인기 물품 배열의 i번째 판매 수보다 큰 경우
			if (topStuffName[i] == null || topStuffCount[i] < stuffCategory[Integer.parseInt(stuff.getCategory()) - 1]) {
				
				// 인기 물품 배열을 오른쪽으로 한 칸씩 이동
				for (int j = 4; j > i; j--) {
					topStuffName[j] = topStuffName[j - 1];
					topStuffCount[j] = topStuffCount[j - 1];
				}
				
				// 해당 카테고리의 물품 이름과 판매 수를 인기 물품 배열에 삽입
				topStuffName[i] = stuff.getName();
				topStuffCount[i] = stuffCategory[Integer.parseInt(stuff.getCategory()) - 1];
				break;
			}
		}
	}

	/**
	 * 인기 물품 순위를 출력하는 메소드
	 * @param topStuffName  인기 물품 배열
	 * @param topStuffCount 인기 물품 카운트 배열
	 */
	private static void displayStuffRanking(String[] topStuffName, int[] topStuffCount) {
		System.out.println();
		System.out.println("[인기 물품 순위]");

		// 순위와 함께 인기 물품 이름 및 판매 수 출력
		for (int i = 0; i < 5; i++) {
			if (topStuffName[i] != null) {
				System.out.printf("%d위 %s (%d개)\n", i + 1, topStuffName[i], topStuffCount[i]);
			}
		}
	}

	/**
	 * 인기 카테고리 순위를 계산하는 메소드
	 * @param stuffCategory 카테고리 배열
	 * @return 상위 카테고리 배열
	 */
	private static int[] calculateTopCategory(int[] stuffCategory) {
		int[] topCategory = new int[5];
		for (int i = 0; i < 5; i++) {
			
			// 각 상위 카테고리의 초기 최대값 및 인덱스 설정
			int maxCount = -1; // 최대 판매 수 초기값 설정
			int maxIndex = -1; // 최대 판매 수를 가진 카테고리 인덱스 초기값 설정
			
			for (int j = 0; j < stuffCategory.length; j++) {
				// 해당 카테고리의 판매 수가 최대값이면서 상위 카테고리 배열에 포함되지 않은 경우
				if (stuffCategory[j] > maxCount && !contains(topCategory, j)) {
					maxCount = stuffCategory[j]; // 최대 판매 수 업데이트
					maxIndex = j; // 최대 판매 수를 가진 카테고리 인덱스 업데이트
				}
			}
			// 최대값을 가지는 카테고리의 인덱스를 상위 카테고리 배열에 삽입
			topCategory[i] = maxIndex;
		}
		
		return topCategory;
	}

	/**
	 * 인기 카테고리 순위를 출력하는 메소드
	 * @param topCategorie 상위 카테고리 배열
	 * @param stuffCategory 카테고리별 물품 개수 배열
	 */
	private static void displayCategoryRanking(int[] topCategorie, int[] stuffCategory) {
	    System.out.println();
	    System.out.println("[인기 카테고리 순위]");

	    // 순위와 함께 해당 카테고리의 이름 및 물품 개수를 출력
	    for (int i = 0; i < 5; i++) {
	        int categoryIndex = topCategorie[i];
	        String categoryName = getCategoryName(categoryIndex + 1);
	        int categoryItemCount = stuffCategory[categoryIndex];
	        System.out.printf("%d위 %s (%d개)\n", i + 1, categoryName, categoryItemCount);
	    }
	}

	/**
	 * 배열 내에서 특정 값이 존재하는지 확인하는 메소드
	 * @param array 배열
	 * @param value 확인할 값
	 * @return 값의 존재 여부
	 */
	private static boolean contains(int[] array, int value) {
		for (int element : array) {
			if (element == value) {
				// 배열 요소가 특정 값과 일치하는 경우 true 반환
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 카테고리 번호에 해당하는 카테고리 이름을 반환하는 메소드
	 * @param stuffCategory 카테고리 번호
	 * @return 카테고리 이름
	 */
	public static String getCategoryName(int stuffCategory) {
		switch (stuffCategory) {
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
}
