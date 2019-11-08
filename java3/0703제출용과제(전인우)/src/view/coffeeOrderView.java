package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.coffeeDto;
import single.Singleton;

public class coffeeOrderView extends JFrame implements MouseListener{

	private JTable jtable;
	private JScrollPane jscrPane;

	Object rowData[][];
	Singleton s = Singleton.getInstance();

	String columnNames[] = { "coffee", "크기", "시럽", "샷추가", "휘핑크림", "잔", "총액" };

	List<coffeeDto> list;

	DefaultTableModel model; // 테이블의 넓이 설정

	public coffeeOrderView() {
		super("영수증");

		list = s.coffeeCtrl.getCoffeeList(); // DB에서 데이터를 취득

		rowData = new Object[list.size() + 1][7]; // 글의 갯수 +1 에 맞춰 생성

		for (int i = 0; i < list.size(); i++) {
			coffeeDto dto = list.get(i);
			rowData[i][0] = dto.getName(); // 커피이름
			rowData[i][1] = dto.getCupsize(); // 커피 크기
			rowData[i][2] = dto.getSyrup(); // 어떤 시럽
			rowData[i][3] = dto.getAddshot(); // 샷 추가 여부
			rowData[i][4] = dto.getAddcream(); // 크림 추가 여부
			rowData[i][5] = dto.getCup(); // 몇잔
			rowData[i][6] = dto.getMoney(); // 얼마인지
		}

		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);

		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(80);
		jtable.getColumnModel().getColumn(1).setMaxWidth(50);
		jtable.getColumnModel().getColumn(2).setMaxWidth(50);
		jtable.getColumnModel().getColumn(3).setMaxWidth(50);
		jtable.getColumnModel().getColumn(4).setMaxWidth(50);
		jtable.getColumnModel().getColumn(5).setMaxWidth(50);
		jtable.getColumnModel().getColumn(6).setMaxWidth(50);

		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.LEFT); // 왼쪽 정렬

		// 컬럼은 글의 중간 맞춤이 된다
		jtable.getColumn("coffee").setCellRenderer(celAlignCenter);
		jtable.getColumn("크기").setCellRenderer(celAlignCenter);
		jtable.getColumn("시럽").setCellRenderer(celAlignCenter);
		jtable.getColumn("샷추가").setCellRenderer(celAlignCenter);
		jtable.getColumn("휘핑크림").setCellRenderer(celAlignCenter);
		jtable.getColumn("잔").setCellRenderer(celAlignCenter);
		jtable.getColumn("총액").setCellRenderer(celAlignCenter);
		jtable.addMouseListener(this);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 500);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
