package entities;


import javax.persistence.*;
import java.util.Date;



/**
 * The persistent class for the Arrives database table.
 * 
 */

public class Request  {
	
	   public enum Kind { defect, feature, patch, claim }
	   public enum Status { NotTreatedYet, open, closed }
	   public enum Category { Issues, Administration, Feedback, Security, UI, Code, Tasks, Projects, Documents, Plugins, Notifications, Others }
	   public enum Priority { Low, Normal, High, Urgent }
	


	private int RequestId;


	private String Name;


	private Kind Kind;
	

	private Category Category;

	private Priority Priority;
	

	private Status Status;
	

	private String Subject;
	

	private String UserCreate;
	

	private String UpdatedBy;
	
	

	private int Id;


	private int ProjectId;
	private Date UpdateDate;
	private boolean flag;


	
	
	
	public Request(String name, Category category,
			Priority priority, Status status,
			String subject, String userCreate, String updatedBy, int id, int projectId, Date updateDate, boolean flag) {
		super();
		Name = name;
		Category = category;
		Priority = priority;
		Status = status;
		Subject = subject;
		UserCreate = userCreate;
		UpdatedBy = updatedBy;
		Id = id;
		ProjectId = projectId;
		UpdateDate = updateDate;
		this.flag = flag;
	}

	
	public Request(String name,Status status, boolean flag) {
		super();
		Name = name;
		Status = status;
		this.flag = flag;
	}


	public Request(String name, Kind kind,
			Category category, Priority priority,
			Status status, String subject, String userCreate, String updatedBy,
			int id, int projectId, Date updateDate, boolean flag) {
		super();
		Name = name;
		Kind = kind;
		Category = category;
		Priority = priority;
		Status = status;
		Subject = subject;
		UserCreate = userCreate;
		UpdatedBy = updatedBy;
		Id = id;
		ProjectId = projectId;
		UpdateDate = updateDate;
		this.flag = flag;
	}

	public Request(String name, boolean flag) {
		super();
		Name = name;
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Request(boolean flag) {
		super();
		this.flag = flag;
	}

	public Request(String name,Status status) {
		super();
		Name = name;
		Status = status;
	}

	public Date getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
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

	public Kind getKind() {
		return Kind;
	}

	public void setKind(Kind kind) {
		Kind = kind;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public Priority getPriority() {
		return Priority;
	}

	public void setPriority(Priority priority) {
		Priority = priority;
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
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

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	

	

	@Override
	public String toString() {
		return "Request [RequestId=" + RequestId + ", Name=" + Name + ", Category=" + Category
				+ ", Priority=" + Priority + ", Status=" + Status + ", Subject=" + Subject + ", UserCreate="
				+ UserCreate + ", UpdatedBy=" + UpdatedBy + ", Id=" + Id + ", ProjectId=" + ProjectId + ", UpdateDate="
				+ UpdateDate + "]";
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Request(String name,Kind kind,
			Category category, Priority priority,
			Status status, String subject, String userCreate, String updatedBy,
			int id, int projectId, Date updateDate) {
		super();
		Name = name;
		Kind = kind;
		Category = category;
		Priority = priority;
		Status = status;
		Subject = subject;
		UserCreate = userCreate;
		UpdatedBy = updatedBy;
		Id = id;
		ProjectId = projectId;
		UpdateDate = updateDate;
	}

	

	public Request(int requestId, String name, Kind kind,
			Category category, Priority priority,
			Status status, String subject, String userCreate, String updatedBy,
			int id, int projectId, Date updateDate) {
		super();
		RequestId = requestId;
		Name = name;
		Kind = kind;
		Category = category;
		Priority = priority;
		Status = status;
		Subject = subject;
		UserCreate = userCreate;
		UpdatedBy = updatedBy;
		Id = id;
		ProjectId = projectId;
		UpdateDate = updateDate;
	}

	public Request(Status status) {
		super();
		Status = status;
	}

	public Request(String name, Kind kind,
			Category category, Priority priority,
			Status status, String subject, String userCreate, int id, int projectId,
			Date updateDate, boolean flag) {
		super();
		Name = name;
		Kind = kind;
		Category = category;
		Priority = priority;
		Status = status;
		Subject = subject;
		UserCreate = userCreate;
		Id = id;
		ProjectId = projectId;
		UpdateDate = updateDate;
		this.flag = flag;
	}

	
	

	
	

	
	
	
	
}


