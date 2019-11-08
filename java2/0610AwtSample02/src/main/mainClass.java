package main;

import view.Windowtest;

public class mainClass {
	public static void main(String[] args) {
		/*
			기본 component :
				AWT
					Button, Label, Choice, CheckBox, List
					RadioButton, ScrollBar
					
				Swing - AWT를 경량화 시켜 놓은 Library
					JButton, JLabel, ... AWT 앞에 J가 붙어있음
			컨테이너 component : 
				Frame, Panel, Container, Window
				Dialog, FileDialog
				
			Text Component :
				TextField, TextArea, TextComponent
				
				** AWT(Button, Label, Choice, CheckBox, RadioButton, ScrollBar)
				** 컨테이너 (Frame, Panel)
				** text(TextField, TextArea)
				  이렇게 3개 중요해서 공부할거
		
		*/
		
		new Windowtest();
	}

}
