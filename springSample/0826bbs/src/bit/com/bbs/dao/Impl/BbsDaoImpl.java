package bit.com.bbs.dao.Impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.bbs.dao.BbsDao;
import bit.com.bbs.model.BbsDto;
import bit.com.bbs.model.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired	// applicationContext 의 sqlSession 이랑 연결하기
	SqlSession sqlSession;
	
	String namespace = "Bbs.";
	
	@Override
	public List<BbsDto> allList() {
		
		List<BbsDto> list = sqlSession.selectList(namespace + "allList");
		
		return list;
	}

	@Override
	public boolean upReadcount(int seq) {
		
		int n = sqlSession.update(namespace + "upReadcount", seq);
		
		return n>0?true:false;
	}

	@Override
	public BbsDto listDetail(int seq) {

		BbsDto bbs = sqlSession.selectOne(namespace + "listDetail", seq);
		
		return bbs;
	}

	@Override
	public boolean upBbs(BbsDto bbs) {

		int n = sqlSession.update(namespace + "upBbs", bbs);
		
		return n>0?true:false;
	}

	@Override
	public boolean delBbs(int seq) {
		
		int n = sqlSession.delete(namespace + "delBbs", seq);
		
		return n>0?true:false;
	}

	@Override
	public boolean writeBbs(BbsDto bbs) {

		int n = sqlSession.insert(namespace + "writeBbs", bbs);
		
		return n>0?true:false;
	}

	@Override
	public List<BbsDto> searchBbs(BbsParam param) {
		
		List<BbsDto> list =  sqlSession.selectList(namespace + "searchBbs", param);
		
		return list;
	}

	@Override
	public List<BbsDto> bbsPaging(BbsParam param) {
		
		List<BbsDto> list = sqlSession.selectList(namespace + "bbsPaging", param);
		
		return list;
	}

	@Override
	public List<BbsDto> searchBbsPaging(BbsParam param) {
		
		List<BbsDto> list = sqlSession.selectList(namespace + "searchBbsPaging", param);
		
		return list;
	}
	
}
