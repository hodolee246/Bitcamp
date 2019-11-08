package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BbsDto;
import service.BbsService;
import service.impl.BbsServiceImpl;
import view.bbsListView;
import view.writeView;

public class BbsController {

	BbsService bbsservice = new BbsServiceImpl();
	
	public List<BbsDto> getBbsList() {
		return bbsservice.getBbsList();
	}
	
	public void Write() {
		new writeView();
	}
	
	public void addContent(String id, String title, String content, int del, int readcount) {
		
		boolean b = bbsservice.addContent(id, title, content, del, readcount);
		if(b) {
			JOptionPane.showMessageDialog(null, "게시글을 추가했습니다.");
			new bbsListView();
		} else {
			JOptionPane.showMessageDialog(null, "게시글 추가에 실패했습니다.");
			return;
		}
		
	}
	
	public BbsDto selectView(int seq) {
		return bbsservice.selectView(seq);
	}
	
	public void clickView(int seq) {
		new view.selectView(seq);
	}
	
}
