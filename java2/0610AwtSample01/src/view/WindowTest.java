package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener{
	
	// Listener 현재 우리들이 접근을 했을때 대기상태로 있어야된다.
	// 대기상태를 유지하는걸 리스너라고 한다. (듣고있는다는 뜻으로 사용된다)
	public WindowTest() {
		super("간단한 예제입니당");
		
		setTitle("안녕하세요 ^^");
		setSize(640, 480);	// 화면 폭, 높이
		setLocation(0, 0);	// 화면 위치(나올 위치)
		setVisible(true);	// 시각화 
		
		
		addWindowListener(this); // addwindowlistener == 윈도우 리스너가 있는 클래스를 인스턴스로 넣어줘라
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
