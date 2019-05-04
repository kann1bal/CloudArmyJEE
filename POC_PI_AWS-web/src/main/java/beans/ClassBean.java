package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import RestConsomation.ProjectConsommation;
import entities.Project;

@ManagedBean
public class ClassBean {
	

	public enum Branche {Net,JEE,Web}

	@EJB
	private ProjectConsommation dcr;
	private static final List<Project> Project = null;
	
	
	private int ProjectId;
	private String Title;
	private String Description;
	private String OutDate;
	private String ImageUrl;
	private  entities.Project.Branche Branche;
	private int Id;
	
	

	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public entities.Project.Branche getBranche() {
		return Branche;
	}
	public void setBranche(entities.Project.Branche branche) {
		Branche = branche;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	public String getOutDate() {
		return OutDate;
	}
	
	
	
	public void setOutDate(String d) {
		OutDate = d;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	

	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	
	public String Ajout(){
		dcr.Add(new Project(ProjectId, Title, Description, OutDate, ImageUrl,Branche, Id));
		return "/Affichage?faces-redirect=true";
	}
	
	public String Update(){
		dcr.Add(new Project(ProjectId, Title, Description, OutDate, ImageUrl,Branche, Id));
		return "/Affichage?faces-redirect=true";
	}
	
	
	
	
	

}
