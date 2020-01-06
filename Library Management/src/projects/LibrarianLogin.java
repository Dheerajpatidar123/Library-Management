package projects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilities.MyDatabaseConnection;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class LibrarianLogin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin frame = new LibrarianLogin();
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
	public LibrarianLogin() {
		
		
		
		setTitle("Librarian Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Connection conn = MyDatabaseConnection.getConnection();
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(89, 75, 101, 25);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(89, 135, 101, 25);
		contentPane.add(lblPassword);

		user = new JTextField();
		user.setBounds(213, 80, 137, 20);
		contentPane.add(user);
		user.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(213, 140, 133, 20);
		contentPane.add(pass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
			}
		});
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					String qr = "SELECT username, password FROM librarian";
					PreparedStatement ps = conn.prepareStatement(qr);
//			            ResultSet results = prepareStatement.executeQuery(queryString);
					ResultSet results = ps.executeQuery();
					String user1 = user.getText();
					char pass11[] = pass.getPassword();
					String pass1 = String.valueOf(pass11);
					boolean a = false;
					while (results.next()) {

						if (results.getString("username").equals(user1)
								&& results.getString("password").equals(pass1)) {
							System.out.println("yes");
							setVisible(false);
							dispose();
							Librarian lb = new Librarian();
							lb.setVisible(true);
							a=true;
						}
						}

					if(a==false) {
					ClassNameHere.infoBox("Wrong Username or Password Please Enter again", "TITLE BAR MESSAGE");
					setVisible(false);
					dispose();
					LibrarianLogin lb1 = new LibrarianLogin();
					lb1.setVisible(true);
					}
					
					results.close();
				}

				catch (SQLException sql) {

					System.out.println(sql);
				}
			}
				
			
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String qr = "SELECT username, password FROM librarian";
					PreparedStatement ps = conn.prepareStatement(qr);
//			            ResultSet results = prepareStatement.executeQuery(queryString);
					ResultSet results = ps.executeQuery();
					String user1 = user.getText();
					char pass11[] = pass.getPassword();
					String pass1 = String.valueOf(pass11);
					boolean a = false;
					while (results.next()) {

						if (results.getString("username").equals(user1)
								&& results.getString("password").equals(pass1)) {
							System.out.println("yes");
							setVisible(false);
							dispose();
							Librarian lb = new Librarian();
							lb.setVisible(true);
							a=true;
						}
						}

					if(a==false) {
					ClassNameHere.infoBox("Wrong Username or Password Please Enter again", "TITLE BAR MESSAGE");
					setVisible(false);
					dispose();
					LibrarianLogin lb1 = new LibrarianLogin();
					lb1.setVisible(true);
					}
					
					results.close();
				}

				catch (SQLException sql) {

					System.out.println(sql);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(145, 193, 137, 31);
		contentPane.add(btnLogin);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Library window = new Library();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(322, 227, 78, 23);
		contentPane.add(btnNewButton);
	}
}
