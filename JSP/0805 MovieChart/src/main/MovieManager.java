package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieVo;

public class MovieManager {
	
	public static List<MovieVo> getCGVdata() {
		
		Document doc;
		
		List<MovieVo> list = new ArrayList<MovieVo>();
		
		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			
			// 영화제목
			Elements titles = doc.select("div.box-contents strong.title");
			/*
			  <div class="box-contents">
              	 <a href="/movies/detail-view/?midx=82012">
                	 <strong class="title">엑시트</strong>
                 </a>
			  
			*/
			/*
			 <span class="like"> 
                  <button class="btn-like" value="82012">영화 찜하기</button>
                       <span class="count"> 
                         <strong><i>8,852</i><span>명이 선택</span></strong> 
                                <i class="corner-RT"></i><i class="corner-LT"></i><i class="corner-LB"></i><i class="corner-RB"></i><i class="corner-arrow"></i>
                            </span>
                            <a class="link-reservation" href="/ticket/?MOVIE_CD=20020039&MOVIE_CD_GROUP=20020039">예매</a>
                        </span>

			  */
			// 좋아요
			Elements likes = doc.select("div.box-contents span.count strong i");
			for (int i = 0; i < 7; i++) {
				Element eTitle = titles.get(i);
				String title = eTitle.text();
				Element eLike = likes.get(i);
				String slike = eLike.text().replace(",", "");
				int like = Integer.parseInt(slike);
				
				MovieVo vo = new MovieVo();
				vo.setTitle(title);
				vo.setLike(like);
				
				list.add(vo);
				
				
				System.out.print(title);
				System.out.println(", " + slike);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
