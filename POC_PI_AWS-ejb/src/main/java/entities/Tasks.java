package entities;

import java.util.Date;

public class Tasks {
	
	public enum Complexity { easy, medium, hard }
	public enum Statuss { affected, notAffected, suggested }
	public enum Progress { level0, level1, level2, level3, level4 }
	public enum IsDone { Done, NotDone}
	
	private int taskId;
	private String Description;
	private Date startDate ;
	private double SpentTime;
	private Date deadline;
	private Complexity complexity;
	private float rate;
	private Statuss status;
	private Progress progress;
	private IsDone IsDone;
	private String estimation;
	private int Id;
	private int ProjectId;
	
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public double getSpentTime() {
		return SpentTime;
	}
	public void setSpentTime(double spentTime) {
		SpentTime = spentTime;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Complexity getComplexity() {
		return complexity;
	}
	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Statuss getStatus() {
		return status;
	}
	public void setStatus(Statuss status) {
		this.status = status;
	}
	public Progress getProgress() {
		return progress;
	}
	public void setProgress(Progress progress) {
		this.progress = progress;
	}
	public IsDone getIsDone() {
		return IsDone;
	}
	public void setIsDone(IsDone isDone) {
		IsDone = isDone;
	}
	public String getEstimation() {
		return estimation;
	}
	public void setEstimation(String estimation) {
		this.estimation = estimation;
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
	public Tasks(String description, Date startDate, double spentTime, Date deadline, Complexity complexity, float rate,
			Statuss status, Progress progress, IsDone isDone, String estimation) {
		super();
		Description = description;
		this.startDate = startDate;
		SpentTime = spentTime;
		this.deadline = deadline;
		this.complexity = complexity;
		this.rate = rate;
		this.status = status;
		this.progress = progress;
		IsDone = isDone;
		this.estimation = estimation;
	}
	
	
	public Tasks() {
		super();
	}
	public Tasks(int taskId, String description, Date startDate, double spentTime, Date deadline, Complexity complexity,
			float rate, Statuss status, Progress progress, IsDone isDone, String estimation, int id,
			int projectId) {
		super();
		this.taskId = taskId;
		Description = description;
		this.startDate = startDate;
		SpentTime = spentTime;
		this.deadline = deadline;
		this.complexity = complexity;
		this.rate = rate;
		this.status = status;
		this.progress = progress;
		IsDone = isDone;
		this.estimation = estimation;
		Id = id;
		ProjectId = projectId;
	}
	
	
	public Tasks(String description, Date startDate, double spentTime, Date deadline) {
		super();
		Description = description;
		this.startDate = startDate;
		SpentTime = spentTime;
		this.deadline = deadline;
	}
	public Tasks(String description, Date startDate, double spentTime, Date deadline, Complexity complexity, float rate,
			Statuss status, Progress progress, IsDone isDone, String estimation, int id, int projectId) {
		super();
		Description = description;
		this.startDate = startDate;
		SpentTime = spentTime;
		this.deadline = deadline;
		this.complexity = complexity;
		this.rate = rate;
		this.status = status;
		this.progress = progress;
		IsDone = isDone;
		this.estimation = estimation;
		Id = id;
		ProjectId = projectId;
	}
	@Override
	public String toString() {
		return "Tasks [Description=" + Description + ", startDate=" + startDate + ", SpentTime=" + SpentTime
				+ ", deadline=" + deadline + ", complexity=" + complexity + ", rate=" + rate + ", status=" + status
				+ ", progress=" + progress + ", IsDone=" + IsDone + ", estimation=" + estimation + ", Id=" + Id
				+ ", ProjectId=" + ProjectId + "]";
	}
	
	
	
	

}
