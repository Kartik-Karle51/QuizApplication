package com.Quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewAllQuestion extends JFrame {

	private JTextField ques,opt1,opt2,opt3,opt4,ans;
	Conn c=new Conn();
    int id;
    
	public ViewAllQuestion() {
		 setLayout(null);
		    
		   
			JLabel heading = new JLabel("View All Question");
			heading.setFont(new Font("Courier New", Font.BOLD, 25));
			heading.setIcon(new ImageIcon("Icons\\all questions.png"));
			heading.setBounds(59, 21, 374, 68);
		    add(heading);
			
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
					AdminHome.update.setEnabled(true);  AdminHome.add.setEnabled(true);	AdminHome.delete.setEnabled(true);	AdminHome.result.setEnabled(true);	AdminHome.logout.setEnabled(true);	AdminHome.exit.setEnabled(true);
					
				}
			});
			close.setFont(new Font("Courier New", Font.BOLD, 25));
			close.setIcon(new ImageIcon("Icons\\Close.png"));
			close.setBounds(1139, 21, 149, 60);
		    add(close);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 90, 1400, 8);
		    add(separator);
			
		    
		    JTable table=new JTable();
		   
		    try {
		    	Conn c=new Conn();
		    	ResultSet rs=c.stmt.executeQuery("Select * from AddQuestion");
		    	table.setModel(DbUtils.resultSetToTableModel(rs));
		    }catch(Exception E) {
		    	E.printStackTrace();
		    }
		    JScrollPane jp=new JScrollPane(table);
		    jp.setBounds(30,100,1330,530);
		    add(jp);
			
		    ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
			Image i2=i1.getImage().getScaledInstance(1400,774,Image.SCALE_SMOOTH);
			ImageIcon i3=new ImageIcon(i2);
			JLabel l=new JLabel(i3);
			l.setBounds(0,0,1380,660);
			add(l);
		    
			setLocation(65,90);
			setSize(1400,694);
			setUndecorated(true);
			setVisible(true);

	}

	public static void main(String[] args) {
		new ViewAllQuestion();
	}

	

}
