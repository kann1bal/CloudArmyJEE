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

import org.primefaces.model.chart.DonutChartModel;

import RestConsomation.MeetingConsomation;
import entities.Meeting;





@ManagedBean
@SessionScoped
public class MeetingBean {
	private List<Meeting> meetings = new ArrayList<Meeting>();
	private List<Meeting> meetingsnot = new ArrayList<Meeting>();
	
	private int MeetingId;
	private String Title;
	private Date Date;
	private String Details;
	private int Id;
	private int ProjectId;
	
	

	public int getMeetingId() {
		return MeetingId;
	}

	public void setMeetingId(int meetingId) {
		MeetingId = meetingId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
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

	public MeetingConsomation getDcr() {
		return dcr;
	}

	public void setDcr(MeetingConsomation dcr) {
		this.dcr = dcr;
	}

	@EJB
	private MeetingConsomation dcr;
	
	
	public List<Meeting> getMeetings() {
		 meetings = dcr.consomation();		
		return meetings;
	}

	public void setMeetingsnot(List<Meeting> meetingsnot) {
		this.meetingsnot = dcr.consomation1();
	}
	
	public List<Meeting> getMeetingsnot() {
		 meetingsnot = dcr.consomation1();
		return meetingsnot;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = dcr.consomation();
	}

	
	
	
	@PostConstruct
	public void init() {
			meetings = dcr.consomation();
			meetingsnot = dcr.consomation1();
	
			
	}
	
	

	public String addMeeting(){
		String navigateTo ="null";
		dcr.ajouterMeeting(new Meeting(Title, Date, Details, 1,1, false));
		navigateTo ="ListMeeting?faces-redirect=true";
		return navigateTo;
		
			}
	
	public  String supprimer(Integer id){
		String navigateTo ="null";
		dcr.deleteMeeting(id);
		navigateTo ="ListMeeting?faces-redirect=true";
		return navigateTo;
	}
	
	public void modifier(Meeting e){
		
		
		
		this.setMeetingId(e.getMeetingId());
		
		this.setTitle(e.getTitle());
		this.setDate(e.getDate());
		this.setDetails(e.getDetails());
		this.setProjectId(e.getProjectId());
		this.setId(e.getId());
		
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("UpdateMeeting.jsf");
		} catch (IOException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
		
	}
	
	public  String update(Integer id){
		String navigateTo = "null";
		dcr.updateMeeting(new Meeting(Title,Date,Details,1,1,true), id);
		navigateTo ="ListMeeting?faces-redirect=true";
		
		return navigateTo;
		
	}
	
	private List<Meeting> filteredMeetings;



	public List<Meeting> getFilteredMeetings() {
		return filteredMeetings;
	}

	public void setFilteredMeetings(List<Meeting> filteredMeetings) {
		this.filteredMeetings = filteredMeetings;
	}

	public  String approuver(Meeting e){
		String navigateTo = "null";

		dcr.updateMeeting(new Meeting(e.getTitle(), e.getDate(), e.getDetails(), 1,1,true), e.getMeetingId());

		navigateTo ="ListMeeting?faces-redirect=true";

		return navigateTo;

		}
	
	
}
