package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberQuestion {
	/**
	 * 관리자 FAQ 및 답변 관리 클래스
	 * @author 이승원
	 * 목적: 관리자가 FAQ 게시판을 확인하고 답변을 수정하는 클래스
	 * 기능:
	 * - FAQ 게시판 출력 및 답변 수정 기능 제공
	 */

	private static final String QNA_LIST = "data\\FAQ.txt"; // FAQ 정보 파일 경로
	private static ArrayList<String[]> qnaDataList = new ArrayList<>(); // FAQ 정보 배열

	/**
	 * FAQ 및 답변 게시판을 화면에 출력하는 메인 메소드
	 */
	public static void manageFAQ() {
		Scanner scan = new Scanner(System.in);
		AdminMenu.printMenu("고객센터 F A Q");
		memberQuestionFunction(); // FAQ 관리 기능 메뉴 출력
		String manageChoice = scan.nextLine().trim();

		if (manageChoice.equals("1")) { // 자주 묻는 질문 확인
			displayFAQ(scan);
			scan.nextLine();
		} else if (manageChoice.equals("2")) { // 자주 묻는 질문 수정
			displayFAQ(scan);
			modifyFAQAnswer(scan);
		}
	}

	/**
	 * FAQ 및 답변 게시판을 화면에 출력하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	private static void displayFAQ(Scanner scan) {
		AdminMenu.printMenu("F A Q 게시판");

		for (String[] data : qnaDataList) {
			String index = data[0];
			String viewCount = data[1];
			String question = data[2];
			String answer = data[3];

			System.out.println("번호: " + index);
			System.out.println("조회수: " + viewCount);
			System.out.println("질문: " + question);
			System.out.println("답변: " + answer);
			AdminMenu.printLine();
		}
	}

	/**
	 * FAQ 답변을 수정하는 메소드
	 * @param scan Scanner 사용자 입력
	 */
	private static void modifyFAQAnswer(Scanner scan) {
		System.out.print("답변할 질문 번호 입력: ");
		String questionNumber = scan.nextLine().trim();
		int index = Integer.parseInt(questionNumber);

		if (index >= 1 && index <= qnaDataList.size()) {
			System.out.print("답변 입력: ");
			String answer = scan.nextLine().trim();
			qnaDataList.get(index - 1)[3] = answer; // 답변을 데이터 목록에 저장
			saveFAQInfo(); // 수정된 FAQ 업데이트
			System.out.printf("%d번 답변을 수정하였습니다.\n", index);
		} else {
			System.out.println("유효하지 않은 질문 번호입니다.");
		}

		scan.nextLine();
	}

	/**
	 * FAQ 데이터를 파일에 저장하는 메소드
	 */
	public static void saveFAQInfo() {
		try {
			FileWriter writer = new FileWriter(QNA_LIST);

			for (String[] data : qnaDataList) {
				writer.write(String.join(",", data) + "\n");
			}

			writer.close();

		} catch (IOException e) {
			System.out.println("saveFAQInfo 오류");
			e.printStackTrace();
		}
	}

	/**
	 * FAQ 데이터를 파일에서 로드하는 메소드
	 */
	public static void loadFAQInfo() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(QNA_LIST));
			String qna;

			while ((qna = reader.readLine()) != null) {
				String[] data = qna.split(",");
				qnaDataList.add(data);
			}

			reader.close();

		} catch (IOException e) {
			System.out.println("loadFAQInfo Error");
			e.printStackTrace();
		}
	}

	/**
	 * FAQ 및 답변 관리 기능 화면 출력 메소드
	 */
	private static void memberQuestionFunction() {
		System.out.println("[F A Q 관리 기능]");
		System.out.println("1. F A Q 게시판");
		System.out.println("2. F A Q 답변 수정");
		System.out.println("0. 돌아가기");
		AdminMenu.printLine();
		System.out.print("번호 입력: ");
	}
}
