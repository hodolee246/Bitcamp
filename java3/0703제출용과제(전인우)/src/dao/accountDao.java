package dao;

import model.AccountDto;

public interface accountDao {

	public boolean addAccount(String id, String pwd, String name, int age);
	
	public boolean idCheck(String id);
	
	public AccountDto login(String id, String pw);
	
}
