package dao;

import java.util.List;

import dto.RoomDto;

public interface iRoomDao {
	
	public List<RoomDto> getRoomSearchList(String search);
	//객실정보에서 체크박스 별로 서치 했을때 리스트 리턴 해주는 함수
	
	public boolean addRoom(RoomDto dto);
	//관리자페이지에서 관리자가 룸 추가할때 함수
	
	public boolean delRoom(String room_num);
	//관리자페이지에서 관리자가 룸 삭제할때 함수
	
	public boolean changeRoom(RoomDto dto);
	//관리자페이지에서 관리자가 룸의 등급과 가격을 수정할때 함수
	
	public boolean CheckRoom_Number(String Room_num);
	//룸 추가할때 룸번호가 있는지 체크하는 함수
	
	
	public List<RoomDto> getRoomList();
	
	public boolean updateRoom(RoomDto dto);
	
	public boolean deleteRoom(String room_number);
	
	public List<RoomDto> getAllList(String visit_date);
	
	public List<RoomDto> getList(int num1, int num2, String visit_date);

}
