package projects;
import java.awt.Window;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-37,269
	 */
	private final JTextField textField_1 = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setBackground(Color.DARK_GRAY);
		textField_1.setColumns(10);
		setTitle("Admin Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDgfh = new JButton("Add Librarian");
		btnDgfh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
            	dispose();
   				AddLibrarian lb = new AddLibrarian();
   				lb.setVisible(true);
			}
		});
		btnDgfh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDgfh.setBounds(122, 40, 174, 36);
		contentPane.add(btnDgfh);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
            	dispose();
				Adminlogin frame = new Adminlogin();
				frame.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout.setBounds(122, 186, 174, 36);
		contentPane.add(btnLogout);
		
		JButton btnDeleteLibrarian = new JButton("Remove Librarian");
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
            	dispose();
            	RemoveLibrarian frame = new RemoveLibrarian();
				frame.setVisible(true);
			}
		});
		btnDeleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteLibrarian.setBounds(122, 139, 174, 36);
		contentPane.add(btnDeleteLibrarian);
		
		JButton btnViewLibrarian = new JButton("View Librarian");
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
            	dispose();
				  ViewLibrarian frame = new   ViewLibrarian();
					frame.setVisible(true);
			}
		});
		btnViewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewLibrarian.setBounds(122, 92, 174, 36);
		contentPane.add(btnViewLibrarian);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
            	dispose();
            	Library window = new Library();
				window.frame.setVisible(true);
			}
		});
		btnHome.setBounds(321, 227, 77, 23);
		contentPane.add(btnHome);
	}
}
