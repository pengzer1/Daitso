package com.project.cow.member.sell;

import com.project.cow.data.SellingStuffData;

public class SellMain {

	public static void main(String[] args) {
		SellMenu sellMenu = new SellMenu();
		
		SellingStuffData.load();
		
		sellMenu.Screen();
	}
	
}
