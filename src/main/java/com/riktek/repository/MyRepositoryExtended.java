package com.riktek.repository;

import java.util.List;
import java.util.Optional;


import com.riktek.repository.dto.ScifiProfileDTO;

public interface MyRepositoryExtended
{
	
    
	
    public Optional<ScifiProfileDTO> findOneOptional(String id);
    /*
    {
    	Optional<ScifiProfileDTO> profile = findOne(id);
    }*/
    
}