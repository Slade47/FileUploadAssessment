package com.michael.hibernate.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.michael.entity.UploadFileEntity;
import com.michael.hibernate.repository.UploadFileEntityRepository;

/**
 * @author Michael Fan
 *  Implement the dao for UploadFileEntity, 
 *  use a customized repository to save the meta data of a file to database
 */
@Component
public class UploadFileEntityDaoImpl implements UploadFileEntityDao {
	
	@Autowired
	UploadFileEntityRepository uploadFileEntityRepository;
	
	//call on the save method of UploadFileEntityRepository and save data
	@Override
	public void saveFileMetadata(UploadFileEntity fileEntity){
		uploadFileEntityRepository.save(fileEntity);
	}
	
	//select the meta data of a file from database by its filename
	@Override
	public UploadFileEntity selectMetadata(String filename){
		return uploadFileEntityRepository.findOne(filename);

	}
	
}
