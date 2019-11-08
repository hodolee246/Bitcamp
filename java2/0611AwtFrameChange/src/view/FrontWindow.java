package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrontWindow extends Frame implements WindowListener, ActionListener {

	public FrontWindow() {
		super("front Window");
		
		setLayout(null);
		
		Button btn = new Button("move");
		btn.setBounds(100, 100, 100, 50);
		btn.addActionListener(this);
		add(btn);
		
		setSize(640, 480);
		setLocation(100, 100);
		setBackground(Color.RED);
		setVisible(true);
		
		addWindowListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new SubWIndow();
		
		this.dispose();		// 현재 창을 닫아라.
						
		
	//	System.exit(0);	// 강제종료 ( 우선순위 엄청높음 )
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
