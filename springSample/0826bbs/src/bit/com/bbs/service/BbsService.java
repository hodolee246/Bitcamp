package bit.com.bbs.service;

import java.util.List;

import bit.com.bbs.model.BbsDto;
import bit.com.bbs.model.BbsParam;

public interface BbsService {

	public List<BbsDto> allList();
	
	public boolean upReadcount(int seq);
	
	public BbsDto listDetail(int seq);
	
	public boolean upBbs(BbsDto bbs);
	
	public boolean delBbs(int seq);
	
	public boolean wrtieBbs(BbsDto bbs);
	
	public List<BbsDto> searchBbs(BbsParam param);
	
	public List<BbsDto> bbsPaging(BbsParam param);
	
	public List<BbsDto> searchBbsPaging(BbsParam param);
	
}
