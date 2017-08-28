package com.michael.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Michael Fan
 * define an entity to store the meta data of a file
 * this entity is mapped to database by Hibernate
 */
@Entity(name="uploadfile_table")
public class UploadFileEntity {

	@Id
	@Column(name="FileName")
	private String fileName;
	
	@Column(name="FileDescription")
    private String fileDescription;
    
	@Column(name="UploadedDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUploaded;

    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date date) {
		this.dateUploaded = date;
	}

}
