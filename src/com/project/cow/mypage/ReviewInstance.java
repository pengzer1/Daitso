package com.project.cow.mypage;

public class ReviewInstance {

    private String num;

    private String seller;

    private String buyer;

    private String select;

    public ReviewInstance(String num, String seller, String buyer, String select) {
        this.num = num;
        this.seller = seller;
        this.buyer = buyer;
        this.select = select;
    }
    public String  toCsvFormat(){
        return num + "," + seller + "," + buyer + "," + select;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }
}
