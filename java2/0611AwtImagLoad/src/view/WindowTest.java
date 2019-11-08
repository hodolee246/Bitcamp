package view;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {

	Image jpgImg = null;
	Image pngImg = null;
	
	
	public WindowTest() {
		setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
	//	jpgImg = tk.getImage("e:\\tmp\\pig.png");	// 절대경로
		pngImg = tk.getImage("bird.png");	// 상대경로
		jpgImg = tk.getImage("\\\\192.168.0.66\\공유\\girl.jpg");
		
				
		setBounds(100, 100, 500, 500);
		setVisible(true);
		addWindowListener(this);
	}
	/*
	  jpg, gif, png, bmp, tga, tiff
	  
	  압출률 제일 좋은게 JPG 
	  gif 는 jpg의 묶음이라 보면된다.
	  bmp는 압축이안되고
	  Alpha 할떄 좋은게 tga
	  
	  jpg 는 웹에서 많이 사용한다 가벼워서 == 퀄리티 제일 낮음
	  절약 == 빈곤
	  
	  
	 */
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		int width = jpgImg.getWidth(this);
		int height = jpgImg.getHeight(this);
		
		// 화면 중앙에 출력 
		g.drawImage(jpgImg,
				(getWidth()-width)/2,			// 중앙좌표
				 (getHeight()-height)/2,		// 중앙좌표
				 this);
		
		// 이미지 위에 이미지를 뿌리는경우
		g.drawImage(pngImg, 200, 200, this);
		
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

}
