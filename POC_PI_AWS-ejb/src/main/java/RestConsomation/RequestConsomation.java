


package RestConsomation;


import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Request;
import entities.Request.Category;
import entities.Request.Priority;
import entities.Request.Status;






/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class RequestConsomation implements RequestConsomationRemote {

    
    public RequestConsomation() {
        // TODO Auto-generated constructor stub
    }

    public List<Request> consomation()
    {
    	List<Request>  lasp = new ArrayList<Request>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/api/RequestWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	System.out.println("erreuuur");
   
    	
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Request m = new Request();
    	m.setRequestId(Integer.parseInt(object.getJsonObject(i).get("RequestId").toString()));
    	System.out.println("fffffff "+Integer.parseInt(object.getJsonObject(i).get("RequestId").toString()));
    	 m.setName(object.getJsonObject(i).get("Name").toString()); 
    	 m.setSubject(object.getJsonObject(i).get("Subject").toString());
    	 m.setCategory(Category.values()[Integer.parseInt(object.getJsonObject(i).get("Category").toString())] );
    	 m.setPriority(Priority.values()[Integer.parseInt(object.getJsonObject(i).get("Priority").toString())] );
    	 m.setStatus(Status.values()[Integer.parseInt(object.getJsonObject(i).get("Status").toString())] );
    	 
    	 
    	 m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
    	 m.setId(Integer.parseInt(object.getJsonObject(i).get("Id").toString()));
    	 m.setUserCreate(object.getJsonObject(i).get("UserCreate").toString());
    	 
    	 SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	 
    	 String dateString;
    	 dateString = object.getJsonObject(i).get("UpdateDate").toString();
    	dateString = dateString.replaceAll("\"", "");
    	 Date date = null;
    	 try {
        
    	  date = sourceFormat.parse(dateString);
    	   
    	 } 
    	 catch (ParseException e) {
    	   e.printStackTrace();
    	 }
    	
    	 m.setUpdateDate(date); 


    	
    	 

    	 lasp.add(m);
    	 
    	}
    	

return lasp;    	
    }
    

}
    
