package view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.coffeeDto;
import single.Singleton;

public class coffeeMenuView extends JFrame implements ActionListener, ItemListener {

	JComboBox coffee, cups;
	JLabel label;
	JRadioButton rsize[] = new JRadioButton[3];
	JRadioButton syrup[] = new JRadioButton[3];
	ButtonGroup size_group, syrup_group;
	JPanel size_panel, syrup_panel, check_panel;

	String size_name[] = { "short", "Tall", "Grande" };
	String syrup_name[] = { "바닐라", "카라멜", "헤이즐넛" };

	ButtonGroup bg = new ButtonGroup();

	JButton menuBtn, OrderBtn;
	JCheckBox adshot, adcream;

	String coffeemenu[] = { "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페모카", "카라멜 라떼", "카페 라떼", "카푸치노",
			"아메리카노", "오늘의 커피" };

	String cup[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

	public coffeeMenuView() {
		super("Coffee order view");

		setLayout(null);

		// 라디오(컵크기)
		size_group = new ButtonGroup();
		size_panel = new JPanel();
		for (int i = 0; i < rsize.length; i++) {
			rsize[i] = new JRadioButton(size_name[i]);
			size_group.add(rsize[i]);
			size_panel.add(rsize[i]);
			rsize[i].addActionListener(this);
		}
		rsize[0].setSelected(true);
		size_panel.setBounds(100, 150, 100, 150);
		size_panel.setLayout(new GridLayout(3, 1));
		add(size_panel);
		// 라디오(어떤시럽)
		syrup_group = new ButtonGroup();
		syrup_panel = new JPanel();
		for (int i = 0; i < syrup.length; i++) {
			syrup[i] = new JRadioButton(syrup_name[i]);
			syrup_group.add(syrup[i]);
			syrup_panel.add(syrup[i]);
			syrup[i].addActionListener(this);
		}
		syrup[0].setSelected(true);
		syrup_panel.setBounds(250, 150, 100, 150);
		syrup_panel.setLayout(new GridLayout(3, 1));
		add(syrup_panel);

		// 체크박스
		check_panel = new JPanel();
		adshot = new JCheckBox("샷추가");
		adcream = new JCheckBox("휘핑크림");
		check_panel.add(adshot);
		check_panel.add(adcream);

		
		
		check_panel.setBounds(400, 150, 100, 150);
		check_panel.setLayout(new GridLayout(2, 1));
		add(check_panel);

		// 선택할 커피 콤보박스
		coffee = new JComboBox(coffeemenu);
		coffee.setBounds(220, 70, 200, 30);
		add(coffee);

		cups = new JComboBox(cup);
		cups.setBounds(200, 400, 65, 30);
		add(cups);
		
		label = new JLabel("잔");
		label.setBounds(270, 400, 30, 30);
		add(label);
		
		menuBtn = new JButton("Menu");
		menuBtn.setBounds(540, 10, 80, 20);
		menuBtn.addActionListener(this);
		add(menuBtn);

		OrderBtn = new JButton("Order");
		OrderBtn.setBounds(400, 400, 80, 30);
		OrderBtn.addActionListener(this);
		add(OrderBtn);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 640, 480);
		setVisible(true);

	}
	public void gettrue() {
		menuBtn.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Singleton s = Singleton.getInstance();
		coffeeDto dto = null;
		String v_size = "short";
		String v_syrup = "바닐라";
		String v_shot = null;
		String v_cream = null;
		int money = 0;
		
		if(rsize[0].isSelected()) {
			v_size = "short";
		}else if(rsize[1].isSelected()) {
			v_size = "Tall";
		}else if(rsize[2].isSelected()) {
			v_size = "Grande";
		}
		
		if(syrup[0].isSelected()) {
			v_syrup = "바닐라";
		}else if(syrup[1].isSelected()) {
			v_syrup = "카라멜";
		}else if(syrup[2].isSelected()) {
			v_syrup = "헤이즐넛";
		}
		
		v_shot = adshot.isSelected()?"O":"X";
		v_cream = adcream.isSelected()?"O":"X";
		
		
		String v_name = (String)coffee.getSelectedItem();
		String v_cup = (String)cups.getSelectedItem();
		int v_cups = Integer.parseInt(v_cup);
		
		// 새로운 테이블 생성후 커피 이름을 대입하여 가격을 출력  출력된 가격에 커피잔수 곱해서 리턴
		money = s.coffeeCtrl.howMuch(v_name, v_size, v_cups);
		
		if (menuBtn.equals(obj)) {
			menuBtn.setEnabled(false);
			s.coffeeCtrl.moneyview();
			this.dispose();
			
		}else if(OrderBtn.equals(obj)) {
			
			
			// dao 에 insert
			boolean b = s.coffeeCtrl.addCoffee(v_name, v_size, v_syrup, v_shot, v_cream, v_cups, money);
			
			if(b) {
				JOptionPane.showMessageDialog(null, "주문 되었습니다.");
				s.coffeeCtrl.orderview();
				this.dispose();
			} else {	// 있을수는 없지만 만약을
				JOptionPane.showMessageDialog(null, "다시 주문해주세요.");
				s.actCtrl.coffeemenu();
			}
			
		}
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

}
