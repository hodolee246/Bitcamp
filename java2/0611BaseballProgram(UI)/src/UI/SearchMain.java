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

public class SearchMain extends Frame implements ActionListener, WindowListener {

	Label label;
	Label la1, la2, la3, la4, la5, la6;
	Label l1, l2, l3, l4, l5, l6;
	TextField tf;
	
	Button btn1, btn2;
	
	private int key;
	
	public SearchMain() {
		super("Search Main");
		
		setLayout(null);
		
		label = new Label("Name");
		label.setBounds(50, 50, 100, 35);
		add(label);
		
		tf = new TextField("Insert Name to Search");
		tf.setBounds(200, 50, 140, 35);
		add(tf);
		
		btn1 = new Button("Search");
		btn1.setBounds(50, 400, 100, 35);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new Button("Back");
		btn2.setBounds(200, 400, 100, 35);
		btn2.addActionListener(this);
		add(btn2);
		
		l1 = new Label("Age");
		l1.setBounds(50, 100, 100, 35);
		add(l1);
		
		l2 = new Label("height");
		l2.setBounds(50, 150, 100, 35);
		add(l2);
		
		l3 = new Label();
		l3.setBounds(50, 200, 100, 35);
		add(l3);
		
		l4 = new Label();
		l4.setBounds(50, 250, 100, 35);
		add(l4);
		
		l5 = new Label();
		l5.setBounds(50, 300, 100, 35);
		add(l5);
		
		
		la1 = new Label("");
		la1.setBounds(200, 100, 100, 35);
		add(la1);
		
		la2 = new Label("");
		la2.setBounds(200, 150, 100, 35);
		add(la2);
		
		la3 = new Label("");
		la3.setBounds(200, 200, 100, 35);
		add(la3);
		
		la4 = new Label("");
		la4.setBounds(200, 250, 100, 35);
		add(la4);
		
		la5 = new Label("");
		la5.setBounds(200, 300, 100, 35);
		add(la5);
		
		la6 = new Label("");
		la6.setBounds(50, 350, 100, 35);
		add(la6);
		
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
			key = ss.search(tf.getText());
			
			System.out.println(tf.getText());
			System.out.println(key);
			
			if(key != -1) {
				Human h = si.TMap.get(key);
				if(h instanceof Pitcher) {
					String name = h.getName();
					int age = h.getAge();
					double height = h.getHeight();
					int win = ((Pitcher) h).getWin();
					int lose = ((Pitcher) h).getLose();
					double defence = ((Pitcher) h).getDefence();
					
					
					la1.setText(age + "");
					la2.setText(height + "");
					la3.setText(win + "");
					la4.setText(lose + "");
					la5.setText(defence + "");
					
					l3.setText("win");
					l4.setText("lose");
					l5.setText("defence");
					
				} else if(h instanceof Batter) {
					
					String name = h.getName();
					int age = h.getAge();
					double height = h.getHeight();
					int ball = ((Batter) h).getBall();
					int hit = ((Batter) h).getHit();
					double hitavg = ((Batter) h).getHitavg();
					
					
					la1.setText(age + "");
					la2.setText(height + "");
					la3.setText(ball + "");
					la4.setText(hit + "");
					la5.setText(hitavg + "");
					
					l3.setText("ball");
					l4.setText("hit");
					l5.setText("hitavg");
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
