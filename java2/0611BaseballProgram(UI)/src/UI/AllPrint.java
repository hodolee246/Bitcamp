package UI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;

import dto.Batter;
import dto.Human;
import single.Singleton;

public class AllPrint extends Frame implements ActionListener, WindowListener {

	TextArea ta ;
	Button btn1, btn2;
	
	public AllPrint() {
		super("AllPrint");
		
		setLayout(null);
		
		ta = new TextArea();
		ta.setBounds(50, 50, 400, 300);
		add(ta);
		Singleton si = Singleton.getInstance();
		
		Iterator<Integer> it = si.TMap.keySet().iterator();
		
		Integer k = 0;
		while(it.hasNext()) {
			Integer key = it.next();
			k = key;
			Human hu = si.TMap.get(k);
			String str = hu.toString();
			ta.append("\n" + str);
		}
		
		btn1 = new Button("Back");
		btn1.setBounds(50, 400, 100, 35);
		btn1.addActionListener(this);
		add(btn1);
		
		
			
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
		
		if(btnName.equals("Back")) {
			new MainWindow();
			this.dispose();
		}

	}

}
