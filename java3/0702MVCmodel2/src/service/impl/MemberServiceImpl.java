package service.impl;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import model.MemberDto;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	MemberDao dao = new MemberDaoImpl();

	@Override
	public boolean addMember(MemberDto dto) {		
		return dao.addMember(dto);
	}

	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public MemberDto login(String id, String pwd) {
		return dao.login(id, pwd);
	}
	
	
}




