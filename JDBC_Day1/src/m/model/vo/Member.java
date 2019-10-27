package m.model.vo;

import java.sql.Date;

//회원정보저장 클래스
public class Member {
	
	//멤버변수(필드)
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate; //date java.sql로 임포트
	public String getMemberId() {
		return memberId;
	}
	
	//생성자
	public Member() {} // 기본생성자
	
	
	//메소드
	//alt+shift+s
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	@Override
	public String toString() { // toString -> 멤버변수에 저장되있는 값을 확인하기위해사용
		return this.memberId + ", " + this.memberPwd + ", " + this.memberName + ", " + this.gender
				+ ", " + this.age + ", " + this.email + ", " + this.phone + ", " + this.address +
				", " + this.hobby + ", " + this.enrollDate;
	}
	
}
