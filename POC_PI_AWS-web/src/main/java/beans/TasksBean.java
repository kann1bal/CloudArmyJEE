package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import RestConsomation.TasksConsomation;
import entities.Tasks;
import entities.Tasks.Complexity;
import entities.Tasks.IsDone;
import entities.Tasks.Progress;
import entities.Tasks.Statuss;





@ManagedBean
@SessionScoped
public class TasksBean {
	
	private List<Tasks> tasks = new ArrayList<Tasks>();
	private String Description;
	private Date startDate ;
	private double SpentTime;
	private Date deadline;
	private Complexity complexity;
	private Statuss statuss;
	private IsDone isDone;
	private Progress progress;
	private String estimation;
	
	@EJB
	private TasksConsomation tc;

	
	
	public String getEstimation() {
		return estimation;
	}



	public void setEstimation(String estimation) {
		this.estimation = estimation;
	}



	public Complexity getComplexity() {
		return complexity;
	}



	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}



	public Statuss getStatuss() {
		return statuss;
	}



	public void setStatuss(Statuss statuss) {
		this.statuss = statuss;
	}



	public IsDone getIsDone() {
		return isDone;
	}



	public void setIsDone(IsDone isDone) {
		this.isDone = isDone;
	}



	public Progress getProgress() {
		return progress;
	}



	public void setProgress(Progress progress) {
		this.progress = progress;
	}



	public TasksConsomation getTc() {
		return tc;
	}



	public void setTc(TasksConsomation tc) {
		this.tc = tc;
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



	
	
	public List<Tasks> getTasks() {
		tasks = tc.consomation();
		return tasks;
	}



	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}



	@PostConstruct
	public void init() {
		tasks = tc.consomation();
	}
	/*public String addMeeting(){
		String navigateTo ="null";
		dcr.ajouterMeeting(new Meeting(Title, Date, Details, 1,1, false));
		navigateTo ="/template/ApprouverMeeting?faces-redirect=true";
		return navigateTo;
		
			}*/
	public String AddTask() {
		String navigateTo ="null";
		tc.Create(new Tasks(Description, startDate, deadline, complexity, estimation));
		navigateTo ="ListTasks?faces-redirect=true";
		return navigateTo;


	}
	
	public String Delete(int id){
		String navigateTo ="null";
		tc.Delete(id);
		navigateTo ="ListTasks?faces-redirect=true";
		return navigateTo;
	}

}
