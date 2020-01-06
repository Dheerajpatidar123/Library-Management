package projects;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

public class Librarian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Librarian frame = new Librarian();
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
	public Librarian() {
		setTitle("Librarian");
		setBackground(Color.BLUE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddBooks = new JButton("Add books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				AddBooks frame = new AddBooks();
				frame.setVisible(true);

			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddBooks.setBounds(48, 43, 141, 30);
		contentPane.add(btnAddBooks);

		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				ViewBooks ad = new ViewBooks();
				ad.setVisible(true);
			}
		});
		btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewBooks.setBounds(220, 43, 141, 30);
		contentPane.add(btnViewBooks);

		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				IssueBook frame = new IssueBook();
				frame.setVisible(true);
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIssueBook.setBounds(48, 97, 141, 30);
		contentPane.add(btnIssueBook);

		JButton btnViewEssuedBooks = new JButton("Issued Books");
		btnViewEssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				IssuedBook frame = new IssuedBook();
				frame.setVisible(true);
			}
		});
		btnViewEssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewEssuedBooks.setBounds(220, 97, 141, 30);
		contentPane.add(btnViewEssuedBooks);

		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				ReturnBook frame = new ReturnBook();
				frame.setVisible(true);
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReturnBook.setBounds(220, 151, 141, 30);
		contentPane.add(btnReturnBook);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				LibrarianLogin lb = new LibrarianLogin();
				lb.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogout.setBounds(50, 257, 76, 23);
		contentPane.add(btnLogout);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Library window = new Library();
				window.frame.setVisible(true);
			}
		});
		btnHome.setBounds(285, 257, 76, 23);
		contentPane.add(btnHome);

		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				RemoveBook frame = new RemoveBook();
				frame.setVisible(true);
			}
		});
		btnRemoveBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveBook.setBounds(128, 204, 175, 30);
		contentPane.add(btnRemoveBook);

		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				StudentDetails frame = new StudentDetails();
				frame.setVisible(true);

			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(48, 152, 141, 29);
		contentPane.add(btnStudent);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane, btnAddBooks, btnViewBooks,
				btnIssueBook, btnViewEssuedBooks, btnReturnBook, btnLogout }));
	}
}
