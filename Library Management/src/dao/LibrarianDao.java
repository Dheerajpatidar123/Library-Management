package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Librarian;
import projects.AddLibrarian;
import projects.ClassNameHere;
import utilities.MyDatabaseConnection;


public class    LibrarianDao {

	public boolean createLibrarian(Librarian lib) {
		Connection conn = MyDatabaseConnection.getConnection();
		
		try {  
			String sql = "insert into  librarian (username, " + "password ,"+" contact ,"+"  address) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lib.getName());
			ps.setString(2, lib.getPassword());
			ps.setString(3, lib.getContact());
			ps.setString(4, lib.getAddress());
			ps.executeUpdate();
			ClassNameHere.infoBox("Librarian added", "TITLE BAR MESSAGE");
		} catch (SQLException sq) {
			
			ClassNameHere.infoBox("Username already Exist", "TITLE BAR MESSAGE");
			AddLibrarian frame = new AddLibrarian();
			frame.setVisible(true);
			return false;
			
			
			
		}
		return true;
	}
	
	public ArrayList<Librarian> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Librarian> listExpenses = new ArrayList<Librarian>();
		try {
			String sql = "select * from  librarian";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Librarian expenses = new Librarian();
				
				expenses.setName(rs.getString("username"));
				expenses.setPassword(rs.getString("password"));
				
				
				listExpenses.add(expenses);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			
		}
		return listExpenses;
	}

	
	public boolean removeLibrarian(String username) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from  librarian where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			return false;
		}
		return true;
	}

	public static void main(String args[]) {

		 Librarian username = new Librarian("Rohitai","9873237476","12","1");
		    LibrarianDao    LibrarianDao = new    LibrarianDao();
		    LibrarianDao.createLibrarian(username);
		 
		 
		
		
//		    LibrarianDao librarianDao = new    LibrarianDao();
//		librarianDao.removeLibrarian("java");
		
		
//		   LibrarianDao cd = new    LibrarianDao();
//		ArrayList<Librarian> al = cd.findAll();
//		for (Librarian lib : al) {
//		System.out.println(lib);	
		//		}
			

		}
}
