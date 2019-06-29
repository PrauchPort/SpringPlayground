package com.apress.todo;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ToDo {

	@NotNull
	private String id;
	@NotNull
	@NotBlank
	private String description;
	private LocalDateTime dateModified;
	private LocalDateTime dateCreated;
	private boolean isDone;
	
	public ToDo()
	{
		LocalDateTime dateTime = LocalDateTime.now();
		
		this.id = UUID.randomUUID().toString();
		this.isDone = false;
		dateModified = dateTime;
		dateCreated = dateTime;
		
	}
	
	public ToDo(String description)
	{
		this();
		this.description = description;
	}
	
}
