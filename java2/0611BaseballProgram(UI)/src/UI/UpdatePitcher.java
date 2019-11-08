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
import single.Singleton;

public class UpdatePitcher extends Frame implements ActionListener, WindowListener {
	



	
	// fkqpf 7 txtf 7 bu2
	
	Label la1, la2, la3, la4, la5, la6;
	TextField tf1, tf2, tf3, tf4, tf5, tf6;
	Button btn1, btn2;
	
	
	
	
	public UpdatePitcher() {
		super("Update Pitcher");
		
		setLayout(null);
		
		la1 = new Label("Name");
		la1.setBounds(50, 50, 100, 35);
		add(la1);
		
		la2 = new Label("Age");
		la2.setBounds(50, 100, 100, 35);
		add(la2);
		
		la3 = new Label("Height");
		la3.setBounds(50, 150, 100, 35);
		add(la3);
		
		la4 = new Label("win");
		la4.setBounds(50, 200, 100, 35);
		add(la4);
		
		la5 = new Label("lose");
		la5.setBounds(50, 250, 100, 35);
		add(la5);
		
		la6 = new Label("defence");
		la6.setBounds(50, 300, 100, 35);
		add(la6);
		
		
		Singleton si = Singleton.getInstance();
		UpdateMain um = new UpdateMain();
		
		
		int ab = si.key;
		Human hu = si.TMap.get(ab);
		String name = hu.getName();
		int age = hu.getAge();
		double height = hu.getHeight();
		int win = ((Pitcher) hu).getWin();
		int lose = ((Pitcher) hu).getLose();
		double defence = ((Pitcher) hu).getDefence();
//		si.TMap.get
		
		tf1 = new TextField(name);
		tf1.setBounds(200, 50, 100, 35);
		add(tf1);
		
		tf2 = new TextField(age + "");
		tf2.setBounds(200, 100, 100, 35);
		add(tf2);
		
		tf3 = new TextField(height + "");
		tf3.setBounds(200, 150, 100, 35);
		add(tf3);
		
		tf4 = new TextField(win + "");
		tf4.setBounds(200, 200, 100, 35);
		add(tf4);
		
		tf5 = new TextField(lose + "");
		tf5.setBounds(200, 250, 100, 35);
		add(tf5);
		
		tf6 = new TextField(defence + "");
		tf6.setBounds(200, 300, 100, 35);
		add(tf6);
		
		btn1 = new Button("Update");
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
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String btnName = btn.getLabel();
		Singleton si = Singleton.getInstance();
		Human h = si.TMap.get(1001);
				
		if(btnName.equals("Update")) {
			String name = tf1.getText();
			String str2 = tf2.getText();
			int age = Integer.parseInt(str2);
			String str3 = tf3.getText();
			double height = Double.parseDouble(str3);
			String str4 = tf4.getText();
			int win = Integer.parseInt(str4);
			String str5 = tf5.getText();
			int lose = Integer.parseInt(str5);
			String str6 = tf6.getText();
			double defence = Double.parseDouble(str6);
			Pitcher p = (Pitcher)h;
		
			p.setName(name);
			p.setAge(age);
			p.setHeight(height);
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
			
			JOptionPane.showMessageDialog(null, "Update Player");
		} else if(btnName.equals("Back")) {
			new InsertMain();
			this.dispose();
		
		}
		
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


}
