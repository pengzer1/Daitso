package com.project.cow.data.object;

public class TradeStuff {
	
	private String no;
	private String name;
	private String category;
	private String price;
	private String method;  //거래방식
	private String payment;  //결제방식
	private String condition;
	private String tradedate;
	private String sellerNO;
	private String buyerNo;

	public TradeStuff(String no, String name, String category, String price, String method, String payment,
			String condition, String tradedate, String sellerNO, String buyerNo) {
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.method = method;
		this.payment = payment;
		this.condition = condition;
		this.tradedate = tradedate;
		this.sellerNO = sellerNO;
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
	public String getTradedate() {
		return tradedate;
	}
	public void setTradedate(String tradedate) {
		this.tradedate = tradedate;
	}
	public String getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(String buyerNo) {
		this.buyerNo = buyerNo;
	}
	public String getSellerNO() {
		return sellerNO;
	}
	public void setSellerNO(String sellerNO) {
		this.sellerNO = sellerNO;
	}

	@Override
	public String toString() {
		return "TradeStuff [no=" + no + ", name=" + name + ", category=" + category + ", price=" + price + ", method="
				+ method + ", payment=" + payment + ", condition=" + condition + ", tradedate=" + tradedate
				+ ", buyerNo=" + buyerNo + ", sellerNO=" + sellerNO + "]";
	}

}
