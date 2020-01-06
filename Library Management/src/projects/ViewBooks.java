package projects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import pojos.AddBook;
import utilities.MyDatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooks frame = new ViewBooks();
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
	Connection conn = null;
	private JTextField search;

	public ViewBooks() {
		setTitle("View Books");
		conn = MyDatabaseConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTable = new JLabel("Enter Book Id");
		lblTable.setBounds(163, 20, 101, 14);
		contentPane.add(lblTable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 100, 332, 116);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		try {
			String qr = "select * from addbook";
			PreparedStatement ps = conn.prepareStatement(qr);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			search = new JTextField();
			search.setBounds(90, 45, 139, 20);
			contentPane.add(search);
			search.setColumns(10);

			JButton SearchBT = new JButton("Search");
			SearchBT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = search.getText();
					int num = Integer.parseInt(input);
					try {
						String qr = "select * from addbook where book_id = ?";
						PreparedStatement ps = conn.prepareStatement(qr);
						ps.setInt(1, num);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			SearchBT.setBounds(239, 42, 89, 23);
			contentPane.add(SearchBT);

			JButton btnHome = new JButton("Home");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					Library window = new Library();
					window.frame.setVisible(true);
				}
			});
			btnHome.setBounds(242, 227, 72, 23);
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
			btnBack.setBounds(325, 227, 72, 23);
			contentPane.add(btnBack);

			JLabel lblLibraryBooks = new JLabel("Available Books");
			lblLibraryBooks.setBounds(52, 76, 80, 20);
			contentPane.add(lblLibraryBooks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
