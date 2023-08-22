package com.project.cow.mypage;

import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {  //txt 파일을 받아서 조작하고 데이터 입출력을 담당.
        public static ArrayList<User> userList;  //회원배열
    public static ArrayList<SoldOut> soldOutArrayList;
    public static ArrayList<String> keyWordList;

        static {
            Data.userList = new ArrayList<User>();
            Data.soldOutArrayList = new ArrayList<>();
            keyWordList = new ArrayList<>();

        }

        public static void memberLoad() {   // 회원정보txt를 배열에 load.
            try {
                BufferedReader reader = new BufferedReader(new FileReader("/Users/green/Desktop/member.txt"));

                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(",");
                    User user = new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
                    Data.userList.add(user);
                }

                reader.close();
            } catch (Exception e) {
                System.out.println("at Data.load");
                e.printStackTrace();
            }
        }

        public static void memberSave(){// 변경된 정보를 텍스트에 세이브
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/green/Desktop/member.txt"));

                for (User user : Data.userList) {
                    // 객체 정보를 텍스트 파일에 쓰는 로직
                    String userInfo = user.toCsvFormat();  // User 객체를 CSV 형식으로 변환
                    writer.write(userInfo);
                    writer.newLine();
                }

                writer.close();
            } catch (Exception e) {
                System.out.println("Error updating file.");
                e.printStackTrace();
            }


        }
      // 1,삼성 전기포트,1,34000,3,1,2,2023-08-22,2023-08-27,15,1208


        public static void deleteMember(User userToDelete) { // 회원 탈퇴 메서드
            String filePath = "/Users/green/Desktop/member.txt";
            String tempFilePath = "/Users/green/Desktop/temp_member.txt";

            try {
                File inputFile = new File(filePath);
                File tempFile = new File(tempFilePath);

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                List<String> lines = new ArrayList<>();
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    String[] userData = currentLine.split(",");
                    if (userData.length >= 3 && userData[2].equals(userToDelete.getId())) {
                        continue; // Skip the line to delete
                    }
                    lines.add(currentLine);
                }

                reader.close();

                BufferedWriter newWriter = new BufferedWriter(new FileWriter(inputFile));
                for (String line : lines) {
                    newWriter.write(line + System.lineSeparator());
                }
                newWriter.close();

                System.out.println("계정을 삭제했습니다.");
            } catch (Exception e) {
                System.out.println("Error updating file.");
                e.printStackTrace();
            }
        }
        public static void soldOutLoad(){  // 판매된 목록
            try {
                BufferedReader reader = new BufferedReader(new FileReader("/Users/green/Desktop/SoldOut.txt"));

                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(",");
                    SoldOut soldOut = new SoldOut(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                    soldOutArrayList.add(soldOut);
                }

                reader.close();
            } catch (Exception e) {
                System.out.println("at Data.load");
                e.printStackTrace();
            }
        }

    public static void sellLoad() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("/Users/green/Desktop/sellingStuff.txt"));

            String line = null;

            while((line = reader.readLine()) != null) {

                String[] temp = line.split(",");

                SellingStuff s = new SellingStuff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);

                SellingStuffData.list.add(s);

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void sellSave() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/green/Desktop/sellingStuff.txt"));

            for (SellingStuff s : SellingStuffData.list) {

                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", s.getNo(), s.getName(), s.getCategory(), s.getPrice(), s.getMethod(), s.getPayment(), s.getCondition(), s.getFrom(), s.getUntil(), s.getLike(), s.getSellerNo()));

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

public static void keyWordLoad(){
    try {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/green/Downloads/keyWord.txt"));

        String line = reader.readLine();
        for (int i = 0; i < 7000; i++) {
            String[] temp = line.split("[,|]");
            keyWordList.add(temp[i]);
        }

        reader.close();
    } catch (Exception e) {
        System.out.println("at Data.load");
        e.printStackTrace();
    }
}

    }



