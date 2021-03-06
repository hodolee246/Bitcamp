package UI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow extends Frame implements ActionListener, WindowListener {

	Button btn1, btn2, btn3, btn4, btn5;
	
	
	public MainWindow() {
		super("Main");
		
		setLayout(null);
		
		btn1 = new Button("Player Add");
		btn1.setBounds(230, 50, 150, 50);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new Button("Player Delete");
		btn2.setBounds(230, 125, 150, 50);
		btn2.addActionListener(this);
		add(btn2);
		
		btn3 = new Button("Player Search");
		btn3.setBounds(230, 200, 150, 50);
		btn3.addActionListener(this);
		add(btn3);
		
		btn4 = new Button("Player Update");
		btn4.setBounds(230, 275, 150, 50);
		btn4.addActionListener(this);
		add(btn4);
		
		btn5 = new Button("Player Print");
		btn5.setBounds(230, 350, 150, 50);
		btn5.addActionListener(this);
		add(btn5);
		
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
		
		if(btnName.equals("Player Add")) {
			new InsertMain();
			this.dispose();
		}else if(btnName.equals("Player Delete")) {
			new DeleteMain();
			this.dispose();
		}else if(btnName.equals("Player Search")) {
			new SearchMain();
			this.dispose();
		}else if(btnName.equals("Player Update")) {
			new UpdateMain();
			this.dispose();
		}else if(btnName.equals("Player Print")) {
			new AllPrint();
			this.dispose();
		}

	}

}
