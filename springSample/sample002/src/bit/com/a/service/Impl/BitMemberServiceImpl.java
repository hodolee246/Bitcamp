package bit.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitMemberDao;
import bit.com.a.service.BitMemberService;

@Service
public class BitMemberServiceImpl implements BitMemberService {
	
	/* 인터 페이스에 에노테이션으로 오토와이어를 할경우 springframework 가 자동생성해준다. */
	@Autowired	// DI : 의존성 (알아서 애가 찾아주도록 의존한다.)
	private BitMemberDao bitMemberDao;
	// BitMemberDao bitMemberDao = new BitMemberDaoImpl();
	// 이 작업이 위에 작업이랑 동일 하다.
	
	
	
	
	
}
