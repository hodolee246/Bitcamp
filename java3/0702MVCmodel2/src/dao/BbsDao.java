package dao;

import java.util.List;

import model.BbsDto;

public interface BbsDao {

	public List<BbsDto> getBbsList();
	
	public boolean addContent(String id, String title, String content, int del, int readcount);
	
	public BbsDto selectView(int seq);
	
}
