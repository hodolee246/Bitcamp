package bit.com.bbs.dao;

import bit.com.bbs.model.MemberDto;

public interface MemberDao {

	public MemberDto allID();
	
	public boolean addMember(MemberDto mem);

	public boolean login(MemberDto mem);
	
	public int idCheck(String id);
}
