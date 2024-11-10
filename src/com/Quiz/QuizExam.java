package com.Quiz;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuizExam extends JFrame implements ActionListener {
	Conn c=new Conn();
	private JLabel lDate,tdate,logo;
	private JLabel totaltime;
	private JLabel ttotaltime;
	private JLabel timetaken;
	private JLabel count;
	private JPanel panel_1;
	private JLabel roll_no;
	private JLabel name;
	private JLabel totalque;
	private JLabel que_no;
	private JLabel Current_Que_No;
	private JLabel curr_Que_num;
	private JLabel lmarks;
	private JLabel tmarks;
	private JLabel troll_no;
	private JLabel tname;
	private JRadioButton ans1,ans2,ans3,ans4;
	String name1,roll;
	private JLabel lbl_Question;
	private JButton next;
	private JButton submit;
	private String answer;
	 ButtonGroup group;
	private int min=0,sec=0,marks=0;
	String id="1";
	Timer time;
	 String studentanswer="";
 public QuizExam(String rollno,String name1) {
	
	 this.name1=name1;
	 roll=rollno;
	 
		LocalDate curr=LocalDate.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String formattedDate=curr.format(format);
		
		time=new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		count.setText(String.valueOf(min)+":"+String.valueOf(sec));
				if(sec==60) {
					sec=0;
					min++;
					if(min==10) {
						time.stop();
						answerCheck();
						submit();
						
					}
				}
				sec++;
			}
		});
		time.start();
	 getContentPane().setLayout(null);
	 
	 JPanel panel = new JPanel();
	 panel.setBackground(new Color(32, 249, 119));
	 panel.setBounds(10, 10, 1526, 87);
	 getContentPane().add(panel);
	 panel.setLayout(null);
	 
	 lDate = new JLabel("Date :");
		lDate.setFont(new Font("Courier New", Font.BOLD, 20));
		lDate.setBounds(468, 37, 98, 31);
		panel.add(lDate);

		tdate = new JLabel(formattedDate);
		tdate.setFont(new Font("Courier New", Font.BOLD, 20));
		tdate.setBounds(562, 37, 195, 31);
		panel.add(tdate);
	 
	  logo = new JLabel("WELCOME");
	 logo.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\index student.png"));
	 logo.setFont(new Font("Algerian", Font.BOLD, 34));
	 logo.setBounds(32, 23, 279, 54);
	 panel.add(logo);
	 
	 totaltime = new JLabel("Total Time :");
	 totaltime.setFont(new Font("Courier New", Font.BOLD, 20));
	 totaltime.setBounds(995, 10, 165, 23);
	 panel.add(totaltime);
	 
	 ttotaltime = new JLabel("10 MIN");
	 ttotaltime.setFont(new Font("Courier New", Font.BOLD, 20));
	 ttotaltime.setBounds(1142, 10, 165, 23);
	 panel.add(ttotaltime);
	 
	 timetaken = new JLabel("Time Taken :");
	 timetaken.setFont(new Font("Courier New", Font.BOLD, 20));
	 timetaken.setBounds(995, 48, 165, 23);
	 panel.add(timetaken);
	 
	 count = new JLabel("00:00");
	 count.setForeground(new Color(255, 0, 0));
	 count.setFont(new Font("Courier New", Font.BOLD, 20));
	 count.setBounds(1142, 48, 165, 23);
	 panel.add(count);
	 
	 panel_1 = new JPanel();
	 panel_1.setBackground(new Color(32, 249, 119));
	 panel_1.setBounds(10, 94, 417, 683);
	 getContentPane().add(panel_1);
	 panel_1.setLayout(null);
	 
	 roll_no = new JLabel("Roll Number :");
	 roll_no.setFont(new Font("Courier New", Font.BOLD, 24));
	 roll_no.setBounds(10, 30, 202, 30);
	 panel_1.add(roll_no);
	 
	 name = new JLabel("Name :");
	 name.setFont(new Font("Courier New", Font.BOLD, 24));
	 name.setBounds(10, 100, 99, 30);
	 panel_1.add(name);
	 
	 totalque = new JLabel("Total Questions :");
	 totalque.setFont(new Font("Courier New", Font.BOLD, 24));
	 totalque.setBounds(10, 170, 247, 30);
	 panel_1.add(totalque);
	 
	 que_no = new JLabel("10");
	 que_no.setFont(new Font("Courier New", Font.BOLD, 24));
	 que_no.setBounds(267, 170, 127, 30);
	 panel_1.add(que_no);
	 
	 Current_Que_No = new JLabel("Quetion Number :");
	 Current_Que_No.setFont(new Font("Courier New", Font.BOLD, 24));
	 Current_Que_No.setBounds(10, 240, 247, 30);
	 panel_1.add(Current_Que_No);
	 
	 curr_Que_num = new JLabel("00");
	 curr_Que_num.setFont(new Font("Courier New", Font.BOLD, 24));
	 curr_Que_num.setBounds(295, 240, 99, 30);
	 panel_1.add(curr_Que_num);
	 
	 lmarks = new JLabel("Marks :");
	 lmarks.setFont(new Font("Courier New", Font.BOLD, 24));
	 lmarks.setBounds(10, 310, 165, 30);
	 panel_1.add(lmarks);
	 
	 tmarks = new JLabel("00");
	 tmarks.setFont(new Font("Courier New", Font.BOLD, 24));
	 tmarks.setBounds(185, 310, 165, 30);
	 panel_1.add(tmarks);
	 
	 troll_no = new JLabel(roll);
	 troll_no.setFont(new Font("Courier New", Font.BOLD, 24));
	 troll_no.setBounds(242, 30, 165, 30);
	 panel_1.add(troll_no);
	 
	 tname = new JLabel(name1);
	 tname.setFont(new Font("Courier New", Font.BOLD, 20));
	 tname.setBounds(145, 100, 219, 30);
	 panel_1.add(tname);
	 
	 lbl_Question = new JLabel("Question");
	 lbl_Question.setFont(new Font("Monospaced", Font.BOLD, 20));
	 lbl_Question.setBounds(488, 155, 1027, 98);
	 getContentPane().add(lbl_Question);
	 
	 ans1 = new JRadioButton("Answer1");
	 ans1.setBackground(new Color(255, 255, 66));
	 ans1.setFont(new Font("Monospaced", Font.BOLD, 20));
	 ans1.setBounds(488, 300, 1027, 30);
	 ans1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(ans1.isSelected()) {
				ans2.setSelected(false);
				ans3.setSelected(false);
				ans4.setSelected(false);
			}
		}
	});
	 getContentPane().add(ans1);
	 
	 ans2 = new JRadioButton("Answer2");
	 ans2.setBackground(new Color(255, 255, 66));
	 ans2.setFont(new Font("Monospaced", Font.BOLD, 20));
	 ans2.setBounds(488, 400, 1027, 30);
	 getContentPane().add(ans2);
	 ans2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ans2.isSelected()) {
					ans1.setSelected(false);
					ans3.setSelected(false);
					ans4.setSelected(false);
				}
			}
		});
	 
	 ans3 = new JRadioButton("Answer3");
	 ans3.setBackground(new Color(255, 255, 66));
	 ans3.setFont(new Font("Monospaced", Font.BOLD, 20));
	 ans3.setBounds(488, 500, 1027, 30);
	 getContentPane().add(ans3);
	 ans3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ans3.isSelected()) {
					ans2.setSelected(false);
					ans1.setSelected(false);
					ans4.setSelected(false);
				}
			}
		});
	 
	 ans4 = new JRadioButton("Answer4");
	 ans4.setBackground(new Color(255, 255, 66));
	 ans4.setFont(new Font("Monospaced", Font.BOLD, 20));
	 ans4.setBounds(488, 600, 1027, 30);
	 getContentPane().add(ans4);
	 ans4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ans4.isSelected()) {
					ans2.setSelected(false);
					ans3.setSelected(false);
					ans1.setSelected(false);
				}
			}
		});
	 
	  group=new ButtonGroup();
	 group.add(ans1);group.add(ans2);group.add(ans3);group.add(ans4);
	 
	 next = new JButton("Next");
	 next.setBackground(new Color(128, 255, 255));
	 next.setFont(new Font("Monospaced", Font.BOLD, 24));
	 next.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\Next.png"));
	 next.setBounds(586, 713, 145, 43);
	 next.addActionListener(this);
	 getContentPane().add(next);
	 
	 
	 submit = new JButton("Submit");
	 submit.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\save.png"));
	 submit.setFont(new Font("Monospaced", Font.BOLD, 24));
	 submit.setBackground(new Color(255, 255, 128));
	 submit.setBounds(1043, 713, 145, 43);
	 submit.addActionListener(this);
	 getContentPane().add(submit);
	 
	 try {
	  ResultSet rs=c.stmt.executeQuery("Select * from AddQuestion where id ='"+id+"'");
	 	while(rs.next()) {
	 		curr_Que_num.setText(rs.getString("id"));
	 		ans1.setText(rs.getString("opt1"));
				ans3.setText(rs.getString("opt3"));
				ans2.setText(rs.getString("opt2"));
				ans4.setText(rs.getString("opt4"));
				answer=rs.getString("ans");
				lbl_Question.setText("Question : "+rs.getString("question"));
	 	}
	 }catch (Exception e) {
	e.printStackTrace();
	}
	 	
	 ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
		Image i2=i1.getImage().getScaledInstance(1400,774,Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l=new JLabel(i3);
		l.setBounds(400,95,1200,704);
		getContentPane().add(l);
	 
		setSize(1550, 824);
		setUndecorated(true);
		setVisible(true);
	 
 }
 
 public void answerCheck() {
	
	 if(ans1.isSelected()) {
		 studentanswer=ans1.getText();
	 }
	else if(ans2.isSelected()) {
		 studentanswer=ans2.getText();
	 }
	else if(ans3.isSelected()) {
		 studentanswer=ans3.getText();
	 }
	 else {
		 studentanswer=ans1.getText();
	 }
	 if(studentanswer.equals(answer)) {
		 marks=marks+1;
		 String marks1=String.valueOf(marks);
		 tmarks.setText(marks1);
	 }
	int qid=Integer.parseInt(id);
	qid=qid+1; //changing question number
	id=String.valueOf(qid);
	 
	//clear radio button
	ans1.setSelected(false);
	ans2.setSelected(false);
	ans3.setSelected(false);
	ans4.setSelected(false);
	 
	String lastquestion="";
	 try {
		  ResultSet rs1=c.stmt.executeQuery("Select max(id) from AddQuestion");
		 	if(rs1.next()) {
		 		lastquestion=rs1.getString(1);
		 	}
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 //last question hide next button
	 if(id.equals(lastquestion)) {
		 next.setVisible(false);
	 }
 }
 
 
 public void submit() {
	 String rollno1=roll;
		answerCheck();
	 try {
		 c.stmt.executeUpdate("update student set marks='"+marks+"'where rollno='"+rollno1+"'");
	
		 setVisible(false);
		 new ShowResult(marks);
	 }catch (Exception e) {
		e.printStackTrace();
	}
 }
 
 
 
 public void question() {
	 try {
		  ResultSet rs1=c.stmt.executeQuery("Select * from AddQuestion where id ='"+id+"'");
		 	if(rs1.next()) {
		 		curr_Que_num.setText(rs1.getString("id"));
		 		ans1.setText(rs1.getString("opt1"));
					ans3.setText(rs1.getString("opt3"));
					ans2.setText(rs1.getString("opt2"));
					ans4.setText(rs1.getString("opt4"));
					answer=rs1.getString("ans");
					lbl_Question.setText("Question : "+rs1.getString("question"));
		 	}
		 }catch (Exception e) {
		e.printStackTrace();
		}
 }
 
 
 
 
	public static void main(String[] args) {
		new QuizExam("","");
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==next) {
			
			answerCheck();//for checking the answer of current question
			question();//for changing the question
			group.clearSelection();
		}
		if(e.getSource()==submit) {
		
			time.stop();
			min=10;
//		int n=JOptionPane.showConfirmDialog(null, "Do You Really Want to Submit ?","Select", JOptionPane.YES_NO_OPTION);
//			if(n==0) {
				submit();
//			}
		}
	}
}
