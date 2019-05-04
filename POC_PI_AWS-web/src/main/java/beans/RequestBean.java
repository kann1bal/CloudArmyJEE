package beans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import RestConsomation.RequestConsomation;
import entities.Request;





@ManagedBean
@SessionScoped
public class RequestBean {
	private List<Request> requests = new ArrayList<Request>();
	
	
	
	private int RequestId;
	private String Name;
	private Request.Kind Kind;
	private Request.Status Status;
	private Request.Category Category;
	private Request.Priority Priority;
	private String Subject;
	private String UserCreate;
	private String UpdatedBy;
	
	
	private int Id;
	private Date UpdateDate;


	private int ProjectId; 
	@EJB
	private RequestConsomation dcr;
	
	
	public List<Request> getRequests() {
		requests = dcr.consomation();
		return requests;
	}	
	

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@PostConstruct
	public void init() {
		requests = dcr.consomation();
	}
	


public int getRequestId() {
	return RequestId;
}


public void setRequestId(int requestId) {
	RequestId = requestId;
}


public String getName() {
	return Name;
}


public void setName(String name) {
	Name = name;
}


public Request.Kind getKind() {
	return Kind;
}


public void setKind(Request.Kind kind) {
	Kind = kind;
}


public String getSubject() {
	return Subject;
}


public void setSubject(String subject) {
	Subject = subject;
}


public String getUserCreate() {
	return UserCreate;
}


public void setUserCreate(String userCreate) {
	UserCreate = userCreate;
}


public String getUpdatedBy() {
	return UpdatedBy;
}


public void setUpdatedBy(String updatedBy) {
	UpdatedBy = updatedBy;
}


public int getId() {
	return Id;
}


public void setId(int id) {
	Id = id;
}


public Date getUpdateDate() {
	return UpdateDate;
}


public void setUpdateDate(Date updateDate) {
	UpdateDate = updateDate;
}


public int getProjectId() {
	return ProjectId;
}


public void setProjectId(int projectId) {
	ProjectId = projectId;
}


public RequestConsomation getDcr() {
	return dcr;
}


public void setDcr(RequestConsomation dcr) {
	this.dcr = dcr;
}


public Request.Status getStatus() {
	return Status;
}


public void setStatus(Request.Status status) {
	Status = status;
}


public Request.Category getCategory() {
	return Category;
}


public void setCategory(Request.Category category) {
	Category = category;
}


public Request.Priority getPriority() {
	return Priority;
}


public void setPriority(Request.Priority priority) {
	Priority = priority;
} 



	
}
