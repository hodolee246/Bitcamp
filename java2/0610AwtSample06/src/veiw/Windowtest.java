package veiw;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Windowtest extends Frame implements WindowListener, ActionListener {

	Button button1, button2, button3, button4;
	TextField textField;
	

	private int result;

	public Windowtest() {
		super("간단한 계산기");
		setSize(640, 480);
		setLocation(50, 50);
		setVisible(true);

		setLayout(null);
		textField = new TextField();
		textField.setText("0");
		textField.setBounds(10, 60, 300, 30);

		add(textField);

		button1 = new Button("+");
		button1.setBounds(50, 120, 100, 40);
		button1.addActionListener(this);
		add(button1);

		button2 = new Button("-");
		button2.setBounds(200, 120, 100, 40);
		button2.addActionListener(this);
		add(button2);

		button3 = new Button("C");
		button3.setBounds(50, 200, 250, 50);
		button3.addActionListener(this);
		add(button3);

		/*
		 * button4 = new Button("="); button4.setBounds(250, 120, 100, 40);
		 * button4.addActionListener(this); add(button4);
		 */

		addWindowListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button btn = (Button) e.getSource();
		String btnName = btn.getLabel();
		
		if (btnName.equals("+")) { // ++

			String str = textField.getText();
			int x = Integer.parseInt(str);
			result = result + x;
			String str2 = Integer.toString(result);
			textField.setText(str2);
		} else if (btnName.equals("-")) { // --
			String str = textField.getText();
			int x = Integer.parseInt(str);
			result = result - x;
			String str2 = Integer.toString(result);
			textField.setText(str2);
		} else if (btnName.equals("C")) {
			// clear
			String str3 = "0";
			textField.setText(str3);
			result = 0;
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
