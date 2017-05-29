package com.riktek.domain;

import org.springframework.data.annotation.Id;

public class DataEntity
{
	@Id
	private String id;
	private int entityType;
	private String designation;
	
	public DataEntity(int t, String s)
	{
		entityType = t;
		designation = s;
	}
}