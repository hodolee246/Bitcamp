package service.impl;

import dao.accountDao;
import dao.impl.accountDaoImpl;
import model.AccountDto;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

	accountDao dao = new accountDaoImpl();
	
	@Override
	public boolean addAccount(String id, String pwd, String name, int age) {
		return dao.addAccount(id, pwd, name, age);
	}

	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public AccountDto login(String id, String pw) {
		return dao.login(id, pw);
	}

}
