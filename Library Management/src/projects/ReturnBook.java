package projects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import pojos.AddBook;
import utilities.MyDatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class  ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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

	public  ReturnBook() {
		setTitle("Return Book");
		conn = MyDatabaseConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTable = new JLabel("Enter BookI ID");
		lblTable.setBounds(101, 27, 119, 14);
		contentPane.add(lblTable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 101, 332, 120);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		try {
			// show the table using jar file
			/*
			 * String qr="select * from addbook"; PreparedStatement ps
			 * =conn.prepareStatement(qr); ResultSet rs = ps.executeQuery();
			 * table.setModel(DbUtils.resultSetToTableModel(rs));
			 */

			String qr = "select * from  issued ";
			PreparedStatement ps = conn.prepareStatement(qr);
			ResultSet rs = ps.executeQuery();
			Object arr[] = { "book_id", " book_name" , "Author"};
			DefaultTableModel ab = new DefaultTableModel();
			ab.setColumnIdentifiers(arr);
			table.setModel(ab);
			while (rs.next()) {
				Integer a = rs.getInt(1);
				String data = a.toString();
				String data2 = rs.getString(2);
				String author = rs.getString(3);
				Object ar[] = { data, data2,author};
				ab.addRow(ar);

			}
//		
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
						String qr = "select * from  issued where book_id = ?";
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

			JButton btnNewButton = new JButton("Home");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					Library window = new Library();
					window.frame.setVisible(true);
				}
			});
			btnNewButton.setBounds(239, 232, 89, 23);
			contentPane.add(btnNewButton);

			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					Librarian frame = new Librarian();
					frame.setVisible(true);
				}

			});
			btnBack.setBounds(338, 232, 89, 23);
			contentPane.add(btnBack);

			JButton btnEssue = new JButton("Return");
			btnEssue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = search.getText();

					Date date = new Date();
					long num1 = date.getTime();
					java.sql.Date date1 = new java.sql.Date(num1);

					int num = Integer.parseInt(input);
					try {

						String qr1 = "select * from  issued where book_id = ?";
						PreparedStatement ps = conn.prepareStatement(qr1);
						ps.setInt(1, num);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							Integer a = rs.getInt(1);
							String data = a.toString();
							String data2 = rs.getString(2);
							String author = rs.getString(3);

							String qr2 = "INSERT INTO addbook" + "(book_id,  book_name,author) VALUES"
									+ "(?,?,?)";
							PreparedStatement ps1 = conn.prepareStatement(qr2);
							ps1.setInt(1, a);
							ps1.setString(2, data2);
							ps1.setString(3, author);
							ps1.executeUpdate();
							
							
							ClassNameHere.infoBox("Book has been Returned", "TITLE BAR MESSAGE");

						}

						
						
						String qr3 = "delete from  issued where book_id = ?";
						PreparedStatement ps2 = conn.prepareStatement(qr3);
						ps2.setInt(1, num);
						ps2.executeUpdate();

						
						
						
						
						String qr="select * from  issued";
						PreparedStatement ps1 =conn.prepareStatement(qr);
						ResultSet rs1 = ps1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						
						
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});
			btnEssue.setBounds(46, 232, 89, 23);
			contentPane.add(btnEssue);
			
			JLabel lblYourBooks = new JLabel("Essued Books");
			lblYourBooks.setBounds(48, 76, 87, 14);
			contentPane.add(lblYourBooks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
