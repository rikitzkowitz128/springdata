package com.riktek.domain;


public class ScifiProfile
{
	private String id;
	private int entityType;
	private String designation;
	
	public ScifiProfile(int t, String s)
	{
		entityType = t;
		designation = s;
	}
}