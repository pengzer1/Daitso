package com.project.cow.data.object;

import com.project.cow.admin.StuffCheck.Stuff;

public class SoldOutStuff implements Stuff {

	private String no;
	private String name;
	private String category;
	private String price;
	private String method;
	private String payment;
	private String condition;
	private String when;
	private String sellerNo;
	private String buyerNo;

	public SoldOutStuff(String no, String name, String category, String price, String method, String payment,
			String condition, String when, String sellerNo, String buyerNo) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.method = method;
		this.payment = payment;
		this.condition = condition;
		this.when = when;
		this.sellerNo = sellerNo;
		this.buyerNo = buyerNo;
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

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getBuyerNo() {
		return buyerNo;
	}

	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}

	@Override
	public String toString() {
		return "SoldOutStuff [no=" + no + ", name=" + name + ", category=" + category + ", price=" + price + ", method="
				+ method + ", payment=" + payment + ", condition=" + condition + ", when=" + when + ", sellerNo="
				+ sellerNo + ", buyerNo=" + buyerNo + "]";
	}
}
