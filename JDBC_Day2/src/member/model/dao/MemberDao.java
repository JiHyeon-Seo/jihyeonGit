package member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {

	//기본생성자, 반환형 x
	public MemberDao() {}
	
	public ArrayList<Member> selectList(){
		ArrayList<Member> memberList = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				memberList = new ArrayList<Member>();
				while (rset.next()) {
					Member memberOne = new Member(); // memberOne객체에 넣어줌.
					
					memberOne.setMemberId(rset.getString("MEMBER_ID"));
					memberOne.setMemberPwd(rset.getString("MEMBER_PWD"));
					memberOne.setMemberName(rset.getString("MEMBER_NAME"));
					memberOne.setGender(rset.getString("GENDER"));
					memberOne.setage(rset.getInt("AGE"));
					memberOne.setEmail(rset.getString("EMAIL"));
					memberOne.setPhone(rset.getString("PHONE"));
					memberOne.setAddress(rset.getString("ADDRESS"));
					memberOne.setHobby(rset.getString("HOBBY"));
					memberOne.setEnrollDate(rset.getDate("ENROLL_DATE"));
					memberList.add(memberOne);
					//리스트에서 정보를 저장, member객체추가
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberList; //반환형 리턴해주기
	}
	
	public Member selectOne(String memberId) {
		
		Member memberOne = null; 
		
		Connection conn = null;
		//Statement stmt = null; 사용안함.
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?"; //preparedStatement 방식
		//? -> 위치홀더를 사용
		//statement 방식 : String query = "SELECT *FROM MEMBER WHERE MEMBER ID = '" + MemberID"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			pstmt = conn.prepareStatement(query);//쿼리 넣어줌.
			pstmt.setString(1, memberId); // 위치홀더 값 넣어줌.
			
			rset = pstmt.executeQuery(); // 위에서 컴파일 된것을 여기서 실행하고 rset에 넣어줌.
			
			if(rset.next()) {
				memberOne = new Member();
				
				memberOne.setMemberId(rset.getString("MEMBER_ID"));
				memberOne.setMemberPwd(rset.getString("MEMBER_PWD"));
				memberOne.setMemberName(rset.getString("MEMBER_NAME"));
				memberOne.setGender(rset.getString("GENDER"));
				memberOne.setage(rset.getInt("AGE"));
				memberOne.setEmail(rset.getString("EMAIL"));
				memberOne.setPhone(rset.getString("PHONE"));
				memberOne.setAddress(rset.getString("ADDRESS"));
				memberOne.setHobby(rset.getString("HOBBY"));
				memberOne.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberOne;
	}
	
	public ArrayList<Member> selectNameSearch (String keyword){
		String query = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE + '%" + keyword + "%'";
		
		ArrayList<Member> memberList = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			memberList = new ArrayList<Member>();
			
			Member memberOne = new Member();
			memberOne.setMemberId(rset.getString("MEMBER_ID"));
			memberOne.setMemberPwd(rset.getString("MEMBER_PWD"));
			memberOne.setMemberName(rset.getString("MEMBER_PWD"));
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return memberList;
	}
}
