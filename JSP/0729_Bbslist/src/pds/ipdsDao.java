package pds;

import java.util.List;

import pds.PdsDto;

public interface ipdsDao {

	public List<PdsDto> getPdsList();
	
	public boolean insertPds(String id, String title, String content, String filename);
	
	public void pdsReadCount(int seq);
	
	public void pdsDownCount(int seq);
	
	public PdsDto getPds(int seq);
	
	public boolean updatePds(String title, String filename, String content, int seq);
	
	public boolean deletePds(int seq);
	
}
