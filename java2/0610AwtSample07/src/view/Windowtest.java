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

import javax.swing.JOptionPane;

public class Windowtest extends Frame implements WindowListener, ActionListener{

	public int rannum, usernum;
	
	
	
	Button button1, button2;
	Label label;
	TextField textField;
	
	public Windowtest() {
		super("랜덤숫자 게임");
		setSize(640, 480);
		setLocation(30, 30);
		setVisible(true);
		
		setLayout(null);
		
		textField = new TextField();
		textField.setText("0");
		textField.setBounds(10, 60, 300, 30);

		add(textField);
		
		label = new Label("No");
		label.setBounds(50, 130, 200, 40);
		label.setBackground(new Color(255, 0, 0));
		add(label);
		
		button1 = new Button("button");
		button1.setBounds(50, 200, 100, 40);
		button1.addActionListener(this);
		add(button1);
		
		button2 = new Button("restart");
		button2.setBounds(50, 280, 100, 40);
		button2.addActionListener(this);
		add(button2);
		
		addWindowListener(this);
		
		rannum = (int)((Math.random()*60)+20);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String btnName = btn.getLabel();
		
		
		if(btnName.equals("button")) {
			String str = textField.getText();
			int x = Integer.parseInt(str);
			if(x > 10 || x <= 0) {
				JOptionPane.showMessageDialog(null, "1~10을 입력해주세요");
			}else {
			rannum = rannum - x;
			}
			if(rannum <= 0) {
				label.setText("Yes.");
				JOptionPane.showMessageDialog(null, "당첨되었습니다.");
			}
		}else if(btnName.equals("restart")) {
			rannum = (int)((Math.random()*60)+20);
			JOptionPane.showMessageDialog(null, "랜덤 숫자가 다시지정되었습니다.");
			label.setText("no");
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
