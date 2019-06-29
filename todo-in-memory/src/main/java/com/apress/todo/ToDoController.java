package com.apress.todo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class ToDoController {

	private CommonRepository<ToDo> repository;

	@Autowired
	public ToDoController(CommonRepository<ToDo> repository) {
		this.repository = repository;
	}
	
	@GetMapping("/todo")
	public ResponseEntity<Iterable<ToDo>> getToDos()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PatchMapping("/todo/{id}")
	public ResponseEntity<ToDo> setCompleted(@PathVariable String id)
	{
		ToDo result = repository.findByID(id);
		result.setDone(true);
		repository.save(result);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(result.getId()).toUri();
				return ResponseEntity.ok().header("Location",location.toString()).
				build();
	}
	
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<ToDo> deleteToDo(@PathVariable String id){
		repository.delete(ToDoBuilder.create().withId(id).build());
		return ResponseEntity.noContent().build();
	}

	
	
}
