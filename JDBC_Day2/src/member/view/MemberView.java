package member.view;

import java.util.ArrayList;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

public class MemberView {

	// 멤버변수
	private Scanner sc;
	private MemberController memControl;

	// 생성자
	public MemberView() { // 생성자의 이름은 클래스의이름과 같음.
		sc = new Scanner(System.in);
		memControl = new MemberController();
	}

	public void mainMenu() {
		while (true) {
			System.out.println("\n= = = = = = = = 회원관리 프로그램 = = = = = = = = =");
			System.out.println("1. 회원 정보 전체 조회");
			System.out.println("2. 회원 아이디 조회");
			System.out.println("3. 회원 이름으로 검색");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 선택 : ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				memControl.selectAll();
				break;
			case 2:
				memControl.selectOne(this.inputMemberId());
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 0:
				System.out.println("\n 정말로 끝내시겠습니까?(Y/N) :  ");
				if (sc.next().toUpperCase().charAt(0) == 'Y')
					return;

			default:
				System.out.println("\n 번호 선택이 잘못되었습니다.");

			}
		}
	}
	public String inputMemberId() {
		System.out.print("조회할 회원 ID입력 : ");
		return sc.next();
	}
	
	
	public void displayMemberList(ArrayList<Member> memList) {
		System.out.println("조회된 전체 회원 정보는 다음과 같습니다. \n");
		for(Member mOne : memList) {
			System.out.println(mOne.toString());
		}
		
	}
	
	//멤버하나만 출력하는 메소드
	public void displayMember(Member member) {
		System.out.println(member.toString()); // 하나 받아서 출력
	}
	
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 처리 결과 : " + message);
	}
}
