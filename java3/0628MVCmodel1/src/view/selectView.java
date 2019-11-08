package view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dto.BbsDto;
import dto.Member;
import javabean.BbsDao;
import javabean.MemberDao;

public class selectView extends JFrame implements ActionListener {

	private JLabel label_id, label_sysdate, label_readcount, label_title, label_content;
	private JTextField tf_id, tf_sysdate, tf_readcount, tf_title;
	private JTextArea ta_content;
	private JButton btn_list, btn_select, btn_delete;
	
	private String id, sysdate, readcount, title, content;
	private int seq;
	
	
	
	public selectView(int seq) {
		super("selectView");
		this.seq = seq;
		setLayout(null);
		
		label_id = new JLabel("id");
		label_id.setBounds(50, 50, 50, 50);
		add(label_id);
		
		label_sysdate = new JLabel("sysdate");
		label_sysdate.setBounds(50, 110, 50, 50);
		add(label_sysdate);
		
		label_readcount = new JLabel("readcount");
		label_readcount.setBounds(50, 170, 50, 50);
		add(label_readcount);
		
		label_title = new JLabel("title");
		label_title.setBounds(50, 230, 50, 50);
		add(label_title);
		
		label_content = new JLabel("content");
		label_content.setBounds(50, 290, 50, 50);
		add(label_content);
		
		BbsDao dao = BbsDao.getInstance();
		dao.readCount(seq);
		
		BbsDto dto = null;
		dto = dao.selectView(seq);
		
		tf_id = new JTextField(dto.getId());
		tf_id.setBounds(110, 50, 100, 50);
		tf_id.setEnabled(false);
		add(tf_id);
		
		tf_sysdate = new JTextField(dto.getWdate());
		tf_sysdate.setBounds(110, 110, 100, 50);
		tf_sysdate.setEnabled(false);
		add(tf_sysdate);
		
		tf_readcount = new JTextField(dto.getReadcount()+"");
		tf_readcount.setBounds(110, 170, 100, 50);
		tf_readcount.setEnabled(false);
		add(tf_readcount);
		
		tf_title = new JTextField(dto.getTitle());
		tf_title.setBounds(110, 230, 100, 50);
		
		add(tf_title);
		
		ta_content = new JTextArea(dto.getContent());
		ta_content.setBounds(50, 350, 150, 100);
		
		add(ta_content);
		
		btn_list = new JButton("list");
		btn_list.setBounds(50, 470, 100, 50);
		btn_list.addActionListener(this);
		add(btn_list);
		
		btn_select = new JButton("select");
		btn_select.setBounds(160, 470, 100, 50);
		btn_select.addActionListener(this);
		add(btn_select);
		
		btn_delete = new JButton("delete");
		btn_delete.setBounds(270, 470, 100, 50);
		btn_delete.addActionListener(this);
		add(btn_delete);
		
		setBounds(0, 0, 400, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		BbsDao dao = BbsDao.getInstance();
		if(btn_list.equals(obj)) {
			this.dispose();
			new bbsListView();
		}
		else if(btn_select.equals(obj)) {
			dao.BbsUpdate(seq, tf_title.getText(), ta_content.getText());
			this.dispose();
			new bbsListView();
		}
		else if(btn_delete.equals(obj)){
			dao.BbsDelete(seq);
			this.dispose();
			new bbsListView();
		}
			
		
	}

}
