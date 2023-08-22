package com.project.cow.mypage;

public class TestUser {
  /*  //1,남승승,4chyz,iltxz3meo,010-2109-7033,580418-2907053,v6ztl78f@nate.com,광진구,사아-8689959395814,219000,2등급
    private String number ="1" ; // 고유번호
    private String name="남승승"; //이름
    private String id="4chyz"; // 아이디
    private String password = "iltxz3meo"; // 비밀번호
    private String phoneNumber ="010-2109-7033"; // 휴대폰 번호
    private String residentNumber = "580418-2907053"; // 주민번호
    private String email ="v6ztl78f@nate.com"; // 이메일
    private String livingArea="광진구"; // 동네
    private String accountNumber = "사아-8689959395814";  //계좌번호
    private String money = "219000";  // 돈
    private String grade = "2등급"; //등급


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() < 4 || id.length() > 16) {
            System.out.println("4~16글자 까지만 입력 가능합니다.");
            return;
        }
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if ((c > '가' || c <'힣') && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != ' ') {
                System.out.println("영어 + 숫자 조합으로만 가능합니다.");
                return;
            }
        }
        this.id = id;
        System.out.println("변경되었습니다.");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResidentNumber() {
        return residentNumber;
    }

    public void setResidentNumber(String residentNumber) {
        this.residentNumber = residentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }*/
}

