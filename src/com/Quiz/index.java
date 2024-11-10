package com.Quiz;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class index extends JFrame{
	ImageIcon i1,i3;
public index(){
	setLayout(null);
	
	JButton exit = new JButton("Exit");
	Image i=new ImageIcon(ClassLoader.getSystemResource("c.png")).getImage().getScaledInstance(50, 55, Image.SCALE_SMOOTH);
	exit.setIcon(new ImageIcon(i));
	exit.setBackground(Color.RED);
	exit.setForeground(Color.WHITE);
	exit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
	exit.setBounds(1387, 43, 133, 60);
	exit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	add(exit);
	
	JButton admin = new JButton("Admin");
	admin.setBackground(new Color(50,220,250));
	i=new ImageIcon(ClassLoader.getSystemResource("index admin.png")).getImage().getScaledInstance(30, 40, Image.SCALE_SMOOTH);

	admin.setIcon(new ImageIcon(i));
	admin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
	admin.setBounds(1220, 43, 133, 60);
	admin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new AdminLogin();
		}
	} );
	add(admin);
	
	JButton student = new JButton("Student");
	i=new ImageIcon(ClassLoader.getSystemResource("index student.png")).getImage().getScaledInstance(35, 48, Image.SCALE_SMOOTH);
	student.setIcon(new ImageIcon(i));
	student.setBackground(new Color(50,220,250));
	student.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
	student.setBounds(1039, 43, 133, 60);
	student.addActionListener(new ActionListener() {
	@Override 
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new StudentHome();
	}
	});
	add(student);
	
	i1=new ImageIcon(ClassLoader.getSystemResource("index background.png"));
	Image i2=i1.getImage().getScaledInstance(1550,824,Image.SCALE_SMOOTH);
	i3=new ImageIcon(i2);
	JLabel l=new JLabel(i3);
	l.setBounds(0,0,1550,824);
	add(l);
	
	setUndecorated(true);
	setSize(1550,824);
	setVisible(true);
	
}
	public static void main(String[] args) {
		new index();
	}
}
