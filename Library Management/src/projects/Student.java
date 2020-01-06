package projects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import utilities.MyDatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import projects.IssueBook;
public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student() {
		 Connection conn = MyDatabaseConnection.getConnection();
		setTitle("Student Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentDetails.setBounds(180, 24, 117, 24);
		contentPane.add(lblStudentDetails);
		
		JLabel lblRollNo = new JLabel("Roll no");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRollNo.setBounds(60, 75, 65, 24);
		contentPane.add(lblRollNo);
		
		textField = new JTextField();
		textField.setBounds(147, 79, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(60, 137, 57, 24);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 141, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEssue = new JButton("Issue");
		btnEssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				EssueBook obj = new EssueBook();
				Date date = new Date();
				long num1 = date.getTime();
				java.sql.Date date1 = new java.sql.Date(num1);
				System.out.println("a");
				String input1=IssueBook.input;
				System.out.println(input1);
				int num = Integer.parseInt(input1);
				
				String roll = textField.getText();
				String name= textField_1.getText();
				try {

					String qr1 = "select * from addbook where book_id = ?";
					PreparedStatement ps = conn.prepareStatement(qr1);
					ps.setInt(1, num);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Integer a = rs.getInt(1);
						String data = a.toString();
						String data2 = rs.getString(2);
						String author = rs.getString(3);

						String qr2 = "INSERT INTO issued" + "(book_id, book_name,author,Issued_date,Student_roll , Student_name) VALUES"
								+ "(?,?,?,?,?,?)";
						PreparedStatement ps1 = conn.prepareStatement(qr2);
						ps1.setInt(1, a);
						ps1.setString(2, data2);
						ps1.setString(3, author);
						ps1.setDate(4, date1);
						ps1.setString(5, roll);
						ps1.setString(6, name);
						ps1.executeUpdate();
						
						

					}

					
					
					String qr3 = "delete from addbook where book_id = ?";
					PreparedStatement ps2 = conn.prepareStatement(qr3);
					ps2.setInt(1, num);
					ps2.executeUpdate();
					
					ClassNameHere.infoBox("Book has been Issued", "TITLE BAR MESSAGE");
					setVisible(false);
					dispose();
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

				
				
			}
		});
		btnEssue.setBounds(135, 202, 89, 23);
		contentPane.add(btnEssue);
	}
}
