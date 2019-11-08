package dao;

import java.util.List;

import dto.CalendarDto;

public interface iCalendar {
	
	
	public List<CalendarDto> getCalendarList(String id,  String yyyyMM);
	
	
	public boolean addCalendarList(String id, String title, String content, String rdate);
}
