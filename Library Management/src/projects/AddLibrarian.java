package projects;
import dao.*;
import pojos.Librarian;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLibrarian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibrarian frame = new AddLibrarian();
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
	public AddLibrarian() {
		setTitle("Librarian Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterLibrarianDetails = new JLabel("Enter Librarian Details");
		lblEnterLibrarianDetails.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblEnterLibrarianDetails.setBounds(128, 11, 184, 40);
		contentPane.add(lblEnterLibrarianDetails);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(50, 55, 76, 28);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(159, 61, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(50, 96, 76, 20);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 97, 153, 22);
		contentPane.add(passwordField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textField.getText();
				char pass1[] = passwordField.getPassword();
				String contact = textField_1.getText();
				String address = textField_2.getText();
				String pass = String.valueOf(pass1);
				
				if (textField.getText().equals("") || pass.equals("") || textField_1.getText().equals("")
						|| textField_2.getText().equals("")) {
					ClassNameHere.infoBox("Please Enter All Details", "");
					setVisible(false);
					dispose();
					AdminRegistration frame = new AdminRegistration();
					frame.setVisible(true);

				}
				else {
				 Librarian name = new Librarian(user,pass,contact,address);
				  LibrarianDao  LibrarianDao = new  LibrarianDao();
				  LibrarianDao.createLibrarian(name);
				
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(131, 215, 119, 23);
		contentPane.add(btnAdd);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContact.setBounds(50, 130, 68, 28);
		contentPane.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(50, 172, 88, 28);
		contentPane.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 136, 153, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 178, 153, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				Admin lb = new Admin();
				lb.setVisible(true);
			}
		});
		btnBack.setBounds(301, 204, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Library window = new Library();
				window.frame.setVisible(true);
			}
		});
		btnHome.setBounds(301, 227, 89, 23);
		contentPane.add(btnHome);
	}
}
