package com.project.cow.data.object;
import java.util.Arrays;

public class KeyWord {

	private String no;
	private String keyWord;
	private String[] str;
	
	    public KeyWord(String no, String temp) {
	        this.no = no;
	        this.keyWord = temp;
	        str = keyWord.split("[|]");
	    }
	    public String[]  getWord(){
	        return str;
	    }

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	@Override
	public String toString() {
		return "[no=" + no + ", keyWord=" + keyWord + ", str=" + Arrays.toString(str) + "]";
	}


	
}
