package view;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener, ItemListener{

	Checkbox cb1, cb2, cb3, cb4, cb5, cb6;
	CheckboxGroup cbg1, cbg2;
	Label la1, la2;
	public WindowTest() {
	
		super("radio button");
		setLayout(null);
		/*
			AWT : RadioButton -> checkbox
			Swing : JRadioButton
		
		*/
		
		cbg1 = new CheckboxGroup();	//1 ~ 3
		
		cbg2 = new CheckboxGroup();	// 4, 5
		
		// Group 1
		cb1 = new Checkbox("Java", true, cbg1);
		cb1.setBounds(100, 100, 100, 20);
		cb2 = new Checkbox("C", false, cbg1);
		cb2.setBounds(100, 130, 100, 20);
		cb3 = new Checkbox("Python", false, cbg1);
		cb3.setBounds(100, 160, 100, 20);
		// Group 2
		cb4 = new Checkbox("Oracle", true, cbg2);
		cb4.setBounds(250, 100, 100, 20);
		cb5 = new Checkbox("My-SQL", false, cbg2);
		cb5.setBounds(250, 130, 100, 20);
		
		
		// checkbox
		cb6 = new Checkbox("exit");
		cb6.setBounds(100, 250, 100, 20);
		
		
		la1 = new Label("label");
		la1.setBounds(100, 200, 150, 30);
		
		la2 = new Label("label2");
		la2.setBounds(250, 200, 150, 30);
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
		
		add(la1);
		add(la2);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		cb6.addItemListener(this);
		
		
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		addWindowListener(this);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		Checkbox cb = (Checkbox)obj;
		String labelName = cb.getLabel();
		
		if(cb == cb1 || cb == cb2 || cb == cb3) {	// cb == 클릭시 인식하게 하는ㄳ
			la1.setText(labelName);
	
		} else if(cb == cb4 || cb == cb5) {
			la2.setText(labelName);
		} else if(cb == cb6) {
			this.dispose();
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
