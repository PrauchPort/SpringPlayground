package com.apress.todo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepository implements CommonRepository<ToDo>{

	Map<String, ToDo> todos = new HashMap<String, ToDo>();
	
	@Override
	public ToDo save(ToDo domain) {
		if(todos.get(domain.getId()) != null)
		{
			todos.remove(domain.getId());
		}
		todos.put(domain.getId(), domain);
		return domain;
	}

	@Override
	public Iterable<ToDo> save(Collection<ToDo> collection) {
		collection.forEach(this::save);
		
		return findAll();
	}

	@Override
	public ToDo findByID(String id) {
		return todos.get(id);
	}

	@Override
	public ToDo delete(String id) {
		return todos.remove(id);
	}

	@Override
	public Iterable<ToDo> findAll() {
		return todos.values().stream().collect(Collectors.toList());
	}
	
	
	

}
