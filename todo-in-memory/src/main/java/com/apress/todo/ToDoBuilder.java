package com.apress.todo;

public class ToDoBuilder {

	
	private String id;
	private String description;
	private ToDo todo;
	
	private static ToDoBuilder instance = new ToDoBuilder();
	
	private ToDoBuilder()
	{
		
	}
	
	public static ToDoBuilder getInstance()
	{
		return instance;
	}
	
	public ToDoBuilder createToDo()
	{
		return instance;
	}
	
	public ToDoBuilder withId(String id)
	{
		this.id = id;
		return instance;
	}
	
	public ToDoBuilder withDesc(String description)
	{
		this.description = description;
		return instance;
	}
	
	public ToDo build()
	{
		todo = new ToDo();
		todo.setDescription(description);
		if(id !=null)
			todo.setId(id);
		return todo;
	}
	
	
	
}
