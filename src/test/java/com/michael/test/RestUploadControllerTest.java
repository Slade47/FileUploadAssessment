package com.michael.test;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.michael.controller.RestUploadController;
import com.michael.service.FileUploadServiceImpl;

/**
 * @author Michael Fan
 * develop a unit test using JUnit and Mockito to test our upload controller
 */
public class RestUploadControllerTest {
	
	private MockMvc mockMvc;
	private String fileDescription;
	
	//create mock object for the service we are gonna inject in the controller
	@Mock
	private FileUploadServiceImpl fileUploadServiceImpl;
	
	@InjectMocks
	private RestUploadController restUploadController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		fileDescription="test";
		
		//create an instance of MockMVC using standaloneSetup, 
		//it will register the upload controller for us to test
		this.mockMvc = MockMvcBuilders.standaloneSetup(restUploadController).build();
	}
	
	@Test
	public void testRestUploadController() throws Exception {
		
		//generate a mock multipartfile for our test
		MockMultipartFile file = new MockMultipartFile("files", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello!".getBytes());
		
		//define the behavior of our upload service mock object
		doNothing().when(fileUploadServiceImpl).saveFileToDirectory(Arrays.asList(file));
		doNothing().when(fileUploadServiceImpl).saveMetadataToDB(Arrays.asList(file), fileDescription);
		
		//make a request call to our upload controller using the fileUpload method and parse the test file as parameter
		mockMvc.perform(fileUpload("/upload").file(file).param("fileDescription", fileDescription)).andDo(print()).andExpect(status().isOk());
	}

}
