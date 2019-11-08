package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.BbsDto;
import oracle.net.aso.s;
import service.BbsService;
import single.Singleton;


public class bbsListView extends JFrame implements ActionListener, MouseListener {
	

	private JTable jtable;
	private JScrollPane jscrPane;
	private JTextField tf1;
	private JButton writeBtn, btn_search;

	private int seq = -1;

	String columnNames[] = { "번호", "제목", "작성자" };

	JComboBox v_box;

	String search[] = {"선택", "제목", "내용", "아이디" };

	Object rowData[][];

	DefaultTableModel model; // 테이블의 넓이 설정

	List<BbsDto> list = null;

	public bbsListView() {
		super("게시판");

		setLayout(null);

		JLabel label = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);
		Singleton s = Singleton.getInstance();
		
		
		list = s.bbsCtrl.getBbsList(); // DB에서 데이터를 취득

		rowData = new Object[list.size()][3]; // 글의 갯수에 맞춰 생성

		for (int i = 0; i < list.size(); i++) {

			BbsDto dto = list.get(i);
			if(dto.getDel() == 0) {
			rowData[i][0] = i + 1; // 글 번호
			rowData[i][1] = dto.getTitle(); // 제목
			rowData[i][2] = dto.getId(); // 작성자
			} else if (dto.getDel() == 1) {
				rowData[i][0] = i + 1; // 글 번호
				rowData[i][1] = "삭제된 글 입니다."; // 제목
				
			}
			
		}

		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);

		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50); // 번호
		jtable.getColumnModel().getColumn(1).setMaxWidth(500); // 글 제목
		jtable.getColumnModel().getColumn(2).setMaxWidth(200); // 작성자

		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 중간

		// 번호와 작성자의 컬럼은 글의 중간 맞춤이 된다
		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		jtable.addMouseListener(this);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);

		writeBtn = new JButton("Write");
		writeBtn.setBounds(10, 370, 90, 30);
		writeBtn.addActionListener(this);
		add(writeBtn);

		v_box = new JComboBox(search);
		v_box.setBounds(130, 400, 90, 30);
		add(v_box);

		tf1 = new JTextField();
		tf1.setBounds(230, 400, 150, 30);
		add(tf1);

		btn_search = new JButton("search");
		btn_search.setBounds(400, 400, 150, 30);
		btn_search.addActionListener(this);
		add(btn_search);

		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 500);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Singleton s = Singleton.getInstance();
		Object obj = e.getSource();
		if (writeBtn.equals(obj)) {
			s.bbsCtrl.Write();
			
		} else if(btn_search.equals(obj)) {
			String combo, text;
			text = tf1.getText();
			/*combo = (String)v_box.getSelectedItem();
			list = dao.getfind(combo, text);
			
			if(list.size() == 0 || text.equals("")) {
				JOptionPane.showMessageDialog(null, "데이터를 못찾았습니다.");
				list = dao.getBbsList();
			}
			
			setList(list);
			*/
		}

	}
	
	public void setList(List<BbsDto> list) {
		rowData = new Object[list.size()][3];	// 글의 갯수에 맞춰 생성
		
		for(int i = 0;i < list.size(); i++) {
			BbsDto dto = list.get(i);
			
			rowData[i][0] = i + 1;	// 글 번호
			if(dto.getDel() == 1) {		// 글제목
				rowData[i][1] = "  ******이 글은 삭제되었습니다*****";
			}else {
				rowData[i][1] = dto.getTitle();
			}
			rowData[i][2] = dto.getId();	// 작성자
		}	
		
		model.setDataVector(rowData, columnNames);
				
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);	// 번호
		jtable.getColumnModel().getColumn(1).setMaxWidth(500);	// 글 제목
		jtable.getColumnModel().getColumn(2).setMaxWidth(200);	// 작성자
		
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
		
		// 번호와 작성자의 컬럼은 글의 중간 맞춤이 된다
		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		
		jtable.setModel(model);		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	int rownum = jtable.getSelectedRow();
	Singleton s = Singleton.getInstance();
		
		if (list.get(rownum).getDel() == 0) {
			s.bbsCtrl.selectView(rownum);
			s.bbsCtrl.clickView(rownum);
			dispose();
		}
			
		else {
			return;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
