package com.michael.hibernate.repository;

import org.springframework.data.repository.CrudRepository;

import com.michael.entity.UploadFileEntity;

/**
 * @author Michael Fan
 * Define a customized repository for UploadFile, 
 * which extends CrudRepository in Spring framework and utilize its powerful CRUD methods
 */
public interface UploadFileEntityRepository extends CrudRepository<UploadFileEntity, String>{

}
