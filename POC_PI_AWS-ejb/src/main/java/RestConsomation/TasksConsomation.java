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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Tasks;





@Stateless
@LocalBean
public class TasksConsomation implements TasksConsomationRemote{
	
	@PersistenceContext
	private EntityManager em;
	
	public TasksConsomation(){
		
	}
	
	 public List<Tasks> consomation()
	    {
	    	List<Tasks>  lt = new ArrayList<Tasks>();
	    	Client client = ClientBuilder.newClient();
	    	
	    	WebTarget web = client.target("http://localhost:6795/api/Taskss"); 
	    	
	    	Response response = web.request().get();
	    	
	    	String result = response.readEntity(String.class); 
	    	
	    	//System.out.println(result);
	    	JsonReader jsonReader = Json.createReader(new StringReader(result));
	    	JsonArray object =  jsonReader.readArray();
	    	System.out.println("erreuuur");
	   
	    	
	    	for (int i=0;i<object.size();i++)
	    	{
	    	 
	    		Tasks t = new Tasks();
	    	 
	    	 t.setDescription(object.getJsonObject(i).get("Description").toString());
	    	 SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    	 
	    	 String dateString;
	    	 String dateStringg;
	    	 dateString = object.getJsonObject(i).get("startDate").toString();
	    	 dateStringg = object.getJsonObject(i).get("deadline").toString();
	    	 //System.out.println("test"+ dateString);
	    	dateString = dateString.replaceAll("\"", "");
	    	dateStringg = dateStringg.replaceAll("\"", "");
	    	 Date startDate = null;
	    	 Date deadline = null;
	    	 try {
	        
	    		 startDate = sourceFormat.parse(dateString);
	    		 deadline = sourceFormat.parse(dateStringg);
	    	   
	    	 } 
	    	 catch (ParseException e) {
	    	   e.printStackTrace();
	    	 }
	    	 t.setStartDate(startDate);
	    	 t.setSpentTime(Double.parseDouble(object.getJsonObject(i).get("SpentTime").toString()));
	    	 t.setDeadline(deadline);
	    	 System.out.println("test"+object.getJsonObject(i));

	    	 /*t.setComplexity(Complexity.values()[Integer.parseInt(object.getJsonObject(i).getString("Complexity"))]);
	    	 t.setRate(Float.parseFloat(object.getJsonObject(i).get("Rate").toString()));
	    	 t.setStatus(Statuss.values()[Integer.parseInt(object.getJsonObject(i).get("Status").toString())]);
	    	 t.setProgress(Progress.values()[Integer.parseInt(object.getJsonObject(i).get("Progress").toString())]);
	    	 t.setIsDone(IsDone.values()[Integer.parseInt(object.getJsonObject(i).get("IsDone").toString())]);
	    	 t.setEstimation(object.getJsonObject(i).get("Estimation").toString());*/
	    	 System.out.println("teeeeessst"); 
	    	 
	    	
	    	 

	    	 lt.add(t);
	    	 
	    	}
	    	System.out.println("enfin");

	return lt;    	
	    }
	 
	 
	 public void Create(Tasks t) {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:6795/api/Create");
			WebTarget hello =target.path("");
			
			Response response =hello.request().post(Entity.entity(t, MediaType.APPLICATION_JSON) );
			
			String result=response.readEntity(String.class);
			System.out.println(result);
			System.out.println("newwwwwwwwwwwwwwwwwwwwwwwwwwwww");


			response.close();
			
			
		}

}
