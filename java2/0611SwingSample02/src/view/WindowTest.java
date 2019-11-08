package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest extends JFrame {
	
	JTextField textField;
	JTextArea textArea;
	JButton btn1, btn2;
	
	
	public WindowTest() {
		super("졸리다.");
		
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true); // 끝 라인 경계선이 있는걸 사용할껀지 없는걸 사용할껀지(테두리)
		
		JScrollPane scrPane = new JScrollPane(textArea);
		scrPane.setPreferredSize(new Dimension(400, 300));
		panel.add(scrPane); // 새로운 패널을 만들어서 거기에 집어넣음
		
		JPanel botpan = new JPanel();
		
		textField = new JTextField(20);	// integer 값을 집어넣으면 textfield 공간이된다. 문자를 쓰면 안에 쓰여있는 문자가 되고
		
		btn1 = new JButton("Back add");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals("")) {
				return;
			}
			
				
				//	JOptionPane.showMessageDialog(null, "btn1");
				String str = textField.getText();
				textArea.append("\n" + str);
			}
		});
		
		btn2 = new JButton("Front add");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(null, "btn2");
				try {
					textArea.insert(textField.getText() + "\n", // insert(가져올 텍스트, 텍스트에어리어.겟라인스타트옵셋(몇번째 라인부터 넣을지)
							textArea.getLineStartOffset(0));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		// Layout
		
		Container contentPane = getContentPane();
		
		contentPane.add(panel, BorderLayout.CENTER);	// 추가하고 위치를 어디로할지 설정해줄수있다.
		contentPane.add(botpan, BorderLayout.SOUTH);
		
		// frame
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
