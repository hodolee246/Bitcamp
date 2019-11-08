package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) {
		
		String res = "mybatis/config.xml";

		try {
			// mybatis 설정 파일을 읽어 들인다.
			InputStream is = Resources.getResourceAsStream(res);
			
			// SqlSessionFactory 객체를 취득
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			// sqlSession 객체를 취득
			SqlSession session = factory.openSession();
			
			// insert
			/*
			MemberDto dto = new MemberDto("dsgf", "222", "cc22");
			
			int n = session.insert("add", dto);
			if(n > 0) {	// 실행 성공시
				session.commit();	// 데이터 저장
				System.out.println("추가성공");
			}else {	// 실행 실패시
				session.rollback();	// 데이터 롤백
				System.out.println(("추가실패"));
			}
			*/
			/*
			// delete
			String findId = "aaa";
			int n = session.delete("remove", findId);
			
			if(n > 0) {	// 실행 성공시
				session.commit();	// 데이터 저장
				System.out.println("삭제성공");				
			}else {	// 실행 실패시
				session.rollback();	// 데이터 롤백
				System.out.println("삭제실패");
			}
			// DELETE OBJ
			MemberDto dto = new MemberDto("bbb", null, "");
			
			int n = session.delete("removeobj", dto);
			
			if(n > 0) {	// 실행 성공시
				session.commit();	// 데이터 저장
				System.out.println("삭제성공");				
			}else {	// 실행 실패시
				session.rollback();	// 데이터 롤백
				System.out.println("삭제실패");
			}
			 
			// update
			
			String password = "333";
			
			int n = session.update("updata", password);
			
			if(n > 0) {	// 실행 성공시
				session.commit();	// 데이터 저장
				System.out.println("업데이트 성공");				
			}else {	// 실행 실패시
				session.rollback();	// 데이터 롤백
				System.out.println("업데이트 실패");
			}
			
			// update
			
			MemberDto dto = new MemberDto("ddd", "252", "ddd@123");
			
			int n = session.update("updata", dto);
			
			if(n > 0) {	// 실행 성공시
				session.commit();	// 데이터 저장
				System.out.println("업데이트 성공");				
			}else {	// 실행 실패시
				session.rollback();	// 데이터 롤백
				System.out.println("업데이트 실패");
			}
			
			// update where
			
			MemberDto dto = new MemberDto("ccc", "555", null);
			
			int n = session.update("updatawhere", dto);
			
			if(n > 0) {	// 실행 성공시
				session.commit();	// 데이터 저장
				System.out.println("업데이트 성공");				
			}else {	// 실행 실패시
				session.rollback();	// 데이터 롤백
				System.out.println("업데이트 실패");
			}
			*//*
			// select
			String id = "ccc";
			MemberDto dto = null;
			
			dto = session.selectOne("find", id);
			
			System.out.println(dto.toString());*/
			
			
			//select list 
			List<MemberDto> list = session.selectList("allfind");
			  
			for (MemberDto mem : list) {
				System.out.println(mem.toString()); 
			}
			
			// search
			
			BbsParam bp = new BbsParam("5", "", "title");
			
			List<BbsDto> bbs = session.selectList("search", bp);
			
			for (BbsDto bbsDto : bbs) {
				System.out.println(bbsDto.toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
