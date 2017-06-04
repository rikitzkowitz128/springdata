package com.riktek.domain;

import lombok.Getter;
import lombok.Setter;

public class ScifiProfile
{
	@Getter private String id;
	@Getter @Setter private int entityType;
	@Getter @Setter private String designation;
	
}