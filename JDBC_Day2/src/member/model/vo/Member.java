package member.model.vo;

import java.sql.Date;

public class Member {
//테이블에 있는 컬럼갯수대로 써야됨.
	
	private String memberId; // MEMBER_ID 
	private String memberPwd;
	private String memberName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {// 멤버변수에 무슨값이 있는지 toString으로 재정의를 해줘야 멤버변수값들이 제대로 run에서 출력됨.
		return this.memberId + ", "
				+this.memberPwd + ", "
				+this.memberName + ", "
				+this.gender + ", "
				+this.age+ ", "
				+this.email + ", "
				+this.phone +", "
				+this.address + ", "
				+this.hobby +","
				+this.enrollDate;
	}
	
	
}
