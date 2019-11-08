package bit.com.bbs.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.bbs.dao.MemberDao;
import bit.com.bbs.model.MemberDto;
import bit.com.bbs.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public MemberDto allID() {

		return memberDao.allID();
	}

	@Override
	public boolean addMember(MemberDto mem) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl addMember");
		return memberDao.addMember(mem);
	}

	@Override
	public boolean login(MemberDto mem) {
		// TODO Auto-generated method stub
		return memberDao.login(mem);
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return memberDao.idCheck(id);
	}
}
