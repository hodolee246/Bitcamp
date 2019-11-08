package view;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class Windowtest extends Frame implements WindowListener {

	public Windowtest() {
		super("제목입니당. here is title");
		
	//	setSize(640, 480);
	//	setLocation(0, 0);
		
		setBounds(0, 0, 640, 480);
		
		setVisible(true); // 시각화 반드시 있어야한다.
		
		// label(레이블)
		Label label = new Label("여기가 Label입니다."); 
		add(label);
		addWindowListener(this); // 리스너가 있는 클래스 == 매개변수
		String str = "AWT입니다.";
		label.setText(str);
		
		System.out.println("WindowTest의 생성자 실행 입니다.");
		
		JOptionPane.showMessageDialog(null, "메세지박스 실행");
		
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
		System.exit(0);
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
