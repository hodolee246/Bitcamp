package UI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import processing.SearchClass;
import single.Singleton;

public class UpdateMain extends Frame implements ActionListener, WindowListener {

	Label label;
	
	TextField tf;
	
	Button btn1, btn2;
	
	public UpdateMain() {
		super("Update Main");
		
		setLayout(null);
		
		label = new Label("Name");
		label.setBounds(50, 100, 100, 35);
		add(label);
		
		tf = new TextField("Insert Name to Search");
		tf.setBounds(200, 100, 140, 35);
		add(tf);
		
		btn1 = new Button("Search");
		btn1.setBounds(50, 400, 100, 35);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new Button("Back");
		btn2.setBounds(200, 400, 100, 35);
		btn2.addActionListener(this);
		add(btn2);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String btnName = btn.getLabel();
		
		if(btnName.equals("Search")) {
			Singleton si = Singleton.getInstance();
			SearchClass ss = new SearchClass();
			int key = ss.search(tf.getText());
			si.key = key;
			Human h = si.TMap.get(key);
			if(key != -1) {
				if(h instanceof Pitcher) {
					new UpdatePitcher();
					this.dispose();
				} else if(h instanceof Batter) {
					new UpdateBatter();
					this.dispose();
					System.out.println(tf.getText());
				}
			}else {
				JOptionPane.showMessageDialog(null, "can not found the name");
			}
		}
		else if(btnName.equals("Back")) {
			new MainWindow();
			
			this.dispose();
		}

	}
	
}
