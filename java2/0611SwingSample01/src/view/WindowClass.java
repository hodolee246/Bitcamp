package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowClass extends JFrame {

	
	public WindowClass() {
		super("집가고싶다");
		
		// Frame == 기본도화지
		// Panel == 도화지 위의 도화지	// 반드시 프레임 위에서만 사용가능
		
		setLayout(new GridLayout(2, 1)); // 행, 열
		
		JLabel label = new JLabel("Label");
		add(label);	// Frame 위에 올린거임
		
		// Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(new GridLayout(1, 2));
		add(panel);	// Frame 위에 패널을 올림
		
		JLabel label1 = new JLabel("Label 1");
		panel.add(label1);
		
		JButton button = new JButton("button");
		panel.add(button);
		
		// Frame 위에 잡은 Panel 공간이 그리드레이아웃으로 1, 2 선택했다.
		// 그래서 2개 이상이 올라가면 허용치를 넘어서 표시가 안된다.
		
		
		
		
		
		setSize(640, 480);
		setLocation(0, 0);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// swing 은 이거 하나로 종료가 가능하다.
		
	}
}


