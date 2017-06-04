package com.riktek.repository.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "scifiprofiles")
public class ScifiProfileDTO
{
	@Id
	@Getter private String id;
	@Getter @Setter private int entityType;
	@Getter @Setter private String designation;
	
	
	public void update(int t, String s)
	{
		entityType = t;
		designation = s;
	}
}