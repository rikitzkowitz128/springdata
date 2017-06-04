package com.riktek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.riktek.repository.MyRepository;

import com.riktek.repository.dto.ScifiProfileDTO;
import com.riktek.controller.dto.ScifiProfileRESTDTO;
import com.riktek.domain.ScifiProfile;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class MyService
{
	@Autowired
	private MyRepository repository;
	
	public void printMessage()
	{
		System.out.println("Goodbye Texas, Hello California!");
	}
	
	public String getMessage()
	{
		return("Goodbye Texas, Hello California!");
	}
	
	public void resetData()
	{
		clean();
	}
	
	public void seedData()
	{
		seed();
	}
	
	private void clean()
	{
		repository.deleteAll();
	}
	
	private void seed()
	{
		ScifiProfileDTO profile = new ScifiProfileDTO();
		profile.setDesignation("Vorlon");
		profile.setEntityType(1);
		repository.save(profile);
		
		profile = new ScifiProfileDTO();
		profile.setDesignation("Minbari");
		profile.setEntityType(1);
		repository.save(profile);
		
	}
	
    public ScifiProfileRESTDTO create(ScifiProfileRESTDTO profile)
    {
    	ScifiProfile domainObjectIn = getDomainObjectFor(profile);
    	ScifiProfileDTO dtoObject = getDTOObjectFor(domainObjectIn);
        ScifiProfileDTO persisted = repository.save(dtoObject);
        ScifiProfile domainObjectOut = getDomainObjectFor(persisted);
        ScifiProfileRESTDTO returnObject = getRESTDTOObjectFor(domainObjectOut);
        return returnObject;
    }
 
    public ScifiProfileRESTDTO delete(String id) 
    {
        ScifiProfileDTO deleted = findProfileById(id);
        repository.delete(deleted);
        ScifiProfile domainObjectOut = getDomainObjectFor(deleted);
        ScifiProfileRESTDTO returnObject = getRESTDTOObjectFor(domainObjectOut);
        return returnObject;
    }
 
    public List<ScifiProfileRESTDTO> findAll()
    {
    	
        List<ScifiProfileDTO> profileDTOEntries = repository.findAll();
        List<ScifiProfileRESTDTO> profileRESTEntries = new ArrayList<ScifiProfileRESTDTO>();
       
        for(ScifiProfileDTO dtoObject : profileDTOEntries)
        {
        	ScifiProfile object = getDomainObjectFor(dtoObject);
        	ScifiProfileRESTDTO restObject = getRESTDTOObjectFor(object);
        	profileRESTEntries.add(restObject);
        }
        return profileRESTEntries;
    }
 
 
    public ScifiProfileRESTDTO findById(String id) 
    {
        ScifiProfileDTO found = findProfileById(id);
        ScifiProfile domainObjectOut = getDomainObjectFor(found);
        ScifiProfileRESTDTO restObjectOut = getRESTDTOObjectFor(domainObjectOut);
        return restObjectOut;
    }
 
    public ScifiProfileRESTDTO update(ScifiProfileRESTDTO profile) 
    {
        ScifiProfileDTO updated = findProfileById(profile.getId());
        
        updated.update(profile.getEntityType(), profile.getDesignation());
        updated = repository.save(updated);
        ScifiProfile domainObjectOut = getDomainObjectFor(updated);
        ScifiProfileRESTDTO returnObject = getRESTDTOObjectFor(domainObjectOut);
        
        return returnObject;
    }
 
    private ScifiProfileDTO findProfileById(String id) 
    {
    	ScifiProfileDTO result = repository.findOne(id);
        return result;
    }
    
    
    private ScifiProfile getDomainObjectFor(ScifiProfileDTO fromObj)
    {
    	ScifiProfile toObj = new ScifiProfile();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	return toObj;
    }
    
    private ScifiProfile getDomainObjectFor(ScifiProfileRESTDTO fromObj)
    {
    	ScifiProfile toObj = new ScifiProfile();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	return toObj;
    }
    
    //
    private ScifiProfileDTO getDTOObjectFor(ScifiProfile fromObj)
    {
    	ScifiProfileDTO toObj = new ScifiProfileDTO();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	return toObj;
    }
    
    //
    private ScifiProfileRESTDTO getRESTDTOObjectFor(ScifiProfile fromObj)
    {
    	ScifiProfileRESTDTO toObj = new ScifiProfileRESTDTO();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	return toObj;
    }
 
}