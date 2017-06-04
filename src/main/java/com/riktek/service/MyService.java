package com.riktek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.riktek.repository.MyRepository;

import com.riktek.repository.dto.ScifiProfileDTO;
import com.riktek.controller.dto.ScifiProfileRESTDTO;
import com.riktek.domain.ScifiProfile;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;;

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
		profile.setAge(234);
		profile.setEntityType(1);
		repository.save(profile);
		
		profile = new ScifiProfileDTO();
		profile.setDesignation("Minbari");
		profile.setAge(97);
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
        Optional<ScifiProfileDTO> deleted = findProfileById(id);
        repository.delete(deleted.get());
        ScifiProfile domainObjectOut = getDomainObjectFor(deleted.get());
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
    
    public List<ScifiProfileRESTDTO> findProfileBetweenAges(int ageGT, int ageLT)
    {
    	List<ScifiProfileDTO> profileDTOEntries = repository.findProfileBetweenAges(ageGT, ageLT);
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
        Optional <ScifiProfileDTO> found = findProfileById(id);
        ScifiProfile domainObjectOut = getDomainObjectFor(found.get());
        ScifiProfileRESTDTO restObjectOut = getRESTDTOObjectFor(domainObjectOut);
        return restObjectOut;
    }
 
    public ScifiProfileRESTDTO update(ScifiProfileRESTDTO profile) 
    {
        Optional <ScifiProfileDTO> updated = findProfileById(profile.getId());
        ScifiProfileDTO updatedObject = updated.get();
        updatedObject.update(profile.getEntityType(), profile.getDesignation());
        updatedObject = repository.save(updated.get());
        ScifiProfile domainObjectOut = getDomainObjectFor(updatedObject);
        ScifiProfileRESTDTO returnObject = getRESTDTOObjectFor(domainObjectOut);
        
        return returnObject;
    }
 
    private Optional<ScifiProfileDTO> findProfileById(String id) 
    {
    	Optional<ScifiProfileDTO> resultA = repository.findOneOptional(id);
    	//ScifiProfileDTO result = repository.findOne(id);
    	resultA.orElseThrow( IllegalStateException::new );
        return resultA;
    }
    
    
    private ScifiProfile getDomainObjectFor(ScifiProfileDTO fromObj)
    {
    	ScifiProfile toObj = new ScifiProfile();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	toObj.setAge(fromObj.getAge());
    	return toObj;
    }
    
    private ScifiProfile getDomainObjectFor(ScifiProfileRESTDTO fromObj)
    {
    	ScifiProfile toObj = new ScifiProfile();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	toObj.setAge(fromObj.getAge());
    	return toObj;
    }
    
    //
    private ScifiProfileDTO getDTOObjectFor(ScifiProfile fromObj)
    {
    	ScifiProfileDTO toObj = new ScifiProfileDTO();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	toObj.setAge(fromObj.getAge());
    	return toObj;
    }
    
    //
    private ScifiProfileRESTDTO getRESTDTOObjectFor(ScifiProfile fromObj)
    {
    	ScifiProfileRESTDTO toObj = new ScifiProfileRESTDTO();
    	toObj.setDesignation(fromObj.getDesignation());
    	toObj.setEntityType(fromObj.getEntityType());
    	toObj.setAge(fromObj.getAge());
    	return toObj;
    }
 
}