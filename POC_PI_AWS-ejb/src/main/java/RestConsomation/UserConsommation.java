package RestConsomation;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;

import javax.json.JsonReader;
import javax.mail.Address;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.User;


/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class UserConsommation  implements UserConsommationRemote, UserConsommationLocal {

    /**
     * Default constructor. 
     */
    
    EntityManager em ;

    @Override
    public List<User> consomation()
    {
    	List<User>  lasp = new ArrayList<User>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/UserWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	System.out.println("erreuuur");
   
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		User u = new User();
    	
    	 u.setId(Integer.parseInt(object.getJsonObject(i).get("Id").toString()));
    	 String Email=object.getJsonObject(i).get("Email").toString();
    	 Email=Email.replaceAll("\"", "");
     	u.setEmail(Email);
    	 //u.setEmail(object.getJsonObject(i).get("Email").toString()); 
    	 //u.setFirstName(object.getJsonObject(i).get("FirstName").toString());
    	 String FirstName=object.getJsonObject(i).get("FirstName").toString();
    	 
    	 FirstName=FirstName.replaceAll("\"", "");
    		u.setFirstName(FirstName);
    	 //u.setPassword(object.getJsonObject(i).get("Password").toString());
    		
    	 
    	 
    	// u.setLastName(object.getJsonObject(i).get("LastName").toString());
    	 
    	 String LastName=object.getJsonObject(i).get("LastName").toString();
    	 LastName=LastName.replaceAll("\"", "");
     	u.setLastName(LastName);
    	 
    	 
    	 
    	 u.setStatus(Integer.parseInt(object.getJsonObject(i).get("status").toString()));
    	
    	 lasp.add(u);
    	 
    	}
    	

    		return lasp;    	
    }
    
    
    public  void deleteUser(Integer id) {

    	System.out.println("id"+id);
    	Client client = ClientBuilder.newClient();
    	WebTarget webTarget = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/UserWebApi/"+id);
    	 
    	Invocation.Builder invocationBuilder =  webTarget.request();
    	Response response = invocationBuilder.delete();
    	//System.out.println("id"+id);
    	System.out.println(response.getStatus());
    	System.out.println(response.readEntity(String.class));
    }
    
    
    @Override
	public User login(String email, String password) {
		User u = new User();
		String navigateTo = null ;
		
		List<User>list=consomation();
		for (User user : list) {
			if(user.getEmail().equals(email))
			{
				System.out.println("***************************");
				u=user;
				System.out.println("***********"+u.toString()+"****************");

			}
			else {
				navigateTo="/template/login/login?faces-redirect=true";
			}
		}
		
		return u;
	}


	@Override
	public String listUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static final String baseUri = "http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/";
    private Client client = null;
    private WebTarget target = null;

    public UserConsommation() {
        client = ClientBuilder.newClient();
        target = client.target(baseUri);
    }
    
    public void reloadUri() {
        target = null;
        target = client.target(baseUri);
    }
	@Override
	public void postRequest(User p) {

		 reloadUri();
		 User pack = new User();
	        
	      /*  pack.setEmail(p.getEmail());
	        pack.setFirstName(p.getFirstName());
	        pack.setLastName(p.getLastName());
	        pack.setPassword(p.getPassword());
	        */
	        target = target.path("/Create");
	// POST Request from Jersey Client
	       Response response = target.request(MediaType.APPLICATION_JSON)
	                .post(Entity.entity(pack, MediaType.APPLICATION_JSON), Response.class);
	                
	        
	        Client client = ClientBuilder.newClient();
	    	WebTarget target = client.target(baseUri);

	    	Entity<User> jsonEntity = Entity.json(p);

	    	Invocation.Builder builder = target.request();
	    	Response message = builder.post(jsonEntity);
	        	        
	        System.out.println(response);
	        if (response.getStatus() == 200) {
	            System.out.println("post success");

	        }
	        else System.out.println("fatal error");
	}


	
}



