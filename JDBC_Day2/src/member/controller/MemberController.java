package member.controller;

import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import member.view.MemberView;

public class MemberController {

	// 기본생성자
	public MemberController() {
	}

	public void selectAll() {
		ArrayList<Member> mList = new MemberDao().selectList();
		MemberView mView = new MemberView();

		if (!mList.isEmpty()) {
			mView.displayMemberList(mList);
		} else {
			mView.displayError("회원 전체 조회 실패");
		}
	}

	public void selectOne(String memberId) {
		Member mOne = new MemberDao().selectOne(memberId); //mOne이라는 멤버객체에 값을 넣어줌.
		MemberView mView = new MemberView();
		
		if(mOne != null) {
			mView.displayMember(mOne);
			
		}else {
			mView.displayError(memberId + " 회원 정보 조회 실패 ");
		}
	}
}
