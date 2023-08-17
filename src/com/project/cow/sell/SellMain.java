package com.project.cow.sell;

import com.project.cow.data.SellingStuffData;

public class SellMain {

	public static void main(String[] args) {
		SellMenu sellMenu = new SellMenu();
		
		SellingStuffData.load();
		
		sellMenu.Screen();
		
		SellingStuffData.save();
	}
	
}
