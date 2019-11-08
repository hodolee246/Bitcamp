package view;

import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dto.DtoClass;


public class WindowTest extends JFrame implements MouseListener{
	
	JTable table; // 하나의 데이터를 Rows라고 한다(한명의 데이터(방어율, 승, 패))
					// 컬럼 (항목) 
	JScrollPane scrPane; // table은 계속 늘어나서 ScroolPane을 잡아ㅜㄴ다.
	
	String columnNames[] = {"상품번호", "상품명", "상품가격", "상품회사"};
	
	Object rowData[][];		// 3 * 4
	/*
	  	{a, b, c, d}
	  	{e, f, g, h}
	  	{i, j, k, l}
	  
	 */
	
	java.util.List<DtoClass> list = new ArrayList<DtoClass>();
	
	public WindowTest() {
	
		super("Table");
		
		list.add(new DtoClass(101, "맛동산", 1000, "오리온"));
		list.add(new DtoClass(102, "초코파이", 1500, "해태"));
		list.add(new DtoClass(103, "감자깡", 1800, "롯데"));
		
		rowData = new Object[list.size()][4];
		
		for (int i = 0; i < list.size(); i++) {
			rowData[i][0] = list.get(i).getSeq();
			rowData[i][1] = list.get(i).getName();
			rowData[i][2] = list.get(i).getMoney();
			rowData[i][3] = list.get(i).getCompany();
		}
		
		table = new JTable(rowData, columnNames);
		table.addMouseListener(this);
					//  실제데이터		항목명
		scrPane = new JScrollPane( table );
		add(scrPane);
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
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
		int rowNumber = table.getSelectedRow();
		
		
			DtoClass dto = list.get(rowNumber);
			JOptionPane.showMessageDialog(null, "선택행:" + rowNumber + 1 + "" + dto.toString());

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
