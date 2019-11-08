package bit.com.project.dao.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.project.dao.BitLoginDao;
import bit.com.project.model.MemberDto;

@Repository	// Repository == 저장소
public class BitLoginDaoImpl implements BitLoginDao {

	@Autowired	// applicationContext 의 SqlSession 이랑 연결을 해준다.
	SqlSession sqlSession;
	
	String namespace = "Member.";
	
	@Override
	public boolean addMember(MemberDto mem) throws Exception {

		int n = sqlSession.insert(namespace + "addmember", mem);
		
		return n>0?true:false;
	}

}

