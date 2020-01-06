package pojos;

public class Librarian {
	
	protected String name;
	protected String password;
	protected String contact;
	protected String address;
	
	public Librarian() {
		name = new String();
		password = new String();
		contact=new String();
		address=new String();
	}

	public Librarian(String name, String password, String contact, String address) {
		this.name = name;
		this.password = password;
		this.contact = contact;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Librarian [name=" + name + ", password=" + password + ", contact=" + contact + ", address=" + address
				+ "]";
	}
	
	
	
	
	
	

}
