package com.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentHome extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JButton save,clear,close,back;
	private JLabel name,Fname,mname,email,lDate,tdate,gender,address,heading,rollNo;
	JTextArea taddress;
	JRadioButton radiomale,radiofemale;
	public StudentHome() {
		LocalDate curr=LocalDate.now();
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
	String formattedDate=curr.format(format);
		
		
		getContentPane().setLayout(null);

		heading = new JLabel("Fill Up the Form");
		heading.setFont(new Font("Algerian", Font.BOLD, 40));
		heading.setIcon(new ImageIcon("Icons\\index student.png"));
		heading.setBounds(59, 21, 434, 68);
		add(heading);

		lDate = new JLabel("Date :");
		lDate.setFont(new Font("Courier New", Font.BOLD, 20));
		lDate.setBounds(682, 43, 98, 31);
		add(lDate);

		tdate = new JLabel(formattedDate);
		tdate.setFont(new Font("Courier New", Font.BOLD, 20));
		tdate.setBounds(779, 43, 195, 31);
		add(tdate);

	    back = new JButton("Back");
		back.setFont(new Font("Courier New", Font.BOLD, 20));
		back.setIcon(new ImageIcon("Icons\\Back.png"));
		back.setBounds(1152, 5, 114, 76);
		back.setBackground(new Color(255, 128, 0));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

	    close = new JButton("Close");
		close.setFont(new Font("Courier New", Font.BOLD, 20));
		close.setIcon(new ImageIcon("Icons\\Close.png"));
		close.setBounds(1349, 5, 159, 76);
		close.setBackground(new Color(255, 128, 128));
		close.setForeground(Color.WHITE);
		close.addActionListener(this);
		add(close);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 1550, 8);
		add(separator);

		rollNo = new JLabel("Roll Number :");
		rollNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		rollNo.setBounds(70, 140, 206, 30);
		add(rollNo);

		name = new JLabel("Name :");
		name.setFont(new Font("Tahoma", Font.BOLD, 18));
		name.setBounds(70, 200, 206, 30);
		add(name);

		Fname = new JLabel("Father Name :");
		Fname.setFont(new Font("Tahoma", Font.BOLD, 18));
		Fname.setBounds(70, 260, 206, 30);
		add(Fname);

		mname = new JLabel("Mother Name :");
		mname.setFont(new Font("Tahoma", Font.BOLD, 18));
		mname.setBounds(70, 320, 206, 30);
		add(mname);

		gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.BOLD, 18));
		gender.setBounds(70, 380, 206, 30);
		add(gender);

		email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 18));
		email.setBounds(70, 440, 206, 30);
		add(email);

		address = new JLabel("Address :");
		address.setFont(new Font("Tahoma", Font.BOLD, 18));
		address.setBounds(70, 500, 206, 30);
		add(address);

		textField = new JTextField("Enter Your Roll No...");
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(302, 140, 356, 28);
		textField.setForeground(Color.LIGHT_GRAY);
		add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("")) {
					textField.setText("Enter Your Roll No...");
					textField.setForeground(Color.LIGHT_GRAY);
				
			}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Enter Your Roll No...")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}
		});


		textField_1 = new JTextField("Enter Your Name...");
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(302, 200, 356, 28);
		add(textField_1);
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().equals("")) {
					textField_1.setText("Enter Your Name...");
					textField_1.setForeground(Color.LIGHT_GRAY);
				
			}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_1.getText().equals("Enter Your Name...")) {
					textField_1.setText("");
					textField_1.setForeground(Color.BLACK);
				}
			}
		});

		textField_2 = new JTextField("Enter Father Name...");
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(302, 260, 356, 28);
		add(textField_2);
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_2.getText().equals("")) {
					textField_2.setText("Enter Father Name...");
					textField_2.setForeground(Color.LIGHT_GRAY);
				
			}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_2.getText().equals("Enter Father Name...")) {
					textField_2.setText("");
					textField_2.setForeground(Color.BLACK);
				}
			}
		});

		textField_3 = new JTextField("Enter Mother Name...");
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(302, 320, 356, 28);
		add(textField_3);
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_3.getText().equals("")) {
					textField_3.setText("Enter Mother Name...");
					textField_3.setForeground(Color.LIGHT_GRAY);
				
			}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_3.getText().equals("Enter Mother Name...")) {
					textField_3.setText("");
					textField_3.setForeground(Color.BLACK);
				}
			}
		});

		textField_5 = new JTextField("Enter Your Email...");
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(302, 440, 356, 28);
		add(textField_5);
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_5.getText().equals("")) {
					textField_5.setText("Enter Your Email...");
					textField_5.setForeground(Color.LIGHT_GRAY);
				
			}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textField_5.getText().equals("Enter Your Email...")) {
					textField_5.setText("");
					textField_5.setForeground(Color.BLACK);
				}
			}
		});

		 taddress= new JTextArea();
		taddress.setBounds(302, 506, 505, 76);
		taddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(taddress);

		radiomale= new JRadioButton("Male");
		radiomale.setFont(new Font("Tahoma", Font.BOLD, 18));
		radiomale.setBounds(306, 388, 103, 21);
		add(radiomale);

		radiofemale = new JRadioButton("Female");
		radiofemale.setFont(new Font("Tahoma", Font.BOLD, 18));
		radiofemale.setBounds(508, 388, 103, 21);
		add(radiofemale);
		
		//If we want to select only one button at a time then we have to group it
		ButtonGroup group=new ButtonGroup();
		group.add(radiomale);
		group.add(radiofemale);

	    save = new JButton("Save & Next");
		save.setBackground(new Color(192, 192, 192));
		save.setFont(new Font("Tahoma", Font.BOLD, 20));
		save.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\save.png"));
		save.setBounds(224, 685, 215, 45);
		save.addActionListener(this);
		add(save);

	    clear = new JButton("Clear");
		clear.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\clear.png"));
		clear.setFont(new Font("Tahoma", Font.BOLD, 20));
		clear.setBackground(new Color(192, 192, 192));
		clear.setBounds(628, 685, 135, 45);
		clear.addActionListener(this);
		add(clear);

		JTextArea info = new JTextArea(
				"Examination Management System is \r\nmanaging all the activites related to \r\nexamination management right from \r\nreceipt of Enrollment Forms and\r\nExamination Forms through the \r\nprocessing of Results and \r\nCertificates and Grading Reports.");
		info.setFont(new Font("Monospaced", Font.PLAIN, 26));
		info.setBounds(834, 140, 600, 312);
		info.setEditable(false);
		add(info);

		 ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
			Image i2=i1.getImage().getScaledInstance(1400,774,Image.SCALE_SMOOTH);
			ImageIcon i3=new ImageIcon(i2);
			JLabel l=new JLabel(i3);
			l.setBounds(-90,95,1680,704);
			add(l);
			
		setSize(1550, 824);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentHome();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String rollno,name;
		if(e.getSource()==back) {
			setVisible(false);
			new index();
		}
		else if(e.getSource()==close) {
			setVisible(false);
			new index();
		}
		else if(e.getSource()==clear) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_5.setText("");
			taddress.setText("");
		}
		else if(e.getSource()==save) {
	name=textField_1.getText();
	String Fathername=textField_2.getText();
	String Mothername=textField_3.getText();
	String email=textField_5.getText();
	rollno=textField.getText();
	String Address=taddress.getText();
	String Gender="";
	if(radiomale.isSelected()) {
		Gender="Male";
	}
	if(radiofemale.isSelected()) {
		Gender="Female";
	}
			if(name.length()>0 && Fathername.length()>0 && Mothername.length()>0 && email.length()>0 && rollno.length()>0 && Address.length()>0 &&
					Gender.length()>0) {
			try {
			Conn c=new Conn();
			ResultSet rs=c.stmt.executeQuery("select * from student where rollno='"+rollno+"'");
			if(rs.next()) {
		
			}
			else {
			String query="insert into student values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=c.con.prepareStatement(query);
			ps.setString(1,rollno);
			ps.setString(2,name);
			ps.setString(3,Fathername);
			ps.setString(4,Mothername);
			ps.setString(5,Gender);
			ps.setString(6,email);
			ps.setString(7,Address);
			ps.setString(8,"");
			
		int n=	ps.executeUpdate();
		if(n>0) {
			setVisible(false);
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_5.setText("");
			taddress.setText("");
		}	
		}
			new Instructions(rollno,name);
			}catch(Exception E) {
				E.printStackTrace();
			}
			}else {
				JOptionPane.showMessageDialog(null, "Please Fill All the Details");
			}
		}
	}
}
