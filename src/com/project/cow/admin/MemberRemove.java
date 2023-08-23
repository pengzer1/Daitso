package com.project.cow.admin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.project.cow.data.MemberData;
import com.project.cow.data.object.Member;

public class MemberRemove {
	/**
	 * 관리자 회원 삭제 클래스
	 * @author 이승원
	 * 목적: 관리자가 회원 정보를 삭제하는 기능을 제공하는 클래스
	 * 기능:
	 * - 검색한 회원 정보를 출력하고 선택한 회원을 삭제할 수 있다.
	 * - 회원을 삭제하여 회원 정보 파일이 수정되면 파일을 업데이트한다.
	 */

	public static final String MEMBER_LIST = "data\\member.txt"; // 회원 정보 파일 경로
	
	/**
	 * 회원 삭제 기능을 수행하는 메인 메소드
	 * @param scan Scanner 사용자 입력
	 */
	public static void removeMember(Scanner scan) {
		AdminMenu.printMenu("회원 삭제");

		System.out.print("삭제할 회원 번호, 이름 또는 아이디 입력: ");
		String deleteKeyword = scan.nextLine().trim();

		// 검색 결과 출력 및 회원 선택
		Set<Integer> selectedMemberList = searchAndSelectMember(deleteKeyword);

		if (!selectedMemberList.isEmpty()) {
			AdminMenu.printLine();
			System.out.print("위 회원들 중 삭제할 회원 번호를 입력하세요: ");
			int deleteIndex = Integer.parseInt(scan.nextLine().trim()) - 1;

			if (deleteIndex >= 0 && deleteIndex < MemberData.list.size()) {
				
				Member selectedMember = MemberData.list.get(deleteIndex);

				AdminMenu.printLine();
				MemberListDisplay.printMemberInfo(selectedMember);
				System.out.print("위 회원을 삭제하시겠습니까? (y/n): ");
				String confirm = scan.nextLine().trim();

				if (confirm.equalsIgnoreCase("y")) {
					performMemberRemove(scan, selectedMember);
				} else {
					System.out.println("삭제가 취소되었습니다.");
					scan.nextLine();
				}
			} else {
				System.out.println("유효하지 않은 회원 번호입니다.");
				scan.nextLine();
			}
		} else {
			System.out.println("해당 회원을 찾을 수 없습니다.");
			scan.nextLine();
		}
	}

	/**
	 * 회원 정보 삭제를 수행하는 메소드
	 * @param scan           Scanner 사용자 입력
	 * @param selectedMember 선택된 회원의 정보 객체
	 */
	private static void performMemberRemove(Scanner scan, Member selectedMember) {
		MemberData.list.remove(selectedMember);
		
		updateMemberFile(); // 회원 정보 파일 업데이트
		
		System.out.println("회원이 삭제되었습니다.");
		scan.nextLine();
	}

	/**
	 * 검색한 회원 정보를 출력하고 선택한 회원의 인덱스를 반환하는 메소드
	 * @param keyword 검색 키워드 (회원 번호, 이름 또는 아이디)
	 * @return 선택된 회원의 인덱스를 담은 TreeSet
	 */
	private static Set<Integer> searchAndSelectMember(String keyword) {
		// TreeSet을 사용하여 중복 없이 선택된 회원 인덱스 저장
		Set<Integer> selectedMemberList = new TreeSet<>();

		AdminMenu.printMenu("회원 목록");

		MemberListDisplay.displayMemberHeader(); // 헤더 출력

		int index = 0; // 회원 인덱스

		for (Member member : MemberData.list) {
			if (member.getNo().equals(keyword) || member.getName().equals(keyword) || member.getId().equals(keyword)) {
				MemberListDisplay.printMemberInfo(member);
				selectedMemberList.add(index);
			}
			index++;
		}

		return selectedMemberList;
	}
	
	/**
	 * 회원 정보를 파일로 업데이트하는 메소드
	 */
	private static void updateMemberFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(MEMBER_LIST))) {
			for (Member member : MemberData.list) {
				String line = String.join(",", member.toString()); // 회원 정보를 CSV 형식으로 변환
	            writer.write(line); // 파일에 회원 정보 쓰기
	            writer.newLine(); // 다음 줄로 이동
			}
		} catch (IOException e) {
			System.out.println("회원 정보 파일 업데이트 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
}
