package pojos;

import java.io.Serializable;

public class AddBook implements Serializable{
	protected String bookName;
 
	
	public AddBook() {
		bookName = new String();
		}
	public AddBook(String bookName) {
		super();
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "AddBook [bookName=" + bookName + "]";
	}
	
	
	}
