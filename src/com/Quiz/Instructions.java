package com.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions extends JFrame{
private JLabel heading;
private JButton save;
private JButton back;
String roll,name;
	public Instructions(String roll,String name) {
		this.roll=roll;
		this.name=name;
		getContentPane().setLayout(null);
	
		heading = new JLabel("Instructions For Exam");
		heading.setFont(new Font("Algerian", Font.BOLD, 40));
		heading.setIcon(new ImageIcon("Icons\\all questions.png"));
		heading.setBounds(59, 21, 434, 68);
		getContentPane().add(heading);
		
		 save = new JButton("Save & Next");
			save.setBackground(new Color(192, 192, 192));
			save.setFont(new Font("Tahoma", Font.BOLD, 20));
			save.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\save.png"));
			save.setBounds(383, 744, 215, 45);
			save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QuizExam(roll,name);
				}
			});
			getContentPane().add(save);
			
			
			JTextArea info = new JTextArea(
					"1.Read Each Question Carefully\n"
					+ "Before answering, make sure you read the question thoroughly to avoid mistakes.\n"
					+ "2.Choose the Correct Answer\n"
					+ "For multiple-choice questions, select the option that you believe is correct. Only one answer is correct unless\nstated otherwise.\n"
					+ "3.Time Limit\n"
					+ "You have a limited time to complete the quiz. Make sure to manage your time wisely. The timer will start as \nsoon as you begin the quiz.\n"
					+ "4.No Going Back\n"
					+ "Once you move to the next question, you won’t be able to go back and change your answer (unless you enable an\noption for review, which you can mention here)."
					+ "\n"
					+ "5.Submit Your Quiz\n"
					+ "Once you've answered all the questions, click the \"Submit\" button to finish the quiz. Your results will be \n displayed immediately after submission.\n"
				
					+ "6.Multiple Attempts\r\n"
					+ "If you’re allowed multiple attempts, you can retake the quiz to improve your score, but the questions may change \n each time.\n"
					+ "\n"
					+ "7.Technical Issues\r\n"
					+ "In case of any technical issues (such as timeouts or errors), please contact support immediately.\n"
					+ "\n"
					+ "8.Review Your Answers\n"
					+ "Some quizzes may offer a review option after you submit. Take this time to review your answers and \n learn from any mistakes.\n"
					);
			info.setFont(new Font("Monospaced", Font.BOLD, 20));
			info.setBounds(69, 99, 1365, 625);
			info.setEditable(false);
			getContentPane().add(info);
			
			back = new JButton("Back");
			back.setFont(new Font("Tahoma", Font.BOLD, 20));
			back.setBackground(Color.LIGHT_GRAY);
			back.setIcon(new ImageIcon("D:\\Kartik_Karle\\QuizApplication\\Icons\\Back.png"));
			back.setBounds(725, 744, 215, 45);
			getContentPane().add(back);
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudentHome();
				}
			});

			 ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("pages background admin.jpg"));
				Image i2=i1.getImage().getScaledInstance(1400,774,Image.SCALE_SMOOTH);
				ImageIcon i3=new ImageIcon(i2);
				JLabel l=new JLabel(i3);
				l.setBounds(-90,95,1680,704);
				getContentPane().add(l);
				
				
			
		setSize(1550, 824);
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Instructions("","");
	}
}
