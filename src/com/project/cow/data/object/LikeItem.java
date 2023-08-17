package com.project.cow.data.object;

public class LikeItem {  //찜목록 제품의 객체정보
	private String no;
	private String itemNo;
	private String buyerNo;  //구매자번호
	
	public LikeItem(String no, String itemNo, String buyerNo) {
		this.no = no;
		this.itemNo = itemNo;
		this.buyerNo = buyerNo;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}

	@Override
	public String toString() {
		return "LikeItem [no=" + no + ", itemNo=" + itemNo + ", buyerNo=" + buyerNo + "]";
	}

}
