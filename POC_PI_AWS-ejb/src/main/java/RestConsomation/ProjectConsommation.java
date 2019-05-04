package RestConsomation;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Project;



/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class ProjectConsommation  implements ProjectConsommationRemote 
{

    /**
     * Default constructor. 
     */
    public ProjectConsommation() {
        // TODO Auto-generated constructor stub
    }

    public  List<Project> Consomation()
    {
    	List<Project>  lasp = new ArrayList<Project>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/API/Affichage"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
   
    	
    	for (int i=0;i<object.size();i++)
    	{
    		System.out.println("erreuuur"+ object.getJsonObject(i).get("Branche").toString());
    	 
    		Project p = new Project();
    	 
    	 p.setTitle(object.getJsonObject(i).get("Title").toString()); 
    	 
    	 p.setDescription(object.getJsonObject(i).get("Description").toString());
    	 
    	/* 
    	 String dat = object.getJsonObject(i).get("OutDate").toString();
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 Date outdate = null;
		try {
			outdate = sdf.parse(dat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 */
    	 
    	 
    	 String dateTime = "2012-02-22T02:06:58.147Z";
    	// ZonedDateTime d = ZonedDateTime.parse(object.getJsonObject(i).get("OutDate").toString());
    	 
		//Instant instant = Instant.parse(object.getJsonObject(i).get("OutDate").toString());
		/*
		ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(zdt.toLocalTime());
		*/
    	 //then
    	 
     p.setOutDate(object.getJsonObject(i).get("OutDate").toString());
    	 
    	 
    	 
    	 System.out.println("hellooo"+ object.getJsonObject(i).get("OutDate").toString());
    	 
    	 

    	 p.setImageUrl(object.getJsonObject(i).get("ImageUrl").toString());
    	
    	 System.out.println(Integer.parseInt(object.getJsonObject(i).get("Branche").toString())); 
    	 p.setImageUrl(object.getJsonObject(i).get("Id").toString());
     	
    	 lasp.add(p);
    	 
     	
    	 
    	}
    	

return lasp;    	
    }
    
    @Override
	public void Add(Project p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6795/API/CreateProject");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
		
	}

	@Override
	public void Update(Project p , int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6795/api/update?id="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}


	
	
	@Override
	public void Delete(Project p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6795/api/delete"+p.getProjectId());
		WebTarget hello =target.path("");
		
		Response response =hello.request().delete( );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}


}




