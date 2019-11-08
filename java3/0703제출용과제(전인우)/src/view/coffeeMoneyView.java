package view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import single.Singleton;

public class coffeeMoneyView extends Frame implements WindowListener {

	JLabel menu[] = new JLabel[48];

	String name[] = { "Espresso Beverages", "Short", "Tall", "Grande", "", "", "", "", "헤이즐넛 카라멜 모카", "4800", "5300",
			"5800", "카라멜 마끼아또", "4300", "4800", "5300", "화이트 초콜릿 모카", "4300", "4800", "5300", "카라멜 모카", "4300", "4800",
			"5300", "카페 모카", "3800", "4300", "4800", "카라멜 라떼", "3800", "4300", "4800", "카페 라떼", "3300", "3800", "4300",
			"카푸치노", "3300", "3800", "4300", "아메리카노", "2800", "3300", "3800", "오늘의 커피", "2500", "3000", "3500" };

	JLabel label1, label2;

	
	Singleton s = Singleton.getInstance();
	
	public coffeeMoneyView() {
		super("coffeeMoneyView");

		setLayout(new GridLayout(13, 4, 40, 0));

		for (int i = 0; i < menu.length; i++) {
			menu[i] = new JLabel();
			menu[i].setText(name[i]);
			add(menu[i]);
		}

		setBounds(0, 0, 1000, 600);
		setVisible(true);
		addWindowListener(this);
	}
	
	

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
		// 끄면서
		this.dispose();
		// 다시 메인창 실행
		s.actCtrl.coffeemenu();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
