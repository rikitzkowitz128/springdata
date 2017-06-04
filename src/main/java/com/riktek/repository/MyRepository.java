package com.riktek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.riktek.repository.MyRepositoryExtended;
import com.riktek.repository.dto.ScifiProfileDTO;

import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MyRepository extends MongoRepository<ScifiProfileDTO, String>,MyRepositoryExtended
{
	public ScifiProfileDTO findByEntityType(int entityType);
    public List<ScifiProfileDTO> findByDesignation(String designation);
    
    @Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
    List<ScifiProfileDTO> findProfileBetweenAges(int ageGT, int ageLT);
    //public Optional<ScifiProfileDTO> findOneOptional(String id);
   
}