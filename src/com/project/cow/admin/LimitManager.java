package com.project.cow.admin;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class LimitManager {
    private Set<String> prohibitedItems;
    private String prohibitedItemsFilePath;

    public LimitManager(String prohibitedItemsFilePath) {
        this.prohibitedItemsFilePath = prohibitedItemsFilePath;
        prohibitedItems = loadProhibitedItemsFromFile();
    }

    public void addProhibitedItem(String item) {
        prohibitedItems.add(item);
        saveProhibitedItemsToFile();
    }

    public boolean isProhibited(String item) {
        return prohibitedItems.contains(item);
    }

    private Set<String> loadProhibitedItemsFromFile() {
        Set<String> loadedProhibitedItems = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(prohibitedItemsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedProhibitedItems.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedProhibitedItems;
    }

    private void saveProhibitedItemsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(prohibitedItemsFilePath))) {
            for (String item : prohibitedItems) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}