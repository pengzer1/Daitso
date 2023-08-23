package com.project.cow.mypage;

public class TradeStuff {
    private   String num; //번호

    private String name; // 제목

    private String category; //카테고리

    private String price;  //가격
    private String transactionMethod; // 거래방법

    private String paymentMethod; //결제방식

    private String status; //물품상태
    private  String  transactionData; //거래일자
    private  String sellNum; //판매자 번호
    private  String buyNum; //구매자 번호

    public TradeStuff(String num, String name, String category, String price, String transactionMethod, String paymentMethod, String status, String transactionData, String sellNum, String buyNum) {
        this.num = num;
        this.name = name;
        this.category = category;
        this.price = price;
        this.transactionMethod = transactionMethod;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.transactionData = transactionData;
        this.sellNum = sellNum;
        this.buyNum = buyNum;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(String transactionData) {
        this.transactionData = transactionData;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }
}
