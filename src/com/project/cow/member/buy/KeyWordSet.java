package com.project.cow.member.buy;

import java.util.Scanner;

import com.project.cow.admin.AdminMenu;
import com.project.cow.data.KeyWordData;
import com.project.cow.data.object.KeyWord;
import com.project.cow.data.object.Member;
import com.project.cow.login.Login;

public class KeyWordSet {
	Scanner scan = new Scanner(System.in);
	
	Member buyer = Login.login;
	KeyWord keyWord = new KeyWord("", "");

	public void Screen() {
		
		AdminMenu.printMenu("키워드 알림 설정");
		System.out.println("키워드 설정을 통해 마이페이지에서\n원하는 물품을 볼 수 있습니다.");
		System.out.println("키워드는 최대 5개까지 설정할 수 있습니다.");
		
		System.out.println("현재 설정되어있는 키워드");
		AdminMenu.printLine();

		findKeyWord();

		AdminMenu.printLine();
		
		select();
		
		System.out.println();
		
		scan.nextLine();
	}

	private void select() {
		AdminMenu.printMenu("키워드 수정");
		AdminMenu.printOption("추가하기", "삭제하기");
		String no = scan.nextLine();
		
		AdminMenu.printLine();
		System.out.println();
		
		if (no.equals("1")) {
			addKeyWord();
		}
		else if (no.equals("2")) {
			deleteKeyWord();
		}
		else if (no.equals("0")) {
			System.out.println();
			BuyMenu.FirstScreen();
		}
		else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			System.out.println();
			select();
		}
	}

	private void deleteKeyWord() {
		int index = 0;
		if (!keyWord.getWord()[0].equals("")) {
			for (int i = 0; i < keyWord.getWord().length; i++) {
				System.out.print((i + 1) + ".");
				System.out.println(keyWord.getWord()[i]);
				index++;
			}
			AdminMenu.printLine();
			System.out.println();
			
			System.out.println("몇번 키워드를 삭제하시겠습니까?");
			System.out.println("0을 입력하면 이전 화면으로 돌아갑니다.");
			System.out.print("번호입력:");
			String no = scan.nextLine();
			
			if(no.equals("0")) {
				Screen();
			}
			
			if (Integer.parseInt(no) > 0 && Integer.parseInt(no) <= index) {
				String keyWords = "";
				
				for(int i = Integer.parseInt(no) - 1; i < index - 1; i++) {
					keyWord.getWord()[i] = keyWord.getWord()[i + 1];
				}
				
				for (int i = 0; i < index - 1; i++) {
					keyWords += keyWord.getWord()[i]+ "|"; 
				}
				
				keyWord = new KeyWord(buyer.getNo(), keyWords);
				
				System.out.println();
				System.out.println("키워드 삭제가 완료되었습니다.");
				System.out.println("Enter를 누르면 키워드 설정 화면으로 돌아갑니다.");
				KeyWordData.keyWordList.set(Integer.parseInt(buyer.getNo()) - 1, keyWord);
				
				KeyWordData.keyWordListSave();
				
				scan.nextLine();
				Screen();
				
			}
			else {
				System.out.println("잘못된 입력입니다.");
				AdminMenu.printLine();
				System.out.println();
				
				deleteKeyWord();
			}
		}
		else {
			System.out.println("삭제할 키워드가 없습니다.");
			System.out.println("Enter를 누르면 키워드 설정 화면으로 돌아갑니다.");
			
			scan.nextLine();
			
			Screen();
		}
		
	}

	private void addKeyWord() {
		if (keyWord.getWord().length != 5) {
			System.out.println("추가할 키워드를 입력해 주세요.");
			System.out.println("0을 입력하면 이전 화면으로 돌아갑니다.");
			System.out.print("키워드입력:");
			String temp = scan.nextLine();
			
			if(temp.equals("0")) {
				Screen();
			}
			
			String keyWords = keyWord.getKeyWord();
			keyWords += temp + "|";
			
			keyWord = new KeyWord(buyer.getNo(), keyWords);
			
			System.out.println();
			System.out.println("키워드 입력이 완료되었습니다.");
			System.out.println("Enter를 누르면 키워드 설정 화면으로 돌아갑니다.");
			KeyWordData.keyWordList.set(Integer.parseInt(buyer.getNo()) - 1, keyWord);
			
			KeyWordData.keyWordListSave();
			
			scan.nextLine();
			Screen();
		}
		else {
			System.out.println("키워드는 최대 5개까지만 설정 가능합니다.");
			System.out.println("기존 키워드를 삭제한 후, 추가해주세요.");
			System.out.println("Enter를 누르면 키워드 설정 화면으로 돌아갑니다.");
			
			scan.nextLine();
			
			Screen();
		}
		
	}

	private void findKeyWord() {
		
		for(KeyWord k : KeyWordData.keyWordList) {
			if (buyer.getNo().equals(k.getNo())) {
				keyWord = k;
				break;
			}
		}
		
		if(keyWord.getNo().equals("")) {
			keyWord.setNo(buyer.getNo());
			KeyWordData.keyWordList.add(keyWord);
		}
		
		if (!keyWord.getWord()[0].equals("")) {
			for (int i = 0; i < keyWord.getWord().length; i++) {
				System.out.print((i + 1) + ".");
				System.out.println(keyWord.getWord()[i]);
			}
		}
		else {
			System.out.println("현재 설정된 키워드가 없습니다.");
		}
		
	}
	
}
