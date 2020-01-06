package pojos;

public class Admin {
	
	protected String name;
	protected String password;
	protected String contact;
	protected String address;
	
	
	
	public Admin() {
		name = new String();
		password = new String();
		contact=new String();
		address=new String();
	}



	public Admin(String name, String password, String contact, String address) {
		super();
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
		return "Admin [name=" + name + ", password=" + password + ", contact=" + contact + ", address=" + address + "]";
	}
	
	
	

}
