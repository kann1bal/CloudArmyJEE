package RestConsomation;


import java.io.StringReader;
import java.util.ArrayList;
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


import entities.Documentt;



/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class DocumentConsomation implements DocumentConsomationRemote{

	
	

    /**
     * Default constructor. 
     */
    public DocumentConsomation() {
    
    }
    
 
    
    
   
    public List<Documentt> consomation()
    {
    	List<Documentt>  lasp = new ArrayList<Documentt>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/api/DocumentWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Documentt m = new Documentt();
    	 
    	 m.setName(object.getJsonObject(i).get("Name").toString()); 
    	 m.setDateDoc(object.getJsonObject(i).get("DateDoc").toString());
    	 m.setSize(object.getJsonObject(i).get("Size").toString());
    	// m.setFileType(Integer.parseInt(object.getJsonObject(i).get("TypeVm").toString()));
    	 m.setImageUrl(object.getJsonObject(i).get("ImageUrl").toString());
    	 m.setProjectName(object.getJsonObject(i).get("ProjectNames").toString());
    	 m.setExtension(object.getJsonObject(i).get("Extension").toString());
     	 m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));

    	 
    	 
    	// m.setDate(object.getJsonObject(i).get("Date").toString()); 
    	 //m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
    	// m.setId(Integer.parseInt(object.getJsonObject(i).get("Id").toString()));



    	 lasp.add(m);
    	}
    	

    		return lasp;    	
    }

  @Override
	public void Create(Documentt p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6795/api/Doc");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);
		System.out.println("newwwwwwwwwwwwwwwwwwwwwwwwwwwww");


		response.close();
		
		
	}
  
  
	@Override
	public void Update(Documentt p , int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6795/api/DocUp?id="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
    
  
    
    
    
    
}
