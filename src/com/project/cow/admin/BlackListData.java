package com.project.cow.admin;

public class BlackListData {
	
	/**
	 * 블랙리스트의 정보가 담겨있는 클래스입니다.
	 * 
	 * @author 안대명
	 */
	public class BlackList {

		private String bid;
		private String bpassword;
		private String bname;
		private String bbirth;
		private String bgender;
		private String btel;
	


		/**
		 * 블랙리스트들의 정보를 매개변수로 받고 초기화 시켜주는 생성자입니다.
		 * @author 안대명
		 */
		public BlackList(String bid, String bpassword, String bname, String bbirth, String bgender,String btel) {
			
			this.bid = bid;
			this.bpassword = bpassword;
			this.bname = bname;
			this.bbirth = bbirth;
			this.bgender = bgender;
			this.btel = btel;
		
		}

		public String getBid() {
			return bid;
		}

		public void setBid(String bid) {
			this.bid = bid;
		}

		public String getBpassword() {
			return bpassword;
		}

		public void setBpassword(String bpassword) {
			this.bpassword = bpassword;
		}

		public String getBname() {
			return bname;
		}

		public void setBname(String bname) {
			this.bname = bname;
		}

		public String getBbirth() {
			return bbirth;
		}

		public void setBbirth(String bbirth) {
			this.bbirth = bbirth;
		}

		public String getBgender() {
			return bgender;
		}

		public void setBgender(String bgender) {
			this.bgender = bgender;
		}

		public String getBtel() {
			return btel;
		}

		public void setBtel(String btel) {
			this.btel = btel;
		}

	}

}
