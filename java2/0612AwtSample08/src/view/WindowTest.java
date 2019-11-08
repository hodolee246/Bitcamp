package view;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener {

	Choice choice;
	Label label;
	
	
	public WindowTest() {
		
		super("choice");
		
		/*
		  AWT - choice
		  swing - JCombobox
		  web - select option
		  
		  Action - button, checkbox iOS(mac)
		  Value Change - slider, list, choice
		*/
		setLayout(null);
		
		choice = new Choice();
		choice.setBounds(150, 100, 155, 40);
		choice.add("사과");
		choice.add("포도");
		choice.add("망고");
		choice.add("딸기");
		choice.add("수박");
		
		choice.addItemListener(new ItemListener() { // 초이스를 누를때 나오는 부분
			
			@Override
			public void itemStateChanged(ItemEvent e) {
		//		JOptionPane.showMessageDialog(null, "choice");
				String index = choice.getSelectedItem();
				label.setText(index);
			}
		});
		
		add(choice);
		
		label = new Label("-----------");
		label.setBounds(50, 350, 130, 50);
		add(label);
		
		
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		addWindowListener(this);
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
