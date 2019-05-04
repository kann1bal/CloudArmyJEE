package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import RestConsomation.DocumentConsomation;
import entities.Documentt;
import entities.Documentt.FileType;
@ManagedBean
@SessionScoped
public class DocumentBean {
	
	
	 private int documentId ;
	 private String dateDoc ;
	 private String name ;
	 private String size ;
	 private String imageUrl; 
	 private FileType fileType ;
	 private int projectId;
	 private String extension ;
	 private String projectName;

	
		private List<Documentt> Documents = new ArrayList<Documentt>();
		
		@EJB
		private DocumentConsomation dcr;
		
		
		public List<Documentt> getDocuments() {
			return Documents;
		}

		public void setDocuments(List<Documentt> Documents) {
			this.Documents = Documents;
		}

		@PostConstruct
		public void init() {
			//dcr.Create(new Documentt("amine","med","path image",2));
				Documentt d =new Documentt("Update","Update","Update",2);
			dcr.Update(d,42);
			Documents = dcr.consomation();
		}
		public void doAddDocument() {

			dcr.Create(new Documentt(name,size,imageUrl,projectId));
			Documents = dcr.consomation();


		}
		public void doUpDocument() {

			dcr.Update(new Documentt(name,size,imageUrl,projectId),documentId);
			Documents = dcr.consomation();
		}

		public int getDocumentId() {
			return documentId;
		}

		public void setDocumentId(int documentId) {
			this.documentId = documentId;
		}

		public String getDateDoc() {
			return dateDoc;
		}

		public void setDateDoc(String dateDoc) {
			this.dateDoc = dateDoc;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public FileType getFileType() {
			return fileType;
		}

		public void setFileType(FileType fileType) {
			this.fileType = fileType;
		}

		public int getProjectId() {
			return projectId;
		}

		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public DocumentConsomation getDcr() {
			return dcr;
		}

		public void setDcr(DocumentConsomation dcr) {
			this.dcr = dcr;
		}
		

}
