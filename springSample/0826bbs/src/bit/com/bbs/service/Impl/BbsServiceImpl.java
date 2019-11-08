package bit.com.bbs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.bbs.dao.BbsDao;
import bit.com.bbs.model.BbsDto;
import bit.com.bbs.model.BbsParam;
import bit.com.bbs.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsDao bbsDao;

	@Override
	public List<BbsDto> allList() {
		
		return bbsDao.allList();
		
	}

	@Override
	public boolean upReadcount(int seq) {
		
		return bbsDao.upReadcount(seq);
	}
	
	@Override
	public BbsDto listDetail(int seq) {
		
		return bbsDao.listDetail(seq);
	}

	@Override
	public boolean upBbs(BbsDto bbs) {
		
		return bbsDao.upBbs(bbs);
	}

	@Override
	public boolean delBbs(int seq) {
		
		return bbsDao.delBbs(seq);
	}

	@Override
	public boolean wrtieBbs(BbsDto bbs) {
		
		return bbsDao.writeBbs(bbs);
	}

	@Override
	public List<BbsDto> searchBbs(BbsParam param) {
		
		return bbsDao.searchBbs(param);
	}

	@Override
	public List<BbsDto> bbsPaging(BbsParam param) {
		
		return bbsDao.bbsPaging(param);
	}

	@Override
	public List<BbsDto> searchBbsPaging(BbsParam param) {
		
		return bbsDao.searchBbsPaging(param);
	}

	
}
