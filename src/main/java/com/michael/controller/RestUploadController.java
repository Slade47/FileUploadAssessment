package com.michael.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.michael.service.FileUploadServiceImpl;
import java.util.Arrays;


/**
 * @author Michael Fan
 *	define a rest controller to call upload services and perform the upload operation
 */
@RestController
public class RestUploadController {
	
	@Autowired
	FileUploadServiceImpl fileUploadServiceImpl;

	//get a logger
    private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);
    
    // upload files
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public ResponseEntity<?> uploadFileMulti(
            @RequestParam(value="fileDescription",required=false) String description,
            @RequestParam("files") MultipartFile uploadfile) {

        logger.debug("Upload file!");

        if (uploadfile.isEmpty()) {
        	// return the warning message if not file is carried in the request
            return new ResponseEntity<>("Sorry, no file is selected", HttpStatus.OK);
        }

        try {
        	//call the upload service to upload a file 
        	fileUploadServiceImpl.saveFileToDirectory(Arrays.asList(uploadfile));
        	fileUploadServiceImpl.saveMetadataToDB(Arrays.asList(uploadfile),description);
       
        } catch (Exception exception) {
        	// return error code if the request is not properly formatted and exceptions occurred
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // return success message if the upload operation is performed successfully 
        return new ResponseEntity<>("File "+ uploadfile.getOriginalFilename()+" uploaded successfully ", HttpStatus.OK);

    }

}
