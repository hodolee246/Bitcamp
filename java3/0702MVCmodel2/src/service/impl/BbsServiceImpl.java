package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BbsDao;
import dao.impl.BbsDaoImpl;
import db.DBClose;
import db.DBConnection;
import model.BbsDto;
import service.BbsService;

public class BbsServiceImpl implements BbsService {

	BbsDao dao = new BbsDaoImpl();
	
	@Override
	public List<BbsDto> getBbsList() {
		return dao.getBbsList();
	}

	@Override
	public boolean addContent(String id, String title, String content, int del, int readcount) {
		return dao.addContent(id, title, content, del, readcount);
	}

	@Override
	public BbsDto selectView(int seq) {
		return dao.selectView(seq);
	}
	
	

}
