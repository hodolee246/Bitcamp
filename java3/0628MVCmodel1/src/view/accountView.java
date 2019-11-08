package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.DBConnection;
import dto.Member;
import javabean.MemberDao;

public class accountView extends JFrame implements ActionListener {

	JLabel label1, label2, label3, label4;
	JTextField tf1, tf2, tf3, tf4;
	JButton btn1, btn2;
	
	public accountView() {
		super("account");
		
		setLayout(null);
		
		label1 = new JLabel("ID");
		label1.setBounds(50, 50, 50, 50);
		add(label1);
		
		label2 = new JLabel("PW");
		label2.setBounds(50, 120, 50, 50);
		add(label2);
		
		label3 = new JLabel("Name");
		label3.setBounds(50, 190, 50, 50);
		add(label3);
		
		label4 = new JLabel("Email");
		label4.setBounds(50, 260, 50, 50);
		add(label4);
		
		tf1 = new JTextField("");
		tf1.setBounds(120, 50, 300, 50);
		add(tf1);
		
		tf2 = new JTextField("");
		tf2.setBounds(120, 120, 300, 50);
		add(tf2);
		
		tf3 = new JTextField("");
		tf3.setBounds(120, 190, 300, 50);
		add(tf3);
		
		tf4 = new JTextField("");
		tf4.setBounds(120, 260, 300, 50);
		add(tf4);
		
		btn1 = new JButton("Check");
		btn1.setBounds(440, 50, 70, 50);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new JButton("account");
		btn2.setBounds(50, 330, 460, 70);
		btn2.addActionListener(this);
		add(btn2);
		
		setBounds(0, 0, 560, 500);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(btn2.equals(obj)) {
			
			String m_id = tf1.getText();
			String m_pw = tf2.getText();
			String m_name = tf3.getText();
			String m_email = tf4.getText();
			
			MemberDao member = MemberDao.getInstance();
			boolean b = member.addMember(m_id, m_pw, m_name, m_email, 1);
			
			if(b) {
				JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
				new loginView();
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "잘못된 값이 존재합니다.");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
			}
		}
		else if(btn1.equals(obj)) {
			DBConnection.initConnection();
			
			MemberDao member = MemberDao.getInstance();
			
			String m_id = tf1.getText();
			
			
			boolean b = member.CheckId(m_id)  ;
			if(b) {
				JOptionPane.showMessageDialog(null, "사용불가능한 아이디 입니다.");
				tf1.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
			}
		}

	}

}
