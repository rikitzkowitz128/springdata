package com.riktek.repository.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scifiprofiles")
public class ScifiProfileDTO
{
	@Id
	private String id;
	private int entityType;
	private String designation;
	
	public ScifiProfileDTO(int t, String s)
	{
		entityType = t;
		designation = s;
	}
}