package com.project.cow.data;

import com.project.cow.data.object.Member;
import java.io.*;
import java.util.*;

public class MemberData {

	public static ArrayList<Member> list; // 회원배열

	static {
		MemberData.list = new ArrayList<Member>();
	}
	
	public static void load() { // 회원정보txt를 배열에 load
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data\\member.txt"));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				Member member = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				MemberData.list.add(member);
			}

			reader.close();
		} catch (Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}

	public static void save() { // 배열에 새로운 내용들을 반영시켜 저장하기
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\member.txt"));

			for (Member member : MemberData.list) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", member.getNo(), member.getName(), member.getId(),
						member.getPwd(), member.getTel(), member.getJumin(), member.getEmail(), member.getAddress(), member.getAccount(),
						member.getMoney(), member.getGrade()));
			} // 배열에 새로운 내용들을 반영시키기

			writer.close();
		} catch (Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}

}
