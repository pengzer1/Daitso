package com.project.cow.admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BlacklistManager {
    private List<String> blacklist;
    private String blacklistFilePath;
    private String memberFilePath;

    public BlacklistManager(String blacklistFilePath, String memberFilePath) {
        this.blacklistFilePath = blacklistFilePath;
        this.memberFilePath = memberFilePath;
        blacklist = loadBlacklistFromFile();
    }

    public void addToBlacklist(String username) {
        blacklist.add(username);
        saveBlacklistToFile();
        addUserToMemberFile(username);
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