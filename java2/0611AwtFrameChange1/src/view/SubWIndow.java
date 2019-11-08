package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import single.Singleton;

public class SubWIndow extends Frame implements WindowListener, ActionListener {

	public SubWIndow() {
		super("SUB window");
		
		
		setLayout(null);
		
		Button btn = new Button("B");
		btn.setBounds(100, 100, 100, 50);
		btn.addActionListener(this);
		add(btn);
		
		setBounds(100, 100, 640, 480);
		setBackground(Color.RED);
		
		setVisible(false);
		
		addWindowListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Singleton s = Singleton.getInstance();
		s.fwin.setVisible(true);
		s.swin.setVisible(false);
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
