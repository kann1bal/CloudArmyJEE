package RestConsomation;

import entities.User;

public interface UserConsommationLocal {
	
	String listUser();
	public  User login(String email, String password) ;
	public void postRequest(User p);
		
	
	

}
