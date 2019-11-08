package controller;

import javax.swing.JOptionPane;

import model.AccountDto;
import service.AccountService;
import service.impl.AccountServiceImpl;
import single.Singleton;
import view.accountView;
import view.coffeeMenuView;
import view.loginView;

public class accountController {

	AccountService service = new AccountServiceImpl();
	
	public void login() {	
		new loginView();	
	}
	
	public void regi() {
		new accountView();		
	}
	
	public void addAccount(String id, String pwd, String name, int age) {
		boolean b = service.addAccount(id, pwd, name, age);
		
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공");
			login();
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			regi();
		}
		
	}
	
	public boolean idCheck(String id) {
		return service.idCheck(id);
		
	}
	
	public void login(String id, String pwd) {
		
		AccountDto dto = service.login(id, pwd);
		
		if(dto == null) {
			JOptionPane.showMessageDialog(null, "ID 혹은 PW 가 틀렸습니다.");
			login();
		} else {
			JOptionPane.showMessageDialog(null, dto.getName() + "님 환영합니다.");
			Singleton s = Singleton.getInstance();
			s.setLoginid(dto.getId());
			coffeemenu();
		}
		
	}
	
	public void coffeemenu() {
		 
		new coffeeMenuView();
	}
	
}
