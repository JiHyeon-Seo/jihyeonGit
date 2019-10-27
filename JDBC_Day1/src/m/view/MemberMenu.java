package m.view;

import java.util.ArrayList;
import java.util.Scanner;

import m.controller.MemberController;
import m.model.vo.Member;

//입출력담당클래스
public class MemberMenu {

	private Scanner sc;
	private MemberController mContrl;

	public MemberMenu() {
		sc = new Scanner(System.in);// 생성자 안에서 초기화
		mContrl = new MemberController(); //memberController객체가 mContrl에 담김.
	}

	public void mainmenu() { // 입출력 담당할 메소드

		while (true) {
			System.out.println("\n=========== 회원 관리 프로그램 ============");
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
				// 실행코드
				mContrl.selectALL();
				break;
			case 2:
				mContrl.selectOne(this.inPutMemberId()); //밑에만들어준 회원아이디입력용메소드 가져다씀. 
				// 실행코드
				break;
			case 3:
				// 실행코드
				break;
			case 4:
				// 실행코드
				break;
			case 5:
				// 실행코드
				break;
			case 6:
				// 실행코드
				break;
			case 0:
				System.out.println("\n정말로 끝내시겠습니까?(y/n) : ");
				if (sc.next().toUpperCase().charAt(0) == 'Y') {
					return;
				}
				break;
			default: // 1~0 까지의 숫자를 제외한 나머지 결과값
				System.out.println("번호 선택이 잘못되었습니다.");
				System.out.println("확인하고 다시 선택하십시오~");

			}
		}
	}
	public void displayMemberList(ArrayList<Member> list) {
		System.out.println("\n조회된 전체 회원 정보");
		for(Member mOne : list) {
			System.out.println(mOne.toString());
		}
	}

	public void displayMember(Member member) {
		System.out.println(member.toString());

	}

	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}

	public void displaySuccess(String message) {
		System.out.println("서비스 요청 결과 : " + message);
	}
	
	//회원 아이디 입력용 메소드 
	public String inPutMemberId() {
		System.out.print("\n조회할 회원의 아이디 입력 : ");
		return sc.next();
	}
	

}
