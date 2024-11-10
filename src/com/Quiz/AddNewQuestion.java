package com.Quiz;

import java.awt.*;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.awt.event.*;

public class AddNewQuestion extends JFrame{
	private JTextField ques,opt1,opt2,opt3,opt4,ans;
	Conn c=new Conn();
    int id;
    
	public AddNewQuestion() {
	    setLayout(null);
	    
		JLabel heading = new JLabel("Add New Question");
		heading.setFont(new Font("Courier New", Font.BOLD, 25));
		heading.setIcon(new ImageIcon("Icons\\add new question.png"));
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
				AdminHome.update.setEnabled(true);  AdminHome.all.setEnabled(true);	AdminHome.delete.setEnabled(true);	AdminHome.result.setEnabled(true);	AdminHome.logout.setEnabled(true);	AdminHome.exit.setEnabled(true);	
				
			}
		});
		close.setFont(new Font("Courier New", Font.BOLD, 25));
		close.setIcon(new ImageIcon("Icons\\Close.png"));
		close.setBounds(1139, 21, 149, 60);
	    add(close);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 1400, 8);
	    add(separator);
		
		JLabel QId = new JLabel(" Question Id :");
		QId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		QId.setBounds(79, 112, 121, 28);
	    add(QId);
		
		JLabel lid = new JLabel(""+getId());
		lid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lid.setBounds(255, 112, 69, 28);
	    add(lid);
		
		JLabel lque = new JLabel(" Question :");
		lque.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lque.setBounds(79, 182, 121, 28);
	    add(lque);
	    
	    ques = new JTextField();
	    ques.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ques.setBounds(223, 182, 1121, 34);
	    add(ques);
		ques.setColumns(10);
		
		
		JLabel lop1 = new JLabel("Option 1 :");
		lop1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lop1.setBounds(79, 252, 121, 28);
	    add(lop1);
	    
	    opt1 = new JTextField();
	    opt1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		opt1.setBounds(223, 252, 664, 34);
	    add(opt1);
	    
	    JLabel lopt2 = new JLabel("Option 2 :");
		lopt2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lopt2.setBounds(79, 322,121, 28);
	    add(lopt2);
	    
	    opt2 = new JTextField();
	    opt2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		opt2.setBounds(223, 322, 664, 34);
	    add(opt2);
	    
		JLabel lopt3 = new JLabel("Option 3 :");
		lopt3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lopt3.setBounds(79, 392, 121, 28);
	    add(lopt3);
	    
	    opt3 = new JTextField();
	    opt3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		opt3.setBounds(223, 392, 664, 34);
	    add(opt3);
		
		JLabel lopt4 = new JLabel("Option 4 :");
		lopt4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lopt4.setBounds(79,462, 121, 28);
	    add(lopt4);
	    
	    opt4 = new JTextField();
	    opt4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		opt4.setBounds(223,462, 664, 34);
	    add(opt4);
		
		JLabel lans = new JLabel("Answer :");
		lans.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lans.setBounds(79, 532, 121, 28);
	    add(lans);
		
		ans = new JTextField();
		ans.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ans.setBounds(223, 532, 664, 34);
	    add(ans);
		
		JButton add = new JButton("SAVE");
		add.setBackground(new Color(5,230,235));
		add.setForeground(Color.BLACK);
		add.setIcon(new ImageIcon("Icons\\save.png"));
		add.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add.setBounds(255, 592, 156, 43);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(ques.getText().length()>0 && opt1.getText().length()>0 && opt2.getText().length()>0 && opt3.getText().length()>0 && opt4.getText().length()>0 && ans.getText().length()>0) {	
				try {
								
					PreparedStatement ps=c.con.prepareStatement("insert into AddQuestion values(?,?,?,?,?,?,?)");
					ps.setString(1, lid.getText());
					ps.setString(2, ques.getText());
					ps.setString(3, opt1.getText());
					ps.setString(4, opt2.getText());
					ps.setString(5, opt3.getText());
					ps.setString(6, opt4.getText());
					ps.setString(7, ans.getText());
					int a=ps.executeUpdate();
					if(a>0) {
						JOptionPane.showMessageDialog(null,"Question Added Successfully");
						opt1.setText("");
						opt2.setText("");
						opt3.setText("");
						opt4.setText("");
						ans.setText("");
						ques.setText("");
						lid.setText(""+getId());
					}
					else {
						JOptionPane.showMessageDialog(null,"Transaction unsuccessfull");
					}
					
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill all fields");
			}
			}
		});;
	    add(add);
		
		JButton clear = new JButton("CLEAR");
		clear.setForeground(Color.BLACK);
		clear.setIcon(new ImageIcon("Icons\\clear.png"));
		clear.setBackground(new Color(5,230,235));		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opt1.setText("");
				opt2.setText("");
				opt3.setText("");
				opt4.setText("");
				ans.setText("");
				ques.setText("");
			}
		});
		clear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		clear.setBounds(549, 592, 156, 43);
	    add(clear);
		
	    ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
		Image i2=i1.getImage().getScaledInstance(1400,774,Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l=new JLabel(i3);
		l.setBounds(20,97,1350,550);
		add(l);
	    
		setLocation(65,90);
		setSize(1400,694);
		setUndecorated(true);
		setVisible(true);
	}
	public int getId() {
	try {
		ResultSet rs=c.stmt.executeQuery("Select Count(id) from AddQuestion");
		if(rs.next()) {
			id=rs.getInt(1);
			id=id+1;
		}
		else {
			id=0;
		}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	return id;
	}
	public static void main(String[] args) {
		new AddNewQuestion();
	}
}