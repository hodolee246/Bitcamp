package view;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WindowTest extends JFrame implements MouseListener, MouseMotionListener{

	JLabel label;
	int posX, posY;	// 마우스 좌표값으로 사용예정
	
	
	public WindowTest() {
		// 마우스 이벤트
		super("졸리고 배고프다");
		
		setLayout(null); // 굳이 사용할 이유X (배치하기 힘듬)
		
		label = new JLabel("x = y =");
		label.setBounds(50, 100, 200, 50);
		add(label);
		
		
		
		setBounds(0, 0, 600, 480);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseListener(this); // 애도 마우스 리스너가 있는 클래스(인수값)
		addMouseMotionListener(this);
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		posX = e.getX();	// 딱봐도 X좌표값을 얻어옴
		posY = e.getY();	//	X가 X라면 Y는 Y겠지
		
		label.setText("x = " + posX + " y = " + posY);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {	// 마우스를 클릭했을때 이벤트를 발생시킴
		// TODO Auto-generated method stub
	//	JOptionPane.showMessageDialog(null, "why");
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
