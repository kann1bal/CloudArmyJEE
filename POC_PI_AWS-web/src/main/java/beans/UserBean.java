package beans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import RestConsomation.UserConsommation;
import entities.User;


@ManagedBean
@SessionScoped
public class UserBean {
	private List<User> users = new ArrayList<User>();
	private int status;
	private String FirstName;
	private String LastName;
	private String Logo;
	private String Email;
	private int Id;
	private String Password;
	@EJB
	private UserConsommation dcr;
	
	
	
	public UserConsommation getDcr() {
		return dcr;
	}


	public void setDcr(UserConsommation dcr) {
		this.dcr = dcr;
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


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public List<User> getUsers() {
		

		return users;
	}	
	

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@PostConstruct
	public void init() {
		users = dcr.consomation();
	}
	
	
	public  String supprimer(Integer id){
		String navigateTo ="null";
		dcr.deleteUser(id);
		navigateTo ="UserList?faces-redirect=true";
		return navigateTo;
	}
	

public void addProject(){
		
	dcr.postRequest(new User(FirstName,Email,Password));

	
		
		
		
	}
	
}
 
