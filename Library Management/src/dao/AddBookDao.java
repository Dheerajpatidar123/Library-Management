package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.AddBook;
import utilities.MyDatabaseConnection;


public class AddBookDao {

	public boolean createAddBook(AddBook book) {
		Connection conn = MyDatabaseConnection.getConnection();
		
		try {  
			String sql = "insert into addbook (bookname) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		}
		return true;
	}
	
	public ArrayList<AddBook> findAll() {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<AddBook> listExpenses = new ArrayList<AddBook>();
		try {
			String sql = "select * from addbook";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AddBook expenses = new AddBook();
				
				expenses.setBookName(rs.getString("bookname"));
				
				
				listExpenses.add(expenses);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			
		}
		return listExpenses;
	}

	
	public boolean removeCourse(String bookname) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from addbook where bookname = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookname);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			return false;
		}
		return true;
	}

	public static void main(String args[]) {

		 AddBook book = new AddBook("Java");
		 AddBookDao addbookDao = new AddBookDao();
		 addbookDao.createAddBook(book);
		 
		 
		
		
		 AddBookDao courseDao = new AddBookDao();
		courseDao.removeCourse("jav");
		
		
		AddBookDao cd = new AddBookDao();
		ArrayList<AddBook> al = cd.findAll();
		for (AddBook expenses : al) {
		System.out.println(expenses);	
				}
			

		}
}
