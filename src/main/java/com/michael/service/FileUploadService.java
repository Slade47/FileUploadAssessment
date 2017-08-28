package com.michael.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public void saveFileToDirectory(List<MultipartFile> uploadfiles) throws IOException;
	public void saveMetadataToDB(List<MultipartFile> uploadfiles, String description);

}
