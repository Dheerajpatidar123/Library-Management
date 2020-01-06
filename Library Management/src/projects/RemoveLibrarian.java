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

import utilities.MyDatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class   RemoveLibrarian extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveLibrarian frame = new RemoveLibrarian();
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

	public   RemoveLibrarian() {
		setTitle("Remove Librarian");
		conn = MyDatabaseConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTable = new JLabel("Enter Librarian Name");
		lblTable.setBounds(101, 27, 157, 14);
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

			String qr = "select * from librarian ";
			PreparedStatement ps = conn.prepareStatement(qr);
			ResultSet rs = ps.executeQuery();
			Object arr[] = { "Username", "contact" ,"address" };
			DefaultTableModel ab = new DefaultTableModel();
			ab.setColumnIdentifiers(arr);
			table.setModel(ab);
			while (rs.next()) {
//				Integer a = rs.getInt(2);
				String data = rs.getString(2);
				String data2 = rs.getString(4);
				String data3 = rs.getString(5);
				Object ar[] = { data, data2,data3 };
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
					
					try {
						String qr = "select * from librarian where username = ?";
						PreparedStatement ps = conn.prepareStatement(qr);
						ps.setString(1, input);
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
					Admin frame = new Admin();
					frame.setVisible(true);
				}

			});
			btnBack.setBounds(338, 232, 89, 23);
			contentPane.add(btnBack);

			JButton btnEssue = new JButton("Remove");
			btnEssue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = search.getText();

				
					try {

						String qr3 = "delete from librarian where username = ?";
						PreparedStatement ps2 = conn.prepareStatement(qr3);
						ps2.setString(1, input);
						ps2.executeUpdate();
						
						
						ClassNameHere.infoBox("Librarian Removed", "TITLE BAR MESSAGE");
						
						
						String qr="select * from librarian";
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
			
			JLabel lblYourLibrarians = new JLabel("Librarian");
			lblYourLibrarians.setBounds(48, 76, 87, 14);
			contentPane.add(lblYourLibrarians);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
