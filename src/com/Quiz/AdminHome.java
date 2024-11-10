package com.Quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminHome extends JFrame implements ActionListener {

	
	static JMenuItem add,update,all,delete,result,exit,logout;
	static int open=0;
	
	
	public AdminHome() {
		setEnabled(true);
		getContentPane().setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("index background.png"));
		Image i2=i1.getImage().getScaledInstance(1550,824,Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l=new JLabel(i3);
		l.setBounds(0,0,1550,824);
		add(l);
		
		JMenuBar menuBar = new JMenuBar();
//		menuBar.setBounds(5, 10, 155, 50);

		
		add = new JMenuItem("Add New Question");
		add.setFont(new Font("Arial",Font.BOLD,17));
		Image i=new ImageIcon(ClassLoader.getSystemResource("add new question.png")).getImage().getScaledInstance(35, 48, Image.SCALE_SMOOTH);
		add.setIcon(new ImageIcon(i));
		add.setBorder(new EmptyBorder(5,0,5,40));
		add.addActionListener(this);
		menuBar.add(add);
		
		update = new JMenuItem("Update Question");
		update.setFont(new Font("Arial",Font.BOLD,17));
		i=new ImageIcon(ClassLoader.getSystemResource("Update Question.png")).getImage().getScaledInstance(35, 48, Image.SCALE_SMOOTH);
		update.setIcon(new ImageIcon(i));
		update.setBorder(new EmptyBorder(5,20,5,30));
		update.addActionListener(this);
		menuBar.add(update);
		
		all= new JMenuItem("All Questions");
		i=new ImageIcon(ClassLoader.getSystemResource("all questions.png")).getImage().getScaledInstance(40, 48, Image.SCALE_SMOOTH);
		all.setIcon(new ImageIcon(i));
		all.setFont(new Font("Arial",Font.BOLD,17));
		all.setBorder(new EmptyBorder(5,25,5,30));
		all.addActionListener(this);
		menuBar.add(all);
		
		delete = new JMenuItem("Delete Question");
		i=new ImageIcon(ClassLoader.getSystemResource("delete Question.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		delete.setIcon(new ImageIcon(i));
		delete.setFont(new Font("Arial",Font.BOLD,17));
		delete.setBorder(new EmptyBorder(5,20,5,30));
		delete.addActionListener(this);
		menuBar.add(delete);
		
		result = new JMenuItem("All Results");
		i=new ImageIcon(ClassLoader.getSystemResource("all student result.png")).getImage().getScaledInstance(45, 48, Image.SCALE_SMOOTH);
		result.setIcon(new ImageIcon(i));
		result.setFont(new Font("Arial",Font.BOLD,17));
		result.addActionListener(this);
		result.setBorder(new EmptyBorder(5,42,5,30));
		menuBar.add(result);
		
		logout = new JMenuItem("LogOut");
		i=new ImageIcon(ClassLoader.getSystemResource("Logout.png")).getImage().getScaledInstance(35, 48, Image.SCALE_SMOOTH);
		logout.setIcon(new ImageIcon(i));
		logout.setFont(new Font("Arial",Font.BOLD,17));
		logout.setBorder(new EmptyBorder(5,0,5,30));
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "Do you Really want to Logout?","select",JOptionPane.YES_OPTION);
				if(n==0) {
					setVisible(false);
					new AdminLogin();
				}
			}
		});
		menuBar.add(logout);
		
		exit = new JMenuItem("Exit");
		i=new ImageIcon(ClassLoader.getSystemResource("Close.png")).getImage().getScaledInstance(35, 48, Image.SCALE_SMOOTH);
		exit.setIcon(new ImageIcon(i));
		exit.setFont(new Font("Arial",Font.BOLD,17));
		exit.setBorder(new EmptyBorder(5,0,5,30));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			int n=JOptionPane.showConfirmDialog(null, "Do you Really want to exit?","select",JOptionPane.YES_NO_CANCEL_OPTION);
			if(n==0) {
				setVisible(false);
				new index();
				
			}
			
			}
		});
		menuBar.add(exit);
		
		setJMenuBar(menuBar);
		setSize(1550,824);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
				new AddNewQuestion();
			update.setEnabled(false);	all.setEnabled(false);	delete.setEnabled(false);	result.setEnabled(false);	logout.setEnabled(false);	exit.setEnabled(false);	
			
		}else if(e.getSource()==update) {
			new UpdateQuestion();
			add.setEnabled(false);	all.setEnabled(false);	delete.setEnabled(false);	result.setEnabled(false);	logout.setEnabled(false);	exit.setEnabled(false);	
		}else if(e.getSource()==all) {
			new ViewAllQuestion();
			update.setEnabled(false);	add.setEnabled(false);	delete.setEnabled(false);	result.setEnabled(false);	logout.setEnabled(false);	exit.setEnabled(false);
		}else if(e.getSource()==delete) {
			new DeleteQuestion();
			update.setEnabled(false);	all.setEnabled(false);	add.setEnabled(false);	result.setEnabled(false);	logout.setEnabled(false);	exit.setEnabled(false);
		}else if(e.getSource()==result) {
			new AllResult();
			update.setEnabled(false);	all.setEnabled(false);	delete.setEnabled(false);	add.setEnabled(false);	logout.setEnabled(false);	exit.setEnabled(false);
		}
		
	}
	
	public static void main(String[] args) {
		new AdminHome();
	}
	
}
