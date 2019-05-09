package entities;

public class User {
	
	private int status;
	private String FirstName;
	private String LastName;
	private String Logo;
	private String Email;
	private int Id;
	private String Password;
	
	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	@Override
	public String toString() {
		return "User [status=" + status + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Logo=" + Logo
				+ ", Email=" + Email + ", Id=" + Id + ", Password=" + Password + "]";
	}
	public User( String firstName, String email, String password) {
		super();
		
		FirstName = firstName;
		
		Email = email;
		
		Password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
