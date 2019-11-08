package bit.com.bbs.dao.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.bbs.dao.MemberDao;
import bit.com.bbs.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired	// applicationContext 의 sqlSession 이랑 연결
	SqlSession sqlSession;
	
	String namespace = "Member.";
	
	@Override
	public MemberDto allID(){
		MemberDto dto = sqlSession.selectOne("allId");
		
		return dto;
	}
	
	@Override
	public boolean addMember(MemberDto mem){
		
		System.out.println("MemberDaoImpl addMember");
		
		int n = sqlSession.insert(namespace + "add", mem);
		
		return n>0?true:false;
	}

	@Override
	public boolean login(MemberDto mem) {
		int n = sqlSession.selectOne(namespace + "login", mem);
		
		return n>0?true:false;
	}

	@Override
	public int idCheck(String id) {
		int n = sqlSession.selectOne(namespace + "idcheck", id);
		return n;
	}

	

}
