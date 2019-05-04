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





@ManagedBean
@SessionScoped
public class TasksBean {
	
	private List<Tasks> tasks = new ArrayList<Tasks>();
	private String Description;
	private Date startDate ;
	private double SpentTime;
	private Date deadline;
	
	@EJB
	private TasksConsomation tc;

	
	
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
		return tasks;
	}



	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}



	@PostConstruct
	public void init() {
		tasks = tc.consomation();
	}
	public void AddTask() {

		tc.Create(new Tasks(Description, startDate, SpentTime, deadline));
		tasks = tc.consomation();


	}

}
