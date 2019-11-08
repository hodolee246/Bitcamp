package dao;

import java.util.List;

import dto.RoomDto;

public interface iRoomDao {

	public List<RoomDto> getAllList(String visit_date);
	
	public List<RoomDto> getList(int num1, int num2, String visit_date);	// 일단은 페이징용 삭제해도 상관X
	
}
