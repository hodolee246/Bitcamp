package service;

import model.AccountDto;

public interface AccountService {
	
	public boolean addAccount(String id, String pwd, String name, int age);

	public boolean idCheck(String id);
	
	public AccountDto login(String id, String pw);
}
