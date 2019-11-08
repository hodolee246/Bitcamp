package dao;

import java.util.List;

import dto.BbsDto;

public interface iBbsDao {
	
	public List<BbsDto> getBbsList();
	
	public boolean AddBbsList(BbsDto bbs);
	
	public BbsDto CheckList(int seq);
	
	public BbsDto CheckListAll(int seq);
	
	public List<BbsDto> GetSearch(String select, String text);
	
	public boolean DeleteList(int seq);
	
	public boolean UpdateList(String title, String content);
	
	public boolean ReadCount(int seq);
	
	public boolean answer(int seq, BbsDto bbs);

	public List<BbsDto> getBbsListPaging(int num1, int num2);
}
