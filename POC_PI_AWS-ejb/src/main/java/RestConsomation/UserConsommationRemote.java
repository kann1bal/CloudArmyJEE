package RestConsomation;

import java.util.List;

import entities.User;

public interface UserConsommationRemote {
	 public List<User> consomation();
	 public User login(String email, String password);
 public void postRequest(User p);

}
