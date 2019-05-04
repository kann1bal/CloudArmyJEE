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

import entities.Meeting;







/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class MeetingConsomation implements MeetingConsomationRemote{

    /**
     * Default constructor. 
     */
    public MeetingConsomation() {
        // TODO Auto-generated constructor stub
    }

    public List<Meeting> consomation() 
    {
    	List<Meeting>  lasp = new ArrayList<Meeting>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/api/MeetingWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 Meeting m = new Meeting();
    	 m.setMeetingId(Integer.parseInt(object.getJsonObject(i).get("MeetingId").toString())); 
    	 m.setTitle(object.getJsonObject(i).get("Title").toString()); 
    	 
    	 m.setDetails(object.getJsonObject(i).get("Details").toString());
    	 m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
    	 m.setId(Integer.parseInt(object.getJsonObject(i).get("Id").toString()));
   
    	 SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	 
    	 String dateString;
    	 dateString = object.getJsonObject(i).get("Date").toString();
    	dateString = dateString.replaceAll("\"", "");
    	 Date date = null;
    	 try {
        
    	  date = sourceFormat.parse(dateString);
    	   
    	 } 
    	 catch (ParseException e) {
    	   e.printStackTrace();
    	 }
    	
    	 m.setDate(date); 



    	 lasp.add(m);
    	}
    	

return lasp;    	
    }
    
}