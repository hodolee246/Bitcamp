package view;

import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
// 값이 수시로 바뀔때에는 아이템 리스너를 사용한다.
public class WindowTest extends JFrame implements ItemListener {

	List list;
	Checkbox check;
	
	Label label;
	TextField textField;
	
	double toRadian;	// * 3.141592 / 180.0
	
	public WindowTest() {
		super("아메리카노");
		
		
		textField = new TextField();
		textField.setText("insert to here");
		
		GridLayout gridbag = new GridLayout();
//		GridBagConstraints c = new GridBagConstraints();
		
		toRadian = 1.0;
		
		label = new Label("1");
		
		// list
		
		list = new List();
		list.add("root");
		list.add("sin");
		list.add("cos");
		list.add("tan");
		list.addItemListener(this); // 이것도 아이템리스너가 있는 클래스를 입력
		add(list);
		
		//	checkbox
		
		check = new Checkbox("Degree");
		check.setState(false); // 처음부터 체크를 해둘지 말지 트루올 펄스
		check.addItemListener(this);
		add(check);
		
		
		add(textField);
		
		setBounds(0, 0, 600, 480);
		setLayout(gridbag);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		JOptionPane.showMessageDialog(null, "why always me");
		
		Object obj = e.getSource(); // getsource return 값은 obj로 넘어온다.
		
		if(obj == list) {
		//	JOptionPane.showMessageDialog(null, "List");
			int itemNum = list.getSelectedIndex();	// list의 indexnumber
			
			
			double value = Double.parseDouble(textField.getText());
			double result = 0.0;
			
			switch(itemNum) {
			case 0:	
				result = Math.sqrt(value);
				break;
			case 1:
				result = Math.sin(value);
				break;
			case 2:
				result = Math.cos(value);
				break;
			case 3:
				result = Math.tan(value);
				break;
			}
			textField.setText(result + "");
		}
		else if(obj == check) {
		//	JOptionPane.showMessageDialog(null, "CheckBox");
			if(check.getState() == true) {
				double d = Double.parseDouble(textField.getText());
				d = d * Math.PI / 180.0;
				textField.setText(d + "");
			}
			else {
				textField.setText("0");
			}
		}
		
		
		
	}
}





