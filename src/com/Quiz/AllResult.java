package com.Quiz;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AllResult extends JFrame{

	public AllResult() {
		getContentPane().setLayout(null);
		
		
		JLabel heading = new JLabel("Fill Up the Form");
		heading.setFont(new Font("Algerian", Font.BOLD, 40));
		heading.setIcon(new ImageIcon("Icons\\all student result.png"));
		heading.setBounds(59, 21, 434, 68);
		getContentPane().add(heading);
		
		JLabel close = new JLabel("Close");
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
				setVisible(false);
				AdminHome.add.setEnabled(true);  AdminHome.all.setEnabled(true);	AdminHome.delete.setEnabled(true);	AdminHome.result.setEnabled(true);	AdminHome.logout.setEnabled(true);	AdminHome.exit.setEnabled(true);
				
			}
		});
		
		close.setFont(new Font("Courier New", Font.BOLD, 25));
		close.setIcon(new ImageIcon("Icons\\Close.png"));
		close.setBounds(1139, 21, 149, 60);
	    getContentPane().add(close);
		
	    JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 1400, 8);
	    getContentPane().add(separator);
	    
	    JTable table=new JTable();
		try {
			Conn con=new Conn();
			ResultSet rs=con.stmt.executeQuery("select * from student");
			//To convert data of resultset into the table
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	JScrollPane jp=new JScrollPane(table);
	jp.setBounds(40,100,1300,600);
	add(jp);
	    
		 ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
			Image i2=i1.getImage().getScaledInstance(1400,774,Image.SCALE_SMOOTH);
			ImageIcon i3=new ImageIcon(i2);
			JLabel l=new JLabel(i3);
			l.setBounds(20,0,1350,690);
			getContentPane().add(l);
		
		setLocation(65,90);
		setSize(1400,694);
		setUndecorated(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AllResult();

	}
}
