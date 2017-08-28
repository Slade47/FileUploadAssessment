package com.michael.hibernate.dao;

import com.michael.entity.UploadFileEntity;

/**
 * @author Michael Fan
 * Define an interface for the dao of UploadFileEntity 
 * and define a save method to store meta data of a file to database
 */
public interface UploadFileEntityDao {
	public void saveFileMetadata(UploadFileEntity fileEntity);
	public UploadFileEntity selectMetadata(String filename);

}
