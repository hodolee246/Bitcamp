package dao;

import model.MemberDto;

public interface MemberDao {
	public boolean addMember(MemberDto dto);


	public boolean idCheck(String id);

	
	public MemberDto login(String id, String pw);
}
