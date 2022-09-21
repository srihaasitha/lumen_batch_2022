package com.training.resources;

import com.example.demo.repos.StudentRepositoryImpl;
import com.training.exceptions.ElementNotFoundException;
import com.training.model.Student;
import java.util.*;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.PathParam;

@Path("/api/students")
public class StudentResource {
	StudentRepositoryImpl repo =null;
	
public StudentResource() {
		super();
		this.repo = new StudentRepositoryImpl();
	}
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public Collection<Student> findAllStudent() {
		return repo.findAll();
	}
	
	@GET
	@Path("/{key}")
	public Student findByIdStudent(@PathParam("key") int key) throws ElementNotFoundException {
		return repo.findById(key);
	}
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	@POST
	public Response addStudent(Student entity) {
		//StudentRepositoryImpl repo = new StudentRepositoryImpl();
		boolean result= repo.save(entity);
		
		return Response.ok(entity).status(201).build();
	}
	@DELETE
	@Path("/{key}")
	public boolean deleteById(@PathParam("key") int key) throws ElementNotFoundException {
		return repo.deleteById(key);
	}
	
//	@Produces(value = MediaType.APPLICATION_JSON)
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	@POST
//	public Response updateStudent(Student entity) {
//		//StudentRepositoryImpl repo = new StudentRepositoryImpl();
//		boolean result= repo.update(entity);
//		
//		return Response.ok(entity).status(201).build();
//	}
	
}
