package UI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InsertMain extends Frame implements ActionListener, WindowListener {

	Button btn1, btn2, btn3;
	
	public InsertMain() {
		super("Insert");
		
		setLayout(null);
		
		btn1 = new Button("Pitcher");
		btn1.setBounds(250, 100, 100, 50);
		btn1.addActionListener(this);
		add(btn1);
		btn2 = new Button("Batter");
		btn2.setBounds(250, 200, 100, 50);
		btn2.addActionListener(this);
		add(btn2);
		btn3 = new Button("Back");
		btn3.setBounds(250, 350, 100, 50);
		btn3.addActionListener(this);
		add(btn3);
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		addWindowListener(this);
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		

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
		// TODO Auto-generated method stub
		Button btn = (Button) e.getSource();
		String btnName = btn.getLabel();
		
		if(btnName.equals("Pitcher")) {
			new InsertPicher();
			
			this.dispose();
		}
		else if(btnName.equals("Batter")) {
			new InsertBatter();
			
			this.dispose();
		}
		else if(btnName.equals("Back")) {
			new MainWindow();
			
			this.dispose();
		}
	}

}
