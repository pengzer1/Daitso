package com.project.cow.data.object;

public class GoodReview {   //하나의 리뷰 객체 생성
	private String no;
	private String buyerNo;
	private String sellerNo;
	private String review;
	
	public GoodReview(String no, String buyerNo, String sellerNo, String review) {
		this.no = no;
		this.buyerNo = buyerNo;
		this.sellerNo = sellerNo;
		this.review = review;
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
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "GoodReview [no=" + no + ", buyerNo=" + buyerNo + ", sellerNo=" + sellerNo + ", review=" + review + "]";
	}
	
}
