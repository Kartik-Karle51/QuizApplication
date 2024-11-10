package com.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ShowResult extends JFrame{
	static int marks;

public ShowResult(int marks) {
	this.marks=marks;
	
	getContentPane().setLayout(null);
	
	JLabel Result = new JLabel("Congratulations...You Got "+marks+" Marks");
	Result.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 52));
	Result.setBounds(306, 204, 887, 222);
	getContentPane().add(Result);
	
	JButton back = new JButton("Exit");
	 back.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\Close.png"));
	 back.setFont(new Font("Monospaced", Font.BOLD, 24));
	 back.setBackground(new Color(255, 128, 255));
	 back.setBounds(616, 596, 277, 79);
	 back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new StudentHome();
		}
	});
	 getContentPane().add(back);
	 
	 ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
		Image i2=i1.getImage().getScaledInstance(1550,824,Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l=new JLabel(i3);
		l.setBounds(-70,0,1680,824);
		getContentPane().add(l);
		
		
	
	setSize(1550, 824);
	setUndecorated(true);
	setVisible(true);
}
	public static void main(String[] args) {
	new ShowResult(0);
	}
}
