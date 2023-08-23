package com.project.cow.data.object;

import com.project.cow.admin.StuffCheck.Stuff;

public class SellingStuff implements Stuff {

	private String no;
	private String name;
	private String category;
	private String price;
	private String method;
	private String payment;
	private String condition;
	private String from;
	private String until;
	private String like;
	private String sellerNo;
	
	public SellingStuff(String no, String name, String category, String price, String method, String payment,
			String condition, String from, String until, String like, String sellerNo) {
		
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.method = method;
		this.payment = payment;
		this.condition = condition;
		this.from = from;
		this.until = until;
		this.like = like;
		this.sellerNo = sellerNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getUntil() {
		return until;
	}

	public void setUntil(String until) {
		this.until = until;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", category=" + category + ", price=" + price + ", method="
				+ method + ", payment=" + payment + ", condition=" + condition + ", from=" + from + ", until=" + until
				+ ", like=" + like + ", sellerNo=" + sellerNo + "]";
	}
	
	
}
