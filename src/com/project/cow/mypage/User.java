package com.project.cow.mypage;

import java.util.function.Function;

public class User {
    private String number; // 고유번호
    private String name; //이름
    private String id; // 아이디
    private String password; // 비밀번호
    private String phoneNumber; // 휴대폰 번호
    private String residentNumber; // 주민번호
    private String email; // 이메일
    private String livingArea; // 동네
    private String accountNumber;  //계좌번호
    private String money;  // 돈
    private String grade; //등급


    public User(){

    }

    public User(String number, String name, String id, String password, String phoneNumber, String residentNumber, String email, String livingArea, String accountNumber, String money, String grade) {
        this.number = number;
        this.name = name;
        this.id = id;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.residentNumber = residentNumber;
        this.email = email;
        this.livingArea = livingArea;
        this.accountNumber = accountNumber;
        this.money = money;
        this.grade = grade;
    }

    // 생성자, getter 및 setter 메서드는 생략됨

    public String toCsvFormat() {
        return number + "," + name + "," + id+ "," +password+ "," +phoneNumber
                + "," +residentNumber + "," +email+ "," + livingArea+ "," +accountNumber+ "," +money+ "," +grade;
    }






    public void setId(String id) { // 아이디
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if ((c > '가' || c <'힣') && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != ' ') {
                System.out.println("영어 + 숫자 조합으로만 가능합니다.");
                return;
            }
        }
        if (id.length() < 4 || id.length() > 16) {
            System.out.println("4~16글자 까지만 입력 가능합니다.");
            return;
        }

        this.id = id;
        System.out.println("아이디가 변경되었습니다.");
    }
    public void setPassword(String password) { //비밀번호
        if (password.length() < 4 || password.length() > 12) {
            System.out.println("4~12글자 까지만 입력 가능합니다.");
            return;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ((c > '가' || c < '힣') && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != ' ') {
                System.out.println("영어 + 숫자 조합으로만 가능합니다.");
                return;
            }
        }
        this.password = password;
        System.out.println("비밀번호가 변경되었습니다.");
    }

    public void setPhoneNumber(String phoneNumber) { // 휴대폰 번호
        try {
            if ((phoneNumber == null) || !(phoneNumber.length() == 11)) {
                throw new IllegalArgumentException("11자리 숫자를 입력해주세요.");
            }
            for (char digit : phoneNumber.toCharArray()) {
                if (!Character.isDigit(digit)) {
                    throw new IllegalArgumentException("숫자만 입력해 주세요.");
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;

        }
        String formatPhoneNumber = phoneNumber.substring(0, 3) + "-"
                + phoneNumber.substring(3, 7) + "-"
                + phoneNumber.substring(7);
        this.phoneNumber = formatPhoneNumber;
        System.out.println("변경되었습니다.");
    }
    public void setMoney(String money) {
        Function<String, Integer> f = i -> Integer.valueOf(i);
        try {

                for (char digit : money.toCharArray()) {
                    if (!Character.isDigit(digit)) {
                        throw new IllegalArgumentException("숫자만 입력해 주세요.");
                    }
                }

            int numMoney = f.apply(money);

            if (numMoney < 10000) {
                throw new IllegalArgumentException("최소 충전 금액은 10000원 입니다.");
            }
            int tmp = f.apply(this.money);
            int tmp2 = f.apply(money);
            int result = tmp + tmp2;

            String str = String.valueOf(result);

            this.money = str;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }





    public void setNumber(String number) {

        this.number = number;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }






    public String getLivingArea() {
        return livingArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }
    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getNumber() {
        return number;
    }



    public String getMoney() {
        return money;
    }



    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", residentNumber='" + residentNumber + '\'' +
                ", email='" + email + '\'' +
                ", livingArea='" + livingArea + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", money='" + money + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
