package com.michael.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.michael.entity.UploadFileEntity;
import com.michael.hibernate.dao.UploadFileEntityDaoImpl;

/**
 * @author Michael Fan
 *	implement the file upload service; 
 *	save the file to a certain directory and save meta data of the file to database as well;
 */
@Service
public class FileUploadServiceImpl implements FileUploadService{
	  
	@Autowired
	UploadFileEntityDaoImpl uploadFileEntityDaoImpl;

	    //Save the file to this folder, the directory may be altered according to runtime environment
	    private static String FileDirectory = "D://TestUpload//";
	    
	    // Save files to the predefined directory
	    @Override
	    public void saveFileToDirectory(List<MultipartFile> uploadfiles) throws IOException {

	        for (MultipartFile file : uploadfiles) {
	            if (file.isEmpty()) 
	                continue;
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(FileDirectory + file.getOriginalFilename());
	            Files.write(path, bytes);
	        }

	    }
	    

	    // call on the save meta data method of UploadFileEntityDaoImpl to save it to database
		@Override
		public void saveMetadataToDB(List<MultipartFile> uploadfiles, String description) {
			for (MultipartFile file : uploadfiles) {
				
				//create the meta data entity first
			 UploadFileEntity fileEntity=new UploadFileEntity();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
	            fileEntity.setFileName(file.getOriginalFilename());
	            fileEntity.setFileDescription(description);
	            fileEntity.setDateUploaded(date);
	            // save the entity to database
	            uploadFileEntityDaoImpl.saveFileMetadata(fileEntity);
			}
		}

}
