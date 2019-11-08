package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class WindowTest1 extends JFrame implements ActionListener{

//	JRadioButton r1, r2, r3;
	JRadioButton radiob[] = new JRadioButton[4];
	ButtonGroup group;
	
	public WindowTest1() {
		super("JRadioButton");
		
		setLayout(null);
		
		group = new ButtonGroup();
		/*r1 = new JRadioButton("Jave");
		r1.setSelected(false);
		r1.addActionListener(this);
		
		r1.setBounds(50, 100, 100, 50);
		add(r1);
		*/
		String title[] = {"Java", "C", "Python", "Object"};
		for (int i = 0; i < radiob.length; i++) {
			radiob[i] = new JRadioButton(title[i]);
			radiob[i].setSelected(false);
			radiob[i].addActionListener(this);
			
			radiob[i].setBounds(50, 100 + (40 * i), 100, 50);
			add(radiob[i]);	// View ( 보려고 프레임에 집어넣ㄴ느거고)
			
			group.add(radiob[i]);	// Process (애는 그룹을 해놔야 하나만 찍히게 할수있고(판단))
			// 함수로 만들어서 매개변수와 리턴값을 받아서 더욱더 쉽게 만들수도있다.
		}
		
		
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*if(radiob[0].isSelected()) {
			JOptionPane.showMessageDialog(null, "Java");
		}else if(radiob[1].isSelected()) {
			JOptionPane.showMessageDialog(null, "C");
		}
		*/
		Enumeration<AbstractButton>	enums = group.getElements();
		
		while (enums.hasMoreElements()) {
// 장점 배열은 추가해야하지만 이거는 추가할 필요가없음
// 마치 배열과 Map 2개를 보는듯한 느낌??
			AbstractButton ab = enums.nextElement();
			JRadioButton rb = (JRadioButton)ab;
			if(rb.isSelected()) {
				JOptionPane.showMessageDialog(null, rb.getText());
			}
		}
	}
	
}
