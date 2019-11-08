package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.BbsDto;
import single.Singleton;



public class writeView extends JFrame implements ActionListener {

	//3211
	
	private JLabel label1, label2, label3;
	private JTextField tf1, tf2;
	private JTextArea ta1;
	private JButton btn1;
	
	public writeView() {
		super("WriteView");
		
		setLayout(null);
		
		label1 = new JLabel("ID");
		label1.setBounds(50, 50, 50, 50);
		add(label1);
		
		label2 = new JLabel("Title");
		label2.setBounds(50, 120, 50, 50);
		add(label2);
		
		label3 = new JLabel("Content");
		label3.setBounds(50, 190, 50, 50);
		add(label3);
	
		Singleton s = Singleton.getInstance();
		
		tf1 = new JTextField(s.getLoginid());
		tf1.setBounds(120, 50, 200, 30);
		tf1.setEnabled(false);
		add(tf1);
		
		tf2 = new JTextField();
		tf2.setBounds(120, 120, 200, 30);
		add(tf2);
		
		ta1 = new JTextArea();
		ta1.setBounds(50, 250, 270, 150);
		add(ta1);
		
		btn1 = new JButton("Add Content");
		btn1.setBounds(50, 430, 90, 30);
		btn1.addActionListener(this);
		add(btn1);
		
		
		setBounds(0, 0, 530, 490);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Singleton s = Singleton.getInstance();
		if(btn1.equals(obj)) {
			s.bbsCtrl.addContent(tf1.getText(), tf2.getText(), ta1.getText(), 0, 0);
		
		}

	}

}
