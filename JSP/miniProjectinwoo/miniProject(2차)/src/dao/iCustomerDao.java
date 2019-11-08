package dao;

import java.util.List;

import dto.AdminChartDto;
import dto.CustomerDto;

public interface iCustomerDao {
	
	public boolean addCustomer(CustomerDto dto);
	//회원추가할때 쓰는것 DB에 rows추가
	
	public boolean getidcheck(String id);
	//회원가입할때 id 확인할때 쓰는것
	
	public CustomerDto loginCustomer(String id, String pwd);
	//로그인할때 회원정보를 줌
	
	public boolean infoChangeCustomer(CustomerDto dto);
	//마이페이지에서 내정보 수정할때 쓰는것
	
	public boolean delCustomer(String id);
	//회원탈퇴할때 id를 삭제해줌
	
	public boolean B_T_ChangeCustomer(CustomerDto dto);
	//방문수와 총소비금액을 바꿔줄때 씀
	
	public boolean GradeChange(String id);
	//방문수와 총 소비금액에 따라 등급을 바꿔줌  B_T_ChangeCustomer 실행될때 자동 실행됌 !!
	
	public CustomerDto getCustomer(String id);
	//아이디만 줫을때 회원정보를 리턴해줌.. dao 안에서만 쓴다.
	
	public List<CustomerDto> getCustomerList();
	//관리자페이지에서 회원관리할떄 모든 회원의 정보를 가져온다.

	public List<AdminChartDto> chartAge();
	// 관리자 페이지에서 연령별로 예약횟수의 통계를 가져온다
	
	// 관리자 페이지에서 회원정보를 가져온다
	public List<CustomerDto> getCustomerList(String search, String text, String page);

}
