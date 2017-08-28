package com.michael.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import com.michael.service.FileUploadServiceImpl;

/**
 * @author Michael Fan
 * develop a unit test for the saving file to directory method of service layer
 */
public class SaveFileToDirectoryTest {
	private FileUploadServiceImpl fileUploadServiceImpl;
	private String directory="D://TestUpload//";//this is the directory where we save our files
	private Path path;
	private MockMultipartFile file;
	
	@Before
	public void setUp(){
		fileUploadServiceImpl=new FileUploadServiceImpl();
		path=Paths.get(directory);
		
		//generate a mock multipartfile for this test, which contains only plain text
		file = new MockMultipartFile("files", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello!".getBytes());
	}
	
	@Test
	public void saveFileTest() throws Exception{
		fileUploadServiceImpl.saveFileToDirectory(Arrays.asList(file));
		
		//test if this file is successfully created
		assertThat(path.resolve("hello.txt")).exists();
		
	}
	
	//delete that test file after we finish our test
	@After
	public void tearDown(){
        File file = new File(directory+this.file.getOriginalFilename());

        if(file.delete())
        {
            System.out.println("Test file is deleted successfully");
        }
        else
        {
            System.out.println("Sorry! Failed to delete test file");
        }
	}

}
