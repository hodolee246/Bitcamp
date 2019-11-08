package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LoginClass extends Frame implements WindowListener, ActionListener{
	Button btn1, btn2;
	Label label1, label2;
	TextField tf1, tf2;
	
	public LoginClass() {
		super("Login");
		
		setLayout(null);
		
		label1 = new Label("ID");
		label1.setBounds(150, 100, 70, 50);
		add(label1);
		
		label2 = new Label("PW");
		label2.setBounds(150, 160, 70, 50);
		add(label2);
		
		tf1 = new TextField();
		tf1.setBounds(240, 100, 150, 50);
		add(tf1);
		
		tf2 = new TextField();
		tf2.setBounds(240, 100, 150, 50);
		add(tf2);
		
		btn1 = new Button("Login");
		btn1.setBounds(100, 100, 100, 50);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new Button("MemberJoin");
		btn2.setBounds(230, 100, 100, 50);
		btn2.addActionListener(this);
		add(btn2);
		
		setBounds(0, 0, 800, 500);
		setVisible(true);
		
		addWindowListener(this);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
