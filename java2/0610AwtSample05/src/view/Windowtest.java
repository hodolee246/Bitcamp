package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class Windowtest extends Frame implements WindowListener, ActionListener {

	Label label;

	Button button1, button2;

	public Windowtest() {
		super("버튼만들기~!");
		setSize(640, 480);
		setLocation(50, 50);
		setVisible(true);

		setLayout(null);
		label = new Label();
		label.setText("10");
		label.setBounds(10, 60, 620, 30);
		label.setBackground(new Color(0, 255, 0));
		add(label);

		button1 = new Button("button1");
		button1.setBounds(50, 120, 100, 40);
		button1.addActionListener(this);
		add(button1);

		button2 = new Button("button2");
		button2.setBounds(200, 120, 100, 40);
		button2.addActionListener(this);
		add(button2);

		addWindowListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//	JOptionPane.showMessageDialog(null, "Button");
		
		Button btn = (Button)e.getSource();
		String btnName = btn.getLabel();
		
		if(btnName.equals("button1")) {
		//	JOptionPane.showMessageDialog(null, "1번 버튼클릭!");
			label.setText("button1 Click");
		}else if(btnName.equals("button2")) {
		//	JOptionPane.showMessageDialog(null, "2번 버튼클릭!");
			label.setText("button2 Click");
		}
		
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
