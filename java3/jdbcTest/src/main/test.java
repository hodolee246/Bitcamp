package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame implements ActionListener {

	JLabel menu[] = new JLabel[44];
	
	String name[] = {"Espresso Beverages", "Short", "Tall", "Grande",
			"", "", "", "",
			"헤이즐넛 카라멜 모카", "4800", "5300", "5800",
			"카라멜 마끼아또", "4300", "4800", "5300",
			"화이트 초콜릿 모카", "4300", "4800", "5300",
			"카라멜 모카", "4300", "4800", "5300",
			"카페 모카", "3800", "4300", "4800",
			"카라멜 라떼", "3800", "4300", "4800",
			"카페 라떼", "3300", "3800", "4300",
			"카푸치노", "3300", "3800", "4300",
			"아메리카노", "2800", "3300", "3800",
			"오늘의 커피", "2500", "3000", "3500"};
	
	
	public test() {
	
		Dimension dim = new Dimension(400, 100);
		
		JFrame jf = new JFrame("testgrd");
		jf.setLocation(200, 400);
		jf.setPreferredSize(dim);
		
		jf.setLayout(new GridLayout(10, 10));

		for (int i = 0; i < menu.length; i++) {
			menu[i] = new JLabel();
			menu[i].setText(name[i]);
			jf.add(menu[i]);
		}
		
		jf.pack();
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
