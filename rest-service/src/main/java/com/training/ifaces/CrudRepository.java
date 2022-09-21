package com.training.ifaces;
import java.util.Collection;
import java.util.List;

import com.training.exceptions.ElementNotFoundException;
import com.training.model.Student;
public interface CrudRepository<T> {
	public boolean save(T obj);
	public Collection<Student> findAll();
	public boolean delete(T obj) throws ElementNotFoundException;
	public T findById(int key) throws ElementNotFoundException;
	public boolean deleteById(int key) throws ElementNotFoundException;
	public boolean update(T obj);
	
	
}
