	package entities;



public class Documentt {

 private int DocumentId ;
 private String DateDoc ;
 private String Name ;
 private String Size ;
 private String ImageUrl; 
 private FileType FileType ;
 private int ProjectId;
 private String Extension ;
 private String ProjectName;

	 public int getProjectId() {
	return ProjectId;
}


public Documentt(String name, String size, String imageUrl, int projectId) {
		super();
		Name = name;
		Size = size;
		ImageUrl = imageUrl;
		ProjectId = projectId;
	}


public void setProjectId(int projectId) {
	ProjectId = projectId;
}

	public enum FileType {    
		 Pdf,
	     Doc,
	     Images}
 
	 
	 
 
 public Documentt(int documentId, String dateDoc, String name, String size, String imageUrl,
			entities.Documentt.FileType fileType) {
		super();
		DocumentId = documentId;
		DateDoc = dateDoc;
		Name = name;
		Size = size;
		ImageUrl = imageUrl;
		FileType = fileType;
	}
 

public Documentt() {
	super();
}



public String getExtension() {
	return Extension;
}


public void setExtension(String extension) {
	Extension = extension;
}


public String getProjectName() {
	return ProjectName;
}


public void setProjectName(String projectName) {
	ProjectName = projectName;
}


@Override
public String toString() {
	return "Documentt [DocumentId=" + DocumentId + ", DateDoc=" + DateDoc + ", Name=" + Name + ", Size=" + Size
			+ ", ImageUrl=" + ImageUrl + ", FileType=" + FileType + "]";
}


public int getDocumentId() {
	return DocumentId;
}

public void setDocumentId(int documentId) {
	DocumentId = documentId;
}

public String getDateDoc() {
	return DateDoc;
}

public void setDateDoc(String dateDoc) {
	DateDoc = dateDoc;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getSize() {
	return Size;
}

public void setSize(String size) {
	Size = size;
}

public String getImageUrl() {
	return ImageUrl;
}

public void setImageUrl(String imageUrl) {
	ImageUrl = imageUrl;
}

public FileType getFileType() {
	return FileType;
}

public void setFileType(FileType fileType) {
	FileType = fileType;
}



}

