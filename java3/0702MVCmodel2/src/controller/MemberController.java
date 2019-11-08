package controller;

import javax.swing.JOptionPane;

import model.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import single.Singleton;
import view.accountView;
import view.bbsListView;
import view.loginView;

public class MemberController {

	MemberService memService = new MemberServiceImpl();
	
	public void login() {	
		new loginView();	
	}
	
	public void regi() {
		new accountView();		
	}
	
	public void regiAf(String id, String pwd, String name, String email) {	 // 회원가입후
		
		boolean b = memService.addMember(new MemberDto(id, pwd, name, email, 3));
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공!");
			login();
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			regi();
		}		
	}
	
	public boolean idCheck(String id) {
		return memService.idCheck(id);
	}

	public void loginAf(String id, String pwd) {
		
		MemberDto dto = memService.login(id, pwd);
		if(dto == null) {
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다");
			login();
		}else {
			JOptionPane.showMessageDialog(null, dto.getName() + "님 환영합니다");
			Singleton s = Singleton.getInstance();
			s.setLoginid(dto.getId());// id를 싱글톤에 저장
			s.bbsCtrl.getBbsList();
			new bbsListView();
		}		
	}

	

	
	
}





