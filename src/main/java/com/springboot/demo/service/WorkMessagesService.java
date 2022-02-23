package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.springboot.demo.model.WorkMessages;
import com.springboot.demo.model.WorkMessagesRepository;

@Service
public class WorkMessagesService {
	
	@Autowired
	private WorkMessagesRepository dao;
	
	public void insert(WorkMessages messages) {
		dao.save(messages);
	}
	
	public WorkMessages findById(Integer id) {
		Optional<WorkMessages> op = dao.findById(id);	    
		if(op.isPresent()) {
			return op.get();
		}		  
		  return null;
	}
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	public List<WorkMessages> findAll() {
		return dao.findAll();
	}
	
	public Page<WorkMessages> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "added");
		return dao.findAll(pgb);
	}
	
	public WorkMessages getLastest() {
		return dao.findFirstByOrderByAddedDesc();
	}
}
