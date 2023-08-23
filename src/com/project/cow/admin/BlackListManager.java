package com.project.cow.admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BlackListManager {
    private List<String> blacklist;
    private String blacklistFilePath;
    private String memberFilePath;

    public BlackListManager(String blacklistFilePath, String memberFilePath) {
        this.blacklistFilePath = blacklistFilePath;
        this.memberFilePath = memberFilePath;
        blacklist = loadBlacklistFromFile();
    }

    public void addToBlacklist(String username) {
        //blacklist.add(username);
        //saveBlacklistToFile();
        //addUserToMemberFile(username);
    	
    	//1. 남승승
    	//2. member.txt > reader > while > 남승승
    	//	 > 1,남승승,4chyz,iltxz3meo,010-2109-7033,580418-2907053,v6ztl78f@nate.com,광진구,사아-8689959395814,219000,2등급
    	//3. blackList.txt > writer
    	// 	 > 1 ,남승승,4chyz,iltxz3meo,010-2109-7033,580418-2907053,v6ztl78f@nate.com,광진구,사아-8689959395814,219000,2등급
    	//   > 50,정라재,s5t6,ovl2rwut0 ,010-5569-8729,210209-4495753,15dj8@gmail.com  ,강서구,마바-3648818843352,453000,1++등급,3,2023-05-17,7
    	
//      	while() {
//    		line > split > name
//    		if (name.equals(input)) {
//    			
//    			Writer.write(line + "3,111,111");
//    			
//    		}
//    	}
        
        try {
            // member.txt 파일에서 정보를 읽어와서 blacklist.txt 파일에 추가
            BufferedReader memberReader = new BufferedReader(new FileReader("data\\member.txt"));
            BufferedWriter blacklistWriter = new BufferedWriter(new FileWriter("data\\blacklist.txt", true));

            String line;
            while ((line = memberReader.readLine()) != null) {
                String[] memberInfo = line.split(",");
                    // 추가 정보
                if (memberInfo.length > 0 && memberInfo[0].equals(username)) {
                    String reportCount = "2";
                    String today = "2023-08-23"; // 현재 날짜로 가정
                    String restrictionDays = "3";

                    // memberInfo 배열의 내용과 추가 정보를 조합하여 blacklist.txt 파일에 추가
                    blacklistWriter.write(line + "," + reportCount + "," + today + "," + restrictionDays);
                    blacklistWriter.newLine();
                }
            }

            memberReader.close();
            blacklistWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        


    }
        
    private boolean isNumeric(String string) {
		
    	 try {
             Double.parseDouble(blacklistFilePath);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
     }


	public boolean isBlacklisted(String username) {
        return blacklist.contains(username);
    }

    public List<String> getBlacklist() {
        return new ArrayList<>(blacklist);
    }

    private List<String> loadBlacklistFromFile() {
        List<String> loadedBlacklist = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(blacklistFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedBlacklist.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedBlacklist;
    }

    private void saveBlacklistToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(blacklistFilePath))) {
            for (String username : blacklist) {
                writer.write(username);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addUserToMemberFile(String username) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(memberFilePath, true))) {
            writer.write(username);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}