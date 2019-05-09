package beans;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import RestConsomation.UserConsommation;
import entities.User;

@ManagedBean(name = "Identity")
@SessionScoped
public class LoginBean {
	
	private User personneLogin = new User();
	private String email;
	private String password ;
	private boolean isLogged = false;
	private User user ;
	public User u ;
	public User usercnx()
	{
		return user ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}

	@EJB
	private UserConsommation UserConsommationLocal;
	
	public String DoLogin ()
	{
		String navigateTo = null ;
	
		 user = UserConsommationLocal.login(email, password);
		System.out.println("*******************"+email+"********************");
		System.out.println("User****"+user.toString());
		if(user.getId()!=0)
		{
			u=user;
			if(u instanceof User)
			{
				navigateTo="/pages/UserList?faces-redirect=true";

			}
			
				
			isLogged =true;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("email ou password invalide"));
		}
		
		return navigateTo;
	}
	
	
	
	
}
