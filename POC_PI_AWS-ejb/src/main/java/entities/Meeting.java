package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



public class Meeting {
	

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

	public Meeting(int meetingId, String title, java.util.Date date, String details, int id, int projectId) {
		super();
		MeetingId = meetingId;
		Title = title;
		Date = date;
		Details = details;
		Id = id;
		ProjectId = projectId;
	}

	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meeting(String title2, String details2, int i, int j) {
		super();
		Title = title2;
		Details = details2;
		Id = i;
		ProjectId = j;
	}

	@Override
	public String toString() {
		return "Meeting [MeetingId=" + MeetingId + ", Title=" + Title + ", Date=" + Date + ", Details=" + Details
				+ ", Id=" + Id + ", ProjectId=" + ProjectId + "]";
	}

	
	
	
	
	


	

	

}