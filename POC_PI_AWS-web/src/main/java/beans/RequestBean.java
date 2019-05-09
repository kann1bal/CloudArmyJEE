package beans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import RestConsomation.RequestConsomation;
import entities.Request;




@ManagedBean
@SessionScoped
public class RequestBean {
	private List<Request> requests = new ArrayList<Request>();
	private List<Request> requestsnot = new ArrayList<Request>();
	
	
	
	private int RequestId;
	private String Name;
	private Request.Kind Kind;
	private Request.Status Status;
	private Request.Category Category;
	private Request.Priority Priority;
	private String Subject;
	private String UserCreate;
	private String UpdatedBy;
	private String header;
	private String title;
	private String mailAdress;
	
	
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
	
	public List<Request> getRequestsnot() {
		requestsnot = dcr.consomation1();
		return requestsnot;
	}	
	

	public void setRequestsnot(List<Request> requestsnot) {
		this.requestsnot = requestsnot;
	}

	@PostConstruct
	public void init() {
		requests = dcr.consomation();
		requestsnot = dcr.consomation1();
		
	}
	


public int getRequestId() {
	return RequestId;
}


public void setRequestId(int requestId) {
	RequestId = requestId;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getHeader() {
	return header;
}


public void setHeader(String header) {
	this.header = header;
}


public String getMailAdress() {
	return mailAdress;
}


public void setMailAdress(String mailAdress) {
	this.mailAdress = mailAdress;
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


public String addRequest(){
String navigateTo = "null";
dcr.ajouterRequest(new Request(Name, Category, Priority,Status, Subject, UserCreate, "null",
		 1, 1,UpdateDate,false));
navigateTo ="ListRequest?faces-redirect=true";

return navigateTo;
		
		}

public  String supprimer(Integer id){
String navigateTo = "null";
dcr.deleteRequest(id);
navigateTo ="ListRequest?faces-redirect=true";

return navigateTo;

}

public void modifier(Request e){
	this.setRequestId(e.getRequestId());
this.setStatus(e.getStatus());
this.setName(e.getName());


try {
	FacesContext.getCurrentInstance().getExternalContext().redirect("UpdateRequest.jsf");
} catch (IOException r) {
	// TODO Auto-generated catch block
	r.printStackTrace();
}

}




public  String update(Integer id){
String navigateTo = "null";
dcr.updateRequest(new Request(Name, Status,true), id);

navigateTo ="ListRequest?faces-redirect=true";
final String username="ikram.bejaoui@esprit.tn";
final String password="Peaceikram123.";
Properties properties = new Properties();
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.port", "587");


Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(username, password);
	}});

try {
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress("aa@aa.com"));
	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hana.guelleli@esprit.tn"));
	message.setSubject("Request treatment");
	message.setText("Hello, your request has been treated, cordially");
	Transport.send(message);
} catch (MessagingException ex) { throw new RuntimeException(ex);}



return navigateTo;

}

public  String approuver(Request e){
String navigateTo = "null";



System.out.println("req "+e.getName());
dcr.updateRequest(new Request(e.getName(),true), e.getRequestId());

navigateTo ="ListRequest?faces-redirect=true";

return navigateTo;

}





/*public boolean filterByPrice(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString().trim();
    if(filterText == null||filterText.equals("")) {
        return true;
    }
     
    if(value == null) {
        return false;
    }
     
    return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
}
*/
private List<Request> filteredRequests;

public List<Request> getFilteredRequests() {
	return filteredRequests;
}


public void setFilteredRequests(List<Request> filteredRequests) {
	this.filteredRequests = filteredRequests;
}
 

	
}
