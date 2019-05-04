package beans;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import entities.Request.Category;
import entities.Request.Kind;
import entities.Request.Priority;
import entities.Request.Status;



@ManagedBean
@ApplicationScoped
public class Data {
	
	public Category[] getCategory(){
		return Category.values();
		
	}
	
	public Priority[] getPriority(){
		return Priority.values();
		
	}
	
	public Kind[] getKind(){
		return Kind.values();
		
	}
	
	public Status[] getStatus(){
		return Status.values();
		
	}


}
