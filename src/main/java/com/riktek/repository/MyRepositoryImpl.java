package com.riktek.repository;

import com.riktek.repository.MyRepositoryExtended;
import com.riktek.repository.dto.ScifiProfileDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Optional;

public class MyRepositoryImpl implements MyRepositoryExtended
{
	@Autowired
    MongoTemplate mongoTemplate;
	
	public Optional<ScifiProfileDTO> findOneOptional(String id)
    {
    	//System.out.println("MyRepositoryImpl findOneOptional 1");
    	Query query = new Query(Criteria.where("id").is(id));
    	
    	ScifiProfileDTO profile = mongoTemplate.findById(id, ScifiProfileDTO.class);
    	//ScifiProfileDTO profile = findOne(id);
    	//System.out.println("MyRepositoryImpl findOneOptional 2 "+ profile.toString());
    	Optional<ScifiProfileDTO> profileReturned = Optional.ofNullable(profile);//findOne(id);
    	return profileReturned;
    }
}