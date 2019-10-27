package m.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import m.model.vo.Member;

//db에 있는 데이터를 가져오는 클래스
public class MemberDao {

	public MemberDao() {
	}

	public Member selectOne(String memberId) { // where절의 하나의 아이디값을 가져와야됨.반환형타입은 Member
		Member memberOne = null; // Member타입
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID ='" + memberId + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		// driverManager.connection 에서 노란전구 surround
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection( // 연결객체를 connection타입의 conn변수에 넣어줌.
					"jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"student", 
					"student");
			// jdbc 작성후 다음에 노란전구 surround
			
			stmt = conn.createStatement(); // statement타입의 statement객체 생성하여 stmt변수에 넣어줌. 
			
			rset = stmt.executeQuery(query); // executeQuery메소드를 통해서 쿼리문을 실행함과 동시에 결과값을 받아옴.
			
			if(rset.next()) {
				memberOne = new Member(); //member객체 생성 후 memberOne에 넣어줌.
				String memId = rset.getString("MEMBER_ID"); // DB의 MEMBER_ID필드값을 memId에 저장함. 
				memberOne.setMemberId(memId); // memberOne이라는 객체에 DB의 MemberId필드에 값을 넣어줌.
				memberOne.setMemberPwd(rset.getString("MEMBER_PWD"));
				memberOne.setMemberName(rset.getString("MEMBER_NAME"));
				memberOne.setGender(rset.getString("GENDER"));
				int memAge = rset.getInt("AGE");
				memberOne.setAge(memAge);
				memberOne.setEmail(rset.getString("EMAIL"));
				memberOne.setPhone(rset.getString("PHONE"));
				memberOne.setAddress(rset.getString("ADDRESS"));
				memberOne.setHobby(rset.getString("HOBBY"));
				
				Date memEnDate = rset.getDate("ENROLL_DATE");
				memberOne.setEnrollDate(memEnDate);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close(); //conn.close() 작성 후 노란전구 surround클릭
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return memberOne;
	}
	public ArrayList<Member> selectAll() {
		ArrayList<Member> memberList = null;
		String query = "SELECT* FROM MEMBER";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		//1. 사용할 DB에 대한 드라이버 등록(클래스 등록)
		// - JDBC driver등록처리
		//해당 DBMS가 제공하는 클래스 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 등록된 클래스를 이용해서 DB연결처리
			//성공시 Connection값, 실패시 null값
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"student", 
					"student");
			System.out.println("conn: " + conn);
			
			//3. 쿼리문을 가지고 실행할 statement 객체 생성
			stmt = conn.createStatement();
			
			//4. 쿼리문 전송하고, 실행결과 받기
			//executeUpdate와 executeQuery가 있는데 
			//excuteUpdate는 처리한 행의 개수를 리턴함(int형)
			//excuteQuery는 SELECT문 전용으로 처리한 결과를 리턴함(ResultSet형)
			rset = stmt.executeQuery(query);
			
			//5. 받은 결과값들을 객체에 옮겨 저장하기
			if(rset != null) {
				memberList = new ArrayList<Member>();
				while(rset.next()) {
					
					//데이터를 담을 Member vo 생성
					Member memberOne = new Member();// memberOne객체 생성, DB에서 가져온 정보 하나씩 넣어주기
					memberOne.setMemberId(rset.getString("MEMBER_ID"));
					memberOne.setMemberPwd(rset.getString("MEMBER_PWD"));
					memberOne.setMemberId(rset.getString("MEMBER_NAME"));
					memberOne.setGender(rset.getString("GENDER"));
					memberOne.setAge(rset.getInt("AGE"));
					memberOne.setEmail(rset.getString("EMAIL"));
					memberOne.setPhone(rset.getString("ADDRESS"));
					memberOne.setAddress(rset.getString("HOBBY"));
					memberOne.setHobby(rset.getString("HOBBY"));
					memberOne.setEnrollDate(rset.getDate("ENROLL_DATE"));
					
					
					//List에 정보를 저장한 Member VO 추가
					memberList.add(memberOne);
					
					
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
				conn.close();// 노란전구 클릭후 surround 
				rset.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return memberList;
	}
}
