package com.Quiz;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AdminLogin extends JFrame  {
	ImageIcon i1,i3;
	Conn conn=new Conn();
	public AdminLogin() {
		setLayout(null);
		
		JLabel user=new JLabel("USERNAME");
		user.setFont(new Font("Times New Roman",Font.BOLD,26));
		user.setBounds(1180,180,180,30);
		add(user);
		
		JTextField tuser=new JTextField();
		tuser.setFont(new Font("Times New Roman",Font.BOLD,22));
		tuser.setBounds(1125,240,250,30);
		add(tuser);
		
		JLabel pass=new JLabel("PASSWORD");
		pass.setFont(new Font("Times New Roman",Font.BOLD,26));
		pass.setBounds(1180,300,180,30);
		add(pass);
		
		JPasswordField tpass=new JPasswordField();
		tpass.setFont(new Font("Times New Roman",Font.BOLD,22));
		tpass.setBounds(1125,360,250,30);
		add(tpass);
	
		JButton show=new JButton("Show Password");
		show.setFont(new Font("Times New Roman",Font.BOLD,26));
		show.setBounds(1125,420,250,50);
		show.setBackground(Color.GREEN);
		show.addActionListener(new ActionListener() {
			int n=0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(n==0) {
					tpass.setEchoChar((char)0);
					show.setText("Hide Password");
					n=1;
				}
				else if(n==1) {
					JOptionPane.showMessageDialog(null, "Password already Visible");
				}
			}
		});
		add(show);
		
		JButton login=new JButton("LOGIN");
		Image i=new ImageIcon(ClassLoader.getSystemResource("login.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		login.setIcon(new ImageIcon(i));
		login.setFont(new Font("Times New Roman",Font.BOLD,26));
		login.setBounds(1060,490,160,50);
		login.setBackground(Color.YELLOW);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i,cnt=0;
				String name=tuser.getText();
				for(i=0;i<name.length();i++) {
					if(name.charAt(i)>=48 && name.charAt(i)<=57) {
					cnt++;	
					}
				}
				if(cnt!=0) {
					JOptionPane.showMessageDialog(null, "You can't enter numbers in name");
					tuser.setText("");
				}else {
				if(tuser.getText().length()>0 && tpass.getText().length()>0) {
					try {
						String user=tuser.getText();String pass=tpass.getText();
						ResultSet rs=conn.stmt.executeQuery("Select * from AdminLogin");
						if(rs.next()) {
							if(user.equals(rs.getString("username"))) {
								if(pass.equals(rs.getString("password"))) {
									setVisible(false);
									new AdminHome();
								}else {
									JOptionPane.showMessageDialog(null, "Incorrect password");
									tpass.setText("");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Incorrect username");
								tuser.setText("");
							}
							
						}
					}catch(Exception E) {
						E.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please fill both fields");
				}
				}
			}
		});
		add(login);
		
		JButton back=new JButton("BACK");
		i=new ImageIcon(ClassLoader.getSystemResource("b.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		back.setIcon(new ImageIcon(i));
		back.setFont(new Font("Times New Roman",Font.BOLD,26));
		back.setBounds(1250,490,160,50);
		back.setBackground(Color.RED);
		back.setForeground(Color.WHITE);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new index();
			}
		});
		add(back);
		
		i1=new ImageIcon(ClassLoader.getSystemResource("login Background.PNG"));
		Image i2=i1.getImage().getScaledInstance(1550,824,Image.SCALE_SMOOTH);
		i3=new ImageIcon(i2);
		JLabel l=new JLabel(i3);
		l.setBounds(0,0,1550,824);
		add(l);
		
	//	setUndecorated(true);
		setSize(1550,824);
		setVisible(true);
	}
	public static void main(String[] args) {
	new AdminLogin();
	}

}
