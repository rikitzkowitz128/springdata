package com.riktek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.riktek.repository.dto.ScifiProfileDTO;

import java.util.List;
import java.util.Optional;

public interface MyRepository extends MongoRepository<ScifiProfileDTO, String>
{
	public ScifiProfileDTO findByEntityType(int entityType);
    //public List<ScifiProfileDTO> findByDesignation(String designation);
    //public Optional<ScifiProfileDTO> findOneOptional(String id);
   
}