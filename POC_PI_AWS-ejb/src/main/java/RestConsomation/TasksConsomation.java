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
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Tasks;
import entities.Tasks.Complexity;
import entities.Tasks.IsDone;
import entities.Tasks.Progress;
import entities.Tasks.Statuss;





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
	    	
	    	WebTarget web = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/Taskss"); 
	    	
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

	    	 //t.setComplexity(Complexity.values()[Integer.parseInt(object.getJsonObject(i).get("complexity").toString())]);
	    	 t.setRate(Float.parseFloat(object.getJsonObject(i).get("rate").toString()));
	    	 t.setStatus(Statuss.values()[Integer.parseInt(object.getJsonObject(i).get("status").toString())]);
	    	 t.setProgress(Progress.values()[Integer.parseInt(object.getJsonObject(i).get("progress").toString())]);
	    	 t.setIsDone(IsDone.values()[Integer.parseInt(object.getJsonObject(i).get("IsDone").toString())]);
	    	 t.setEstimation(object.getJsonObject(i).get("estimation").toString());
	    	 System.out.println("teeeeessst"); 
	    	 
	    	
	    	 

	    	 lt.add(t);
	    	 
	    	}
	    	System.out.println("enfin");

	return lt;    	
	    }
	 
	 
	 public void Create(Tasks t) {
		 String lien = "http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/Create";
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(lien);
			
			Entity<Tasks> jsonEntity = Entity.json(t);
			Invocation.Builder builder = target.request();
			Response message = builder.post(jsonEntity);
			System.out.println("t'ajoutettt");

			
			
			
		}
	 
	 public void Delete(int id) {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://cloudfinal-env.fyvmsnjpxm.eu-west-1.elasticbeanstalk.com/api/Taskss/"+id);
			
			Invocation.Builder invocationBuilder =  target.request();
	    	Response response = invocationBuilder.delete();
			
			 System.out.println("LOG DELETED"+response.getStatus());	
			String result=response.readEntity(String.class);
			System.out.println("XXXXXXXXXXX:"+result);
			
			
			System.out.println("tfas5et");
			
		}

}
