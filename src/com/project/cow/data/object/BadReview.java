package com.project.cow.data.object;

public class BadReview {
	private String no;
	private String buyerNo;
	private String sellerNo;
	private String warningCnt;
	
	public BadReview(String no, String buyerNo, String sellerNo, String warningCnt) {
		this.no = no;
		this.buyerNo = buyerNo;
		this.sellerNo = sellerNo;
		this.warningCnt = warningCnt;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	public String getWarningCnt() {
		return warningCnt;
	}
	public void setWarningCnt(String warningCnt) {
		this.warningCnt = warningCnt;
	}

	@Override
	public String toString() {
		return "GoodReview [no=" + no + ", buyerNo=" + buyerNo + ", sellerNo=" + sellerNo + ", warningCnt=" + warningCnt + "]";
	}
	
	
}
