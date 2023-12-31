package com.project.cow.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextProhibitFileReader {

	    public static String readTextFile(String filePath) {
	        StringBuilder content = new StringBuilder();

	        try {
	            File file = new File(filePath);
	            BufferedReader reader = new BufferedReader(new FileReader("data\\prohibited_items.txt"));
	            	
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	                

	            
	            
	            reader.close();
	            return content.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	}
