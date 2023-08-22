package com.project.cow.member.buy;

import com.project.cow.data.LikeItemData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.SellingStuff;

public class BuyMain {
	public static void main(String[] args) {
		SellingStuffData.load();  //물품목록
		LikeItemData.likeItemLoad();
		BuyMenu.FirstScreen();
		
	}
}
