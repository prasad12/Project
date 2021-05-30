package com.example.sampleproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sampleproject.datamodel.Todo;

@Repository
public interface TodoDAO extends CrudRepository<Todo, Long>{

	List<Todo> findAllById(Long id);

}
