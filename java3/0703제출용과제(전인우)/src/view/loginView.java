package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import single.Singleton;

public class loginView extends JFrame implements ActionListener {

	JLabel label1, label2;

	JTextField tf1;
	
	JPasswordField tf2;

	JButton btn1, btn2;
	
	public loginView() {
		super("login");
		
		
		setLayout(null);
		

		label1 = new JLabel("ID");
		label1.setBounds(50, 50, 50, 50);
		add(label1);
		
		label2 = new JLabel("PW");
		label2.setBounds(50, 120, 50, 50);
		add(label2);
		
		tf1 = new JTextField();
		tf1.setBounds(120, 50, 300, 50);
		add(tf1);
		
		tf2 = new JPasswordField();
		tf2.setBounds(120, 120, 300, 50);
		add(tf2);

		btn1 = new JButton("login");
		btn1.setBounds(25, 250, 180, 50);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new JButton("account");
		btn2.setBounds(240, 250, 180, 50);
		btn2.addActionListener(this);
		add(btn2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 490, 390);
		setVisible(true);
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Singleton s = Singleton.getInstance();
		if(btn2.equals(obj)) {
			s.actCtrl.regi();
			this.dispose();
		}
		else if(btn1.equals(obj)) {
			s.actCtrl.login(tf1.getText(), tf2.getText());
			this.dispose();
			
			
		/*	if(mem == null) {
				JOptionPane.showMessageDialog(null, "ID 혹은 PW가 일치하지 않습니다.");
				return;
			}*/
			//else {
			/*	JOptionPane.showMessageDialog(null,mem.getId() + " 님 로그인되었습니다.");
				dao.setLoginId(mem.getId());
				this.dispose();
				new bbsListView();*/
			}
		}
	}


