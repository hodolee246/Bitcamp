package bit.com.bbs.service;

import bit.com.bbs.model.MemberDto;

public interface MemberService {
	
	public MemberDto allID();
	
	public boolean addMember(MemberDto mem);

	public boolean login(MemberDto mem);
	
	public int idCheck(String id);

}
