package com.project.cow.data.object;

public class Member {   //회원 1명의 정보
	   private String no;
	   private String name;
	   private String id;
	   private String pwd;
	   private String tel;
	   private String jumin;
	   private String email;
	   private String address;
	   private String account; 
	   private String money;
	   private String grade;
	   
	   public Member() {}
	public  String toCsvFormat() {
		return no + "," + name + "," + id+ "," +pwd+ "," +tel
				+ "," +jumin + "," +email+ "," + address+ "," +account+ "," +money+ "," +grade;
	}
	   
	   public Member(String no, String name, String id, String pwd, String tel, String jumin, String email, String address,
	         String account, String money, String grade) {
	      this.no = no;
	      this.name = name;
	      this.id = id;
	      this.pwd = pwd;
	      this.tel = tel;
	      this.jumin = jumin;
	      this.email = email;
	      this.address = address;
	      this.account = account;
	      this.money = money;
	      this.grade = grade;
	   }



	public Member (String foundid, String foundidname, String foundidtel) {
		 
		this.id = foundid;
		this.name = foundidname;
		this.tel = foundidtel;
		
	}
	

	public Member(String id, String name, String tel, String pwd) {
		
		
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.pwd = pwd;

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
	   public String getId() {
	      return id;
	   }
	   public void setId(String id) {
	      this.id = id;
	   }
	   public String getPwd() {
	      return pwd;
	   }
	   public void setPwd(String pwd) {
	      this.pwd = pwd;
	   }
	   public String getTel() {
	      return tel;
	   }
	   public void setTel(String tel) {
	      this.tel = tel;
	   }
	   public String getJumin() {
	      return jumin;
	   }
	   public void setJumin(String jumin) {
	      this.jumin = jumin;
	   }
	   public String getEmail() {
	      return email;
	   }
	   public void setEmail(String email) {
	      this.email = email;
	   }
	   public String getAddress() {
	      return address;
	   }
	   public void setAddress(String address) {
	      this.address = address;
	   }
	   public String getAccount() {
	      return account;
	   }
	   public void setAccount(String account) {
	      this.account = account;
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
	   }

	   @Override
	   public String toString() {
	      return "Member [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", tel=" + tel + ", jumin=" + jumin + ", email="
	            + email + ", address=" + address + ", account=" + account + ", money=" + money + ", grade=" + grade
	            + "]";
	   }

	}