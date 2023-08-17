package com.project.cow.sell;

import com.project.cow.data.SellingStuffData;

public class SellMain {

	public static void main(String[] args) {
		
		SellingStuffData.load();
		
		SellMenu.Screen();
		
		SellingStuffData.save();
	}
	
}
