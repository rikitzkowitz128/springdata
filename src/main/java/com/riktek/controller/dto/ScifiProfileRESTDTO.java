package com.riktek.controller.dto;

import lombok.Getter;
import lombok.Setter;

public class ScifiProfileRESTDTO
{
	@Getter private String id;
	@Getter @Setter private int entityType;
	@Getter @Setter private int age;
	@Getter @Setter private String designation;
	
	
	public void update(int t, String s)
	{
		entityType = t;
		designation = s;
	}
}