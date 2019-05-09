package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

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
	 private Part file;
	 private boolean upladed;
	 

	
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
				
			Documents = dcr.consomation();
		}
		public void doAddDocument()throws IOException {
			
			InputStream in=file.getInputStream();

			System.out.println("xxxxxxxxxxxxx:  "+file.getSubmittedFileName());
			imageUrl=file.getSubmittedFileName();		
			String d =imageUrl;
			d.replace("\\", File.separator);
			String a=d.substring(imageUrl.lastIndexOf(File.separator)+1);
			System.out.println(a);
			imageUrl=a;
		
				
			File f =new File("C:/Users/Med Zied/Desktop/CloudArmy/git/MAP.Presentation/Content/Upload/"+a);
			f.createNewFile();
			FileOutputStream out=new FileOutputStream(f);

            byte[] buffer=new byte[1024];

            int length;
            while((length=in.read(buffer))>0){

                out.write(buffer, 0, length);

            }

            out.close();
            in.close();
   

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());

            upladed=true;
            
			dcr.Create(new Documentt(name,size,imageUrl,projectId));
			Documents = dcr.consomation();


		}
		
		public void doUpDocument(int id) {

			dcr.Update(new Documentt(name,size,imageUrl,projectId),id);
			Documents = dcr.consomation();
		}
		
		
		
		public void modifier(Documentt e){
			
			
			
			this.setDocumentId(e.getDocumentId());
			this.setName(e.getName());
			this.setSize(e.getSize());
			this.setImageUrl(e.getImageUrl());
			this.setProjectId(e.getProjectId());
		
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("UpdateDoc.jsf");
			} catch (IOException r) {
				// TODO Auto-generated catch block
				r.printStackTrace();
			}
			
		}
		
		
		 public void postProcessXLS(Object document) {
		        HSSFWorkbook wb = (HSSFWorkbook) document;
		        HSSFSheet sheet = wb.getSheetAt(0);
		        CellStyle style = wb.createCellStyle();
		        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		 
		        for (Row row : sheet) {
		            for (Cell cell : row) {
		                cell.setCellValue(cell.getStringCellValue().toUpperCase());
		                cell.setCellStyle(style);
		            }
		        }
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

		public Part getFile() {
			return file;
		}

		public void setFile(Part file) {
			this.file = file;
		}
		
		

}
