package projects;

import java.awt.EventQueue;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.awt.Rectangle;

public class Library {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library window = new Library();
					window.frame.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the application.
	 */
	public Library() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Library Managment ");
		frame.setBounds(new Rectangle(500, 500, 500, 500));
		frame.setBounds(500,250, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		

		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				frame.dispose();
				Adminlogin ad = new Adminlogin();
				ad.setVisible(true);

			}
		});
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Adminlogin ad = new Adminlogin();
				ad.setVisible(true);

			}
		});
		btnAdmin.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnAdmin.setBounds(155, 57, 127, 48);
		frame.getContentPane().add(btnAdmin);

		JButton btnNewButton = new JButton("Librarian");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				frame.dispose();
				LibrarianLogin lb = new LibrarianLogin();
				lb.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LibrarianLogin lb = new LibrarianLogin();
				lb.setVisible(true);
			}
		});
		btnNewButton.setBounds(155, 140, 127, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setBounds(319, 214, 89, 23);
		frame.getContentPane().add(btnClose);
	}

}
