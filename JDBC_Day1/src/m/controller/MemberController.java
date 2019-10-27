package m.controller;

import java.util.ArrayList;

import m.model.dao.MemberDao;
import m.model.vo.Member;
import m.view.MemberMenu;

public class MemberController {

	public MemberController() {
	}

	public void selectOne(String memberId) {

		MemberMenu mMenu = new MemberMenu();
		MemberDao mDao = new MemberDao();

		Member mOne = mDao.selectOne(memberId);
		// mONe은 DB에서 가져온 데이터들을 저장한 멤버객체임

		if (mOne != null) {
			mMenu.displayMember(mOne);
			// View를 통해 출력함
		} else {
			mMenu.displayError(memberId + "회원정보 조회실패");
			// view를 통해 에러코드 출력
		}
	}

	public void selectALL() {

		MemberDao mDao = new MemberDao();
		ArrayList<Member> memList = mDao.selectAll();

		MemberMenu mMenu = new MemberMenu();

		if (!memList.isEmpty()) {
			// view를 통하여 출력
			mMenu.displayMemberList(memList);
		} else {
			// view를 통하여 조회 실패를 출력
			mMenu.displayError("회원 전체 조회 실패");
		}
	}
}
