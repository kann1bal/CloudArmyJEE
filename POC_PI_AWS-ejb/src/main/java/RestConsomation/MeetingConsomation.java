package RestConsomation;


import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    public int nbmeetingdone;
    public int nbmeetingnotdone;
    public int nbmeeting;
    public int nbmeetingtoday;
    
    public List<Meeting> consomation() 
    {
    	nbmeeting =0;
    	nbmeetingdone=0;
    	nbmeetingnotdone=0;
    	nbmeetingtoday=0;
    	
    	List<Meeting>  lasp = new ArrayList<Meeting>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi"); 
    	
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
    	 
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);
    	 m.setFlag(Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString()));
   
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
    	 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");  
    	 Date now = new Date(System.currentTimeMillis());  
    	 System.out.println(formatter.format(date));  
    		if (date.compareTo(now) < 0) {
                nbmeetingdone++;
            } else if (date.compareTo(now) > 0) {
            	nbmeetingnotdone++;
            } else if (date.compareTo(now) == 0) {
               nbmeetingtoday++;
            } else {
                System.out.println("How to get here?");
            }
    		
    		nbmeeting++;
    		
    	 m.setDate(date); 
    	 
    	 if (x==true) {
    		 lasp.add(m);
    	 }
    	 
    	    	}
    	
    	System.out.println("meetingdone "+nbmeetingdone);
    	System.out.println("meetingnotdone "+nbmeetingnotdone);
    	System.out.println("meetingtoday "+nbmeetingtoday);
    	System.out.println("meetingzzzz "+nbmeeting);
return lasp;    	
    }
    public int totalmeeting() 
    {
    	nbmeeting =0;
    	
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 Meeting m = new Meeting();
    	
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);

    		nbmeeting++;
    	}
    	System.out.println("meetingzzzz "+nbmeeting);
return nbmeeting;    	
    }
    
    public int meetingdone() 
    {
    	nbmeetingdone =0;
    	
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 Meeting m = new Meeting();
    	
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);

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
    	 
    	 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");  
    	 Date now = new Date(System.currentTimeMillis());  
    	
    	 if (date.compareTo(now) < 0)
    	 
    	 
    		nbmeetingdone++;
    	}
    	System.out.println("meetingzzzzdone "+nbmeetingdone);
return nbmeetingdone;    	
    }
    
    public int meetingnotdone() 
    {
    	nbmeetingnotdone =0;
    	
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 Meeting m = new Meeting();
    	
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);

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
    	 
    	 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");  
    	 Date now = new Date(System.currentTimeMillis());  
    	
    	 if (date.compareTo(now) > 0)
    	 
    	 
    		nbmeetingnotdone++;
    	}
    	System.out.println("meetingzzzznotdone "+nbmeetingnotdone);
return nbmeetingnotdone;    	
    }
    
    public int meetingtoday() 
    {
    	nbmeetingtoday =0;
    	
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 Meeting m = new Meeting();
    	
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);

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
    	 
    	 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");  
    	 Date now = new Date(System.currentTimeMillis());  
    	
    	 if (date.compareTo(now) == 0)
    	 
    	 
    		nbmeetingtoday++;
    	}
    	System.out.println("meetingzzzztoday "+nbmeetingtoday);
return nbmeetingtoday;    	
    }
    
    
    
    public List<Meeting> consomation1() 
    {
    	List<Meeting>  lasp = new ArrayList<Meeting>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi"); 
    	
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

    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
   	 System.out.println("boolean "+x);
   	 m.setFlag(Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString()));
   	 
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
    	 
    	 if (x==false) {
   		 lasp.add(m);
   	 }
   	 
   	    	}
   	



   return lasp;    	
    }

    public void  ajouterMeeting(Meeting m)
    {
    String uri = "http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/Meeting/Create";

	Client client = ClientBuilder.newClient();
	WebTarget target = client.target(uri);

	Entity<Meeting> jsonEntity = Entity.json(m);

	Invocation.Builder builder = target.request();
	Response message = builder.post(jsonEntity);

    }
    
    public  void deleteMeeting(Integer id) {

    	System.out.println("id"+id);
    	Client client = ClientBuilder.newClient();
    	WebTarget webTarget = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/MeetingWebApi/"+id);
    	 
    	Invocation.Builder invocationBuilder =  webTarget.request();
    	Response response = invocationBuilder.delete();
    	//System.out.println("id"+id);
    	System.out.println(response.getStatus());
    	System.out.println(response.readEntity(String.class));
    }
    
 public void updateMeeting(Meeting m, int id) {
		
    	Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/Meeting/Update?MeetingId="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(m, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
 
 

    
}