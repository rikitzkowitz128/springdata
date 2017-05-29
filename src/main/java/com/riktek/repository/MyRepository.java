package com.riktek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.riktek.domain.DataEntity;
import java.util.List;

@EnableMongoRepositories
public interface MyRepository extends MongoRepository<DataEntity, String>
{
	public DataEntity findByEntityType(int entityType);
    public List<DataEntity> findByDesignation(String designation);
}