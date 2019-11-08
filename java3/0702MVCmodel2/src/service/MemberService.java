package service;

import model.MemberDto;

public interface MemberService {
	
	public boolean addMember(MemberDto dto);
	
	public boolean idCheck(String id);

	public MemberDto login(String id, String pwd);
	

}
