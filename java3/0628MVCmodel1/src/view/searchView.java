package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.BbsDto;
import javabean.BbsDao;

public class searchView extends JFrame implements ActionListener {

	private JTable jtable;
	private JScrollPane jscrPane;
	
	String columnNames[] = { "번호", "제목", "작성자" };

	JComboBox v_box;

	String search[] = { "Title", "Content", "Name" };

	Object rowData[][];

	DefaultTableModel model; // 테이블의 넓이 설정

	List<BbsDto> list = null;
	
	public searchView() {
		super("searchView");
		
		setLayout(null);

		JLabel label = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);

		BbsDao dao = BbsDao.getInstance();
		list = dao.getBbsList(); // DB에서 데이터를 취득

		rowData = new Object[list.size()][3]; // 글의 갯수에 맞춰 생성

		for (int i = 0; i < list.size(); i++) {

			BbsDto dto = list.get(i);
			
			rowData[i][0] = i + 1; // 글 번호
			rowData[i][1] = dto.getTitle(); // 제목
			rowData[i][2] = dto.getId(); // 작성자
				
			
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

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
