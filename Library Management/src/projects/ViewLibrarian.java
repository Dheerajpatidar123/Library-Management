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

public class ViewLibrarian extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrarian frame = new ViewLibrarian();
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

	public ViewLibrarian() {
		setTitle("View Librarian");
		conn = MyDatabaseConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTable = new JLabel("Librarian");
		lblTable.setBounds(163, 20, 101, 14);
		contentPane.add(lblTable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 71, 332, 145);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		try {
			String qr = "select * from librarian";
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

			JButton btnHome = new JButton("Home");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					Library window = new Library();
					window.frame.setVisible(true);
				}
			});
			btnHome.setBounds(220, 227, 78, 23);
			contentPane.add(btnHome);

			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					Admin frame = new Admin();
					frame.setVisible(true);
				}
			});
			btnBack.setBounds(319, 227, 78, 23);
			contentPane.add(btnBack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
