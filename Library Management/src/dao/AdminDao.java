package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Admin;
import pojos.Admin;
import projects.AdminRegistration;
import projects.ClassNameHere;
import utilities.MyDatabaseConnection;


public class   AdminDao {

	public boolean createAdmin(Admin lib) {
		Connection conn = MyDatabaseConnection.getConnection();
		
		try {  
			String sql = "insert into  admin (username, " + "password ,"+" contact ,"+"  address) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lib.getName());
			ps.setString(2, lib.getPassword());
			ps.setString(3, lib.getContact());
			ps.setString(4, lib.getAddress());
			ps.executeUpdate();
			ClassNameHere.infoBox("Admin Registered", "TITLE BAR MESSAGE");
		} catch (SQLException sq) {
			ClassNameHere.infoBox("Username already Exist", "TITLE BAR MESSAGE");
			System.out.println("Unable to create a new row." + sq);
			AdminRegistration frame = new AdminRegistration();
			frame.setVisible(true);
			return false;
		}
			
		
		return true;
	}
	
	public ArrayList<Admin> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Admin> listExpenses = new ArrayList<Admin>();
		try {
			String sql = "select * from  admin";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin expenses = new Admin();
				
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

	
	public boolean removeAdmin(String username) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from  admin where username = ?";
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

//		 Admin username = new Admin("Rohitai","9873237476","12","1");
//		   AdminDao   AdminDao = new   AdminDao();
//		   AdminDao.createAdmin(username);
		 
		 
		
		
//		   AdminDao librarianDao = new   AdminDao();
//		librarianDao.removeAdmin("java");
		
		
//		  AdminDao cd = new   AdminDao();
//		ArrayList<Admin> al = cd.findAll();
//		for (Admin lib : al) {
//		System.out.println(lib);	
		//		}
			

		}


}
