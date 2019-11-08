package tt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class window extends Frame implements WindowListener, ActionListener{

	Button b1, b2 ,b3;
	TextField tf ;
	public window() {
		
		super("this is Title");
		setSize(640, 480);
		setLocation(0, 0);
		setVisible(true);
		
		setLayout(null);
	
		b1 = new Button("b1");
		b1.setBounds(50, 200, 50, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new Button("b2");
		b2.setBounds(100, 200, 50, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new Button("b3");
		b3.setBounds(150, 200, 50, 30);
		b3.addActionListener(this);
		add(b3);
		
		tf = new TextField();
		tf.setBounds(75, 300, 125, 30);
		add(tf);
		
		addWindowListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String bn = btn.getLabel();
		
		if(bn.equals("b1")) {
			String str = tf.getText();
			int a = Integer.parseInt(str);
			if(a > 10 || a < 0 ) {
				JOptionPane.showMessageDialog(null, "1 ~ 10 사이 숫자를 입력해주세요");
				tf.setText("집가고싶다.");
			} else {
				tf.setText("집");
			}
			}else if(bn.equals("b2")) {
				tf.setText("집가고싶어요");
		}else if(bn.equals("b3")) {
			tf.setText("");
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
