package projects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import utilities.MyDatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookId;
	private JTextField name;
	private JTextField author;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setTitle("Add Book");
		Connection conn = MyDatabaseConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(51, 43, 46, 14);
		contentPane.add(lblBookId);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(51, 68, 46, 14);
		contentPane.add(lblName);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(51, 96, 46, 14);
		contentPane.add(lblAuthor);

		bookId = new JTextField();
		bookId.setBounds(135, 43, 134, 18);
		contentPane.add(bookId);
		bookId.setColumns(10);

		name = new JTextField();
		name.setBounds(135, 68, 134, 18);
		contentPane.add(name);
		name.setColumns(10);

		author = new JTextField();
		author.setBounds(135, 96, 134, 18);
		contentPane.add(author);
		author.setColumns(10);

		JLabel lblYourBooks = new JLabel("Your Books");
		lblYourBooks.setBounds(51, 121, 93, 14);
		contentPane.add(lblYourBooks);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					
					String bookid = bookId.getText();
					int bookid1 = Integer.parseInt(bookid);
					String bookname = name.getText();
					String bookauthor = author.getText();
					String qr2 = "INSERT INTO addbook" + "(bookid, bookname,author) VALUES" + "(?,?,?)";

					PreparedStatement ps1 = conn.prepareStatement(qr2);
					ps1.setInt(1, bookid1);
					ps1.setString(2, bookname);
					ps1.setString(3, bookauthor);
					ps1.executeUpdate();

					String qr = "select * from addbook";
					PreparedStatement ps = conn.prepareStatement(qr);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					ClassNameHere.infoBox("Book Added", "TITLE BAR MESSAGE");
				}

				catch (Exception e1) {
					e1.printStackTrace();
					ClassNameHere.infoBox("Please Give Numric value", "TITLE BAR MESSAGE");
				}
			}
		});
		btnAddBook.setBounds(305, 67, 89, 23);
		contentPane.add(btnAddBook);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 138, 345, 78);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblEnterBookDatails = new JLabel("Enter Book Datails");
		lblEnterBookDatails.setBounds(61, 11, 110, 14);
		contentPane.add(lblEnterBookDatails);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Library window = new Library();
				window.frame.setVisible(true);
			}
		});
		btnHome.setBounds(51, 227, 89, 23);
		contentPane.add(btnHome);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Librarian frame = new Librarian();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(320, 227, 89, 23);
		contentPane.add(btnBack);

		try {
			String qr = "select * from addbook";
			PreparedStatement ps = conn.prepareStatement(qr);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
